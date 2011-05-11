package com.gm.core.test.text;

import junit.framework.TestCase;

import com.gm.core.text.Display;

public class DisplayTestCase extends TestCase {

	public void testDisplayStringString() {
		TestCase.assertEquals("abc", Display.display(null, "abc"));
		TestCase.assertEquals("def", Display.display("def", "abc"));
	}

	public void testDisplayString() {
		TestCase.assertEquals("", Display.display(null));
		TestCase.assertEquals("def", Display.display("def"));
	}

}
