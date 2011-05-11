package com.gm.common.mvc;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * Dec 31, 2009,3:19:59 AM
 * 
 * @author azheng 处理 Ajax 和多方法调用
 * @version 2.0
 */
public abstract class BaseMultiActionController extends MultiActionController implements InitializingBean {

	/** 表格数据List */
	private static final String GRID_DATA = "rows";
	/** 表格数据记录数 */
	private static final String GRID_DATA_COUNT = "total";
	/** 表格汇总行数据List */
	private static final String GRID_FOOTER_DATA = "footer";

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
					System.out.println("param: " + paramName + "=" + paramValue);
					map.put(paramName, paramValue);
				}
			}
		}
		return map;
	}

	/**
	 * 封装List为DataGrid的数据格式
	 * @param dataList
	 * @return
	 */
	protected Map<String, Object> getJsonModel(int totalCount, List dataList) {
		Map<String, Object> jsonModel = new HashMap<String, Object>();
		jsonModel.put(GRID_DATA, dataList);
		jsonModel.put(GRID_DATA_COUNT, totalCount);
		return jsonModel;
	}

	/**
	 * 封装List为DataGrid的数据格式,带汇总行
	 * @param dataList grid数据
	 * @param footerDataList 底部合计行数据
	 * @return
	 */
	protected Map<String, Object> getJsonModel(int totalCount, List dataList, List footerDataList) {
		Map<String, Object> jsonModel = new HashMap<String, Object>();
		jsonModel.put(GRID_DATA, dataList);
		jsonModel.put(GRID_FOOTER_DATA, footerDataList);
		jsonModel.put(GRID_DATA_COUNT, totalCount);
		return jsonModel;
	}

	/**
	 * Bean 加载后处理
	 */
	public void afterPropertiesSet() throws Exception {
	}

}
