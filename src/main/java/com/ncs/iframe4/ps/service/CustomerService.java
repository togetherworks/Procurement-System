package com.ncs.iframe4.ps.service;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.Customer;
import com.ncs.iframe4.ps.to.CustomerFormTO;

/**
 * Created by IntelliJ IDEA.
 * User: qinjun
 * Date: 11-9-7
 * Time: 下午3:52
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerService {

    public void save(CustomerFormTO customerBean);

    public void delete(Customer[] customers);

    public Customer findById(String id);

    public ListAndPagingInfo<Customer> searchCustomer(String name);

    public void update(CustomerFormTO customerBean);

}
