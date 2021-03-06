package com.gm.demo.dao;

import java.util.List;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.orm.mybatis.Page;
import com.gm.common.orm.mybatis.QueryRequest;
import com.gm.demo.model.Customer;

public interface CustomerDao extends EntityDao<Customer, java.lang.Long> {

	public void saveOrUpdate(Customer customer);

	public List<Customer> findCusList();

	public Page<Customer> findCusListPage(QueryRequest<Customer> queryRequest);

}
