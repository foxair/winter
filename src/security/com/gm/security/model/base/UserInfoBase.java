package com.gm.security.model.base;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.core.text.DateFormatUtils;

public class UserInfoBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats
	public static final String FORMAT_REGISTER_TIME = DATE_FORMAT;

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long userInfoId;
	@NotBlank
	@Length(max = 32)
	protected java.lang.String loginAccount;
	@NotBlank
	@Length(max = 64)
	protected java.lang.String userName;
	@Length(max = 32)
	protected java.lang.String firstName;
	@Length(max = 32)
	protected java.lang.String lastName;
	@NotBlank
	@Length(max = 128)
	protected java.lang.String loginPwd;
	@NotBlank
	@Email
	@Length(max = 256)
	protected java.lang.String loginEmail;
	@Max(32767)
	protected Integer userType;

	protected java.util.Date registerTime;
	@Max(32767)
	protected Integer userStatus;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("userInfoId", "user_info_id");
		FIELD_MAP.put("loginAccount", "login_account");
		FIELD_MAP.put("userName", "user_name");
		FIELD_MAP.put("firstName", "first_name");
		FIELD_MAP.put("lastName", "last_name");
		FIELD_MAP.put("loginPwd", "login_pwd");
		FIELD_MAP.put("loginEmail", "login_email");
		FIELD_MAP.put("userType", "user_type");
		FIELD_MAP.put("registerTime", "register_time");
		FIELD_MAP.put("userStatus", "user_status");
	}

	public static final String USER_INFO_ID = "userInfoId";
	public static final String LOGIN_ACCOUNT = "loginAccount";
	public static final String USER_NAME = "userName";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String LOGIN_PWD = "loginPwd";
	public static final String LOGIN_EMAIL = "loginEmail";
	public static final String USER_TYPE = "userType";
	public static final String REGISTER_TIME = "registerTime";
	public static final String USER_STATUS = "userStatus";

	public void setUserInfoId(java.lang.Long value) {
		this.userInfoId = value;
	}

	public java.lang.Long getUserInfoId() {
		return this.userInfoId;
	}

	public void setLoginAccount(java.lang.String value) {
		this.loginAccount = value;
	}

	public java.lang.String getLoginAccount() {
		return this.loginAccount;
	}

	public void setUserName(java.lang.String value) {
		this.userName = value;
	}

	public java.lang.String getUserName() {
		return this.userName;
	}

	public void setFirstName(java.lang.String value) {
		this.firstName = value;
	}

	public java.lang.String getFirstName() {
		return this.firstName;
	}

	public void setLastName(java.lang.String value) {
		this.lastName = value;
	}

	public java.lang.String getLastName() {
		return this.lastName;
	}

	public void setLoginPwd(java.lang.String value) {
		this.loginPwd = value;
	}

	public java.lang.String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginEmail(java.lang.String value) {
		this.loginEmail = value;
	}

	public java.lang.String getLoginEmail() {
		return this.loginEmail;
	}

	public void setUserType(Integer value) {
		this.userType = value;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public String getRegisterTimeString() {
		return DateFormatUtils.format(getRegisterTime(), FORMAT_REGISTER_TIME);
	}

	public void setRegisterTimeString(String value) {
		setRegisterTime(DateFormatUtils.parse(value, FORMAT_REGISTER_TIME, java.util.Date.class));
	}

	public void setRegisterTime(java.util.Date value) {
		this.registerTime = value;
	}

	public java.util.Date getRegisterTime() {
		return this.registerTime;
	}

	public void setUserStatus(Integer value) {
		this.userStatus = value;
	}

	public Integer getUserStatus() {
		return this.userStatus;
	}

	/** registerTime */
	protected java.util.Date registerTimeBegin;
	protected java.util.Date registerTimeEnd;

	public java.util.Date getRegisterTimeBegin() {
		return this.registerTimeBegin;
	}

	public void setRegisterTimeBegin(java.util.Date value) {
		this.registerTimeBegin = value;
	}

	public java.util.Date getRegisterTimeEnd() {
		return this.registerTimeEnd;
	}

	public void setRegisterTimeEnd(java.util.Date value) {
		this.registerTimeEnd = value;
	}
}
