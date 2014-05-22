package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.OrderDetail;
import com.ncs.iframe4.ps.to.OrderDetailFormTO;
import com.ncs.iframe4.ps.to.OrderDetailUpdateFormBean;
import com.ncs.iframe4.ps.to.OrderUpdateFormBean;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 18/06/2012
 */
public class OrderDetailUpdateAction extends OrderDetailAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7520743380752905967L;

//	public String gotoEdit(String orderId, String productId) {
//		OrderDetail orderDetail = this.getOrderDetailService().findOrderDetailById(orderId,productId);
//		OrderDetailUpdateFormBean odUpdateBean = new OrderDetailUpdateFormBean();
//		BeanUtils.copyProperties(orderDetail, odUpdateBean); // copyProperties(Object source, Object target)		
//		return "orderDetailUpdateProduct?faces-redirect=true";
//	}
	
	public String gotoEdit(String orderDetailId, OrderDetailUpdateFormBean updateBean, OrderUpdateFormBean orderUpdateBean) {
		System.out.println("OrderDetailUpdateAction.gotoEdit inside--"+orderDetailId.toString());
		OrderDetail orderDetail = this.getOrderDetailService().findOrderDetailById(orderDetailId);
		System.out.println("OrderDetailUpdateAction.orderDetail.productNumber--"+orderDetail.getProduct().getProductNum());
		System.out.println("OrderDetailUpdateAction.orderDetail.order quantity--"+orderDetail.getOrderQuantity());
		System.out.println("OrderDetailUpdateAction.orderDetail.getIsAirFreight()--"+orderDetail.getIsAirFreight());
		System.out.println("----------------------------------------------------------------------------");
		BeanUtils.copyProperties(orderDetail, updateBean); // copyProperties(Object source, Object target)	
		System.out.println("OrderDetailUpdateAction.updateBean.product Number--"+updateBean.getProduct().getProductNum());
		System.out.println("OrderDetailUpdateAction.updateBean.order quantity--"+updateBean.getOrderQuantity());
		System.out.println("OrderDetailUpdateAction.updateBean.getIsAirFreight()--"+updateBean.getIsAirFreight());
		return "orderDetailUpdateProduct?faces-redirect=true";
	}
	

	public String editProcess(OrderDetailFormTO orderDetailFormTO, OrderUpdateFormBean orderUpdateBean) {
		OrderDetailUpdateFormBean updateFormBean = (OrderDetailUpdateFormBean)orderDetailFormTO;
		this.getOrderDetailService().update(updateFormBean);
		
		//refresh order amount
		Integer orderId = updateFormBean.getOrderId();
		
		Float currentOrderAmount = this.getOrderDetailService().loadOrderAmountById(orderId);
		orderUpdateBean.setOrderAmount(currentOrderAmount);
		
		JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
				"msg.order.updatesuccess", FacesMessage.SEVERITY_INFO);
		return "orderDetailUpdateProduct";
	}

	public String cancelProcess() {
		return "update?faces-redirect=true";
	}
}
