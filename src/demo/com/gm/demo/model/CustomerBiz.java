package com.gm.demo.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gm.demo.model.base.CustomerBizBase;

public class CustomerBiz extends CustomerBizBase implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public CustomerBiz() {
	}

	public CustomerBiz(java.lang.Long bizId) {
		this.bizId = bizId;
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
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("BizId", getBizId())
				.append("CusId", getCusId()).append("Consultant", getConsultant()).append("Cs", getCs())
				.append("Cooperation", getCooperation()).append("CusLevel", getCusLevel())
				.append("GmcLevel", getGmcLevel()).append("ReceiptAddress", getReceiptAddress())
				.append("BackupAddress1", getBackupAddress1()).append("BackupAddress2", getBackupAddress2())
				.append("ShippingArea", getShippingArea()).append("Status", getStatus())
				.append("CreateBy", getCreateBy()).append("CreateTime", getCreateTime())
				.append("UpdateBy", getUpdateBy()).append("UpdateTime", getUpdateTime()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getBizId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof CustomerBiz == false)
			return false;
		if (this == obj)
			return true;
		CustomerBiz other = (CustomerBiz) obj;
		return new EqualsBuilder().append(getBizId(), other.getBizId()).isEquals();
	}
}
