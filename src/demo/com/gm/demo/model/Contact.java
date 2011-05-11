package com.gm.demo.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.demo.model.base.ContactBase;

public class Contact extends ContactBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public Contact() {
	}

	public Contact(java.lang.Long contactId) {
		this.contactId = contactId;
	}

	private List<CusContact> cusContacts = null;

	public void setCusContacts(List<CusContact> cusContact) {
		this.cusContacts = cusContact;//a
	}

	public List<CusContact> getCusContacts() {
		return cusContacts;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("ContactId", getContactId())
				.append("ContactName", getContactName()).append("Gender", getGender())
				.append("Position", getPosition()).append("Mobile", getMobile()).append("WorkPhone", getWorkPhone())
				.append("Email", getEmail()).append("HomePhone", getHomePhone()).append("Qq", getQq())
				.append("Msn", getMsn()).append("Other", getOther()).append("Status", getStatus())
				.append("CreateBy", getCreateBy()).append("CreateTime", getCreateTime())
				.append("UpdateBy", getUpdateBy()).append("UpdateTime", getUpdateTime()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getContactId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Contact == false)
			return false;
		if (this == obj)
			return true;
		Contact other = (Contact) obj;
		return new EqualsBuilder().append(getContactId(), other.getContactId()).isEquals();
	}
}
