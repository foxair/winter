package com.gm.security.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.security.model.base.RoleInfoBase;

public class RoleInfo extends RoleInfoBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public RoleInfo() {
	}

	public RoleInfo(java.lang.Long roleInfoId) {
		this.roleInfoId = roleInfoId;
	}

	private List<UserRole> userRoles = null;

	public void setUserRoles(List<UserRole> userRole) {
		this.userRoles = userRole;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	private List<RolePrivilege> rolePrivileges = null;

	public void setRolePrivileges(List<RolePrivilege> rolePrivilege) {
		this.rolePrivileges = rolePrivilege;
	}

	public List<RolePrivilege> getRolePrivileges() {
		return rolePrivileges;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("RoleInfoId", getRoleInfoId())
				.append("RoleName", getRoleName()).append("SuperRoleId", getSuperRoleId())
				.append("Description", getDescription()).append("Note", getNote()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRoleInfoId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof RoleInfo == false)
			return false;
		if (this == obj)
			return true;
		RoleInfo other = (RoleInfo) obj;
		return new EqualsBuilder().append(getRoleInfoId(), other.getRoleInfoId()).isEquals();
	}
}
