package com.ncs.iframe4.ps.to;

import java.util.List;

import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.jsf.component.codelookup.entity.CodeLookup;
import com.ncs.iframe4.jsf.component.codelookup.service.CodeLookupService;
import com.ncs.iframe4.ps.po.Customer;
import com.ncs.iframe4.ps.service.CustomerService;

/**
 * Created by IntelliJ IDEA.
 * User: qinjun
 * Date: 12-1-16
 * Time: ä¸Šå�ˆ7:35
 * To change this template use File | Settings | File Templates.
 */
public class UpdateFormBean extends CustomerFormTO {
    private static final long serialVersionUID = 0L;
    private List<CodeLookup> industryList = null;
    private CustomerService customerService;
    private CodeLookupService codeLookupService;

    public CodeLookupService getCodeLookupService() {
        return codeLookupService;
    }

    public void setCodeLookupService(CodeLookupService codeLookupService) {
        this.codeLookupService = codeLookupService;
    }

    public List<CodeLookup> getIndustryList() {
        if (industryList == null) {
            industryList = codeLookupService.getCodes("industry", "true", "TBL_SAMPLE_INDUSTRY", "INDUSTRY_ID", "INDUSTRY_DESC", true, null, null, null);
        }
        return industryList;
    }

    public void setIndustryList(List<CodeLookup> industryList) {
        this.industryList = industryList;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void preRenderView(ComponentSystemEvent event) {
        String customerId = this.getCustomerId();
        Customer customer = customerService.findById(customerId);
        BeanUtils.copyProperties(customer, this);
    }

}
