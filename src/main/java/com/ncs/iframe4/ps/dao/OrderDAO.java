package com.ncs.iframe4.ps.dao;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.Order;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 31/05/2012
 *
 */
public interface OrderDAO {
   
   public void load();
   
   public void save(Order order);

   public void delete(Order order);

   public Order findById(Integer id);

   public ListAndPagingInfo<Order> searchOrder(Integer orderId, String optusPoNum, String ncsPoNum);
   
   public ListAndPagingInfo<Order> searchOrderStatus(String optusPoNum);
   
   public void update(Order order);
   
//   public List<OrderDetail> searchOrderedProducts(Integer orderId);

   
}
