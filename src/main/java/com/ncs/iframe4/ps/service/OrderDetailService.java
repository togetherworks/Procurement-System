package com.ncs.iframe4.ps.service;

import java.util.List;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.OrderDetail;
import com.ncs.iframe4.ps.to.OrderDetailFormTO;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 06/06/2012 
 *
 */

public interface OrderDetailService {

    public void save(OrderDetailFormTO orderDetailBean);

    public void removeOrderedProduct(OrderDetail selectedProduct);

    public ListAndPagingInfo<OrderDetail> searchOrderedProducts(Integer orderId);

    public void update(OrderDetailFormTO orderDetailBean);

	public OrderDetail findOrderDetailById(String orderDetailId);

	public Boolean checkProductExist(Integer oID, String pID);
	
//	public Order findById(Integer orderId);
    
	public Float loadOrderAmountById(Integer orderId);
	
	public List<OrderDetail> getOrderDetail4Export(Integer orderId);

}
