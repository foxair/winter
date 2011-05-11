package com.gm.demo.dao;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.demo.model.CusContact;

public interface CusContactDao extends EntityDao<CusContact, java.lang.Long> {

	public void saveOrUpdate(CusContact cusContact);

}
