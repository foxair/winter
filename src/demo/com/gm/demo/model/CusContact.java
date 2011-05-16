package com.gm.demo.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.demo.model.base.CusContactBase;

public class CusContact extends CusContactBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public CusContact() {
	}

	public CusContact(java.lang.Long cusContactId) {
		this.cusContactId = cusContactId;
	}

	private Contact contact;

	public void setContact(Contact contact) {
		this.contact = contact;
		this.contactId = contact.getContactId();
	}

	public Contact getContact() {
		return contact;
	}

	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
		this.cusId = customer.getCusId();
	}

	public Customer getCustomer() {
		return customer;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("CusContactId", getCusContactId())
				.append("CusId", getCusId()).append("ContactId", getContactId()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCusContactId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof CusContact == false)
			return false;
		if (this == obj)
			return true;
		CusContact other = (CusContact) obj;
		return new EqualsBuilder().append(getCusContactId(), other.getCusContactId()).isEquals();
	}
}
