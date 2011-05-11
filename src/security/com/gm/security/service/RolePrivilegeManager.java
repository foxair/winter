package com.gm.security.service;

import com.gm.common.service.Manager;
import com.gm.security.dao.RolePrivilegeDao;
import com.gm.security.model.RolePrivilege;

public interface RolePrivilegeManager extends Manager<RolePrivilege, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setRolePrivilegeDao(RolePrivilegeDao dao);

}
