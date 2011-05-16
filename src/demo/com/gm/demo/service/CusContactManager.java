package com.gm.demo.service;

import com.gm.common.service.Manager;
import com.gm.demo.dao.CusContactDao;
import com.gm.demo.model.CusContact;

public interface CusContactManager extends Manager<CusContact, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCusContactDao(CusContactDao dao);

}
