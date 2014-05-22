package com.ncs.iframe4.ps.action;

import java.util.Map;

import org.primefaces.model.LazyDataModel;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.jsf.pagination.PaginationDataModel;
import com.ncs.iframe4.ps.po.Customer;

/**
 * Created by IntelliJ IDEA.
 * User: qinjun
 * Date: 12-1-11
 * Time: ä¸‹å�ˆ5:44
 * To change this template use File | Settings | File Templates.
 */
public class SearchAction extends CustomerAction {

 

    /**
	 * 
	 */
	private static final long serialVersionUID = 6973496623713799210L;
	private LazyDataModel<Customer> customerList;       //show data in list page


    public SearchAction() {
    	 customerList = new PaginationDataModel<Customer>() {
             public ListAndPagingInfo loadPaginationData(Map filters) {
                 return new ListAndPagingInfo();
             }
         }; 	
    }

    public LazyDataModel<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(LazyDataModel<Customer> customerList) {
        this.customerList = customerList;
    }

    /**
     * search action is in preRenderViewSearch() method
     * this method will automatically call method preRenderViewSearch()  and update list page by page ajax
     *
     * @param
     * @return
     */
	public void searchCustomer(final String customerName) {
    	searchByName(customerName);
    }

    /**
     * commnon method for search all data  or  search by name
     *
     * @param customerName
     */
    private void searchByName(final String customerName) {
        PaginationDataModel<Customer> refreshedLazyDataModel = new PaginationDataModel<Customer>() {
            public ListAndPagingInfo loadPaginationData(Map filters) {
                return getCustomerService().searchCustomer(customerName);
            }
        };
        int size = refreshedLazyDataModel.getPageSize();
        int pageSize = (size == 0) ? 1 : size;
        refreshedLazyDataModel.initialWrappedData(0, pageSize);
        this.customerList = refreshedLazyDataModel;
    }
}
