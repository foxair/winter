package com.gm.security.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.security.model.RoleInfo;

public interface RoleInfoDao extends EntityDao<RoleInfo, java.lang.Long> {

	public void saveOrUpdate(RoleInfo roleInfo);
	
}
