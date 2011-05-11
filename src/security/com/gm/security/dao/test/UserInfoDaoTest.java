package com.gm.security.dao.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gm.common.context.SpringValidatorHolder;
import com.gm.common.orm.mybatis.Page;
import com.gm.common.orm.mybatis.QueryRequest;
import com.gm.common.orm.mybatis.query.Compare;
import com.gm.common.orm.mybatis.query.Conditions;
import com.gm.common.orm.mybatis.query.Orders;
import com.gm.common.test.BaseDaoTestCase;
import com.gm.security.dao.UserInfoDao;
import com.gm.security.model.RoleInfo;
import com.gm.security.model.UserInfo;

public class UserInfoDaoTest extends BaseDaoTestCase {
	private static final Logger logger = Logger.getLogger(UserInfoDaoTest.class);

	@Resource
	UserInfoDao userInfoDao;
	@Resource
	JdbcTemplate jdbcTemplate;

	@Resource
	SpringValidatorHolder springValidatorHolder;

	/*public static final <T> void validate(T object) throws ConstraintViolationException {
		Set constraintViolations = getValidator().validate(object);
		String msg = "validate failure on object:" + object.getClass().getSimpleName();
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(msg, constraintViolations);
		}
	}*/

	//@Test
	public void jdbcTest() {
		jdbcTemplate
				.update("INSERT INTO user_info ( user_info_id , login_account , user_name , first_name , last_name ,  login_pwd , login_email , user_type , register_time , user_status )  VALUES "
						+ "( NULL , 'sdfdf' ,  '中文名' , '' , '' , '123456' , '' , 1 , NULL , NULL ) ");
	}

	//@Test
	@Order(1)
	public void saveUser() {
		//userInfoDao.deleteById(10100L);
		UserInfo user = new UserInfo();
		//user.setUserInfoId(10100L);
		user.setLoginAccount("weweeaaa");
		user.setLoginPwd("ppp");
		user.setFirstName("12345678901234567");
		user.setUserName("nameuuu");
		user.setLoginEmail("eeeem@mma.daa");
		try {
			springValidatorHolder.validate(user);
			userInfoDao.save(user);
			System.out.println(">>>> userId=" + user.getUserInfoId());
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}

		//userInfoDao.deleteById(10100L);
	}

	//@Test
	@Order(3)
	public void getByLoginAccount() {
		UserInfo userInfo;
		try {
			userInfo = userInfoDao.getByLoginAccount("hdddaha25");
			System.out.println(">>>" + userInfo.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	@Order(1)
	public void deleteUser() {
		Long[] ids = new Long[] { 10L, 11L, 12L };
		userInfoDao.deleteByIds(ids);
		//userInfoDao.deleteById(100L);
	}

	//@Test
	@Order(2)
	public void saveUsers() {
		for (int i = 10; i <= 100; i++) {
			UserInfo user = new UserInfo();
			//System.out.println("==== userId=" + user.getUserInfoId());
			user.setLoginAccount("hdddaha" + i);
			user.setLoginPwd("ppp");
			user.setFirstName("jjj" + (300 - i));
			user.setUserName("nameuuu" + i);
			user.setLoginEmail("fffmmaaa" + i + "@adf.com");
			userInfoDao.save(user);
			System.out.println(">>>> userId=" + user.getUserInfoId());
		}
	}

	//@Test
	@Order(2)
	public void getCount() {
		System.out.println(userInfoDao.getCount());
	}

	//@Test
	@Order(2)
	public void findPage() {
		UserInfo ui = new UserInfo();
		ui.setLoginPwd("ppp");
		ui.setLoginEmail("%adf%");
		QueryRequest uiq = new QueryRequest(ui);
		uiq.setCondition(Conditions.or(UserInfo.LOGIN_EMAIL, Compare.like));
		uiq.setCondition(Conditions.or(UserInfo.LOGIN_PWD));
		uiq.setPageNumber(1);
		uiq.setPageSize(15);
		uiq.addOrder(Orders.desc(UserInfo.LOGIN_ACCOUNT));
		Page<UserInfo> p = userInfoDao.findPage(uiq);
		List<UserInfo> ul = p.getResult();
		for (Iterator<UserInfo> iterator = ul.iterator(); iterator.hasNext();) {
			UserInfo userInfo = (UserInfo) iterator.next();
			System.out.println(userInfo.getUserInfoId() + " " + userInfo.getLoginAccount());
		}
	}

	//@Test
	public void findAll() {
		List<UserInfo> ul = userInfoDao.findAll();
		List<UserInfo> ul1 = userInfoDao.findAll();
		List<UserInfo> ul2 = userInfoDao.findAll();
	}

	//@Test
	public void findUnique() {
		/*UserInfoQuery uiq = new UserInfoQuery();
		uiq.setLoginAccount("hahaha7");
		UserInfo user = userInfoDao.findUnique(uiq);
		System.out.println(user.getUserName());*/
	}

	@Resource
	private SqlSessionFactory sqlSessionFactory;

	//@Test
	public void cacheTest() {
		UserInfo userQuery = new UserInfo();
		userQuery.setLastName("a");

		//缓存测试
		System.out.println("---" + 0);
		List<UserInfo> users = userInfoDao.findAll();

		System.out.println("---" + 1);
		List<UserInfo> users1 = userInfoDao.find(userQuery);
		System.out.println("---" + 2);
		List<UserInfo> users2 = userInfoDao.find(userQuery);

		/*
		System.out.println("---"+3); 
		UserInfo user = userInfoDao.getById(10L);
		user.setFirstName("abc");
		userInfoDao.update(user);*/

		userQuery.setLastName("b");
		System.out.println("---" + 4);
		List<UserInfo> users3 = userInfoDao.find(userQuery);
		System.out.println("---" + 5);
		List<UserInfo> users4 = userInfoDao.find(userQuery);

		userQuery.setLastName("c");
		System.out.println("---" + 6);
		List<UserInfo> users5 = userInfoDao.find(userQuery);
		System.out.println("---" + 7);
		List<UserInfo> users6 = userInfoDao.find(userQuery);

		userQuery.setLastName("b");
		System.out.println("---" + 4);
		List<UserInfo> users8 = userInfoDao.find(userQuery);
		System.out.println("---" + 5);
		List<UserInfo> users9 = userInfoDao.find(userQuery);

		/*UserInfo user = userInfoDao.getById(10L);
		System.out.println(user.getFirstName());
		UserInfo user1 = userInfoDao.getById(11L);
		System.out.println(user1.getFirstName());
		UserInfo user2 = userInfoDao.getById(12L);
		System.out.println(user2.getFirstName());
		UserInfo user3= userInfoDao.getById(13L);
		System.out.println(user3.getFirstName());*/
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void queryUserRole() {
		List<RoleInfo> roles = userInfoDao.findRolesByUserId(3L);
		for (Iterator it = roles.iterator(); it.hasNext();) {
			RoleInfo roleInfo = (RoleInfo) it.next();
			System.out.println(roleInfo.getRoleInfoId() + " : " + roleInfo.getRoleName());
		}
	}
	
	@SuppressWarnings("rawtypes")
	//@Test
	public void queryUsers() {
		List<UserInfo> users = userInfoDao.findUsersWithRoles();
		for (Iterator it = users.iterator(); it.hasNext();) {
			UserInfo userInfo = (UserInfo) it.next();
			List<RoleInfo> roles = userInfo.getRoles();
			if(userInfo.getRoles().size()>0){
				System.out.print(userInfo.getLoginAccount()+":");
				System.out.print("[");
				for (Iterator rit = roles.iterator(); rit.hasNext();) {
					RoleInfo roleInfo = (RoleInfo) rit.next();
					System.out.print(roleInfo.getRoleName());
					System.out.print(rit.hasNext()?",":"]\n");
				}
			}
		}
	}

}
