package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.Product;
import com.ncs.iframe4.ps.to.ProductFormTO;
import com.ncs.iframe4.ps.to.ProductUpdateFormBean;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 */
public class ProductUpdateAction extends ProductAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7520743380752905967L;

	public String gotoEdit(String productId, ProductUpdateFormBean productFromBean) {
		Product product = this.getProductService().findById(productId);
		BeanUtils.copyProperties(product, productFromBean);
		return "update?faces-redirect=true";
	}

	public String editProcess(ProductFormTO productFormTO) {
		ProductUpdateFormBean updateFormBean = (ProductUpdateFormBean) productFormTO;
		this.getProductService().update(updateFormBean);
		JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
				"msg.product.updatesuccess", FacesMessage.SEVERITY_INFO);
		return "update";
	}

	public String cancelProcess() {
		return "list?faces-redirect=true";
	}
}
