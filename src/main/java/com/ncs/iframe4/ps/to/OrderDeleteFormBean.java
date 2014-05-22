package com.ncs.iframe4.ps.to;

import com.ncs.iframe4.ps.po.Order;

/**
 * *@author cheng zhang
 * 
 * @version 0.1
 * @since 01/06/2012
 */
public class OrderDeleteFormBean extends OrderFormTO {
	private static final long serialVersionUID = 0L;
	
	private Order[] selectedOrders; // selected records in list page to
										// delete or update.
	public Order[] getSelectedOrders() {
		return selectedOrders;
	}
	public void setSelectedOrders(Order[] selectedOrders) {
		this.selectedOrders = selectedOrders;
	}


}
