package com.ncs.iframe4.ps.to;


import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.jsf.component.codelookup.service.CodeLookupService;
import com.ncs.iframe4.ps.po.Order;
import com.ncs.iframe4.ps.service.OrderService;


/**
 * @author cheng zhang
 * @version 0.1
 * @since 31/05/2012
 */
public class OrderUpdateFormBean extends OrderFormTO {
    private static final long serialVersionUID = 0L;
//  private List<CodeLookup> industryList = null;
    private OrderService orderService;
    private CodeLookupService codeLookupService;



	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public CodeLookupService getCodeLookupService() {
		return codeLookupService;
	}



	public void setCodeLookupService(CodeLookupService codeLookupService) {
		this.codeLookupService = codeLookupService;
	}



	public void preRenderView(ComponentSystemEvent event) {
		Integer orderId= this.getOrderId();
//        System.out.println("preRenderView.orderId---"+orderId.toString());
        Order order = orderService.findById(orderId);
//        System.out.println("preRenderView.orderId---"+orderId.toString());
        BeanUtils.copyProperties(order, this);
    }

}
