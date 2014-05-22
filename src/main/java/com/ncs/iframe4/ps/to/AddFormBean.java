package com.ncs.iframe4.ps.to;

import java.util.List;

import com.ncs.iframe4.jsf.component.codelookup.entity.CodeLookup;
import com.ncs.iframe4.jsf.component.codelookup.service.CodeLookupService;

/**
 * Page Bean show in add page by JSF EL
 * User: qinjun
 * Date: 12-1-16
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public class AddFormBean extends CustomerFormTO {
    private static final long serialVersionUID = 0L;
    private List<CodeLookup> industryList;    //show listbox on add page
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

}
