package com.gm.demo.model.base;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.core.text.DateFormatUtils;

public class CustomerBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats
	public static final String FORMAT_CREATE_TIME = DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = DATE_FORMAT;

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long cusId;
	@NotNull
	protected java.lang.Long cusNo;
	@Length(max = 64)
	protected java.lang.String cusEngName;
	@NotBlank
	@Length(max = 64)
	protected java.lang.String cusChnName;

	protected java.lang.Integer area;
	@Length(max = 128)
	protected java.lang.String address;

	protected java.lang.Integer zipcode;
	@Length(max = 12)
	protected java.lang.String contactTel;
	@Length(max = 12)
	protected java.lang.String backupTel1;
	@Length(max = 12)
	protected java.lang.String backupTel2;
	@Length(max = 12)
	protected java.lang.String fax;
	@Length(max = 1024)
	protected java.lang.String cusEngIntro;
	@Length(max = 1024)
	protected java.lang.String cusChnIntro;
	@Length(max = 256)
	protected java.lang.String website;
	@Length(max = 1024)
	protected java.lang.String remark;
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
		FIELD_MAP.put("cusId", "cus_id");
		FIELD_MAP.put("cusNo", "cus_no");
		FIELD_MAP.put("cusEngName", "cus_eng_name");
		FIELD_MAP.put("cusChnName", "cus_chn_name");
		FIELD_MAP.put("area", "area");
		FIELD_MAP.put("address", "address");
		FIELD_MAP.put("zipcode", "zipcode");
		FIELD_MAP.put("contactTel", "contact_tel");
		FIELD_MAP.put("backupTel1", "backup_tel1");
		FIELD_MAP.put("backupTel2", "backup_tel2");
		FIELD_MAP.put("fax", "fax");
		FIELD_MAP.put("cusEngIntro", "cus_eng_intro");
		FIELD_MAP.put("cusChnIntro", "cus_chn_intro");
		FIELD_MAP.put("website", "website");
		FIELD_MAP.put("remark", "remark");
		FIELD_MAP.put("status", "status");
		FIELD_MAP.put("createBy", "create_by");
		FIELD_MAP.put("createTime", "create_time");
		FIELD_MAP.put("updateBy", "update_by");
		FIELD_MAP.put("updateTime", "update_time");
	}

	public static final String CUS_ID = "cusId";
	public static final String CUS_NO = "cusNo";
	public static final String CUS_ENG_NAME = "cusEngName";
	public static final String CUS_CHN_NAME = "cusChnName";
	public static final String AREA = "area";
	public static final String ADDRESS = "address";
	public static final String ZIPCODE = "zipcode";
	public static final String CONTACT_TEL = "contactTel";
	public static final String BACKUP_TEL1 = "backupTel1";
	public static final String BACKUP_TEL2 = "backupTel2";
	public static final String FAX = "fax";
	public static final String CUS_ENG_INTRO = "cusEngIntro";
	public static final String CUS_CHN_INTRO = "cusChnIntro";
	public static final String WEBSITE = "website";
	public static final String REMARK = "remark";
	public static final String STATUS = "status";
	public static final String CREATE_BY = "createBy";
	public static final String CREATE_TIME = "createTime";
	public static final String UPDATE_BY = "updateBy";
	public static final String UPDATE_TIME = "updateTime";

	public void setCusId(java.lang.Long value) {
		this.cusId = value;
	}

	public java.lang.Long getCusId() {
		return this.cusId;
	}

	public void setCusNo(java.lang.Long value) {
		this.cusNo = value;
	}

	public java.lang.Long getCusNo() {
		return this.cusNo;
	}

	public void setCusEngName(java.lang.String value) {
		this.cusEngName = value;
	}

	public java.lang.String getCusEngName() {
		return this.cusEngName;
	}

	public void setCusChnName(java.lang.String value) {
		this.cusChnName = value;
	}

	public java.lang.String getCusChnName() {
		return this.cusChnName;
	}

	public void setArea(java.lang.Integer value) {
		this.area = value;
	}

	public java.lang.Integer getArea() {
		return this.area;
	}

	public void setAddress(java.lang.String value) {
		this.address = value;
	}

	public java.lang.String getAddress() {
		return this.address;
	}

	public void setZipcode(java.lang.Integer value) {
		this.zipcode = value;
	}

	public java.lang.Integer getZipcode() {
		return this.zipcode;
	}

	public void setContactTel(java.lang.String value) {
		this.contactTel = value;
	}

	public java.lang.String getContactTel() {
		return this.contactTel;
	}

	public void setBackupTel1(java.lang.String value) {
		this.backupTel1 = value;
	}

	public java.lang.String getBackupTel1() {
		return this.backupTel1;
	}

	public void setBackupTel2(java.lang.String value) {
		this.backupTel2 = value;
	}

	public java.lang.String getBackupTel2() {
		return this.backupTel2;
	}

	public void setFax(java.lang.String value) {
		this.fax = value;
	}

	public java.lang.String getFax() {
		return this.fax;
	}

	public void setCusEngIntro(java.lang.String value) {
		this.cusEngIntro = value;
	}

	public java.lang.String getCusEngIntro() {
		return this.cusEngIntro;
	}

	public void setCusChnIntro(java.lang.String value) {
		this.cusChnIntro = value;
	}

	public java.lang.String getCusChnIntro() {
		return this.cusChnIntro;
	}

	public void setWebsite(java.lang.String value) {
		this.website = value;
	}

	public java.lang.String getWebsite() {
		return this.website;
	}

	public void setRemark(java.lang.String value) {
		this.remark = value;
	}

	public java.lang.String getRemark() {
		return this.remark;
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
