package com.ncs.iframe4.ps.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.ncs.iframe4.commons.pagination.ListAndPagingInfo;
import com.ncs.iframe4.commons.pagination.PaginationContext;
import com.ncs.iframe4.commons.tools.SequenceUUID;
import com.ncs.iframe4.commons.tools.StringUtil;
import com.ncs.iframe4.hibernate.IframeHibernatePaginationDaoSupport;
import com.ncs.iframe4.jsf.util.JSFTools;
import com.ncs.iframe4.ps.po.Product;

/**
 * 
 * @author cheng zhang
 * @version 0.1
 * @since 25/05/2012
 * 
 * 
 */
public class ProductDAOImpl extends IframeHibernatePaginationDaoSupport
		implements ProductDAO {
	

	public ProductDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);

	}

	public void save(Product product) {
		String id = SequenceUUID.getUUID32();
		product.setProductId(id);
		product.setProductStatus("A");
		getCurrentSession().save(product);

	}

	public void delete(Product product) {
		getCurrentSession().delete(product);

	}

	public Product findById(String id) {
		Product instance = (Product) getCurrentSession().get(Product.class, id);
		return instance;
	}

	public ListAndPagingInfo<Product> searchProduct(String productNum) {
		
		// use findByCriteria4Page method
		productNum = JSFTools.processNull(productNum);
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);

		if (!StringUtil.isEmptyString(productNum)||StringUtil.isEmptyString(productNum)) {
			criteria.add(Restrictions.like("productNum", productNum, MatchMode.ANYWHERE));
			criteria.add(Restrictions.sqlRestriction(" PROD_STATUS != 'O' "));
			System.out.println("-----------DetachedCriteria.toString()----------"+criteria.toString());
		//	criteria.add(Restrictions.like("productStatus", productId, MatchMode.ANYWHERE));
		}
		if (PaginationContext.getPaginationSortOrderData() != null	&& PaginationContext.getPaginationSortOrderData()
						.getSortValue() == null) {
			PaginationContext.getPaginationSortOrderData().setSortValue("updatedDt");
			PaginationContext.getPaginationSortOrderData().setAscending(false);
		}
		
		return findByCriteria4Page(criteria);

		// use find4Page method
		/*
		 * name = JSFTools.processNull(name); String hql =
		 * "FROM Customer customer " + "WHERE  customer.name like ? " +
		 * "ORDER BY customer.updatedDt DESC";
		 * 
		 * String hqlCount = "SELECT COUNT(*) FROM Customer customer " +
		 * "WHERE  customer.name like ? " + "ORDER BY customer.updatedDt DESC";
		 * 
		 * return this.find4Page(hql, hqlCount, new String[]{"%" + name + "%"});
		 */

	}
	
	public ListAndPagingInfo<Product> searchProduct4Optus(String productNum) {
		
		// use findByCriteria4Page method
		productNum = JSFTools.processNull(productNum);
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);

		if (!StringUtil.isEmptyString(productNum)||StringUtil.isEmptyString(productNum)) {
			criteria.add(Restrictions.like("productNum", productNum, MatchMode.ANYWHERE));
			criteria.add(Restrictions.sqlRestriction(" PROD_STATUS = 'A' "));
			System.out.println("-----------searchProduct4Optus DetachedCriteria.toString()----------"+criteria.toString());
		
		}
		if (PaginationContext.getPaginationSortOrderData() != null	&& PaginationContext.getPaginationSortOrderData()
						.getSortValue() == null) {
			PaginationContext.getPaginationSortOrderData().setSortValue("updatedDt");
			PaginationContext.getPaginationSortOrderData().setAscending(false);
		}
		
		return findByCriteria4Page(criteria);

	}

	public void update(Product product) {
		Product saveProduct = (Product) getCurrentSession().get(Product.class,product.getProductId());
		
		//TODO: update order amount by change optus price
		
		BeanUtils.copyProperties(product, saveProduct);
		getCurrentSession().update(saveProduct);

	}

}
