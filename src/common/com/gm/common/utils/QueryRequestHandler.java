package com.gm.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;

import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.common.orm.mybatis.QueryRequest;
import com.gm.common.orm.mybatis.query.Orders;
import com.gm.core.lang.StringUtils;

/**
 * 分页请求对象处理
 * 用于从HttpRequest中获取分页参数
 */
@SuppressWarnings("static-access")
public class QueryRequestHandler {

	/**
	 * 只传入过实体对象的滤参数
	 * @param paramObj
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static QueryRequest buildQueryHttpRequestParameters(BaseEntity filterObj, HttpServletRequest request) {
		QueryRequest queryRequest = new QueryRequest(filterObj);
		queryRequest.setFilters(filterObj);
		if (StringUtils.isEmpty(queryRequest.getSortColumns()))
			return bindHttpRequestParameters(queryRequest, request, queryRequest.getSortColumns());
		else
			return bindHttpRequestParameters(queryRequest, request, null);
	}

	/**
	 * 绑定HttpServletRequest中的分页参数到分页请求对象
	 * @param queryRequest
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static QueryRequest bindHttpRequestParameters(QueryRequest queryRequest, HttpServletRequest request) {
		if (StringUtils.isEmpty(queryRequest.getSortColumns()))
			return bindHttpRequestParameters(queryRequest, request, queryRequest.getSortColumns());
		else
			return bindHttpRequestParameters(queryRequest, request, null);
	}

	/**
	 * 绑定HttpServletRequest中的分页参数到分页请求对象,并设置默认排序字段
	 * @param queryRequest
	 * @param request
	 * @param defaultSortColumns
	 * @return
	 */
	public static QueryRequest<?> bindHttpRequestParameters(QueryRequest<?> queryRequest, HttpServletRequest request,
			String defaultSortColumns) {
		if (ServletRequestUtils.getIntParameter(request, QueryRequest.PAGE_SIZE, 0) > 0)
			return bindHttpRequestParameters(queryRequest, request, defaultSortColumns,
					ServletRequestUtils.getIntParameter(request, QueryRequest.PAGE_SIZE, 10));
		else if (queryRequest.getPageSize() > 0)
			return bindHttpRequestParameters(queryRequest, request, defaultSortColumns, queryRequest.getPageSize());
		else
			return bindHttpRequestParameters(queryRequest, request, defaultSortColumns, QueryRequest.PAGE_DEFAULT_SIZE);
	}

	/**
	 * TODO request的参数会覆盖程序里指定的参数
	 * 绑定HttpServletRequest中的分页参数到分页请求对象,并设置默认排序字段和默认分页大小
	 * @param queryRequest
	 * @param request
	 * @param defaultSortColumns
	 * @param defaultPageSize
	 * @return
	 */
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	public static QueryRequest bindHttpRequestParameters(QueryRequest queryRequest, HttpServletRequest request,
			String defaultSortColumns, int defaultPageSize) {
		//Map params = WebUtils.getParametersStartingWith(request, "");

		queryRequest.setPageNumber(ServletRequestUtils.getIntParameter(request, queryRequest.PAGE_NUMBER, 0));
		queryRequest.setPageSize(ServletRequestUtils.getIntParameter(request, queryRequest.PAGE_SIZE, 10));

		if (ServletRequestUtils.getIntParameter(request, queryRequest.PAGE_NUMBER, 0) == 0
				&& queryRequest.getPageNumber() == 0)
			queryRequest.setPageNumber(ServletRequestUtils.getIntParameter(request, queryRequest.PAGE_NUMBER, 1));

		if (queryRequest.getPageSize() == 0)
			queryRequest.setPageSize(defaultPageSize);
		if (queryRequest.getPageSize() > queryRequest.PAGE_MAX_SIZE) {
			queryRequest.setPageSize(queryRequest.PAGE_MAX_SIZE);
		}

		String field = ServletRequestUtils
				.getStringParameter(request, queryRequest.PAGE_SORT_FIELD, defaultSortColumns);
		String orderType = ServletRequestUtils.getStringParameter(request, queryRequest.PAGE_ORDER_TYPE,
				queryRequest.ORDER_DESC);
		if (field != null) {
			if (orderType.equals(queryRequest.ORDER_ASC))
				queryRequest.addOrder(Orders.asc(field));
			else
				queryRequest.addOrder(Orders.desc(field));
		}
		return queryRequest;
	}

}