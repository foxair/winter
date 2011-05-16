package com.gm.demo.dao.impl;

import com.gm.common.orm.mybatis.BaseEntityDao;
import com.gm.common.orm.mybatis.BaseEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.common.service.Manager;
import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.service.BaseManager;
import com.gm.demo.model.CusContact;
import com.gm.demo.dao.CusContactDao;

@Repository("cusContactDao")
public class CusContactDaoImpl extends BaseEntityDao<CusContact,java.lang.Long> implements CusContactDao{
	
	@Override
	public String getMybatisMapperNamesapce() {
		return "com.gm.demo.model.CusContact";
	}
	
	public void saveOrUpdate(CusContact cusContact) {
		if(cusContact.getCusContactId() == null) 
			save(cusContact);
		else 
			update(cusContact);
	}
	
	
}
