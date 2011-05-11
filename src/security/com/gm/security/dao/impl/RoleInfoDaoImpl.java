package com.gm.security.dao.impl;

import org.springframework.stereotype.Repository;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.security.dao.RoleInfoDao;
import com.gm.security.model.RoleInfo;

@Repository("roleInfoDao")
public class RoleInfoDaoImpl extends BaseEntityDao<RoleInfo, java.lang.Long> implements RoleInfoDao {

	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.security.model.RoleInfo";
	}

	public void saveOrUpdate(RoleInfo roleInfo) {
		if (roleInfo.getRoleInfoId() == null)
			save(roleInfo);
		else
			update(roleInfo);
	}

}
