package com.ncs.iframe4.ps.action;

import java.util.Map;

import org.primefaces.model.LazyDataModel;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.jsf.pagination.PaginationDataModel;
import com.ncs.iframe4.ps.po.Order;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 31/05/2012
 * 
 */
public class OrderSearchAction extends OrderAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6973496623713799210L;
	private LazyDataModel<Order> orderList; // show data in list page

	public LazyDataModel<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(LazyDataModel<Order> orderList) {
		this.orderList = orderList;
	}

	public OrderSearchAction() {
		orderList = new PaginationDataModel<Order>() {
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
	public void searchOrder(final Integer orderId, final String optusPoNum, final String ncsPoNum) {
		searchByOrderId(orderId,optusPoNum,ncsPoNum );
	}
	
	public void searchOrderStatus(final String optusPoNum) {
		searchOrderStatusByOptusPO(optusPoNum );
	}

	/**
	 * commnon method for search all data or search by name
	 * 
	 * @param productId
	 */
	private void searchByOrderId(final Integer orderId, final String optusPoNum, final String ncsPoNum) {
		PaginationDataModel<Order> refreshedLazyDataModel = new PaginationDataModel<Order>() {
			public ListAndPagingInfo loadPaginationData(Map filters) {
				return getOrderService().searchOrder(orderId,optusPoNum,ncsPoNum);
			}
		};
		int size = refreshedLazyDataModel.getPageSize();
		int pageSize = (size == 0) ? 1 : size;
		refreshedLazyDataModel.initialWrappedData(0, pageSize);
		this.orderList = refreshedLazyDataModel;
	}
	
	private void searchOrderStatusByOptusPO(final String optusPoNum) {
		PaginationDataModel<Order> refreshedLazyDataModel = new PaginationDataModel<Order>() {
			public ListAndPagingInfo loadPaginationData(Map filters) {
				return getOrderService().searchOrderStatusByOptusPO(optusPoNum);
			}
		};
		int size = refreshedLazyDataModel.getPageSize();
		int pageSize = (size == 0) ? 1 : size;
		refreshedLazyDataModel.initialWrappedData(0, pageSize);
		this.orderList = refreshedLazyDataModel;
	}
}
