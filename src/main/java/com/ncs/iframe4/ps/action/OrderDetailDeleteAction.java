package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.OrderDetail;
import com.ncs.iframe4.ps.to.OrderDetailDeleteFormBean;
import com.ncs.iframe4.ps.to.OrderDetailFormTO;
import com.ncs.iframe4.ps.to.OrderUpdateFormBean;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 01/06/2012
 */
public class OrderDetailDeleteAction extends OrderDetailAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8032820796622979447L;

	public void deleteOrderedProducts(OrderDetailFormTO orderDetailFormTO, OrderUpdateFormBean orderUpdateBean) {
		System.out.println("----OrderDetailDeleteAction inside-----");
		OrderDetailDeleteFormBean orderDetailDeleteFromBean = (OrderDetailDeleteFormBean)orderDetailFormTO;
		OrderDetail selectedProduct=orderDetailDeleteFromBean.getSelectedProduct();
		

		if (selectedProduct != null) {
			
			this.getOrderDetailService().removeOrderedProduct(selectedProduct);
			
			//refresh order amount
			Integer orderId = orderUpdateBean.getOrderId();
			Float currentOrderAmount = this.getOrderDetailService().loadOrderAmountById(orderId);
			orderUpdateBean.setOrderAmount(currentOrderAmount);
			System.out.println("----selectedProducts-----"+ selectedProduct);
		} else {
			JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
					"label.orderdetail.deleteinfo", FacesMessage.SEVERITY_ERROR);
		}
	}

}
