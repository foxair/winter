package com.gm.demo.dao.impl;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.common.orm.mybatis.BaseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.common.service.Manager;
import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.service.BaseManager;
import com.gm.demo.model.CustomerBiz;
import com.gm.demo.dao.CustomerBizDao;

@Repository("customerBizDao")
public class CustomerBizDaoImpl extends BaseEntityDao<CustomerBiz,java.lang.Long> implements CustomerBizDao{
	
	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.demo.model.CustomerBiz";
	}
	
	public void saveOrUpdate(CustomerBiz customerBiz) {
		if(customerBiz.getBizId() == null) 
			save(customerBiz);
		else 
			update(customerBiz);
	}
	
	
}
