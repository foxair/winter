package com.gm.demo.service.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.gm.common.orm.mybatis.Page;
import com.gm.common.orm.mybatis.QueryRequest;
import com.gm.common.orm.mybatis.query.Compare;
import com.gm.common.orm.mybatis.query.Condition;
import com.gm.common.orm.mybatis.query.Orders;
import com.gm.common.test.BaseServiceTestCase;
import com.gm.demo.model.Contact;
import com.gm.demo.model.CusContact;
import com.gm.demo.model.Customer;
import com.gm.demo.model.CustomerBiz;
import com.gm.demo.service.ContactManager;
import com.gm.demo.service.CusContactManager;
import com.gm.demo.service.CustomerBizManager;
import com.gm.demo.service.CustomerManager;

public class DemoTest extends BaseServiceTestCase {
	@Resource
	private CustomerManager customerManager;
	@Resource
	private ContactManager contactManager;
	@Resource
	private CusContactManager cusContactManager;
	@Resource
	private CustomerBizManager customerBizManager;

	//一起保存用户和联系方式
	//@Test
	public void saveCustomerWithContactTests() throws Exception {
		Date now = new Date();
		//保存Customer
		Customer cus = new Customer();
		cus.setCusNo(1001L);
		cus.setCusEngName("Company Name");
		//cus.setCusChnName("公司名");
		cus.setStatus("12");
		cus.setCreateBy(1001L);
		cus.setCreateTime(now);
		cus.setUpdateBy(1001L);
		cus.setUpdateTime(now);
		//SpringValidatorHolder.validate(cus);
		customerManager.save(cus);

		//保存Contact
		Contact cnt = new Contact();
		cnt.setContactName("Contact Name");
		cnt.setMobile("13800138000138001380001380013800013800138000");
		cnt.setEmail("demo@gm.com");
		cnt.setStatus("1");
		cnt.setCreateBy(1001L);
		cnt.setCreateTime(now);
		cnt.setUpdateBy(1001L);
		cnt.setUpdateTime(now);
		contactManager.save(cnt);

		//保存关系
		CusContact cc = new CusContact();
		cc.setCustomer(cus);
		cc.setContact(cnt);
		cusContactManager.save(cc);

		//保存CustomerBiz
		CustomerBiz cb = new CustomerBiz();
		cb.setBizId(2L);
		cb.setCustomer(cus);
		cb.setConsultant(1000L);
		cb.setCs(20000L);
		cb.setStatus("1");
		cb.setCreateBy(1001L);
		cb.setCreateTime(now);
		cb.setUpdateBy(1001L);
		cb.setUpdateTime(now);
		customerBizManager.save(cb);
	}

	//@Test
	public void saveAll() {
		customerManager.saveAll();
	}

	//@Test
	public void getCus() {
		List<Customer> cusList = customerManager.findCusList();
		for (Iterator it = cusList.iterator(); it.hasNext();) {
			Customer customer = (Customer) it.next();
			System.out.println(customer.getCusId() + " " + customer.getCusChnName() + " - "
					+ customer.getContacts().size());
		}
	}

	@Test
	public void getCusPage() {
		QueryRequest<Customer> queryRequest = new QueryRequest<Customer>(Customer.class);
		queryRequest.addOrder(Orders.asc(Customer.CUS_NO));//添加排序
		queryRequest.addOrder(Orders.desc(Customer.CREATE_TIME));//添加排序
		//设置一个查询条件
		queryRequest.setCondition(Customer.CUS_CHN_NAME, Condition.AND, Compare.like, "%joe%");
		queryRequest.setPageSize(50);
		Page<Customer> page = customerManager.findCusListPage(queryRequest);
		List<Customer> cusList = page.getResult();
		System.out.println(cusList.size());
		for (Iterator<Customer> it = cusList.iterator(); it.hasNext();) {
			Customer customer = it.next();
			System.out.println(customer.getCusId() + " " + customer.getCusChnName() + " - "
					+ customer.getContacts().size());
		}
	}
}
