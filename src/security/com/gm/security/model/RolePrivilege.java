package com.gm.security.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.security.model.base.RolePrivilegeBase;

public class RolePrivilege extends RolePrivilegeBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public RolePrivilege() {
	}

	public RolePrivilege(java.lang.Long rolePrivilegeId) {
		this.rolePrivilegeId = rolePrivilegeId;
	}

	private RoleInfo roleInfo;

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	private PrivilegeInfo privilegeInfo;

	public void setPrivilegeInfo(PrivilegeInfo privilegeInfo) {
		this.privilegeInfo = privilegeInfo;
	}

	public PrivilegeInfo getPrivilegeInfo() {
		return privilegeInfo;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("RolePrivilegeId", getRolePrivilegeId()).append("RoleInfoId", getRoleInfoId())
				.append("PrivilegeId", getPrivilegeId()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRolePrivilegeId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof RolePrivilege == false)
			return false;
		if (this == obj)
			return true;
		RolePrivilege other = (RolePrivilege) obj;
		return new EqualsBuilder().append(getRolePrivilegeId(), other.getRolePrivilegeId()).isEquals();
	}
}
