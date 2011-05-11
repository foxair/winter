package com.gm.security.dao;

import java.util.List;
import java.util.Set;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.security.model.RoleInfo;
import com.gm.security.model.UserInfo;

public interface UserInfoDao extends EntityDao<UserInfo, java.lang.Long> {

	public void saveOrUpdate(UserInfo userInfo);

	public UserInfo getByLoginAccount(java.lang.String loginAccount);

	public int deleteByLoginAccount(java.lang.String loginAccount);

	public List<RoleInfo> findRolesByUserId(Long userId);

	public List<UserInfo> findUsersWithRoles();

}
