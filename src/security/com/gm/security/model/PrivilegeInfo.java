package com.gm.security.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.security.model.base.PrivilegeInfoBase;

public class PrivilegeInfo extends PrivilegeInfoBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public PrivilegeInfo() {
	}

	public PrivilegeInfo(java.lang.Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	private List<RolePrivilege> rolePrivileges = null;

	public void setRolePrivileges(List<RolePrivilege> rolePrivilege) {
		this.rolePrivileges = rolePrivilege;
	}

	public List<RolePrivilege> getRolePrivileges() {
		return rolePrivileges;
	}

	private List<PrivilegeResource> privilegeResources = null;

	public void setPrivilegeResources(List<PrivilegeResource> privilegeResource) {
		this.privilegeResources = privilegeResource;
	}

	public List<PrivilegeResource> getPrivilegeResources() {
		return privilegeResources;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("PrivilegeId", getPrivilegeId())
				.append("PrivilegeName", getPrivilegeName()).append("PrivilegeValue", getPrivilegeValue())
				.append("AccessType", getAccessType()).append("Description", getDescription())
				.append("Note", getNote()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getPrivilegeId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof PrivilegeInfo == false)
			return false;
		if (this == obj)
			return true;
		PrivilegeInfo other = (PrivilegeInfo) obj;
		return new EqualsBuilder().append(getPrivilegeId(), other.getPrivilegeId()).isEquals();
	}
}
