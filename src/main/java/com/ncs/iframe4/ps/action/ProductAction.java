package com.ncs.iframe4.ps.action;

import java.io.Serializable;

import com.ncs.iframe4.ps.service.ProductService;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 25/05/2012
 * 
 */

public class ProductAction implements Serializable {
	private static final long serialVersionUID = 0L;
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
