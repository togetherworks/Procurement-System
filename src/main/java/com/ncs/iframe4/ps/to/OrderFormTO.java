package com.ncs.iframe4.ps.to;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.ncs.iframe4.ps.po.OrderDetail;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 31/05/2012
 * 
 */
@ManagedBean(name="orderBean")
public class OrderFormTO implements Serializable {
	
	private static final long serialVersionUID = 0L;

	private Integer orderId;
	private String optusPoNum;
	private String ncsPoNum;
	private String lenovoOrderNum;
	private Date eta;
	private String orderStatus;
	private Float orderAmount=(float) 0;
	private Date dtReceived;
	private Timestamp updatedDt = new Timestamp(new Date().getTime());
	private String updateBy;
	private List<OrderDetail> products;
	private Integer pageId;
	

	public void pageIdListener(AjaxBehaviorEvent event){
		System.out.println("---pageIdListener inside--");
		 FacesContext context = FacesContext.getCurrentInstance();
		 String orderId = context.getApplication().evaluateExpressionGet(context, "#{orderUpdateBean.orderId}", String.class);
		 Integer orderIdParsed=Integer.parseInt(orderId);
		System.out.println("---pageIdListener inside--");
		System.out.println("orderId--"+orderIdParsed);
		pageId=orderIdParsed;
		System.out.println("pageId--"+pageId);
		System.out.println("---pageIdListener end--");
		
	}

	
	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public List<OrderDetail> getProducts() {
		return products;
	}

	public void setProducts(List<OrderDetail> products) {
		this.products = products;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public OrderFormTO() {
	}
	


	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOptusPoNum() {
		return optusPoNum;
	}

	public void setOptusPoNum(String optusPoNum) {
		this.optusPoNum = optusPoNum;
	}

	public String getNcsPoNum() {
		return ncsPoNum;
	}

	public void setNcsPoNum(String ncsPoNum) {
		this.ncsPoNum = ncsPoNum;
	}

	public String getLenovoOrderNum() {
		return lenovoOrderNum;
	}

	public void setLenovoOrderNum(String lenovoOrderNum) {
		this.lenovoOrderNum = lenovoOrderNum;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}





	public Float getOrderAmount() {
		return orderAmount;
	}


	public void setOrderAmount(Float orderAmount) {
		this.orderAmount = orderAmount;
	}


	public Date getDtReceived() {
		return dtReceived;
	}

	public void setDtReceived(Date dtReceived) {
		this.dtReceived = dtReceived;
	}

	public Timestamp getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Timestamp updatedDt) {
		this.updatedDt = updatedDt;
	}

	
	
}
