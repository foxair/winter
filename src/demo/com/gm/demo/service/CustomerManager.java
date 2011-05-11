package com.gm.demo.service;

import java.util.List;

import com.gm.common.service.Manager;
import com.gm.demo.dao.CustomerDao;
import com.gm.demo.model.Customer;

public interface CustomerManager extends Manager<Customer, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCustomerDao(CustomerDao dao);

	public void saveAll();

	public List<Customer> getCusList();

}
