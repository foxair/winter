package com.gm.demo.service;

import com.gm.common.service.Manager;
import com.gm.demo.dao.CustomerBizDao;
import com.gm.demo.model.CustomerBiz;

public interface CustomerBizManager extends Manager<CustomerBiz, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCustomerBizDao(CustomerBizDao dao);

}
