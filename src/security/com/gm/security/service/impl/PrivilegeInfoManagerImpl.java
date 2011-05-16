package com.gm.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.service.BaseManager;
import com.gm.security.dao.PrivilegeInfoDao;
import com.gm.security.model.PrivilegeInfo;
import com.gm.security.service.PrivilegeInfoManager;

@Service("privilegeInfoManager")
@Transactional
public class PrivilegeInfoManagerImpl extends BaseManager<PrivilegeInfo, java.lang.Long> implements
		PrivilegeInfoManager {

	private PrivilegeInfoDao privilegeInfoDao;

	@Resource
	public void setPrivilegeInfoDao(PrivilegeInfoDao dao) {
		this.privilegeInfoDao = dao;
	}

	public PrivilegeInfoDao getEntityDao() {
		return this.privilegeInfoDao;
	}

}
