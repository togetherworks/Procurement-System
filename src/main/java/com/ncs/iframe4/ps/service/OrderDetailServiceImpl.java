package com.ncs.iframe4.ps.service;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.dao.OrderDetailDAO;
import com.ncs.iframe4.ps.po.OrderDetail;
import com.ncs.iframe4.ps.to.OrderDetailFormTO;
import com.ncs.iframe4.ps.to.OrderDetailUpdateFormBean;

public class OrderDetailServiceImpl implements OrderDetailService {
	
	private OrderDetailDAO orderDetailDAO;
	
	public OrderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}
	
	
	//Save
	public void save(OrderDetailFormTO orderDetailBean) {
		
//		System.out.println("-----------OrderDetailServiceImpl save inside ------------------");
		OrderDetail orderDetail = new OrderDetail();
		BeanUtils.copyProperties(orderDetailBean, orderDetail);//1.source, 2.target
		orderDetailDAO.save(orderDetail);
//		System.out.println("-----------after orderDetailDAO.save(orderDetail); ------------------");
	}
	
	//remove ordered products
	public void removeOrderedProduct(OrderDetail selectedProduct) {
		  orderDetailDAO.removeOrderedProduct(selectedProduct);
	      
	}
	
	//find order detail by Id, this is for select particular ordered product for edit/update
	public OrderDetail findOrderDetailById(String orderDetailId) {
		return orderDetailDAO.findOrderDetailById(orderDetailId);
	}
	
	//search ordered products
	public ListAndPagingInfo<OrderDetail> searchOrderedProducts(Integer orderId) {
		return orderDetailDAO.searchOrderedProducts(orderId);
	}
	
	//get orderDetails for export 	
	public List<OrderDetail> getOrderDetail4Export(Integer orderId) {
		// TODO Auto-generated method stub
		return orderDetailDAO.getOrderDetail4Export(orderId);
	}

	//update order detail
	public void update(OrderDetailFormTO orderDetailBean) {
    	OrderDetailUpdateFormBean orderDetailUpdateFormBean = (OrderDetailUpdateFormBean)orderDetailBean;
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(orderDetailUpdateFormBean, orderDetail);
        orderDetailDAO.update(orderDetail);  

	}

//    public Order findById(Integer orderId) {
//    	System.out.println("--OrderServiceImpl--inside--"+orderId.toString());
//        return orderDetailDAO.findById(orderId);
//    }
//	
	public Boolean checkProductExist(Integer oID, String pID) {
		Boolean flag = orderDetailDAO.checkProductExist(oID,pID);
		return flag;
	}

public Float loadOrderAmountById(Integer orderId) {

	return orderDetailDAO.loadOrderAmountById(orderId);
}

	

}
