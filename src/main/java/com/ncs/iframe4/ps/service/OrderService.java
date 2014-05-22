package com.ncs.iframe4.ps.service;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.Order;
import com.ncs.iframe4.ps.to.OrderFormTO;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 31/05/2012 
 *
 */

public interface OrderService {
	
	public void load();
	
    public void save(OrderFormTO orderBean);

    public void delete(Order[] order);

    public Order findById(Integer id);

    public ListAndPagingInfo<Order> searchOrder(Integer orderId, String optusPoNum,String ncsPoNum);
    
    public ListAndPagingInfo<Order> searchOrderStatusByOptusPO(String optusPoNum);

    public void update(OrderFormTO orderBean);
    
//    public List<OrderDetail> searchOrderedProducts(Integer orderId);
    

}
