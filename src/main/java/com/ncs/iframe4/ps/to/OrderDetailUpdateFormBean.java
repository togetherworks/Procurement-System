package com.ncs.iframe4.ps.to;

import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.ps.po.OrderDetail;
import com.ncs.iframe4.ps.service.OrderDetailService;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 18/06/2012
 */
public class OrderDetailUpdateFormBean extends OrderDetailFormTO {
	private static final long serialVersionUID = 0L;
	// private List<CodeLookup> industryList = null;
	private OrderDetailService orderDetailService;

	public OrderDetailService getOrderDetailService() {
		return orderDetailService;
	}

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	public void preRenderView(ComponentSystemEvent event) {
		String orderDetailId = this.getOrderDetailId();
		System.out.println("----preRenderView---"+orderDetailId.toString());
		OrderDetail orderDetail = orderDetailService.findOrderDetailById(orderDetailId);
		System.out.println("----preRenderView orderDetail.getOrderId---"+orderDetail.getOrderId());
		System.out.println("----preRenderView orderDetail.getproductnum---"+orderDetail.getProduct().getProductNum());
		BeanUtils.copyProperties(orderDetail, this);
	}

}
