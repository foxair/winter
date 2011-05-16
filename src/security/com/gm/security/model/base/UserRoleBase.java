package com.gm.security.model.base;

import java.util.HashMap;
import java.util.Map;

import com.gm.common.orm.mybatis.BaseEntity;

public class UserRoleBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long userRoleId;

	protected java.lang.Long roleInfoId;

	protected java.lang.Long userInfoId;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("userRoleId", "user_role_id");
		FIELD_MAP.put("roleInfoId", "role_info_id");
		FIELD_MAP.put("userInfoId", "user_info_id");
	}

	public static final String USER_ROLE_ID = "userRoleId";
	public static final String ROLE_INFO_ID = "roleInfoId";
	public static final String USER_INFO_ID = "userInfoId";

	public void setUserRoleId(java.lang.Long value) {
		this.userRoleId = value;
	}

	public java.lang.Long getUserRoleId() {
		return this.userRoleId;
	}

	public void setRoleInfoId(java.lang.Long value) {
		this.roleInfoId = value;
	}

	public java.lang.Long getRoleInfoId() {
		return this.roleInfoId;
	}

	public void setUserInfoId(java.lang.Long value) {
		this.userInfoId = value;
	}

	public java.lang.Long getUserInfoId() {
		return this.userInfoId;
	}

}
