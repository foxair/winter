package com.gm.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.service.BaseManager;
import com.gm.security.dao.PrivilegeResourceDao;
import com.gm.security.model.PrivilegeResource;
import com.gm.security.service.PrivilegeResourceManager;

@Service("privilegeResourceManager")
@Transactional
public class PrivilegeResourceManagerImpl extends BaseManager<PrivilegeResource, java.lang.Long> implements
		PrivilegeResourceManager {

	private PrivilegeResourceDao privilegeResourceDao;

	@Resource
	public void setPrivilegeResourceDao(PrivilegeResourceDao dao) {
		this.privilegeResourceDao = dao;
	}

	public PrivilegeResourceDao getEntityDao() {
		return this.privilegeResourceDao;
	}

}
