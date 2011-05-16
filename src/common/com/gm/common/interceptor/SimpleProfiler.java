package com.gm.common.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 拦截接口方法,记录执行时间通知
 * TODO
 */
public class SimpleProfiler {

	public Object profile(ProceedingJoinPoint call) throws Throwable {
		StopWatch clock = new StopWatch(call.toString());
		try {
			clock.start();
			return call.proceed();
		} finally {
			clock.stop();
			System.out
					.println("============================================================================================");
			System.out.print("[Profiler:" + clock.prettyPrint());
			System.out
					.println("============================================================================================");
		}
	}
}