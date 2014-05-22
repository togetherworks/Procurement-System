package com.ncs.iframe4.ps.action;

import java.util.Map;

import org.primefaces.model.LazyDataModel;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.jsf.pagination.PaginationDataModel;
import com.ncs.iframe4.ps.po.Product;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 * 
 */
public class ProductSearchAction extends ProductAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6973496623713799210L;
	private LazyDataModel<Product> productList; // show data in list page

	public ProductSearchAction() {
		productList = new PaginationDataModel<Product>() {
			//TODO filter here??
			public ListAndPagingInfo loadPaginationData(Map filters) {
				return new ListAndPagingInfo();
			}
		};
	}

	public LazyDataModel<Product> getProductList() {
		return productList;
	}

	public void setProductList(LazyDataModel<Product> productList) {
		this.productList = productList;
	}

	/**
	 * search action is in preRenderViewSearch() method this method will
	 * automatically call method preRenderViewSearch() and update list page by
	 * page ajax
	 * 
	 * @param
	 * @return
	 */
	public void searchProduct(final String productNum) {
		searchByProductNum(productNum);
	}
	//this search function is only used for Optus staff (only show product with status 'Active')
	public void searchProduct4Optus(final String productNum) {
		searchByProductNum4Optus(productNum);
	}

	/**
	 * commnon method for search all data or search by name
	 * 
	 * @param productId
	 */
	private void searchByProductNum(final String productNum) {
		PaginationDataModel<Product> refreshedLazyDataModel = new PaginationDataModel<Product>() {
			//TODO filter here??
			public ListAndPagingInfo loadPaginationData(Map filters) {
				return getProductService().searchProduct(productNum);
			}
		};
		int size = refreshedLazyDataModel.getPageSize();
		int pageSize = (size == 0) ? 1 : size;
		refreshedLazyDataModel.initialWrappedData(0, pageSize);
		this.productList = refreshedLazyDataModel;
	}
	
	//this function is used for Optus staff
	private void searchByProductNum4Optus(final String productNum) {
		PaginationDataModel<Product> refreshedLazyDataModel = new PaginationDataModel<Product>() {
			//TODO filter here??
			public ListAndPagingInfo loadPaginationData(Map filters) {
				return getProductService().searchProduct4Optus(productNum);
			}
		};
		int size = refreshedLazyDataModel.getPageSize();
		int pageSize = (size == 0) ? 1 : size;
		refreshedLazyDataModel.initialWrappedData(0, pageSize);
		this.productList = refreshedLazyDataModel;
	}
}
