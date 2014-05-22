package com.ncs.iframe4.ps.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 25/05/2012
 * 
 */


@Entity
@Table(name = "tbl_ps_product")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Product implements Serializable {
	
	private static final long serialVersionUID = 0L;
	
	@Id
	@Column (name="PROD_ID", nullable=false)
	private String productId;
	
	
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orders;

	public List<OrderDetail> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}

	@Column (name = "PROD_NUM")
	private String productNum;

	@Column(name = "PRODUCT_DESC")
	private String productDesc;
	
	@Column (name="PROD_STATUS")
	private String productStatus;
	
	@Column(name = "PRODUCT_QUANTITY")
	private String productQuantity;

	@Column(name = "UNIT")
	private String unit;

	@Column(name = "NCS_PRICE", columnDefinition="float(10,2)")
	private Float ncsPrice;

	@Column(name = "PERCENTAGE")
	private Float percentage;

	@Column(name = "OPTUS_PRICE", columnDefinition="float(10,2)")
	private Float optusPrice;

	@Column(name = "AIR_FREIGHT", columnDefinition="float(10,2)")
	private Float airFreight;

	@Column(name = "UPDATED_DT")
	private Timestamp updatedDt = new Timestamp(new Date().getTime());
	
	@Column(name="UPDATED_BY")
	private String updateBy;

//	@ManyToMany(mappedBy="productList",fetch=FetchType.EAGER)
//	private List<Order> orederList;
//	
//	public List<Order> getOrederDetails() {
//		return orederList;
//	}
//
//	public void setOrederDetails(List<Order> orederDetails) {
//		this.orederList = orederDetails;
//	}
	// Constructors

	

	/**
	 * default constructor
	 */
	public Product() {
	}

	/**
	 * minimal constructor
	 */
	public Product(String productId) {
		super();
		this.productId = productId;
	}
	

	/**
	 * full constructor
	 */

	public Product(String productId, List<OrderDetail> orders,
			String productNum, String productDesc, String productStatus,
			String productQuantity, String unit, Float ncsPrice,
			Float percentage, Float optusPrice, Float airFreight,
			Timestamp updatedDt, String updateBy) {
		super();
		this.productId = productId;
		this.orders = orders;
		this.productNum = productNum;
		this.productDesc = productDesc;
		this.productStatus = productStatus;
		this.productQuantity = productQuantity;
		this.unit = unit;
		this.ncsPrice = ncsPrice;
		this.percentage = percentage;
		this.optusPrice = optusPrice;
		this.airFreight = airFreight;
		this.updatedDt = updatedDt;
		this.updateBy = updateBy;
	}



	// Property accessors
	
	public String getProductStatus() {
		return productStatus;
	}


	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}


	
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
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


	

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

		

	

	public Float getNcsPrice() {
		return ncsPrice;
	}

	public void setNcsPrice(Float ncsPrice) {
		this.ncsPrice = ncsPrice;
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