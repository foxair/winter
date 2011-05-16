package com.gm.test;

import org.junit.Test;

import com.gm.common.annotation.test.TrimTest;
import com.gm.common.test.BaseServiceTestCase;

public class AopTest extends BaseServiceTestCase {

	@Test
	public void trimTest() {
		TrimTest bt = new TrimTest();
		bt.setStr("    123    ");
		System.out.println(bt.getStr());
	}
}
