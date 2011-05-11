package com.gm.common.mvc;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.mvc.SimpleFormController;

public abstract class BaseFormController extends SimpleFormController implements InitializingBean {

	/**
	 * 国际化处理
	 * 
	 * @param i18nKey
	 * @return
	 */
	protected String i18n(String i18nKey) {
		return getApplicationContext().getMessage(i18nKey, null, null);
	}

	/**
	 * 取得所有请求参数放入Map中 Dec 29, 2009,8:17:41 AM
	 * 
	 * @author azheng
	 * @param request
	 * @return
	 */
	protected Map<String, String> getAllParams(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() != 0) {
					// System.out.println("param: " + paramName + "=" +
					// paramValue);
					map.put(paramName, paramValue);
				}
			}
		}
		return map;
	}

	public void afterPropertiesSet() throws Exception {
	}

}
