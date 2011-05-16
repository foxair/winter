package com.gm.demo.model.base;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.core.text.DateFormatUtils;

public class CustomerBizBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats
	public static final String FORMAT_CREATE_TIME = DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = DATE_FORMAT;

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long bizId;
	@NotNull
	protected java.lang.Long cusId;
	@NotNull
	protected java.lang.Long consultant;
	@NotNull
	protected java.lang.Long cs;
	@Length(max = 1)
	protected java.lang.String cooperation;
	@Length(max = 1)
	protected java.lang.String cusLevel;
	@Length(max = 1)
	protected java.lang.String gmcLevel;
	@Length(max = 256)
	protected java.lang.String receiptAddress;
	@Length(max = 256)
	protected java.lang.String backupAddress1;
	@Length(max = 256)
	protected java.lang.String backupAddress2;

	protected java.lang.Integer shippingArea;
	@NotBlank
	@Length(max = 1)
	protected java.lang.String status;
	@NotNull
	protected java.lang.Long createBy;
	@NotNull
	protected java.util.Date createTime;
	@NotNull
	protected java.lang.Long updateBy;
	@NotNull
	protected java.util.Date updateTime;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("bizId", "biz_id");
		FIELD_MAP.put("cusId", "cus_id");
		FIELD_MAP.put("consultant", "consultant");
		FIELD_MAP.put("cs", "cs");
		FIELD_MAP.put("cooperation", "cooperation");
		FIELD_MAP.put("cusLevel", "cus_level");
		FIELD_MAP.put("gmcLevel", "gmc_level");
		FIELD_MAP.put("receiptAddress", "receipt_address");
		FIELD_MAP.put("backupAddress1", "backup_address1");
		FIELD_MAP.put("backupAddress2", "backup_address2");
		FIELD_MAP.put("shippingArea", "shipping_area");
		FIELD_MAP.put("status", "status");
		FIELD_MAP.put("createBy", "create_by");
		FIELD_MAP.put("createTime", "create_time");
		FIELD_MAP.put("updateBy", "update_by");
		FIELD_MAP.put("updateTime", "update_time");
	}

	public static final String BIZ_ID = "bizId";
	public static final String CUS_ID = "cusId";
	public static final String CONSULTANT = "consultant";
	public static final String CS = "cs";
	public static final String COOPERATION = "cooperation";
	public static final String CUS_LEVEL = "cusLevel";
	public static final String GMC_LEVEL = "gmcLevel";
	public static final String RECEIPT_ADDRESS = "receiptAddress";
	public static final String BACKUP_ADDRESS1 = "backupAddress1";
	public static final String BACKUP_ADDRESS2 = "backupAddress2";
	public static final String SHIPPING_AREA = "shippingArea";
	public static final String STATUS = "status";
	public static final String CREATE_BY = "createBy";
	public static final String CREATE_TIME = "createTime";
	public static final String UPDATE_BY = "updateBy";
	public static final String UPDATE_TIME = "updateTime";

	public void setBizId(java.lang.Long value) {
		this.bizId = value;
	}

	public java.lang.Long getBizId() {
		return this.bizId;
	}

	public void setCusId(java.lang.Long value) {
		this.cusId = value;
	}

	public java.lang.Long getCusId() {
		return this.cusId;
	}

	public void setConsultant(java.lang.Long value) {
		this.consultant = value;
	}

	public java.lang.Long getConsultant() {
		return this.consultant;
	}

	public void setCs(java.lang.Long value) {
		this.cs = value;
	}

	public java.lang.Long getCs() {
		return this.cs;
	}

	public void setCooperation(java.lang.String value) {
		this.cooperation = value;
	}

	public java.lang.String getCooperation() {
		return this.cooperation;
	}

	public void setCusLevel(java.lang.String value) {
		this.cusLevel = value;
	}

	public java.lang.String getCusLevel() {
		return this.cusLevel;
	}

	public void setGmcLevel(java.lang.String value) {
		this.gmcLevel = value;
	}

	public java.lang.String getGmcLevel() {
		return this.gmcLevel;
	}

	public void setReceiptAddress(java.lang.String value) {
		this.receiptAddress = value;
	}

	public java.lang.String getReceiptAddress() {
		return this.receiptAddress;
	}

	public void setBackupAddress1(java.lang.String value) {
		this.backupAddress1 = value;
	}

	public java.lang.String getBackupAddress1() {
		return this.backupAddress1;
	}

	public void setBackupAddress2(java.lang.String value) {
		this.backupAddress2 = value;
	}

	public java.lang.String getBackupAddress2() {
		return this.backupAddress2;
	}

	public void setShippingArea(java.lang.Integer value) {
		this.shippingArea = value;
	}

	public java.lang.Integer getShippingArea() {
		return this.shippingArea;
	}

	public void setStatus(java.lang.String value) {
		this.status = value;
	}

	public java.lang.String getStatus() {
		return this.status;
	}

	public void setCreateBy(java.lang.Long value) {
		this.createBy = value;
	}

	public java.lang.Long getCreateBy() {
		return this.createBy;
	}

	public String getCreateTimeString() {
		return DateFormatUtils.format(getCreateTime(), FORMAT_CREATE_TIME);
	}

	public void setCreateTimeString(String value) {
		setCreateTime(DateFormatUtils.parse(value, FORMAT_CREATE_TIME, java.util.Date.class));
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateBy(java.lang.Long value) {
		this.updateBy = value;
	}

	public java.lang.Long getUpdateBy() {
		return this.updateBy;
	}

	public String getUpdateTimeString() {
		return DateFormatUtils.format(getUpdateTime(), FORMAT_UPDATE_TIME);
	}

	public void setUpdateTimeString(String value) {
		setUpdateTime(DateFormatUtils.parse(value, FORMAT_UPDATE_TIME, java.util.Date.class));
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	/** createTime */
	protected java.util.Date createTimeBegin;
	protected java.util.Date createTimeEnd;
	/** updateTime */
	protected java.util.Date updateTimeBegin;
	protected java.util.Date updateTimeEnd;

	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}

	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}

	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
	}

	public java.util.Date getUpdateTimeBegin() {
		return this.updateTimeBegin;
	}

	public void setUpdateTimeBegin(java.util.Date value) {
		this.updateTimeBegin = value;
	}

	public java.util.Date getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}

	public void setUpdateTimeEnd(java.util.Date value) {
		this.updateTimeEnd = value;
	}
}
