package com.ncs.iframe4.ps.dao;


import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.commons.pagination.PaginationContext;
import com.ncs.iframe4.commons.tools.StringUtil;
import com.ncs.iframe4.hibernate.IframeHibernatePaginationDaoSupport;
import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.po.Order;


/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 31/05/2012
 * 
 * 
 */
public class OrderDAOImpl extends IframeHibernatePaginationDaoSupport
		implements OrderDAO {

	public OrderDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);

	}

	public void save(Order order) {
		System.out.println("before save order Id--" + order.getOrderId());		
		getCurrentSession().save(order);
		System.out.println("after save order Id--" + order.getOrderId());

	}

	public void delete(Order order) {
		getCurrentSession().delete(order);

	}

	public Order findById(Integer id) {
		System.out.println("----------OrderDAOImpl inside.orderID----------"+id.toString());
		Order instance = (Order) getCurrentSession().get(Order.class, id);
		return instance;
	}
	
	public ListAndPagingInfo<Order> searchOrder(Integer orderId, String optusPoNum, String ncsPoNum ) {

		// use findByCriteria4Page method
		System.out.println("searchOrder---inside");
		
		if (orderId ==null){
			System.out.println("orderId is null");
		}else{
			System.out.println("orderId is NOT null");
		}
//		Integer.parseInt(String a)； 	
//		orderId = JSFTools.processNull(orderIdString.toString());
		System.out.println("searchOrder---orderID--"+orderId);
		String stringOrderId=" ";
		
		optusPoNum = JSFTools.processNull(optusPoNum);
		ncsPoNum = JSFTools.processNull(ncsPoNum);
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
		
		if (orderId == 0||!StringUtil.isEmptyString(optusPoNum)||!StringUtil.isEmptyString(ncsPoNum)) {
			System.out.println(" order is 0 inside ---orderId != null||!StringUtil.isEmptyString(optusPoNum)||!StringUtil.isEmptyString(ncsPoNum)");
			criteria.add(Restrictions.like("optusPoNum", optusPoNum, MatchMode.ANYWHERE) );
			criteria.add(Restrictions.like("ncsPoNum", ncsPoNum, MatchMode.ANYWHERE) );
//			criteria.add(Restrictions.sqlRestriction("CAST(ORDER_ID AS CHAR) like ? ", stringOrderId, Hibernate.STRING));
//			criteria.add(Restrictions.like("orderId", stringOrderId, MatchMode.ANYWHERE) );
			
			
		}
		if (orderId !=0){
			System.out.println("orderId is NOT 0 criterira inside");
			criteria.add(Restrictions.sqlRestriction("CAST(ORDER_ID AS CHAR) like ? ", orderId.toString(), Hibernate.STRING));
			criteria.add(Restrictions.like("optusPoNum", optusPoNum, MatchMode.ANYWHERE) );
			criteria.add(Restrictions.like("ncsPoNum", ncsPoNum, MatchMode.ANYWHERE) );
		}
	
		if (PaginationContext.getPaginationSortOrderData() != null	&& PaginationContext.getPaginationSortOrderData()
						.getSortValue() == null) {
			PaginationContext.getPaginationSortOrderData().setSortValue("updatedDt");
			PaginationContext.getPaginationSortOrderData().setAscending(false);
		}
		return findByCriteria4Page(criteria);

		// use find4Page method
		/*
		 * name = JSFTools.processNull(name); String hql =
		 * "FROM Customer customer " + "WHERE  customer.name like ? " +
		 * "ORDER BY customer.updatedDt DESC";
		 * 
		 * String hqlCount = "SELECT COUNT(*) FROM Customer customer " +
		 * "WHERE  customer.name like ? " + "ORDER BY customer.updatedDt DESC";
		 * 
		 * return this.find4Page(hql, hqlCount, new String[]{"%" + name + "%"});
		 */

	}
	
	public ListAndPagingInfo<Order> searchOrderStatus(String optusPoNum) {

			
		optusPoNum = JSFTools.processNull(optusPoNum);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
		
		if (!StringUtil.isEmptyString(optusPoNum)) {
			
			criteria.add(Restrictions.like("optusPoNum", optusPoNum, MatchMode.ANYWHERE) );
		}
		
		if (PaginationContext.getPaginationSortOrderData() != null	&& PaginationContext.getPaginationSortOrderData()
						.getSortValue() == null) {
			PaginationContext.getPaginationSortOrderData().setSortValue("updatedDt");
			PaginationContext.getPaginationSortOrderData().setAscending(false);
		}
		return findByCriteria4Page(criteria);

	}
		

	public void update(Order order) {
		Order saveOrder = (Order) getCurrentSession().get(Order.class,order.getOrderId());
		BeanUtils.copyProperties(order, saveOrder);
		getCurrentSession().update(saveOrder);

	}

	public void load() {
		
//		OrderAddFormBean addOrderBean = new OrderAddFormBean();
//		String id = SequenceUUID.getUUID32();
//		addOrderBean.setOrderId(id);
//		getCurrentSession().load(OrderAddFormBean.class, id);
		
	}

//	public List<OrderDetail> searchOrderedProducts(Integer orderId) {
//		//TODO: need to check here search orderId by Integer.
//		// use findByCriteria4Page method
//		System.out.println("------------LUCKY ME--------------------");
//		DetachedCriteria criteria = DetachedCriteria.forClass(OrderDetail.class);
//		criteria.add(Restrictions.eq("orderId", orderId));
//		List results = criteria.getExecutableCriteria(getCurrentSession()).list();
//		
//		Iterator iter = results.iterator();  
//	    while(iter.hasNext()) {  
//	    	OrderDetail orderDetail = (OrderDetail)iter.next();  
//	        System.out.println(orderDetail.getOrderDetailId()); 
//	        System.out.println(orderDetail.getProductId()); 
//	        System.out.println(orderDetail.getOrderId()); 	        
//	    }  
//	      
//		
//		return results;
//		
//	}
	

}
