package com.gm.security.model.base;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.gm.common.orm.mybatis.BaseEntity;

public class RoleInfoBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long roleInfoId;
	@NotBlank
	@Length(max = 128)
	protected java.lang.String roleName;
	@NotNull
	protected java.lang.Long superRoleId;
	@Length(max = 256)
	protected java.lang.String description;
	@Length(max = 512)
	protected java.lang.String note;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("roleInfoId", "role_info_id");
		FIELD_MAP.put("roleName", "role_name");
		FIELD_MAP.put("superRoleId", "super_role_id");
		FIELD_MAP.put("description", "description");
		FIELD_MAP.put("note", "note");
	}

	public static final String ROLE_INFO_ID = "roleInfoId";
	public static final String ROLE_NAME = "roleName";
	public static final String SUPER_ROLE_ID = "superRoleId";
	public static final String DESCRIPTION = "description";
	public static final String NOTE = "note";

	public void setRoleInfoId(java.lang.Long value) {
		this.roleInfoId = value;
	}

	public java.lang.Long getRoleInfoId() {
		return this.roleInfoId;
	}

	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}

	public java.lang.String getRoleName() {
		return this.roleName;
	}

	public void setSuperRoleId(java.lang.Long value) {
		this.superRoleId = value;
	}

	public java.lang.Long getSuperRoleId() {
		return this.superRoleId;
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
