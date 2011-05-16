package com.gm.security.dao.impl;

import org.springframework.stereotype.Repository;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.security.dao.PrivilegeResourceDao;
import com.gm.security.model.PrivilegeResource;

@Repository("privilegeResourceDao")
public class PrivilegeResourceDaoImpl extends BaseEntityDao<PrivilegeResource, java.lang.Long> implements
		PrivilegeResourceDao {

	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.security.model.PrivilegeResource";
	}

	public void saveOrUpdate(PrivilegeResource privilegeResource) {
		if (privilegeResource.getPrivilegeResource() == null)
			save(privilegeResource);
		else
			update(privilegeResource);
	}

}
