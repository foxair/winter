package com.gm.demo.model.base;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.core.text.DateFormatUtils;

public class ContactBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats
	public static final String FORMAT_CREATE_TIME = DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = DATE_FORMAT;

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long contactId;
	@NotBlank
	@Length(max = 32)
	protected java.lang.String contactName;
	@Length(max = 1)
	protected java.lang.String gender;
	@Length(max = 32)
	protected java.lang.String position;
	@NotBlank
	@Length(max = 32)
	protected java.lang.String mobile;
	@Length(max = 32)
	protected java.lang.String workPhone;
	@NotBlank
	@Email
	@Length(max = 32)
	protected java.lang.String email;
	@Length(max = 32)
	protected java.lang.String homePhone;
	@Length(max = 16)
	protected java.lang.String qq;
	@Length(max = 64)
	protected java.lang.String msn;
	@Length(max = 128)
	protected java.lang.String other;
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
		FIELD_MAP.put("contactId", "contact_id");
		FIELD_MAP.put("contactName", "contact_name");
		FIELD_MAP.put("gender", "gender");
		FIELD_MAP.put("position", "position");
		FIELD_MAP.put("mobile", "mobile");
		FIELD_MAP.put("workPhone", "work_phone");
		FIELD_MAP.put("email", "email");
		FIELD_MAP.put("homePhone", "home_phone");
		FIELD_MAP.put("qq", "qq");
		FIELD_MAP.put("msn", "msn");
		FIELD_MAP.put("other", "other");
		FIELD_MAP.put("status", "status");
		FIELD_MAP.put("createBy", "create_by");
		FIELD_MAP.put("createTime", "create_time");
		FIELD_MAP.put("updateBy", "update_by");
		FIELD_MAP.put("updateTime", "update_time");
	}

	public static final String CONTACT_ID = "contactId";
	public static final String CONTACT_NAME = "contactName";
	public static final String GENDER = "gender";
	public static final String POSITION = "position";
	public static final String MOBILE = "mobile";
	public static final String WORK_PHONE = "workPhone";
	public static final String EMAIL = "email";
	public static final String HOME_PHONE = "homePhone";
	public static final String QQ = "qq";
	public static final String MSN = "msn";
	public static final String OTHER = "other";
	public static final String STATUS = "status";
	public static final String CREATE_BY = "createBy";
	public static final String CREATE_TIME = "createTime";
	public static final String UPDATE_BY = "updateBy";
	public static final String UPDATE_TIME = "updateTime";

	public void setContactId(java.lang.Long value) {
		this.contactId = value;
	}

	public java.lang.Long getContactId() {
		return this.contactId;
	}

	public void setContactName(java.lang.String value) {
		this.contactName = value;
	}

	public java.lang.String getContactName() {
		return this.contactName;
	}

	public void setGender(java.lang.String value) {
		this.gender = value;
	}

	public java.lang.String getGender() {
		return this.gender;
	}

	public void setPosition(java.lang.String value) {
		this.position = value;
	}

	public java.lang.String getPosition() {
		return this.position;
	}

	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setWorkPhone(java.lang.String value) {
		this.workPhone = value;
	}

	public java.lang.String getWorkPhone() {
		return this.workPhone;
	}

	public void setEmail(java.lang.String value) {
		this.email = value;
	}

	public java.lang.String getEmail() {
		return this.email;
	}

	public void setHomePhone(java.lang.String value) {
		this.homePhone = value;
	}

	public java.lang.String getHomePhone() {
		return this.homePhone;
	}

	public void setQq(java.lang.String value) {
		this.qq = value;
	}

	public java.lang.String getQq() {
		return this.qq;
	}

	public void setMsn(java.lang.String value) {
		this.msn = value;
	}

	public java.lang.String getMsn() {
		return this.msn;
	}

	public void setOther(java.lang.String value) {
		this.other = value;
	}

	public java.lang.String getOther() {
		return this.other;
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
