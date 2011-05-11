package com.gm.demo.model.base;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.gm.common.orm.mybatis.BaseEntity;

public class CusContactBase extends BaseEntity implements java.io.Serializable {
	protected static final long serialVersionUID = 5454155825314635342L;

	//date formats

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START

	protected java.lang.Long cusContactId;
	@NotNull
	protected java.lang.Long cusId;
	@NotNull
	protected java.lang.Long contactId;
	//columns END

	public static Map<String, String> FIELD_MAP = new HashMap<String, String>();

	static {
		FIELD_MAP.put("cusContactId", "cus_contact_id");
		FIELD_MAP.put("cusId", "cus_id");
		FIELD_MAP.put("contactId", "contact_id");
	}

	public static final String CUS_CONTACT_ID = "cusContactId";
	public static final String CUS_ID = "cusId";
	public static final String CONTACT_ID = "contactId";

	public void setCusContactId(java.lang.Long value) {
		this.cusContactId = value;
	}

	public java.lang.Long getCusContactId() {
		return this.cusContactId;
	}

	public void setCusId(java.lang.Long value) {
		this.cusId = value;
	}

	public java.lang.Long getCusId() {
		return this.cusId;
	}

	public void setContactId(java.lang.Long value) {
		this.contactId = value;
	}

	public java.lang.Long getContactId() {
		return this.contactId;
	}

}
