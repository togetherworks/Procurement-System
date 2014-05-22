package com.ncs.iframe4.ps.to;

import java.util.List;

import com.ncs.iframe4.jsf.component.codelookup.entity.CodeLookup;
import com.ncs.iframe4.jsf.component.codelookup.service.CodeLookupService;

/**
 * @author cheng zhang
 * @since 14/06/2012
 */
public class OrderDetailAddFormBean extends OrderDetailFormTO {
    private static final long serialVersionUID = 0L;
    private List<CodeLookup> productList;
  //show listbox on add page
    private CodeLookupService codeLookupService;
    

    public CodeLookupService getCodeLookupService() {
        return codeLookupService;
    }

    public void setCodeLookupService(CodeLookupService codeLookupService) {
        this.codeLookupService = codeLookupService;
    }

    public List<CodeLookup> getProductList() {
   	 if (productList == null) {
        	productList = codeLookupService.getCodes("orderProduct", "true", "tbl_ps_product", "PROD_ID", "PROD_NUM", false, " PROD_STATUS = 'A' ", null, null);
        }
        return productList;
	}

	public void setProductList(List<CodeLookup> productList) {
		this.productList = productList;
	}
 

}
