package com.gm.security.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.security.model.base.UserInfoBase;

public class UserInfo extends UserInfoBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public UserInfo() {
	}

	public UserInfo(java.lang.Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	private List<RoleInfo> roles = null;

	public List<RoleInfo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleInfo> roles) {
		this.roles = roles;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("UserInfoId", getUserInfoId())
				.append("LoginAccount", getLoginAccount()).append("UserName", getUserName())
				.append("FirstName", getFirstName()).append("LastName", getLastName())
				.append("LoginPwd", getLoginPwd()).append("LoginEmail", getLoginEmail())
				.append("UserType", getUserType()).append("RegisterTime", getRegisterTime())
				.append("UserStatus", getUserStatus()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getUserInfoId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof UserInfo == false)
			return false;
		if (this == obj)
			return true;
		UserInfo other = (UserInfo) obj;
		return new EqualsBuilder().append(getUserInfoId(), other.getUserInfoId()).isEquals();
	}
}
