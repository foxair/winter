package com.gm.common.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 拦截方法进行授权验证
 * @author azheng
 * TODO
 */
public class AuthorizeValidateAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method m, Object[] args, Object target) throws Throwable {
		System.out.println("记录日志 (by " + this.getClass().getName() + ")");
	}
}