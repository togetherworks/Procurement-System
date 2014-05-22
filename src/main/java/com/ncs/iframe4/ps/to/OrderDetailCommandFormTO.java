package com.ncs.iframe4.ps.to;

import java.io.Serializable;

import org.primefaces.model.LazyDataModel;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 05/06/2012
 * 
 */

public class OrderDetailCommandFormTO implements Serializable {

	private LazyDataModel o2pTOs;
	private OrderDetailFormTO selectOrderDetailFormTo[];
	
	public OrderDetailFormTO[] getSelectOrderDetailFormTo() {
		return selectOrderDetailFormTo;
	}

	public void setSelectOrderDetailFormTo(
			OrderDetailFormTO[] selectOrderDetailFormTo) {
		this.selectOrderDetailFormTo = selectOrderDetailFormTo;
	}
	
	public LazyDataModel getO2pTOs() {
		return o2pTOs;
	}

	public void setO2pTOs(LazyDataModel o2pTOs) {
		this.o2pTOs = o2pTOs;
	}



}
