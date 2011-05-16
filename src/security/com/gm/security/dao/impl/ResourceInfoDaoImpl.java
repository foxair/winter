package com.gm.security.dao.impl;

import org.springframework.stereotype.Repository;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.security.dao.ResourceInfoDao;
import com.gm.security.model.ResourceInfo;

@Repository("resourceInfoDao")
public class ResourceInfoDaoImpl extends BaseEntityDao<ResourceInfo, java.lang.Long> implements ResourceInfoDao {

	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.security.model.ResourceInfo";
	}

	public void saveOrUpdate(ResourceInfo resourceInfo) {
		if (resourceInfo.getResourceId() == null)
			save(resourceInfo);
		else
			update(resourceInfo);
	}

}
