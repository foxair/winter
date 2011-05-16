package com.gm.security.model.base;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.gm.common.orm.mybatis.BaseEntity;

public class PrivilegeInfoBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long privilegeId;
	@NotBlank
	@Length(max = 128)
	protected java.lang.String privilegeName;
	@Length(max = 128)
	protected java.lang.String privilegeValue;
	@Length(max = 32)
	protected java.lang.String accessType;
	@Length(max = 256)
	protected java.lang.String description;
	@Length(max = 512)
	protected java.lang.String note;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("privilegeId", "privilege_id");
		FIELD_MAP.put("privilegeName", "privilege_name");
		FIELD_MAP.put("privilegeValue", "privilege_value");
		FIELD_MAP.put("accessType", "access_type");
		FIELD_MAP.put("description", "description");
		FIELD_MAP.put("note", "note");
	}

	public static final String PRIVILEGE_ID = "privilegeId";
	public static final String PRIVILEGE_NAME = "privilegeName";
	public static final String PRIVILEGE_VALUE = "privilegeValue";
	public static final String ACCESS_TYPE = "accessType";
	public static final String DESCRIPTION = "description";
	public static final String NOTE = "note";

	public void setPrivilegeId(java.lang.Long value) {
		this.privilegeId = value;
	}

	public java.lang.Long getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeName(java.lang.String value) {
		this.privilegeName = value;
	}

	public java.lang.String getPrivilegeName() {
		return this.privilegeName;
	}

	public void setPrivilegeValue(java.lang.String value) {
		this.privilegeValue = value;
	}

	public java.lang.String getPrivilegeValue() {
		return this.privilegeValue;
	}

	public void setAccessType(java.lang.String value) {
		this.accessType = value;
	}

	public java.lang.String getAccessType() {
		return this.accessType;
	}

	public void setDescription(java.lang.String value) {
		this.description = value;
	}

	public java.lang.String getDescription() {
		return this.description;
	}

	public void setNote(java.lang.String value) {
		this.note = value;
	}

	public java.lang.String getNote() {
		return this.note;
	}

}
