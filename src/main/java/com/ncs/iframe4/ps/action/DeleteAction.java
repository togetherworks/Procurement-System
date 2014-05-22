package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.Customer;
import com.ncs.iframe4.ps.to.CustomerFormTO;
import com.ncs.iframe4.ps.to.DeleteFormBean;

/**
 * Created by IntelliJ IDEA. User: qinjun Date: 12-1-12 To change this template
 * use File | Settings | File Templates.
 */
public class DeleteAction extends CustomerAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8032820796622979447L;

	public void deleteCustomer(CustomerFormTO customerFormTO) {
		DeleteFormBean deleteFormBean = (DeleteFormBean) customerFormTO;

		Customer[] selectedCustomers = deleteFormBean.getSelectedCustomers();

		if (selectedCustomers != null && selectedCustomers.length > 0) {
			this.getCustomerService().delete(selectedCustomers);
		} else {
			JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
					"label.deleteinfo", FacesMessage.SEVERITY_ERROR);
		}
	}

}
