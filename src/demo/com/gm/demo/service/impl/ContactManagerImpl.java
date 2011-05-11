package com.gm.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.demo.model.Contact;
import com.gm.demo.dao.ContactDao;
import com.gm.demo.service.ContactManager;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.common.orm.mybatis.BaseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.common.service.Manager;
import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.service.BaseManager;
@Service("contactManager")
@Transactional
public class ContactManagerImpl extends BaseManager<Contact,java.lang.Long> implements ContactManager{

	private ContactDao contactDao;
	
	@Resource
	public void setContactDao(ContactDao dao) {
		this.contactDao = dao;
	}
	
	public ContactDao getEntityDao() {
		return this.contactDao;
	}
	
	
}
