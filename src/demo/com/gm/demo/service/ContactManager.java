package com.gm.demo.service;

import com.gm.common.service.Manager;
import com.gm.demo.dao.ContactDao;
import com.gm.demo.model.Contact;

public interface ContactManager extends Manager<Contact, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setContactDao(ContactDao dao);

}
