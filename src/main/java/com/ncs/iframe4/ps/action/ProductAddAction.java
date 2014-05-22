package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.to.ProductFormTO;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 */
public class ProductAddAction extends ProductAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6835739430965661953L;

	/**
	 * goto createCustomerPage
	 * 
	 * @return
	 */
	public String gotoCreateProduct() {
		return "add?faces-redirect=true";
	}

	/**
	 * do create product
	 * 
	 * @param product
	 * @return
	 */
	public String createProductProcess(ProductFormTO product) {
		this.getProductService().save(product);
		JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE, "msg.product.addsuccess",
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
