package com.ncs.iframe4.ps.to;

import com.ncs.iframe4.ps.po.OrderDetail;

/**
 * *@author cheng zhang
 * 
 * @version 0.1
 * @since 13/06/2012
 */
public class OrderDetailDeleteFormBean extends OrderDetailFormTO {
	private static final long serialVersionUID = 0L;
	
	private OrderDetail selectedProduct; // selected ordered products in list page to
										// delete or update.

	public OrderDetail getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(OrderDetail selectedProduct) {
		this.selectedProduct = selectedProduct;
	}



	

}
