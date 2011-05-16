package com.gm.security.service;

import com.gm.common.service.Manager;
import com.gm.security.dao.PrivilegeResourceDao;
import com.gm.security.model.PrivilegeResource;

public interface PrivilegeResourceManager extends Manager<PrivilegeResource, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setPrivilegeResourceDao(PrivilegeResourceDao dao);

}
