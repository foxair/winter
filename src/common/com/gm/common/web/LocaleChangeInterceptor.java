package com.gm.common.web;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

/**
 * 用户local拦截
 * 
 * @author azheng
 */
public class LocaleChangeInterceptor extends org.springframework.web.servlet.i18n.LocaleChangeInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {

		Locale locale = (Locale) WebUtils.getSessionAttribute(request,
				SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if (null != locale) {
			return true;
		}
		String paramLocale = request.getParameter(DEFAULT_PARAM_NAME);
		String localeChange = request.getParameter("locale");
		if (null != localeChange && paramLocale != null) {
			super.preHandle(request, response, handler);
			return true;
		}

		if (paramLocale != null) {
			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			if (localeResolver == null) {
				throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
			}
			LocaleEditor localeEditor = new LocaleEditor();
			localeEditor.setAsText(paramLocale);
			localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());
		}
		return true;
	}
}
