package com.ncs.iframe4.ps.to;

import java.io.Serializable;

import com.ncs.iframe4.ps.po.Order;
import com.ncs.iframe4.ps.po.Product;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 05/06/2012
 * 
 */

public class OrderDetailFormTO implements Serializable {
	private static final long serialVersionUID = 0L;
	
	private String orderDetailId;
	private Integer orderQuantity;
	private Boolean isAirFreight=false;
	private Float optusPrice;
	private Product product;
	private Order order;
	private Integer orderId;

	public Float getOptusPrice() {
		return optusPrice;
	}

	public void setOptusPrice(Float optusPrice) {
		this.optusPrice = optusPrice;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	private String productId;
	


	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	


	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Boolean getIsAirFreight() {
		return isAirFreight;
	}

	public void setIsAirFreight(Boolean isAirFreight) {
		this.isAirFreight = isAirFreight;
	}



}
