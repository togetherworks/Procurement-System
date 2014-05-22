package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.Order;
import com.ncs.iframe4.ps.to.OrderDeleteFormBean;
import com.ncs.iframe4.ps.to.OrderFormTO;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 01/06/2012
 */
public class OrderDeleteAction extends OrderAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8032820796622979447L;

	public void deleteOrder(OrderFormTO orderFormTO) {
		
		OrderDeleteFormBean orderDeleteFromBean = (OrderDeleteFormBean)orderFormTO;
		Order[] selectedOrders=orderDeleteFromBean.getSelectedOrders();

		if (selectedOrders != null && selectedOrders.length > 0) {
			this.getOrderService().delete(selectedOrders);
		} else {
			JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
					"label.order.deleteinfo", FacesMessage.SEVERITY_ERROR);
		}
	}

}
