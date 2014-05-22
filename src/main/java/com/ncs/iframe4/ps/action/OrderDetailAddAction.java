package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.to.OrderDetailAddFormBean;
import com.ncs.iframe4.ps.to.OrderDetailFormTO;
import com.ncs.iframe4.ps.to.OrderUpdateFormBean;

/**
 *@author cheng zhang
 *@since 14/06/2012
 */
public class OrderDetailAddAction extends OrderDetailAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6835739430965661953L;

	/**
	 * goto add products page
	 * 
	 * @return
	 */
	
	public String gotoAddProduct(Integer orderId, OrderUpdateFormBean orderUpdateBean) {
		System.out.println("gotoAddProduct inside---");
//		OrderDetailFormTO orderBean = new OrderDetailFormTO();
		
		OrderDetailAddFormBean addBean = new OrderDetailAddFormBean();
		addBean.setOrderId(orderId);
//		addBean.getOrders().setOrderId(orderId);
//		OrderUpdateFormBean updateFormBean = (OrderUpdateFormBean)orderBean;
		System.out.println("gotoAddProduct optusPoNum---"+orderUpdateBean.getOptusPoNum());
				
		
		return "orderDetailAddProduct?faces-redirect=true";
	}	

	/**
	 *
	 */
	//, OrderUpdateFormBean orderUpdateBean
	public String addProductProcess(Integer orderId, OrderDetailFormTO orderDetailBean, OrderUpdateFormBean orderUpdateFormBean){
		System.out.println("-------------addProductProcess-----------------");
		orderDetailBean.setOrderId(orderId);
		Integer oID = orderDetailBean.getOrderId();
		System.out.println("-------------2oID-----------------"+oID);
		String pID = orderDetailBean.getProductId();
		System.out.println("-------------3pID-----------------"+pID);
		Float currentOPrice = orderDetailBean.getOptusPrice();
		System.out.println("-------------4 current Optus Price-----------------"+currentOPrice);
		Boolean flag = this.getOrderDetailService().checkProductExist(oID, pID);
		System.out.println("-------------5 flag-----------------"+flag);
		
		if (flag!=true){
			JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE, "msg.check.exist.product",
					FacesMessage.SEVERITY_INFO);
		}else{ this.getOrderDetailService().save(orderDetailBean);
				
				
				//refresh order amount
			 	Float currentOrderAmount = this.getOrderDetailService().loadOrderAmountById(orderId);
			 	orderUpdateFormBean.setOrderAmount(currentOrderAmount);
		        JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE, "msg.orderdetail.product.added",
								FacesMessage.SEVERITY_INFO);
		}
//		System.out.println("addProductProcess orderUpdateBean.optusPoNum---"+orderUpdateBean.getOptusPoNum());
		//load orderUpdateBean
		
		return "orderDetailAddProduct";
	}

	/**
	 * after add customer return back to customer list page
	 * 
	 * @return
	 */
	public String cancelProcess() {
		//load and update orderUpdateFormBean
//		OrderUpdateFormBean
		return "update?faces-redirect=true";
	}
}
