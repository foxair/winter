package com.gm.core.test.aop;

import com.gm.core.proxy.DynamicProxy;

public class DyamicProxyTest {

	public static void main(String[] args) {
		DoSomething dst = new DoSomethingImpl();
		DoSomething dstProxy = (DoSomething) new DynamicProxy().createProxyObject(dst);
		String endRes = dstProxy.doSomething();
		System.out.println(endRes);
	}

}
