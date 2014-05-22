package com.ncs.iframe4.ps.to;

import com.ncs.iframe4.ps.po.Product;

/**
 * *@author cheng zhang
 * 
 * @version 0.1
 * @since 25/05/2012
 */
public class ProductDeleteFormBean extends ProductFormTO {
	private static final long serialVersionUID = 0L;
	private Product[] selectedProducts; // selected records in list page to
										// delete or update.

	public Product[] getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(Product[] selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

}
