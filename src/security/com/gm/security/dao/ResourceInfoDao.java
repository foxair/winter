package com.gm.security.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.security.model.ResourceInfo;

public interface ResourceInfoDao extends EntityDao<ResourceInfo, java.lang.Long> {

	public void saveOrUpdate(ResourceInfo resourceInfo);

}
