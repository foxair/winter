package com.gm.security.model.base;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.Length;

import com.gm.common.orm.mybatis.BaseEntity;

public class ResourceInfoBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long resourceId;
	@Length(max = 512)
	protected java.lang.String resourceName;

	protected java.lang.Long superId;

	protected java.lang.Integer resourceType;

	protected java.lang.Integer loadType;

	protected java.lang.Integer accessType;
	@Length(max = 64)
	protected java.lang.String appName;
	@Length(max = 256)
	protected java.lang.String description;
	@Length(max = 512)
	protected java.lang.String note;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("resourceId", "resource_id");
		FIELD_MAP.put("resourceName", "resource_name");
		FIELD_MAP.put("superId", "super_id");
		FIELD_MAP.put("resourceType", "resource_type");
		FIELD_MAP.put("loadType", "load_type");
		FIELD_MAP.put("accessType", "access_type");
		FIELD_MAP.put("appName", "app_name");
		FIELD_MAP.put("description", "description");
		FIELD_MAP.put("note", "note");
	}

	public static final String RESOURCE_ID = "resourceId";
	public static final String RESOURCE_NAME = "resourceName";
	public static final String SUPER_ID = "superId";
	public static final String RESOURCE_TYPE = "resourceType";
	public static final String LOAD_TYPE = "loadType";
	public static final String ACCESS_TYPE = "accessType";
	public static final String APP_NAME = "appName";
	public static final String DESCRIPTION = "description";
	public static final String NOTE = "note";

	public void setResourceId(java.lang.Long value) {
		this.resourceId = value;
	}

	public java.lang.Long getResourceId() {
		return this.resourceId;
	}

	public void setResourceName(java.lang.String value) {
		this.resourceName = value;
	}

	public java.lang.String getResourceName() {
		return this.resourceName;
	}

	public void setSuperId(java.lang.Long value) {
		this.superId = value;
	}

	public java.lang.Long getSuperId() {
		return this.superId;
	}

	public void setResourceType(java.lang.Integer value) {
		this.resourceType = value;
	}

	public java.lang.Integer getResourceType() {
		return this.resourceType;
	}

	public void setLoadType(java.lang.Integer value) {
		this.loadType = value;
	}

	public java.lang.Integer getLoadType() {
		return this.loadType;
	}

	public void setAccessType(java.lang.Integer value) {
		this.accessType = value;
	}

	public java.lang.Integer getAccessType() {
		return this.accessType;
	}

	public void setAppName(java.lang.String value) {
		this.appName = value;
	}

	public java.lang.String getAppName() {
		return this.appName;
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
