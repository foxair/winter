package com.gm.demo.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.mvc.BaseMultiActionController;
import com.gm.common.utils.JsonUtils;
import com.gm.demo.model.Contact;
import com.gm.demo.model.CusContact;
import com.gm.demo.model.Customer;
import com.gm.demo.service.ContactManager;
import com.gm.demo.service.CusContactManager;
import com.gm.demo.service.CustomerBizManager;
import com.gm.demo.service.CustomerManager;

@Controller
public class DemoController extends BaseMultiActionController {
	@Resource
	private CustomerManager customerManager;
	@Resource
	private ContactManager contactManager;
	@Resource
	private CusContactManager cusContactManager;
	@Resource
	private CustomerBizManager customerBizManager;

	@RequestMapping(value = "/demo/list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/demo/list");
		List<Customer> cusList = customerManager.getCusList();
		mav.addObject("cusList", cusList);
		return mav;
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ModelAndView demo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/demo/demo");
		return mav;
	}

	/**
	 * 保存用户
	 * @param user
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/demo/save", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> saveUser(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();

		//Http Request中取得序列化JSON
		String customerJson = request.getParameter("customer");
		String contactsJson = request.getParameter("contacts");

		try {
			//反序列化得到对象
			Customer customer = JsonUtils.parseObject(customerJson, Customer.class);
			List<Contact> contacts = JsonUtils.parseList(contactsJson, Contact.class);

			//保存Customer
			customerManager.save(customer);
			//保存多个Contact和对应关系
			for (Iterator<Contact> it = contacts.iterator(); it.hasNext();) {
				Contact contact = (Contact) it.next();
				contactManager.save(contact);
				CusContact cc = new CusContact();
				cc.setCustomer(customer);
				cc.setContact(contact);
				cusContactManager.save(cc);
			}
		} catch (Exception e) {
			result.put("isError", true);
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}
}
