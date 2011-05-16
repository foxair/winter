package com.gm.demo.dao.impl;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.common.orm.mybatis.BaseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.common.service.Manager;
import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.service.BaseManager;
import com.gm.demo.model.Contact;
import com.gm.demo.dao.ContactDao;

@Repository("contactDao")
public class ContactDaoImpl extends BaseEntityDao<Contact,java.lang.Long> implements ContactDao{
	
	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.demo.model.Contact";
	}
	
	public void saveOrUpdate(Contact contact) {
		if(contact.getContactId() == null) 
			save(contact);
		else 
			update(contact);
	}
	
	
}
