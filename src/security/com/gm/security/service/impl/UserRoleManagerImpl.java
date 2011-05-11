package com.gm.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.service.BaseManager;
import com.gm.security.dao.UserRoleDao;
import com.gm.security.model.UserRole;
import com.gm.security.service.UserRoleManager;

@Service("userRoleManager")
@Transactional
public class UserRoleManagerImpl extends BaseManager<UserRole, java.lang.Long> implements UserRoleManager {

	private UserRoleDao userRoleDao;

	@Resource
	public void setUserRoleDao(UserRoleDao dao) {
		this.userRoleDao = dao;
	}

	public UserRoleDao getEntityDao() {
		return this.userRoleDao;
	}

}
