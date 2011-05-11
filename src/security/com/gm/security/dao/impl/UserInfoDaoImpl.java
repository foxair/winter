package com.gm.security.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.security.dao.UserInfoDao;
import com.gm.security.model.RoleInfo;
import com.gm.security.model.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseEntityDao<UserInfo, java.lang.Long> implements UserInfoDao {

	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.security.model.UserInfo";
	}

	public void saveOrUpdate(UserInfo userInfo) {
		if (userInfo.getUserInfoId() == null)
			save(userInfo);
		else
			update(userInfo);
	}

	public UserInfo getByLoginAccount(java.lang.String loginAccount) {
		return (UserInfo) getSqlSessionTemplate().selectOne(getMybatisMapperNamesapce() + ".getByLoginAccount",
				loginAccount);
	}

	public int deleteByLoginAccount(java.lang.String loginAccount) {
		return getSqlSessionTemplate().delete(getMybatisMapperNamesapce() + ".deleteByLoginAccount", loginAccount);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<RoleInfo> findRolesByUserId(Long userId) {
		List roleList = getSqlSessionTemplate().selectList(getMybatisMapperNamesapce() + ".findRolesByUserId", userId);
		return roleList;
	}

	@SuppressWarnings({"rawtypes", "unchecked" })
	@Override
	public List<UserInfo> findUsersWithRoles() {
		List userinfo = getSqlSessionTemplate().selectList(getMybatisMapperNamesapce() + ".findUserWithRoles");
		return userinfo;
	}

}
