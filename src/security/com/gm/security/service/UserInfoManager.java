package com.gm.security.service;

import java.util.List;

import com.gm.common.service.Manager;
import com.gm.security.dao.UserInfoDao;
import com.gm.security.model.RoleInfo;
import com.gm.security.model.UserInfo;

public interface UserInfoManager extends Manager<UserInfo, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserInfoDao(UserInfoDao dao);

	public UserInfo getByLoginAccount(java.lang.String loginAccount);

	public int deleteByLoginAccount(java.lang.String loginAccount);

	public List<RoleInfo> findRolesByUserId(Long userId);

}
