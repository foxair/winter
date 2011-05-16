package com.gm.demo.dao.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.gm.common.test.BaseDaoTestCase;
import com.gm.demo.dao.ContactDao;
import com.gm.demo.dao.CusContactDao;
import com.gm.demo.dao.CustomerBizDao;
import com.gm.demo.dao.CustomerDao;
import com.gm.demo.model.Contact;
import com.gm.demo.model.CusContact;
import com.gm.demo.model.Customer;
import com.gm.demo.model.CustomerBiz;

public class DemoDaoTest extends BaseDaoTestCase {

	@Resource
	private CustomerDao customerDao;
	@Resource
	private ContactDao contactDao;
	@Resource
	private CusContactDao cusContactDao;
	@Resource
	private CustomerBizDao customerBizDao;

	//一起保存用户和联系方式
	@Test
	public void saveCustomerWithContactTests() {
		Date now = new Date();
		//保存Customer
		Customer cus = new Customer();
		cus.setCusNo(1001L);
		cus.setCusEngName("Company Name");
		cus.setCusChnName("公司名");
		cus.setStatus("1");
		cus.setCreateBy(1001L);
		cus.setCreateTime(now);
		cus.setUpdateBy(1001L);
		cus.setUpdateTime(now);
		customerDao.save(cus);

		//保存Contact
		Contact cnt = new Contact();
		cnt.setContactName("Contact Name");
		cnt.setMobile("13800138000");
		cnt.setEmail("demo@gm.com");
		cnt.setStatus("1");
		cnt.setCreateBy(1001L);
		cnt.setCreateTime(now);
		cnt.setUpdateBy(1001L);
		cnt.setUpdateTime(now);
		contactDao.save(cnt);

		//保存关系
		CusContact cc = new CusContact();
		cc.setCustomer(cus);
		cc.setContact(cnt);
		cusContactDao.save(cc);

		//保存CustomerBiz
		CustomerBiz cb = new CustomerBiz();
		cb.setBizId(1L);
		cb.setCustomer(cus);
		cb.setConsultant(1000L);
		cb.setCs(20000L);
		cb.setStatus("1");
		cb.setCreateBy(1001L);
		cb.setCreateTime(now);
		cb.setUpdateBy(1001L);
		cb.setUpdateTime(now);
		customerBizDao.save(cb);

	}

}
