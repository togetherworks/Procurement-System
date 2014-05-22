package com.ncs.iframe4.ps.action;

import java.util.Map;

import org.primefaces.model.LazyDataModel;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.jsf.pagination.PaginationDataModel;
import com.ncs.iframe4.ps.po.OrderDetail;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 31/05/2012
 * 
 */
public class OrderDetailSearchAction extends OrderDetailAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6973496623713799210L;
	private LazyDataModel<OrderDetail> orderDetailList; // show data in list page
	

	public LazyDataModel<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(LazyDataModel<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public OrderDetailSearchAction() {
		orderDetailList = new PaginationDataModel<OrderDetail>() {
			public ListAndPagingInfo loadPaginationData(Map filters) {
				return new ListAndPagingInfo();
			}
		};
	}

	/**
	 * search action is in preRenderViewSearch() method this method will
	 * automatically call method preRenderViewSearch() and update list page by
	 * page ajax
	 * 
	 * @param
	 * @return
	 */
	
	
	public void searchOrderDetail(Integer orderId) {
//		System.out.println("---searchOrderDetail.orderId--"+orderId);
		searchByOrderId(orderId);
	}

	/**
	 * commnon method for search all data or search by name
	 * 
	 * @param productId
	 */
	private void searchByOrderId(final Integer orderId) {
//		System.out.println("---searchByOrderId.orderId--"+orderId);
		PaginationDataModel<OrderDetail> refreshedLazyDataModel = new PaginationDataModel<OrderDetail>() {
			public ListAndPagingInfo loadPaginationData(Map filters) {
				return getOrderDetailService().searchOrderedProducts(orderId);
			}
		};
		int size = refreshedLazyDataModel.getPageSize();
		int pageSize = (size == 0) ? 1 : size;
		refreshedLazyDataModel.initialWrappedData(0, pageSize);
		this.orderDetailList = refreshedLazyDataModel;
	}
}
