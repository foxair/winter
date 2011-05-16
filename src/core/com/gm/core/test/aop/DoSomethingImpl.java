package com.gm.core.test.aop;

public class DoSomethingImpl implements DoSomething {
	public String doSomething() {
		String hl = "Do Something ~ ~ ~";
		System.out.println(hl);
		return hl;
	}
}
