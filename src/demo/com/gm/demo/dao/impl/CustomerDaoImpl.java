package com.gm.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.demo.dao.CustomerDao;
import com.gm.demo.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseEntityDao<Customer,java.lang.Long> implements CustomerDao{
	
	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.demo.model.Customer";
	}
	
	public void saveOrUpdate(Customer customer) {
		if(customer.getCusId() == null) 
			save(customer);
		else 
			update(customer);
	}

	@Override
	public List<Customer> findCusList() {
		List<Customer> cusList = (List<Customer>)getSqlSessionTemplate().selectList(getStatement("findCusList"));
		return cusList;
	}
	
	
}
