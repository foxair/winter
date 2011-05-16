package com.gm.security.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.security.model.RolePrivilege;

public interface RolePrivilegeDao extends EntityDao<RolePrivilege, java.lang.Long> {

	public void saveOrUpdate(RolePrivilege rolePrivilege);

}
