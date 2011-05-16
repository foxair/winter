package com.gm.security.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.security.model.base.ResourceInfoBase;

public class ResourceInfo extends ResourceInfoBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public ResourceInfo() {
	}

	public ResourceInfo(java.lang.Long resourceId) {
		this.resourceId = resourceId;
	}

	private List<PrivilegeResource> privilegeResources = null;

	public void setPrivilegeResources(List<PrivilegeResource> privilegeResource) {
		this.privilegeResources = privilegeResource;
	}

	public List<PrivilegeResource> getPrivilegeResources() {
		return privilegeResources;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("ResourceId", getResourceId())
				.append("ResourceName", getResourceName()).append("SuperId", getSuperId())
				.append("ResourceType", getResourceType()).append("LoadType", getLoadType())
				.append("AccessType", getAccessType()).append("AppName", getAppName())
				.append("Description", getDescription()).append("Note", getNote()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof ResourceInfo == false)
			return false;
		if (this == obj)
			return true;
		ResourceInfo other = (ResourceInfo) obj;
		return new EqualsBuilder().append(getResourceId(), other.getResourceId()).isEquals();
	}
}
