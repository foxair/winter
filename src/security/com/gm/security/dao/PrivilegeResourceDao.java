package com.gm.security.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.security.model.PrivilegeResource;

public interface PrivilegeResourceDao extends EntityDao<PrivilegeResource, java.lang.Long> {

	public void saveOrUpdate(PrivilegeResource privilegeResource);

}
