package com.ncs.iframe4.ps.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
 * @since 25/05/2012
 * 
 */
@ManagedBean(name = "productBean")
public class ProductFormTO implements Serializable {
	private static final long serialVersionUID = 0L;

	private String productId;
	private String productNum;
	private String productDesc;
	private String productStatus;
	private String productQuantity;
	private String unit;
	private Float ncsPrice;
	private Float percentage;
	private Float optusPrice;
	private Float airFreight;
	private Timestamp updatedDt = new Timestamp(new Date().getTime());
	private String updateBy;
	private List<OrderDetail> orders;

	// add page
	public void countListenerP(AjaxBehaviorEvent event) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		String ncs = context.getApplication().evaluateExpressionGet(context,"#{productAddBean.ncsPrice}", String.class);
		float ncsParsed = Float.parseFloat(ncs);

		BigDecimal ncsPriceDicimal = new BigDecimal(Float.toString(ncsParsed));
		BigDecimal ncsDisplayVal = ncsPriceDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal percentageDicimal = new BigDecimal(Float.toString(percentage));
		BigDecimal percentageDiplayVal = percentageDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal optusPriceDecimal = ncsDisplayVal.multiply(percentageDiplayVal).add(ncsDisplayVal);
		BigDecimal optusPriceDiplayVal = optusPriceDecimal.setScale(2,RoundingMode.HALF_EVEN);
		optusPrice = optusPriceDiplayVal.floatValue();


	}

	// add page
	public void countListenerN(AjaxBehaviorEvent event) {

		FacesContext context = FacesContext.getCurrentInstance();
		String per = context.getApplication().evaluateExpressionGet(context,"#{productAddBean.percentage}", String.class);
		float perParsed = Float.parseFloat(per);

		BigDecimal perDicimal = new BigDecimal(Float.toString(perParsed));
		BigDecimal perDisplayVal = perDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal ncsPriceDicimal = new BigDecimal(Float.toString(ncsPrice));
		BigDecimal ncsDisplayVal = ncsPriceDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal optusPriceDecimal = ncsDisplayVal.multiply(perDisplayVal).add(ncsDisplayVal);
		BigDecimal optusPriceDiplayVal = optusPriceDecimal.setScale(2,RoundingMode.HALF_EVEN);

		optusPrice = optusPriceDiplayVal.floatValue();

	}

	// update page
	public void countListenerPu(AjaxBehaviorEvent event) {
		// optusPrice=(float) (ncsPrice*(0.10));
		FacesContext context = FacesContext.getCurrentInstance();
		String ncs = context.getApplication().evaluateExpressionGet(context,"#{productUpdateBean.ncsPrice}", String.class);
		float ncsParsed = Float.parseFloat(ncs);

		BigDecimal ncsPriceDicimal = new BigDecimal(Float.toString(ncsParsed));
		BigDecimal ncsDisplayVal = ncsPriceDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal percentageDicimal = new BigDecimal(Float.toString(percentage));
		BigDecimal percentageDiplayVal = percentageDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal optusPriceDecimal = ncsDisplayVal.multiply(percentageDiplayVal).add(ncsDisplayVal);
		BigDecimal optusPriceDiplayVal = optusPriceDecimal.setScale(2,RoundingMode.HALF_EVEN);
		optusPrice = optusPriceDiplayVal.floatValue();

	}

	// update page
	public void countListenerNu(AjaxBehaviorEvent event) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		String per = context.getApplication().evaluateExpressionGet(context,"#{productUpdateBean.percentage}", String.class);
		float perParsed = Float.parseFloat(per);
		
		BigDecimal perDicimal = new BigDecimal(Float.toString(perParsed));
		BigDecimal perDisplayVal = perDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal ncsPriceDicimal = new BigDecimal(Float.toString(ncsPrice));
		BigDecimal ncsDisplayVal = ncsPriceDicimal.setScale(2,RoundingMode.HALF_EVEN);

		BigDecimal optusPriceDecimal = ncsDisplayVal.multiply(perDisplayVal).add(ncsDisplayVal);
		BigDecimal optusPriceDiplayVal = optusPriceDecimal.setScale(2,RoundingMode.HALF_EVEN);

		optusPrice = optusPriceDiplayVal.floatValue();

	}

	public List<OrderDetail> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public ProductFormTO() {
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getNcsPrice() {
		return ncsPrice;
	}

	public void setNcsPrice(Float ncsPrice) {
		this.ncsPrice = ncsPrice;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public Float getOptusPrice() {
		return optusPrice;
	}

	public void setOptusPrice(Float optusPrice) {
		this.optusPrice = optusPrice;
	}

	public Float getAirFreight() {
		return airFreight;
	}

	public void setAirFreight(Float airFreight) {
		this.airFreight = airFreight;
	}

	public Timestamp getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Timestamp updatedDt) {
		this.updatedDt = updatedDt;
	}

}
