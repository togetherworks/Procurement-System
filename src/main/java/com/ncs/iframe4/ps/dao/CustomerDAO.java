package com.ncs.iframe4.ps.dao;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.Customer;

/**
 * Created by IntelliJ IDEA.
 * User: qinjun
 * Date: 11-9-7
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerDAO {

   public void save(Customer customer);

   public void delete(Customer customer);

   public Customer findById(String id);

   public ListAndPagingInfo<Customer> searchCustomer(String name);

   public void update(Customer customer);
}
