package com.ncs.iframe4.ps.service;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.dao.CustomerDAO;
import com.ncs.iframe4.ps.po.Customer;
import com.ncs.iframe4.ps.to.CustomerFormTO;
import com.ncs.iframe4.ps.to.UpdateFormBean;

/**
 * Created by IntelliJ IDEA.
 * User: qinjun
 * Date: 11-9-7
 * Time: 下午3:56
 * To change this template use File | Settings | File Templates.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void save(CustomerFormTO customerBean) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerBean, customer);
        customerDAO.save(customer);
    }

    public void delete(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            customerDAO.delete(customers[i]);
        }
    }

    public Customer findById(String id) {
        return customerDAO.findById(id);
    }

    public ListAndPagingInfo<Customer> searchCustomer(String name) {
        return customerDAO.searchCustomer(name);
    }


    public void update(CustomerFormTO customerFormTO) {
        UpdateFormBean updateFormBean = (UpdateFormBean) customerFormTO;
        Customer customer = new Customer();
        BeanUtils.copyProperties(updateFormBean, customer);
        customerDAO.update(customer);
    }
}
