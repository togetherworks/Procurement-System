package com.ncs.iframe4.ps.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.commons.pagination.PaginationContext;
import com.ncs.iframe4.commons.tools.SequenceUUID;
import com.ncs.iframe4.hibernate.IframeHibernatePaginationDaoSupport;
import com.ncs.iframe4.ps.po.Order;
import com.ncs.iframe4.ps.po.OrderDetail;
import com.ncs.iframe4.ps.po.Product;

public class OrderDetailDAOImpl extends IframeHibernatePaginationDaoSupport
		implements OrderDetailDAO {
	
	Product productInstance;
	Order orderInstance;
	
	public OrderDetailDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);

	}
	
	
	public void save(OrderDetail orderDetail) {
		String id = SequenceUUID.getUUID32();
		orderDetail.setOrderDetailId(id);
		
		//procurement system 1.1 update: save optus price to order detail
		String pID = orderDetail.getProductId();
		
		if (pID != null){
			System.out.println("--------------pID is not null, and value is---------------"+pID);
			//get current optus price based on product id
			productInstance = (Product)getCurrentSession().get(Product.class, pID);
			Float optusPrice = productInstance.getOptusPrice();
			//update optus price in order details
			orderDetail.setOptusPrice(optusPrice);
		}	
		
		getCurrentSession().save(orderDetail);
				
		//update order amount while add product
		updateOrderAmountInAdd(orderDetail);
	
		
	}
	
	
	public OrderDetail findOrderDetailById(String orderDetailId) {
		OrderDetail instance = (OrderDetail) getCurrentSession().get(OrderDetail.class, orderDetailId);
		return instance;
	}
	
	//order detail add product page check product exist in this order or not
	public Boolean checkProductExist(Integer oID, String pID) {
		Boolean flag = false;
		DetachedCriteria criteria = DetachedCriteria.forClass(OrderDetail.class);
		criteria.add(Restrictions.eq("orderId", oID));
		criteria.add(Restrictions.eq("productId", pID));
		List results = criteria.getExecutableCriteria(getCurrentSession()).list();
		if(!results.isEmpty()){
			System.out.print("result is NOT empty for product"+pID);
		}
		if (results.isEmpty()){
			System.out.print("result is empty for product"+pID);
			flag=true;
		}
		return flag;
	}
	
	
	//update order details (product)
	public void update(OrderDetail orderDetail) {
		
		OrderDetail saveOrder = (OrderDetail) getCurrentSession().get(OrderDetail.class,orderDetail.getOrderDetailId());
		
		Boolean oriIsAirFreight = saveOrder.getIsAirFreight();
		System.out.println("------------oriIsAirFreight-----------"+oriIsAirFreight);
		Boolean updateIsAirFreight=orderDetail.getIsAirFreight();
		System.out.println("------------updateIsAirFreight-----------"+updateIsAirFreight);
		
		Integer oriOrderQuantity = saveOrder.getOrderQuantity();
		System.out.println("------------oriOrderQuantity-----------"+oriOrderQuantity);
		Integer updateOrderQuantity = orderDetail.getOrderQuantity();
		System.out.println("------------updateOrderQuantity-----------"+updateOrderQuantity);
		
		//get ori optus price
		Float oriOptusPrice = orderDetail.getOptusPrice();
		System.out.println("-------oriOptusPrice--------"+oriOptusPrice);
		
		//find update optus price
		//procurement system 1.1 update: save updated optus price to order detail
		String pID = orderDetail.getProductId();
		productInstance = (Product)getCurrentSession().get(Product.class, pID);
		Float updateOptusPrice= productInstance.getOptusPrice();
		System.out.println("-------updateOptusPrice--------"+updateOptusPrice);
				
				
		Integer orderId=orderDetail.getOrderId();
		String productId=orderDetail.getProductId();

		//update order amount before update order, this will keep original quantity and its air freight
		updateOrderAmountInUpdate(oriIsAirFreight, updateIsAirFreight, oriOrderQuantity, updateOrderQuantity,oriOptusPrice,orderId, productId);
		
		BeanUtils.copyProperties(orderDetail, saveOrder);	//source, target	
		
		//if ori optus price is different with update one, get update one save to order detail
		if (oriOptusPrice!=updateOptusPrice){
			saveOrder.setOptusPrice(updateOptusPrice);
		}
		getCurrentSession().update(saveOrder);

		
	}
	
		
	//remove ordered product
	public void removeOrderedProduct(OrderDetail orderDetail) {
		updateOrderAmountInDel(orderDetail);
		getCurrentSession().delete(orderDetail);	
		
	}
	
	//search ordered products
	public ListAndPagingInfo<OrderDetail> searchOrderedProducts(Integer orderId) {
		// use findByCriteria4Page method
		System.out.println("+++++++searchOrderedProducts++++++");
		DetachedCriteria criteria = DetachedCriteria.forClass(OrderDetail.class);

		if (orderId != null) {
			criteria.add(Restrictions.eq("orderId", orderId));
		}
		if (PaginationContext.getPaginationSortOrderData() != null && PaginationContext.getPaginationSortOrderData().getSortValue() == null) {
			PaginationContext.getPaginationSortOrderData().setSortValue("productId");
			PaginationContext.getPaginationSortOrderData().setSortValue("orderId");
			PaginationContext.getPaginationSortOrderData().setAscending(false);
		}
		return findByCriteria4Page(criteria);
	}
	
	//get order details for export purpose
	public List<OrderDetail> getOrderDetail4Export(Integer orderId) {
		System.out.println("+++++++getOrderDetail4Export++++++");
		List<OrderDetail> result = new ArrayList<OrderDetail>();
	           
	      Criteria criteria=  getCurrentSession().createCriteria(OrderDetail.class);
	      criteria.add(Restrictions.eq("orderId", orderId));
	      result = criteria.list();		
		return result;
	}

	//update order amount while add product in order
	public void updateOrderAmountInAdd(OrderDetail orderDetail){
		Boolean isAirFreight=orderDetail.getIsAirFreight();
		Integer orderQuantity=orderDetail.getOrderQuantity();
		BigDecimal orderQuantityDecimal = new BigDecimal(Integer.toString(orderQuantity));
		BigDecimal orderQuantityDisplayVal = orderQuantityDecimal.setScale(2, RoundingMode.HALF_EVEN);
		
		Integer orderId=orderDetail.getOrderId();
		String productId=orderDetail.getProductId();
		
		productInstance = (Product)getCurrentSession().get(Product.class, productId);
		
		Float airFreightFees = productInstance.getAirFreight();
		BigDecimal airFreightFeesDisplayVal;
		
		
		Float optusPrice = productInstance.getOptusPrice();
		BigDecimal optusPriceDecimal = new BigDecimal(Float.toString(optusPrice));
		BigDecimal optusPriceDisplayVal = optusPriceDecimal.setScale(2, RoundingMode.HALF_EVEN);
		
		orderInstance= (Order)getCurrentSession().get(Order.class, orderId);
		
		Float orderAmount = orderInstance.getOrderAmount();
		BigDecimal orderAmountDisplayVal;
		
		
		if (airFreightFees==null){
			System.out.println("------------airFreightFees==null inside--------------------");
			airFreightFees = (float) 0;
			BigDecimal airFreightFeesDecimal = new BigDecimal(Float.toString(airFreightFees));
			airFreightFeesDisplayVal = airFreightFeesDecimal.setScale(2, RoundingMode.HALF_EVEN);
			System.out.println("------------airFreightFees--------------------"+airFreightFees);
		}else{
			BigDecimal airFreightFeesDecimal = new BigDecimal(Float.toString(airFreightFees));
			airFreightFeesDisplayVal = airFreightFeesDecimal.setScale(2, RoundingMode.HALF_EVEN);
		}
	
		if (orderAmount==null){
			if (isAirFreight==true){
//				orderAmount=airFreightFees+optusPrice*orderQuantity;
//				orderAmount=optusPriceDisplayVal.multiply(orderQuantityDisplayVal).add(airFreightFeesDisplayVal).floatValue();
//				BigDecimal orderAmountDecimal = new BigDecimal(Float.toString(orderAmount));
				BigDecimal orderAmountDecimal = optusPriceDisplayVal.multiply(orderQuantityDisplayVal).add(airFreightFeesDisplayVal);
				orderAmountDisplayVal = orderAmountDecimal.setScale(2, RoundingMode.HALF_EVEN);
			}else{
//				orderAmount=optusPrice*orderQuantity;
//				orderAmount=optusPriceDisplayVal.multiply(orderQuantityDisplayVal).floatValue();
//				BigDecimal orderAmountDecimal = new BigDecimal(Float.toString(orderAmount));
				System.out.println("---orderAmount==null--");
				System.out.println("optusPriceDisplayVal--"+optusPriceDisplayVal);
				System.out.println("orderQuantityDisplayVal--"+orderQuantityDisplayVal);
				System.out.println("optusPriceDisplayVal.multiply(orderQuantityDisplayVal)----"+optusPriceDisplayVal.multiply(orderQuantityDisplayVal));
				BigDecimal orderAmountDecimal=optusPriceDisplayVal.multiply(orderQuantityDisplayVal);
				orderAmountDisplayVal = orderAmountDecimal.setScale(2, RoundingMode.HALF_EVEN);
				System.out.println("orderAmountDisplayVal--"+orderAmountDisplayVal);
				
			}
		}else{
			BigDecimal orderAmountDecimal = new BigDecimal(Float.toString(orderAmount));
			orderAmountDisplayVal = orderAmountDecimal.setScale(2, RoundingMode.HALF_EVEN);
			if (isAirFreight==true){
//				orderAmount=airFreightFees+optusPrice*orderQuantity+orderAmount;
//				orderAmount=optusPriceDisplayVal.multiply(orderQuantityDisplayVal).add(airFreightFeesDisplayVal).add(orderAmountDisplayVal).floatValue();
				orderAmountDisplayVal=optusPriceDisplayVal.multiply(orderQuantityDisplayVal).add(airFreightFeesDisplayVal).add(orderAmountDisplayVal);
			}else{
//				orderAmount=optusPrice*orderQuantity+orderAmount;
//				orderAmount=optusPriceDisplayVal.multiply(orderQuantityDisplayVal).add(orderAmountDisplayVal).floatValue();
				System.out.println("orderAmountDisplayVal--"+orderAmountDisplayVal);
				System.out.println("optusPriceDisplayVal--"+optusPriceDisplayVal);
				System.out.println("orderQuantityDisplayVal--"+orderQuantityDisplayVal);
				System.out.println("optusPriceDisplayVal.multiply(orderQuantityDisplayVal)----"+optusPriceDisplayVal.multiply(orderQuantityDisplayVal));
				orderAmountDisplayVal=optusPriceDisplayVal.multiply(orderQuantityDisplayVal).add(orderAmountDisplayVal);
				System.out.println("orderAmountDisplayVal--"+orderAmountDisplayVal);
			}
		}
		System.out.println("orderAmountDisplayVal---"+orderAmountDisplayVal);
		orderAmount=orderAmountDisplayVal.floatValue();
		System.out.println("orderAmountDisplayVal.floatValue()---"+orderAmountDisplayVal.floatValue());
		orderInstance.setOrderAmount(orderAmount);
		System.out.println("after set order amount---"+orderAmount);
		getCurrentSession().update(orderInstance);		
	}
	
	//update order amount while update product in order
	public void updateOrderAmountInUpdate(Boolean oriIsAirFreight, Boolean updateIsAirFreight, Integer oriOrderQuantity, Integer updateOrderQuantity, Float oriOptusPrice, Integer orderId, String productId){
		productInstance = (Product)getCurrentSession().get(Product.class, productId);
		Float airFreightFees = productInstance.getAirFreight();
		Float updateOptusPrice = productInstance.getOptusPrice();//updateOptusPrice
		
		orderInstance= (Order)getCurrentSession().get(Order.class, orderId);
		Float orderAmount = orderInstance.getOrderAmount();
		
		if (airFreightFees==null){
			System.out.println("------------airFreightFees==null inside--------------------");
			airFreightFees = (float) 0;
			System.out.println("------------airFreightFees--------------------"+airFreightFees);
		}
		if (oriOrderQuantity ==updateOrderQuantity ){
			System.out.println("------------oriOrderQuantity ==updateOrderQuantity inside--------------------");
			if (oriOptusPrice!=updateOptusPrice){
				System.out.println("------------oriOptusPrice!=updateOptusPrice inside--------------------");
				orderAmount=orderAmount-updateOptusPrice*oriOrderQuantity+updateOptusPrice*updateOrderQuantity;
			}else if (oriOptusPrice==updateOptusPrice){
				orderAmount=orderAmount-oriOptusPrice*oriOrderQuantity+updateOptusPrice*updateOrderQuantity;	
				System.out.println("------------orderAmount-------------------"+orderAmount);
			}
			
		}
		if (oriOrderQuantity !=updateOrderQuantity ){
			System.out.println("------------oriOrderQuantity !=updateOrderQuantity inside--------------------");
			if (oriOptusPrice!=updateOptusPrice){
				System.out.println("------------oriOptusPrice!=updateOptusPrice inside--------------------");
				orderAmount=orderAmount-oriOptusPrice*oriOrderQuantity+updateOptusPrice*updateOrderQuantity;	
			}else if (oriOptusPrice==updateOptusPrice){
				orderAmount=orderAmount-updateOptusPrice*oriOrderQuantity+updateOptusPrice*updateOrderQuantity;	
				System.out.println("------------orderAmount-------------------"+orderAmount);
			}			
		}
		if (oriIsAirFreight == true && updateIsAirFreight==false ) {
			System.out.println("------------oriIsAirFreight == true && updateIsAirFreight==false inside--------------------");
			orderAmount = orderAmount-airFreightFees;
			System.out.println("------------orderAmount-------------------"+orderAmount);
		} 
		if (oriIsAirFreight == false && updateIsAirFreight==true ) {
			System.out.println("------------oriIsAirFreight == false && updateIsAirFreight==true inside--------------------");
			orderAmount = orderAmount+airFreightFees;
			System.out.println("------------orderAmount-------------------"+orderAmount);
		} 
		System.out.println("------------before  orderInstance.setOrderAmount(orderAmount);-------------------");		
		orderInstance.setOrderAmount(orderAmount);
		System.out.println("------------after  orderInstance.setOrderAmount(orderAmount);-------------------");
		System.out.println("------------before  getCurrentSession().update(orderInstance);-------------------");
		getCurrentSession().update(orderInstance);
		System.out.println("------------after  getCurrentSession().update(orderInstance);-------------------");
		
	}
	// update order amount while delete product in order
	public void updateOrderAmountInDel(OrderDetail orderDetail){
		System.out.println("------------updateOrderAmountInDel inside--------------------");
		Integer orderId=orderDetail.getOrderId();
		System.out.println("------------orderId---------"+orderId);
		String productId=orderDetail.getProductId();
		System.out.println("------------productId---------"+productId);
		Boolean isAirFreight=orderDetail.getIsAirFreight();
		System.out.println("------------isAirFreight---------"+isAirFreight);
		
		Integer orderQuantity=orderDetail.getOrderQuantity();
		BigDecimal orderQuantityDecimal = new BigDecimal(Integer.toString(orderQuantity));
		BigDecimal orderQuantityDisplayVal = orderQuantityDecimal.setScale(2, RoundingMode.HALF_EVEN);
		
		System.out.println("------------orderQuantity---------"+orderQuantity);
		
		productInstance = (Product)getCurrentSession().get(Product.class, productId);
		Float airFreightFees = productInstance.getAirFreight();		
		BigDecimal airFreightFeesDisplayVal;
		
		System.out.println("------------airFreightFees---------"+airFreightFees);
		
		//update 1.1 save optus price to tbl_ps_orderdetail
		Float currentOptusPrice = orderDetail.getOptusPrice();
		BigDecimal currentOptusPriceDecimal = new BigDecimal(Float.toString(currentOptusPrice));
		BigDecimal currentOptusPriceDisplayVal = currentOptusPriceDecimal.setScale(2, RoundingMode.HALF_EVEN);
		
		orderInstance= (Order)getCurrentSession().get(Order.class, orderId);
		Float orderAmount = orderInstance.getOrderAmount();
		BigDecimal orderAmountPriceDecimal = new BigDecimal(Float.toString(orderAmount));
		BigDecimal orderAmountDisplayVal = orderAmountPriceDecimal.setScale(2, RoundingMode.HALF_EVEN);
		
		if (airFreightFees==null){
			System.out.println("------------airFreightFees==null inside--------------------");
			airFreightFees = (float) 0;
			BigDecimal airFreightFeesDecimal = new BigDecimal(Float.toString(airFreightFees));
			airFreightFeesDisplayVal = airFreightFeesDecimal.setScale(2, RoundingMode.HALF_EVEN);
			System.out.println("------------airFreightFees--------------------"+airFreightFees);
		}else{
			BigDecimal airFreightFeesDecimal = new BigDecimal(Float.toString(airFreightFees));
			airFreightFeesDisplayVal = airFreightFeesDecimal.setScale(2, RoundingMode.HALF_EVEN);
		}
		
		if (isAirFreight==true){
//			orderAmount=orderAmount-currentOptusPrice*orderQuantity-airFreightFees;
//			orderAmount=orderAmountDisplayVal.subtract(currentOptusPriceDisplayVal.multiply(orderQuantityDisplayVal)).subtract(airFreightFeesDisplayVal).floatValue();
			orderAmountDisplayVal=orderAmountDisplayVal.subtract(currentOptusPriceDisplayVal.multiply(orderQuantityDisplayVal)).subtract(airFreightFeesDisplayVal);
		}else{
//			orderAmount=orderAmount-currentOptusPrice*orderQuantity;
//			orderAmount=orderAmountDisplayVal.subtract(currentOptusPriceDisplayVal.multiply(orderQuantityDisplayVal)).floatValue();
			System.out.println("orderAmountDisplayVal--"+orderAmountDisplayVal);
			System.out.println("currentOptusPriceDisplayVal--"+currentOptusPriceDisplayVal);
			System.out.println("orderQuantityDisplayVal----"+orderQuantityDisplayVal);
			System.out.println("currentOptusPriceDisplayVal.multiply(orderQuantityDisplayVal----"+currentOptusPriceDisplayVal.multiply(orderQuantityDisplayVal));
			orderAmountDisplayVal=orderAmountDisplayVal.subtract(currentOptusPriceDisplayVal.multiply(orderQuantityDisplayVal));
			System.out.println("orderAmountDisplayVal--"+orderAmountDisplayVal);
		}
		System.out.println("------------orderAmount after if else-----------"+orderAmount);
		
		orderAmount=orderAmountDisplayVal.floatValue();
		System.out.println("------------orderAmount=orderAmountDisplayVal.floatValue()-----------"+orderAmount);
		orderAmount=orderAmountDisplayVal.setScale(2, RoundingMode.HALF_EVEN).floatValue();
		System.out.println("------------orderAmountDisplayVal.setScale(2, RoundingMode.HALF_EVEN).floatValue()-----------"+orderAmount);
		
		orderInstance.setOrderAmount(orderAmount);
		
		getCurrentSession().update(orderInstance);
		System.out.println("------------after delete orderAmount-----------"+orderAmount);
		
	}

	public Float loadOrderAmountById(Integer orderId) {
		orderInstance= (Order)getCurrentSession().get(Order.class, orderId);
		Float orderAmount =orderInstance.getOrderAmount();
		System.out.println("---orderDetailDAOIMP -- order amount --"+orderAmount);
		return orderAmount;
	}





}
