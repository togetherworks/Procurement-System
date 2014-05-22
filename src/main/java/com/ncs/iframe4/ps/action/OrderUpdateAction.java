package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.Order;
import com.ncs.iframe4.ps.to.OrderFormTO;
import com.ncs.iframe4.ps.to.OrderUpdateFormBean;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 01/06/2012
 */
public class OrderUpdateAction extends OrderAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7520743380752905967L;
//	private List<OrderDetail> orderDetailList;
//	
//	public List<OrderDetail> getOrderDetailList() {
//		return orderDetailList;
//	}
//
//	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
//		this.orderDetailList = orderDetailList;
//	}

	//	OrderDetailSearchAction odsa;
	public String gotoEdit(Integer orderId, OrderUpdateFormBean orderFromBean) {
		System.out.println("-----orderUpdateAction.gotoEdit inside--------"+orderId.toString());
		Order order = this.getOrderService().findById(orderId);	
//		odsa.searchOrderDetail(orderId);
		BeanUtils.copyProperties(order, orderFromBean); // copyProperties(Object source, Object target)
//		System.out.println("orderFromBean.orderId-----" + orderFromBean.getOrderId());
//		System.out.println("orderFromBean.getNcsPoNum()-----" + orderFromBean.getNcsPoNum());
//		System.out.println("orderFromBean.getLenovoOrderNum()-----" + orderFromBean.getLenovoOrderNum());
//		System.out.println("orderFromBean.getOptusPoNum()-----" + orderFromBean.getOptusPoNum());
//		System.out.println("orderFromBean.getOrderAmount()-----" + orderFromBean.getOrderAmount());
//		System.out.println("orderFromBean.getOrderStatus()-----" + orderFromBean.getOrderStatus());
//		System.out.println("orderFromBean.getUpdateBy()-----" + orderFromBean.getUpdateBy());
//		System.out.println("orderFromBean..getEta()-----" + orderFromBean.getEta());
//		System.out.println("-----orderUpdateAction.gotoEdit end--------");
//		System.out.println("--before load orderdetaillist");
//		load(orderId);
//		System.out.println("--after load orderdetaillist");
		
		return "update?faces-redirect=true";
	}

	public String editProcess(OrderFormTO orderFormTO) {
		OrderUpdateFormBean updateFormBean = (OrderUpdateFormBean)orderFormTO;
		Integer orderID=updateFormBean.getOrderId();
		Order order = this.getOrderService().findById(orderID);	
		
		//update order amount from db
		updateFormBean.setOrderAmount(order.getOrderAmount());
				
		
		this.getOrderService().update(updateFormBean);
		JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
				"msg.order.updatesuccess", FacesMessage.SEVERITY_INFO);
		return "update";
	}

	public String cancelProcess() {
		return "list?faces-redirect=true";
	}

//	public List<OrderDetail> load(Integer orderId){
//		orderDetailList=this.getOrderService().searchOrderedProducts(orderId);
//		return orderDetailList;
//	}
}
