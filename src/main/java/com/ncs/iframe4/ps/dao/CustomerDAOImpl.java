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
import com.ncs.iframe4.ps.po.Customer;

public class CustomerDAOImpl extends IframeHibernatePaginationDaoSupport
		implements CustomerDAO {

	public CustomerDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public void save(Customer customer) {
		String id = SequenceUUID.getUUID32();
		customer.setCustomerId(id);
		getCurrentSession().save(customer);

	}

	public void delete(Customer customer) {
		getCurrentSession().delete(customer);

	}

	public Customer findById(String id) {
		Customer instance = (Customer) getCurrentSession().get(Customer.class,
				id);
		return instance;
	}

	public ListAndPagingInfo<Customer> searchCustomer(String name) {

		// use findByCriteria4Page method

		name = JSFTools.processNull(name);
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

		if (!StringUtil.isEmptyString(name)) {
			criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}
		if (PaginationContext.getPaginationSortOrderData() != null
				&& PaginationContext.getPaginationSortOrderData()
						.getSortValue() == null) {
			PaginationContext.getPaginationSortOrderData().setSortValue(
					"updatedDt");
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

	public void update(Customer customer) {
		Customer saveCustomer = (Customer) getCurrentSession().get(
				Customer.class, customer.getCustomerId());
		BeanUtils.copyProperties(customer, saveCustomer);
		getCurrentSession().update(saveCustomer);
	}

}