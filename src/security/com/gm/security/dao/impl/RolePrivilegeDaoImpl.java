package com.gm.security.dao.impl;

import org.springframework.stereotype.Repository;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.security.dao.RolePrivilegeDao;
import com.gm.security.model.RolePrivilege;

@Repository("rolePrivilegeDao")
public class RolePrivilegeDaoImpl extends BaseEntityDao<RolePrivilege, java.lang.Long> implements RolePrivilegeDao {

	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.security.model.RolePrivilege";
	}

	public void saveOrUpdate(RolePrivilege rolePrivilege) {
		if (rolePrivilege.getRolePrivilegeId() == null)
			save(rolePrivilege);
		else
			update(rolePrivilege);
	}

}
