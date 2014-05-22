package com.ncs.iframe4.ps.dao;

import java.util.List;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.OrderDetail;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 06/06/2012
 * 
 */
public interface OrderDetailDAO {

    public void save(OrderDetail orderDetail);

    public void removeOrderedProduct(OrderDetail orderDetail);

    public OrderDetail findOrderDetailById(String orderDetailId);

    public ListAndPagingInfo<OrderDetail> searchOrderedProducts(Integer orderId);

    public void update(OrderDetail orderDetail);

    public Boolean checkProductExist(Integer oID, String pID);
	
//    public Order findById(Integer orderId);
    public Float loadOrderAmountById(Integer orderId);

	public List<OrderDetail> getOrderDetail4Export(Integer orderId);
}
