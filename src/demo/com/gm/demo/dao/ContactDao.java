package com.gm.demo.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.demo.model.Contact;

public interface ContactDao extends EntityDao<Contact, java.lang.Long> {

	public void saveOrUpdate(Contact contact);

}
