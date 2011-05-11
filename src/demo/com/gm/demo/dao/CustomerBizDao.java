package com.gm.demo.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.demo.model.CustomerBiz;

public interface CustomerBizDao extends EntityDao<CustomerBiz, java.lang.Long> {

	public void saveOrUpdate(CustomerBiz customerBiz);

}
