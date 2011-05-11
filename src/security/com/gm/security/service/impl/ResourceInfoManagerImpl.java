package com.gm.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.service.BaseManager;
import com.gm.security.dao.ResourceInfoDao;
import com.gm.security.model.ResourceInfo;
import com.gm.security.service.ResourceInfoManager;

@Service("resourceInfoManager")
@Transactional
public class ResourceInfoManagerImpl extends BaseManager<ResourceInfo, java.lang.Long> implements ResourceInfoManager {

	private ResourceInfoDao resourceInfoDao;

	@Resource
	public void setResourceInfoDao(ResourceInfoDao dao) {
		this.resourceInfoDao = dao;
	}

	public ResourceInfoDao getEntityDao() {
		return this.resourceInfoDao;
	}

}
