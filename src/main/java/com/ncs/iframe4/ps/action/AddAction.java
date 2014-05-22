package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.to.CustomerFormTO;

/**
 * Created by IntelliJ IDEA. User: qinjun Date: 12-1-12 To change this template
 * use File | Settings | File Templates.
 */
public class AddAction extends CustomerAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6835739430965661953L;

	/**
	 * goto createCustomerPage
	 * 
	 * @return
	 */
	public String gotoCreateCustomer() {
		return "add?faces-redirect=true";
	}

	/**
	 * do create customer
	 * 
	 * @param customer
	 * @return
	 */
	public String createCustomerProcess(CustomerFormTO customer) {
		this.getCustomerService().save(customer);
		JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE, "msg.added",
				FacesMessage.SEVERITY_INFO);
		return "add";
	}

	/**
	 * after add customer return back to customer list page
	 * 
	 * @return
	 */
	public String cancelProcess() {
		return "list?faces-redirect=true";
	}
}
