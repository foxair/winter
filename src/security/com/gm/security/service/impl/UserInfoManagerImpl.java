package com.gm.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.service.BaseManager;
import com.gm.security.dao.UserInfoDao;
import com.gm.security.model.RoleInfo;
import com.gm.security.model.UserInfo;
import com.gm.security.service.UserInfoManager;

@Service("userInfoManager")
@Transactional
public class UserInfoManagerImpl extends BaseManager<UserInfo, java.lang.Long> implements UserInfoManager {

	private UserInfoDao userInfoDao;

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	@Resource
	public void setUserInfoDao(UserInfoDao dao) {
		this.userInfoDao = dao;
	}

	@SuppressWarnings("unchecked")
	public EntityDao getEntityDao() {
		return this.userInfoDao;
	}

	public int deleteByLoginAccount(java.lang.String loginAccount) {
		return userInfoDao.deleteByLoginAccount(loginAccount);
	}

	@Transactional(readOnly = true)
	public UserInfo getByLoginAccount(java.lang.String loginAccount) {
		return userInfoDao.getByLoginAccount(loginAccount);
	}

	@Override
	public List<RoleInfo> findRolesByUserId(Long userId) {
		return userInfoDao.findRolesByUserId(userId);
	}

}
