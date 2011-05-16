package com.gm.security.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.mvc.BaseMultiActionController;
import com.gm.common.orm.mybatis.Page;
import com.gm.common.orm.mybatis.QueryRequest;
import com.gm.common.orm.mybatis.query.Compare;
import com.gm.common.orm.mybatis.query.Conditions;
import com.gm.common.orm.mybatis.query.Orders;
import com.gm.common.utils.QueryRequestHandler;
import com.gm.security.model.UserInfo;
import com.gm.security.service.UserInfoManager;

/**
 * 用户管理controller
 */
@Controller
public class UserManagerController extends BaseMultiActionController {

	@Resource
	UserInfoManager userInfoManager;

	@RequestMapping(value = "/security", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/security/index");
		return mav;
	}

	@RequestMapping(value = "/security/user", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("/security/index");
		return mav;
	}

	// @PathVariable是对资源路径参数的解析，它会自动根据提交的数据格式，解析参数值。
	@RequestMapping(value = "/security/user/{loginAccount}", method = RequestMethod.GET)
	public ModelAndView showUser(@PathVariable String loginAccount, Model model) {
		ModelAndView mav = new ModelAndView("security/userInfo");
		UserInfo user = userInfoManager.getByLoginAccount(loginAccount);
		model.addAttribute("user", user);
		return mav;
	}

	@RequestMapping(value = "/security/user/save/{userInfoId}", method = RequestMethod.GET)
	public ModelAndView saveUserTest(@PathVariable Long userInfoId, Model model) {
		ModelAndView mav = new ModelAndView("security/userInfo");
		UserInfo user = new UserInfo();
		user.setUserInfoId(userInfoId);
		user.setLoginAccount("hahaha");
		user.setFirstName("jjj");
		user.setUserName("nameuuu");
		user.setLoginEmail("eeemmmaaa");
		userInfoManager.save(user);
		model.addAttribute("user", user);
		return mav;
	}

	@RequestMapping(value = "/security/users", method = RequestMethod.GET)
	public ModelAndView users(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		ModelAndView mav = new ModelAndView("security/users");
		return mav;
	}

	/**
	 * 用户列表json
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/security/usersJson")
	public @ResponseBody
	Map<String, Object> usersJson(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("request----------> page=" + request.getParameter(QueryRequest.PAGE_NUMBER));
		System.out.println("request----------> rows=" + request.getParameter(QueryRequest.PAGE_SIZE));
		System.out.println("request----------> sort=" + request.getParameter(QueryRequest.PAGE_SORT_FIELD));
		System.out.println("request----------> order=" + request.getParameter(QueryRequest.PAGE_ORDER_TYPE));
		
		UserInfo user = new UserInfo();
		user.setLoginPwd("%p%");
		user.setLoginAccount("b");
		user.setFirstName("%e%");
		QueryRequest userQuery = new QueryRequest(user);//建立一个查询对象
		userQuery.addOrder(Orders.asc(UserInfo.LOGIN_ACCOUNT));
		userQuery.setCondition(Conditions.or(UserInfo.LOGIN_PWD,Compare.like));
		userQuery.setCondition(Conditions.or(UserInfo.FIRST_NAME,Compare.equals));
		userQuery.setCondition(Conditions.and(UserInfo.LOGIN_ACCOUNT,Compare.equals));
		QueryRequestHandler.bindHttpRequestParameters(userQuery, request);//将HttpRequest中的参数绑定到查询对象中
		Page<UserInfo> page = this.userInfoManager.findPage(userQuery);//进行分页查询获得分页结果
		List<UserInfo> users = page.getResult();//获得分页结果中的结果集
		Map<String, Object> pageData = getJsonModel(page.getTotalCount(), users);
		return pageData;
	}

	/**
	 * 用户添加编辑窗口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/security/userForm", method = RequestMethod.GET)
	public ModelAndView userForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("security/userForm");
		return mav;
	}

	/**
	 * 用户角色关联窗口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/security/roleSelect", method = RequestMethod.GET)
	public ModelAndView userRoleForm(@RequestParam(required = false) Long userId, HttpServletRequest request) {
		UserInfo userInfo = null;
		if (userId != null) {
			userInfo = userInfoManager.getById(userId);
		}
		ModelAndView mav = new ModelAndView("security/roleSelect");
		mav.addObject("userInfo", userInfo);//model
		return mav;
	}

	/**
	 * 保存用户
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/security/saveUser", method = RequestMethod.POST)
	public @ResponseBody
	int saveUser(@RequestBody UserInfo user, HttpServletRequest request) {
		user.setLoginPwd("123456");
		userInfoManager.save(user);
		return 1;
	}

	/**
	 * 删除选择用户
	 * @param userIds
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/security/delUsers", method = RequestMethod.POST)
	public @ResponseBody
	int delUser(@RequestParam Long[] userIds, HttpServletRequest request) {
		userInfoManager.removeByIds(userIds);
		return 1;
	}
}