package com.gm.security.dao.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.validation.BindException;

import com.gm.common.context.SpringValidatorHolder;
import com.gm.common.test.BaseDaoTestCase;
import com.gm.security.dao.RoleInfoDao;
import com.gm.security.model.RoleInfo;

public class RoleInfoDaoTest extends BaseDaoTestCase {
	@Resource
	RoleInfoDao roleInfoDao;
	@Resource
	SpringValidatorHolder springValidatorHolder;
	
	@Test
	public void saveRole(){
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleName("admin3");
		roleInfo.setDescription("平台管理员角色2");
		roleInfo.setNote("管理整个平台1");
		roleInfo.setSuperRoleId(0L);
		try {
			springValidatorHolder.validate(roleInfo);
			roleInfoDao.save(roleInfo);
		} catch (BindException e) {
			System.out.println("Validate Msg:"+e.getMessage());
		}
		
	}
	
}
