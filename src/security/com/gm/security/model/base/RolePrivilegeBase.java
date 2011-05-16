package com.gm.security.model.base;

import java.util.HashMap;
import java.util.Map;

import com.gm.common.orm.mybatis.BaseEntity;

public class RolePrivilegeBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long rolePrivilegeId;

	protected java.lang.Long roleInfoId;

	protected java.lang.Long privilegeId;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("rolePrivilegeId", "role_privilege_id");
		FIELD_MAP.put("roleInfoId", "role_info_id");
		FIELD_MAP.put("privilegeId", "privilege_id");
	}

	public static final String ROLE_PRIVILEGE_ID = "rolePrivilegeId";
	public static final String ROLE_INFO_ID = "roleInfoId";
	public static final String PRIVILEGE_ID = "privilegeId";

	public void setRolePrivilegeId(java.lang.Long value) {
		this.rolePrivilegeId = value;
	}

	public java.lang.Long getRolePrivilegeId() {
		return this.rolePrivilegeId;
	}

	public void setRoleInfoId(java.lang.Long value) {
		this.roleInfoId = value;
	}

	public java.lang.Long getRoleInfoId() {
		return this.roleInfoId;
	}

	public void setPrivilegeId(java.lang.Long value) {
		this.privilegeId = value;
	}

	public java.lang.Long getPrivilegeId() {
		return this.privilegeId;
	}

}
