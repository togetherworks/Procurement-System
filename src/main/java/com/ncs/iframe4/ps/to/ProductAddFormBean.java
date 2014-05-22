package com.ncs.iframe4.ps.to;

import com.ncs.iframe4.jsf.component.codelookup.service.CodeLookupService;

/**
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 */
public class ProductAddFormBean extends ProductFormTO {
    private static final long serialVersionUID = 0L;
    
//  private List<CodeLookup> industryList;    //show listbox on add page
   private CodeLookupService codeLookupService;
//
    public CodeLookupService getCodeLookupService() {
        return codeLookupService;
    }

    public void setCodeLookupService(CodeLookupService codeLookupService) {
        this.codeLookupService = codeLookupService;
    }

//    public List<CodeLookup> getIndustryList() {
//        if (industryList == null) {
//            industryList = codeLookupService.getCodes("industry", "true", "TBL_SAMPLE_INDUSTRY", "INDUSTRY_ID", "INDUSTRY_DESC", true, null, null, null);
//        }
//        return industryList;
//    }
//
//    public void setIndustryList(List<CodeLookup> industryList) {
//        this.industryList = industryList;
//    }

}
