package com.ncs.iframe4.ps.action;

import javax.faces.application.FacesMessage;

import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.SampleConstants;
import com.ncs.iframe4.ps.po.Product;
import com.ncs.iframe4.ps.to.ProductDeleteFormBean;
import com.ncs.iframe4.ps.to.ProductFormTO;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 */
public class ProductDeleteAction extends ProductAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8032820796622979447L;

	public void deleteProduct(ProductFormTO productFormTO) {
		ProductDeleteFormBean productDeleteFormBean = (ProductDeleteFormBean)productFormTO;		
		Product[] selectedProducts = productDeleteFormBean.getSelectedProducts();

		if (selectedProducts != null && selectedProducts.length > 0) {
			this.getProductService().delete(selectedProducts);
		} else {
			JSFTools.processMessage(SampleConstants.SAMPLE_MESSAGE,
					"label.product.deleteinfo", FacesMessage.SEVERITY_ERROR);
		}
	}

}
