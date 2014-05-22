package com.ncs.iframe4.ps.service;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.po.Product;
import com.ncs.iframe4.ps.to.ProductFormTO;

/**
 * @author Cheng Zhang
 * @version 0.1
 * @since 25/05/2012 
 *
 */

public interface ProductService {

    public void save(ProductFormTO productBean);

    public void delete(Product[] products);

    public Product findById(String id);

    public ListAndPagingInfo<Product> searchProduct(String name);
    
    public ListAndPagingInfo<Product> searchProduct4Optus(String name);

    public void update(ProductFormTO productBean);


    // TODO added 20/06 check product exist in order details
//    public OrderDetail findExistProduct(String productId);
}
