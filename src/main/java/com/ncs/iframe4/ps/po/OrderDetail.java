package com.ncs.iframe4.ps.po;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 31/05/2012
 * 
 */

@Entity
@Table(name = "tbl_ps_order_detail")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 0L;
	
	@Id
	@Column(name = "orderDetailId")
	private String OrderDetailId;
	
//	@ManyToOne(fetch=FetchType.LAZY) @20120628 9:47 remove lazy  --result: no impact
	@ManyToOne
	@JoinColumn(name = "orderId", nullable=false, updatable = false, insertable = false, referencedColumnName = "ORDER_ID")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "productId", nullable=false, updatable = false, insertable = false, referencedColumnName = "PROD_ID")
	private Product product;
	
	@Column(name = "ORDER_QUANTITY")
	private Integer orderQuantity;

	@Column(name = "IS_AIR_FREIGHT", columnDefinition="tinyint(1) default 0")
	@Basic(optional = false)
	private Boolean isAirFreight=false;
	
	@Column(name = "OPTUS_PRICE", columnDefinition="float(10,2)")
	private Float optusPrice;
		
	private Integer orderId;
	private String productId;
	
	public String getOrderDetailId() {
		return OrderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		OrderDetailId = orderDetailId;
	}
	
	

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	

	/**
	 * default constructor
	 */
	public OrderDetail() {
	}

	/**
	 * minimal constructor
	 */
	public OrderDetail(String orderDetailId) {
		super();
		OrderDetailId = orderDetailId;
	}

	/**
	 * full constructor
	 * 
	 */


	public OrderDetail(String orderDetailId, Order order, Product product,
			Integer orderQuantity, Boolean isAirFreight, Integer orderId,
			String productId) {
		super();
		OrderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.orderQuantity = orderQuantity;
		this.isAirFreight = isAirFreight;
		this.orderId = orderId;
		this.productId = productId;
	}


	// Property accessors


	public Order getOrder() {
		return order;
	}




	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
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

	public Boolean getIsAirFreight() {
		return isAirFreight;
	}

	public void setIsAirFreight(Boolean isAirFreight) {
		this.isAirFreight = isAirFreight;
	}

	public Float getOptusPrice() {
		return optusPrice;
	}

	public void setOptusPrice(Float optusPrice) {
		this.optusPrice = optusPrice;
	}

	
}