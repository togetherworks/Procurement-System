package com.ncs.iframe4.ps.to;

import com.ncs.iframe4.ps.po.Customer;

/**
 * Created by IntelliJ IDEA.
 * User: qinjun
 * Date: 12-1-16
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class DeleteFormBean extends CustomerFormTO {
    private static final long serialVersionUID = 0L;
    private Customer[] selectedCustomers;             //selected records in list page to delete or update.

    public Customer[] getSelectedCustomers() {
        return selectedCustomers;
    }

    public void setSelectedCustomers(Customer[] selectedCustomers) {
        this.selectedCustomers = selectedCustomers;
    }
}
