package com.ncs.iframe4.ps.action;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ncs.iframe4.ps.po.OrderDetail;
import com.ncs.iframe4.ps.service.OrderDetailService;
import com.ncs.iframe4.ps.to.OrderDetailUpdateFormBean;
import com.ncs.iframe4.ps.to.OrderUpdateFormBean;
import com.ncs.iframe4.util.GenerateExport;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 31/05/2012
 * 
 */

public class OrderDetailAction implements Serializable {
	private static final long serialVersionUID = 0L;
	
	private OrderDetailService orderDetailService;

	public OrderDetailService getOrderDetailService() {
		return orderDetailService;
	}

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	//export function
	//TODO
	public void processExport(OrderDetailUpdateFormBean orderDetailBean,OrderUpdateFormBean orderUpdateBean) throws IOException {
		System.out.println("process Export inside---");
		Integer orderId = orderUpdateBean.getOrderId();
		String optusPoNum = orderUpdateBean.getOptusPoNum();
		Timestamp generateDate = new Timestamp(new Date().getTime());
		 String formatedDt = new SimpleDateFormat("dd-mm-yyyy").format(generateDate);
		Float totalAmount = orderUpdateBean.getOrderAmount();
		
		List<OrderDetail> productList = getOrderDetailService().getOrderDetail4Export(orderId);
		
		for (int i=0; i < productList.size(); i++) {
			OrderDetail orderDetailList = (OrderDetail) productList.get(i);
			  System.out.println("OrderDetail list--"+productList.size());
			  System.out.println("Vendor Part No.--"+orderDetailList.getProduct().getProductNum());
			  System.out.println("Delivery Date--"+orderDetailList.getOrder().getEta());
			  System.out.println("Qty to Deliver--"+orderDetailList.getOrderQuantity());
			  System.out.println("Unit Type--"+orderDetailList.getProduct().getUnit());
			  System.out.println("Unit Price--"+ orderDetailList.getOptusPrice());	  
			  System.out.println("----OrderDetail end--");
			}
		
		
		// Prepare Excel report to be downloaded.
		HSSFWorkbook wb =GenerateExport.createReport(optusPoNum,totalAmount, productList);
	    String filename = formatedDt+"_"+optusPoNum;

	    // Prepare response to show a Save As dialogue with Excel report.
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	    externalContext.setResponseContentType("application/vnd.ms-excel");
	    externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

	    // Write Excel report to response body.
	    wb.write(externalContext.getResponseOutputStream());

	    // Inform JSF that response is completed and it thus doesn't have to navigate.
	    facesContext.responseComplete();	
	}	




}
