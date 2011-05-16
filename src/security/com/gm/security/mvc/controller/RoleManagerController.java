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
import com.gm.common.utils.tree.pojo.TreeNode;
import com.gm.security.model.RoleInfo;
import com.gm.security.service.RoleInfoManager;

/**
 * 角色管理controller
 */
@Controller
public class RoleManagerController extends BaseMultiActionController {
	@Resource
	RoleInfoManager roleInfoManager;

	@RequestMapping(value = "/security/roles", method = RequestMethod.GET)
	public ModelAndView roles(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		ModelAndView mav = new ModelAndView("security/roles");
		return mav;
	}

	@RequestMapping(value = "/security/role", method = RequestMethod.POST)
	public @ResponseBody
	RoleInfo role(@RequestParam Long roleId, HttpServletRequest request) {
		RoleInfo role = roleInfoManager.getById(roleId);
		return role;
	}

	@RequestMapping(value = "/security/rolesJson", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> rolesJson(@RequestParam Long superId, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if (superId == null) {
			superId = 0L;
		}
		System.out.println("request----------> page=" + request.getParameter(QueryRequest.PAGE_NUMBER));
		System.out.println("request----------> rows=" + request.getParameter(QueryRequest.PAGE_SIZE));
		System.out.println("request----------> sort=" + request.getParameter(QueryRequest.PAGE_SORT_FIELD));
		System.out.println("request----------> order=" + request.getParameter(QueryRequest.PAGE_ORDER_TYPE));

		RoleInfo roleFilter = new RoleInfo();//建立一个RoleInfo的查询过滤对象
		roleFilter.setSuperRoleId(superId);
		QueryRequest query = new QueryRequest(roleFilter);//建立一个分页查询对象
		QueryRequest queryRequest = QueryRequestHandler.bindHttpRequestParameters(query, request);//将HttpRequest中的分页参数绑定到分页查询对象中
		Page<RoleInfo> page = this.roleInfoManager.findPage(queryRequest);//进行分页查询获得分页结果
		List<RoleInfo> roles = page.getResult();//获得分页结果中的结果集
		Map<String, Object> pageData = getJsonModel(page.getTotalCount(), roles);
		return pageData;
	}

	@RequestMapping(value = "/security/roleForm", method = RequestMethod.GET)
	public ModelAndView userForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("security/roleForm");
		return mav;
	}

	@RequestMapping(value = "/security/saveRole", method = RequestMethod.POST)
	public @ResponseBody
	int saveRole(@RequestBody RoleInfo role, HttpServletRequest request) {
		roleInfoManager.save(role);
		return 1;
	}

	@RequestMapping(value = "/security/delRoles", method = RequestMethod.POST)
	public @ResponseBody
	int delRoles(@RequestParam Long[] roleIds, HttpServletRequest request) {
		roleInfoManager.removeByIds(roleIds);
		return 1;
	}

	@RequestMapping(value = "/security/roleTreeJson", method = RequestMethod.POST)
	public @ResponseBody
	List<TreeNode> roleTreeJson(@RequestParam Long superId, HttpServletRequest request, HttpServletResponse response) {
		List<TreeNode> roleTree = null;
		if (superId == null || superId == 0) {
			roleTree = roleInfoManager.getRoleTree();
		} else {
			roleTree = roleInfoManager.getRoleNodes(superId);
		}
		//String roleTreeJson = JsonUtils.getJson(roleTree);
		//System.out.println(roleTreeJson);
		return roleTree;
	}

}
