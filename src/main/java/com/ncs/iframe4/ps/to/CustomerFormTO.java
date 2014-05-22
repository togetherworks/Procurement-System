package com.ncs.iframe4.ps.to;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
/**
 * This class is common page bean,extended by every formTO
 * User: qinjun
 * Date: 12-1-11
 * To change this template use File | Settings | File Templates.
 */
public class CustomerFormTO implements Serializable {
	private static final long serialVersionUID = 0L;
    private String customerId;
    private String name;
    private String telMain;
    private String industryCd;
    private String remarks;
    private String imagepath;
    private Integer version;
    private Timestamp updatedDt = new Timestamp(new Date().getTime());
    private String dataFilterId;


    public CustomerFormTO() {
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelMain() {
        return telMain;
    }

    public void setTelMain(String telMain) {
        this.telMain = telMain;
    }

    public String getIndustryCd() {
        return industryCd;
    }

    public void setIndustryCd(String industryCd) {
        this.industryCd = industryCd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Timestamp getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Timestamp updatedDt) {
        this.updatedDt = updatedDt;
    }

    public String getDataFilterId() {
        return dataFilterId;
    }

    public void setDataFilterId(String dataFilterId) {
        this.dataFilterId = dataFilterId;
    }
}
