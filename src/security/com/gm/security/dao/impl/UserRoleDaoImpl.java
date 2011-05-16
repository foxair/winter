package com.gm.security.dao.impl;

import org.springframework.stereotype.Repository;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.security.dao.UserRoleDao;
import com.gm.security.model.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseEntityDao<UserRole, java.lang.Long> implements UserRoleDao {

	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.security.model.UserRole";
	}

	public void saveOrUpdate(UserRole userRole) {
		if (userRole.getUserRoleId() == null)
			save(userRole);
		else
			update(userRole);
	}

}
