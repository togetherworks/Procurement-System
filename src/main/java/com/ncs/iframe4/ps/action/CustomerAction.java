package com.ncs.iframe4.ps.action;

import java.io.Serializable;

import com.ncs.iframe4.ps.service.CustomerService;

/**
 * 
 * Common action User: qinjun Date: 12-1-16 Time: 上午10:49 To change this
 * template use File | Settings | File Templates.
 */
public class CustomerAction implements Serializable {
	private static final long serialVersionUID = 0L;
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
