package com.gm.security.service.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.core.annotation.Order;

import com.gm.common.test.BaseServiceTestCase;
import com.gm.security.service.UserInfoManager;

public class ServiceTestCase extends BaseServiceTestCase {
	private static final Logger logger = Logger.getLogger(ServiceTestCase.class);

	@Resource
	UserInfoManager userInfoManager;

	@Test
	@Order(1)
	public void saveUser() {
		/*UserInfo user = new UserInfo();
		// user.setUserId(10100L);
		user.setLoginAccount("hahaha");
		user.setLoginPwd("ppp");
		user.setFirstName("jjj");
		user.setUserName("nameuuu");
		user.setLoginEmail("eeemmmaaa");
		userInfoManager.save(user);
		System.out.println(">>>> userId=" + user.getUserInfoId());*/

		userInfoManager.findAll();
	}

}
