package com.gm.security.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.mvc.BaseMultiActionController;
import com.gm.common.orm.mybatis.Page;
import com.gm.common.orm.mybatis.QueryRequest;
import com.gm.common.utils.QueryRequestHandler;
import com.gm.security.model.UserInfo;
import com.gm.security.service.UserInfoManager;

/**
 * 用户角色绑定controller
 */
@Controller
public class UserRoleController extends BaseMultiActionController {

	@Resource
	UserInfoManager userInfoManager;


	@RequestMapping(value = "/security/userRole", method = RequestMethod.GET)
	public ModelAndView users(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		ModelAndView mav = new ModelAndView("security/userRole");
		return mav;
	}

}