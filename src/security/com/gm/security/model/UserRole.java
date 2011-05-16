package com.gm.security.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.security.model.base.UserRoleBase;

public class UserRole extends UserRoleBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public UserRole() {
	}

	public UserRole(java.lang.Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	private UserInfo userInfo;

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	private RoleInfo roleInfo;

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("UserRoleId", getUserRoleId())
				.append("RoleInfoId", getRoleInfoId()).append("UserInfoId", getUserInfoId()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getUserRoleId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof UserRole == false)
			return false;
		if (this == obj)
			return true;
		UserRole other = (UserRole) obj;
		return new EqualsBuilder().append(getUserRoleId(), other.getUserRoleId()).isEquals();
	}
}
