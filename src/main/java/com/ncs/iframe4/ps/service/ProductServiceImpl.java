package com.ncs.iframe4.ps.service;

import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.ps.dao.ProductDAO;
import com.ncs.iframe4.ps.po.Product;
import com.ncs.iframe4.ps.to.ProductFormTO;
import com.ncs.iframe4.ps.to.ProductUpdateFormBean;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 *
 * 
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
//    private OrderDetailDAO orderDetailDAO;

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void save(ProductFormTO productBean) {
        Product product = new Product();
        BeanUtils.copyProperties(productBean, product);
        productDAO.save(product);
    }

    public void delete(Product[] product) {
        for (int i = 0; i < product.length; i++) {
        	productDAO.delete(product[i]);
        }
    }

    public Product findById(String id) {
        return productDAO.findById(id);
    }
    
//	public OrderDetail findExistProduct(String productId) {
//		// TODO added 20/06 check product exist in order details
//		return orderDetailDAO.findExistProduct(productId);
//	}
    
    
    

    public ListAndPagingInfo<Product> searchProduct(String name) {
        return productDAO.searchProduct(name);
    }
    
    public ListAndPagingInfo<Product> searchProduct4Optus(String name) {
        return productDAO.searchProduct4Optus(name);
    }


    public void update(ProductFormTO productFormTO) {
    	ProductUpdateFormBean productUpdateFormBean = (ProductUpdateFormBean)productFormTO;
        Product product = new Product();
        BeanUtils.copyProperties(productUpdateFormBean, product);
        productDAO.update(product);
    }


}
