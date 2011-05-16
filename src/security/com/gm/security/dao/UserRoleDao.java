package com.gm.security.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.security.model.UserRole;

public interface UserRoleDao extends EntityDao<UserRole, java.lang.Long> {

	public void saveOrUpdate(UserRole userRole);

}
