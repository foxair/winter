package com.gm.security.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.gm.security.model.RoleInfo;

/**
 * 扩展SpringSecurity的WebAuthenticationDetails类, 增加登录时间属性和角色属性.
 * 
 */
public class OperatorDetails extends User {
	private static final long serialVersionUID = 1919464185097508773L;

	private Date loginTime;

	private List<RoleInfo> roleList;

	public OperatorDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities)
			throws IllegalArgumentException {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public List<RoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
