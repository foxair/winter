package com.gm.security.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.security.model.base.PrivilegeResourceBase;

public class PrivilegeResource extends PrivilegeResourceBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public PrivilegeResource() {
	}

	public PrivilegeResource(java.lang.Long privilegeResource) {
		this.privilegeResource = privilegeResource;
	}

	private PrivilegeInfo privilegeInfo;

	public void setPrivilegeInfo(PrivilegeInfo privilegeInfo) {
		this.privilegeInfo = privilegeInfo;
	}

	public PrivilegeInfo getPrivilegeInfo() {
		return privilegeInfo;
	}

	private ResourceInfo resourceInfo;

	public void setResourceInfo(ResourceInfo resourceInfo) {
		this.resourceInfo = resourceInfo;
	}

	public ResourceInfo getResourceInfo() {
		return resourceInfo;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("PrivilegeResource", getPrivilegeResource()).append("ResourceInfoId", getResourceInfoId())
				.append("PrivilegeId", getPrivilegeId()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getPrivilegeResource()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof PrivilegeResource == false)
			return false;
		if (this == obj)
			return true;
		PrivilegeResource other = (PrivilegeResource) obj;
		return new EqualsBuilder().append(getPrivilegeResource(), other.getPrivilegeResource()).isEquals();
	}
}
