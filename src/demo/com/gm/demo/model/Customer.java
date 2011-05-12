package com.gm.demo.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.demo.model.base.CustomerBase;

public class Customer extends CustomerBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public Customer() {
	}

	public Customer(java.lang.Long cusId) {
		this.cusId = cusId;
	}

	private List<CustomerBiz> customerBizs = null;

	public void setCustomerBizs(List<CustomerBiz> customerBiz) {
		this.customerBizs = customerBiz;//a
	}

	public List<CustomerBiz> getCustomerBizs() {
		return customerBizs;
	}

	private List<CusContact> cusContacts = null;

	public void setCusContacts(List<CusContact> cusContact) {
		this.cusContacts = cusContact;//a
	}

	public List<CusContact> getCusContacts() {
		return cusContacts;
	}

	private List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("CusId", getCusId())
				.append("CusNo", getCusNo()).append("CusEngName", getCusEngName())
				.append("CusChnName", getCusChnName()).append("Area", getArea()).append("Address", getAddress())
				.append("Zipcode", getZipcode()).append("ContactTel", getContactTel())
				.append("BackupTel1", getBackupTel1()).append("BackupTel2", getBackupTel2()).append("Fax", getFax())
				.append("CusEngIntro", getCusEngIntro()).append("CusChnIntro", getCusChnIntro())
				.append("Website", getWebsite()).append("Remark", getRemark()).append("Status", getStatus())
				.append("CreateBy", getCreateBy()).append("CreateTime", getCreateTime())
				.append("UpdateBy", getUpdateBy()).append("UpdateTime", getUpdateTime()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCusId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Customer == false)
			return false;
		if (this == obj)
			return true;
		Customer other = (Customer) obj;
		return new EqualsBuilder().append(getCusId(), other.getCusId()).isEquals();
	}
}
