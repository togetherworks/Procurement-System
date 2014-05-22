package com.ncs.iframe4.ps.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 30/05/2012
 * 
 */

@Entity
@Table(name = "tbl_ps_order")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Order implements Serializable {

	private static final long serialVersionUID = 0L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ORDER_ID", nullable=false)
	private Integer orderId;
// @OneToMany(mappedBy = "propertyDetail", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//	@OneToMany(mappedBy = "order", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) @20120628 9:47 remove lazy --result: no impact
	@OneToMany(mappedBy = "order", cascade=CascadeType.REMOVE)
	private List<OrderDetail> products;
	

	public List<OrderDetail> getProducts() {
		return products;
	}

	public void setProducts(List<OrderDetail> products) {
		this.products = products;
	}

	@Column(name = "OPTUS_PO_NUM")
	private String optusPoNum;

	@Column(name = "NCS_PO_NUM")
	private String ncsPoNum;

	@Column(name = "LENOVO_ORDER_NUM")
	private String lenovoOrderNum;

	@Column(name = "ETA")
	private Date eta;

	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	@Column(name = "OREDR_AMOUNT", columnDefinition="float(10,2)")
	private Float orderAmount=(float) 0;

	@Column(name = "DATE_RECEIVED")
	private Date dtReceived;

	@Column(name = "UPDATED_DT")
	private Timestamp updatedDt = new Timestamp(new Date().getTime());
	
	@Column(name="UPDATED_BY")
	private String updateBy;

	// @ManyToMany
	// @JoinTable(
	// name="tbl_ps_order_detail",
	// joinColumns=
	// @JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID"),
	// inverseJoinColumns=
	// @JoinColumn(name="PROD_ID", referencedColumnName="PROD_ID")
	// )
	//
	// private List<Product> productList;
	//
	//
	// public List<Product> getProductList() {
	// return productList;
	// }
	//
	// public void setProductList(List<Product> productList) {
	// this.productList = productList;
	// }

	// Constructors
	



	/**
	 * default constructor
	 */
	public Order() {
	}

	/**
	 * minimal constructor
	 */
	public Order(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	/**
	 * full constructor
	 */
	public Order(Integer orderId, List<OrderDetail> products, String optusPoNum,
			String ncsPoNum, String lenovoOrderNum, Date eta,
			String orderStatus, Float orderAmount, Date dtReceived,
			Timestamp updatedDt, String updateBy) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.optusPoNum = optusPoNum;
		this.ncsPoNum = ncsPoNum;
		this.lenovoOrderNum = lenovoOrderNum;
		this.eta = eta;
		this.orderStatus = orderStatus;
		this.orderAmount = orderAmount;
		this.dtReceived = dtReceived;
		this.updatedDt = updatedDt;
		this.updateBy = updateBy;
	}

	// Property accessors
	
	public String getUpdateBy() {
		return updateBy;
	}

	

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public Date getDtReceived() {
		return dtReceived;
	}

	public void setDtReceived(Date dtReceived) {
		this.dtReceived = dtReceived;
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

	public Timestamp getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Timestamp updatedDt) {
		this.updatedDt = updatedDt;
	}

}