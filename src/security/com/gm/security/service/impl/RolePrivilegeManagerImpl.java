package com.gm.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.service.BaseManager;
import com.gm.security.dao.RolePrivilegeDao;
import com.gm.security.model.RolePrivilege;
import com.gm.security.service.RolePrivilegeManager;

@Service("rolePrivilegeManager")
@Transactional
public class RolePrivilegeManagerImpl extends BaseManager<RolePrivilege, java.lang.Long> implements
		RolePrivilegeManager {

	private RolePrivilegeDao rolePrivilegeDao;

	@Resource
	public void setRolePrivilegeDao(RolePrivilegeDao dao) {
		this.rolePrivilegeDao = dao;
	}

	public RolePrivilegeDao getEntityDao() {
		return this.rolePrivilegeDao;
	}

}
