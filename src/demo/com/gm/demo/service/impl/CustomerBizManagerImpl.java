package com.gm.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.demo.model.CustomerBiz;
import com.gm.demo.dao.CustomerBizDao;
import com.gm.demo.service.CustomerBizManager;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.common.orm.mybatis.BaseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.common.service.Manager;
import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.service.BaseManager;
@Service("customerBizManager")
@Transactional
public class CustomerBizManagerImpl extends BaseManager<CustomerBiz,java.lang.Long> implements CustomerBizManager{

	private CustomerBizDao customerBizDao;
	
	@Resource
	public void setCustomerBizDao(CustomerBizDao dao) {
		this.customerBizDao = dao;
	}
	
	public CustomerBizDao getEntityDao() {
		return this.customerBizDao;
	}
	
	
}
