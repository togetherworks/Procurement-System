package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.to.OrderFormTO;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 01/06/2012
 */
public class OrderAddAction extends OrderAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6835739430965661953L;

	/**
	 * goto createOrderPage
	 * 
	 * @return
	 */
	public String gotoCreateOrder() {
		return "add?faces-redirect=true";
	}

	/**
	 * do create order
	 * 
	 * @param order
	 * @return
	 */
	public String createOrderProcess(OrderFormTO order) {
		this.getOrderService().save(order);
		JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
				"msg.order.added", FacesMessage.SEVERITY_INFO);
//		this.getOrderService().findById(order.getOrderId());
//		
//		OrderUpdateFormBean orderUpdateFormBean = new OrderUpdateFormBean();
//        
//        BeanUtils.copyProperties(order, orderUpdateFormBean);
//		
//		return "update?faces-redirect=true";
		return "add";
	}

	/**
	 * after add order return back to order list page
	 * 
	 * @return
	 */
	public String cancelProcess() {
		return "list?faces-redirect=true";
	}
}
