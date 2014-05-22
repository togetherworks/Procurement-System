package com.ncs.iframe4.ps.service;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.dao.OrderDAO;
import com.ncs.iframe4.ps.po.Order;
import com.ncs.iframe4.ps.to.OrderFormTO;
import com.ncs.iframe4.ps.to.OrderUpdateFormBean;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 31/05/2012
 *
 * 
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public void save(OrderFormTO orderBean) {
        Order order = new Order();
        BeanUtils.copyProperties(orderBean, order);
        orderDAO.save(order);
    }

    public void delete(Order[] order) {
        for (int i = 0; i < order.length; i++) {
        	orderDAO.delete(order[i]);
        }
    }

    public Order findById(Integer orderId) {
    	System.out.println("--OrderServiceImpl--inside--"+orderId.toString());
        return orderDAO.findById(orderId);
    }

	public ListAndPagingInfo<Order> searchOrder(Integer orderId, String optusPoNum,String ncsPoNum) {
		return orderDAO.searchOrder(orderId, optusPoNum, ncsPoNum);
	}
	

    public ListAndPagingInfo<Order> searchOrderStatusByOptusPO(String optusPoNum) {
    	return orderDAO.searchOrderStatus(optusPoNum);
	}

	public void update(OrderFormTO orderFormTO) {
    	OrderUpdateFormBean orderUpdateFormBean = (OrderUpdateFormBean)orderFormTO;
        Order order = new Order();
        BeanUtils.copyProperties(orderUpdateFormBean, order);
        orderDAO.update(order);
    }
    //TODO not yet finished.
	public void load() {
		orderDAO.load();
	}
	
//	 public List<OrderDetail> searchOrderedProducts(Integer orderId){
//		 return orderDAO.searchOrderedProducts(orderId);
//	 }
	
}
