package com.ncs.iframe4.ps.to;


import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.jsf.component.codelookup.service.CodeLookupService;
import com.ncs.iframe4.ps.po.Product;
import com.ncs.iframe4.ps.service.ProductService;


/**
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 */
public class ProductUpdateFormBean extends ProductFormTO {
    private static final long serialVersionUID = 0L;
//  private List<CodeLookup> industryList = null;
    private ProductService productService;
    private CodeLookupService codeLookupService;

    public CodeLookupService getCodeLookupService() {
		return codeLookupService;
	}

	public void setCodeLookupService(CodeLookupService codeLookupService) {
		this.codeLookupService = codeLookupService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void preRenderView(ComponentSystemEvent event) {
        String productId = this.getProductId();
        Product product = productService.findById(productId);
        BeanUtils.copyProperties(product, this);
    }

}
