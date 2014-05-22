package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.Customer;
import com.ncs.iframe4.ps.to.CustomerFormTO;
import com.ncs.iframe4.ps.to.UpdateFormBean;


/**
 * Created by IntelliJ IDEA.
 * User: qinjun
 * Date: 12-1-16
 * To change this template use File | Settings | File Templates.
 */
public class UpdateAction extends CustomerAction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7520743380752905967L;

	public String gotoEdit(String customerId, UpdateFormBean formBean) {
        Customer customer = this.getCustomerService().findById(customerId);
        BeanUtils.copyProperties(customer, formBean);
        return "update?faces-redirect=true";
    }

    public String editProcess(CustomerFormTO customerFormTO) {
        UpdateFormBean updateFormBean = (UpdateFormBean) customerFormTO;
        this.getCustomerService().update(updateFormBean);
        JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE, "msg.sample.updatesuccess", FacesMessage.SEVERITY_INFO);
        return "update";
    }

    public String cancelProcess() {
        return "list?faces-redirect=true";
    }
}
