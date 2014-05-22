package com.ncs.iframe4.ps.dao;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.Product;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 *
 */
public interface ProductDAO {

   public void save(Product product);

   public void delete(Product product);

   public Product findById(String id);

   public ListAndPagingInfo<Product> searchProduct(String name);
   
   public ListAndPagingInfo<Product> searchProduct4Optus(String name);

   public void update(Product product);

}
