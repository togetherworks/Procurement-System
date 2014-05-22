package com.ncs.iframe4.ps.po;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;


@Audited
@Entity
@Table(name = "tbl_sample_customer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class Customer implements java.io.Serializable {
    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(generator = "sample-generator")
    @GenericGenerator(name = "sample-generator", strategy = "assigned")
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "TEL_MAIN")
    private String telMain;

    @Column(name = "INDUSTRY_CD")
    private String industryCd;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "imagepath")
    private String imagepath;

    @Version
    private Integer version;

    @Column(name = "UPDATED_DT")
    private Timestamp updatedDt = new Timestamp(new Date().getTime());

    @Column(name = "DATA_FILTER_ID")
    private String dataFilterId;


    // Constructors

    /**
     * default constructor
     */
    public Customer() {
    }

    /**
     * minimal constructor
     */
    public Customer(String name, String industryCd, Integer version) {
        this.name = name;
        this.industryCd = industryCd;
        this.version = version;
    }

    /**
     * full constructor
     */
    public Customer(String name, String telMain, String industryCd, String remarks, String imagepath, Integer version, Timestamp updatedDt, String dataFilterId) {
        this.name = name;
        this.telMain = telMain;
        this.industryCd = industryCd;
        this.remarks = remarks;
        this.imagepath = imagepath;
        this.version = version;
        this.updatedDt = updatedDt;
        this.dataFilterId = dataFilterId;
    }


    // Property accessors

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelMain() {
        return this.telMain;
    }

    public void setTelMain(String telMain) {
        this.telMain = telMain;
    }

    public String getIndustryCd() {
        return this.industryCd;
    }

    public void setIndustryCd(String industryCd) {
        this.industryCd = industryCd;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImagepath() {
        return this.imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Timestamp getUpdatedDt() {
        return this.updatedDt;
    }

    public void setUpdatedDt(Timestamp updatedDt) {
        this.updatedDt = updatedDt;
    }

    public String getDataFilterId() {
        return this.dataFilterId;
    }

    public void setDataFilterId(String dataFilterId) {
        this.dataFilterId = dataFilterId;
    }


}