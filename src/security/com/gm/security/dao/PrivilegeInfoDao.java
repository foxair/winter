package com.gm.security.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.security.model.PrivilegeInfo;

public interface PrivilegeInfoDao extends EntityDao<PrivilegeInfo, java.lang.Long> {

	public void saveOrUpdate(PrivilegeInfo privilegeInfo);

}
