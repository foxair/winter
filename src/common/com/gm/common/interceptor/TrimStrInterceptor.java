package com.gm.common.interceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.gm.common.annotation.TrimValue;
import com.gm.core.lang.StringUtils;

/**
 * 拦截参数类型是 String 并包含 @TrimValue 的注释的  Set 方法
 * Set 方法参数去除空格  Trim
 */
public class TrimStrInterceptor implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("--------------------");
		TrimValue annotation = invocation.getMethod().getAnnotation(TrimValue.class); //获取指定注解  
		if (annotation != null) {
			Method m = invocation.getMethod();
			if (m.getName().startsWith("set")) {
				Type c = m.getReturnType();
				if (c.getClass().equals(String.class)) {
					switch (annotation.value()) {
					case BEGIN:
						invocation.getArguments()[0] = StringUtils
								.leftTrim(String.valueOf(invocation.getArguments()[0]));
						break;
					case END:
						invocation.getArguments()[0] = StringUtils
								.leftTrim(String.valueOf(invocation.getArguments()[0]));
						break;
					default:
						invocation.getArguments()[0] = String.valueOf(invocation.getArguments()[0]).trim();
						break;
					}
				}
			}
		}
		return invocation.proceed();
	}
}