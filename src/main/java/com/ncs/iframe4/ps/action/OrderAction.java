package com.ncs.iframe4.ps.action;

import java.io.Serializable;

import com.ncs.iframe4.ps.service.OrderService;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 31/05/2012
 * 
 */

public class OrderAction implements Serializable {
	private static final long serialVersionUID = 0L;
	private OrderService orderService;
//	private OrderDetailService orderDetailService;
//	
//	public OrderDetailService getOrderDetailService() {
//		return orderDetailService;
//	}
//	public void setOrderDetailService(OrderDetailService orderDetailService) {
//		this.orderDetailService = orderDetailService;
//	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}



}
