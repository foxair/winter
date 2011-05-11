package com.gm.security.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gm.common.mvc.BaseMultiActionController;
import com.gm.common.utils.JsonUtils;

@Controller
public class IndexController extends BaseMultiActionController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping(value = "/gridData", method = RequestMethod.POST)
	public ModelAndView getJson(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String sort = request.getParameter("sort");

		int pageNo = 1;
		int rpNo = 10;

		if (StringUtils.hasText(page)) {
			pageNo = Integer.valueOf(page);
		}

		if (StringUtils.hasText(rows)) {
			rpNo = Integer.valueOf(rows);
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", pageNo);
		data.put("total", 40);// 模拟10页数据

		List<Map<String, Object>> rowData = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < rpNo; i++) {
			Map<String, Object> cell = new HashMap<String, Object>();
			cell.put("id", i + "-" + rpNo);
			cell.put("code", i + " - " + rpNo);
			cell.put("name", i + " - " + rpNo);
			cell.put("addr", i + " - " + rpNo);
			cell.put("opt", i + " - " + rpNo);
			rowData.add(cell);
		}

		data.put("rows", rowData);

		String jsonStr = JsonUtils.toJSONString(data);
		System.out.println(jsonStr);
		JsonUtils.outPutJson(jsonStr, response);
		return null;
	}

	public ModelAndView doit(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" ---------->>>>>>");
		return new ModelAndView("index");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}
}