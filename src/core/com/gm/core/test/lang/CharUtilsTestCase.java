package com.gm.core.test.lang;

import junit.framework.TestCase;

import com.gm.core.lang.CharUtils;

public class CharUtilsTestCase extends TestCase {

	public void testIntArray1() {
		char c = 'a';
		char[] cs = { 'a', 'b', 'c' };
		TestCase.assertTrue(CharUtils.inArray(c, cs));
		TestCase.assertFalse(CharUtils.notInArray(c, cs));
	}

	public void testIntArray2() {
		char c = 'a';
		char[] cs = { 'z', 'b', 'a' };
		TestCase.assertTrue(CharUtils.inArray(c, cs));
		TestCase.assertFalse(CharUtils.notInArray(c, cs));
	}

	public void testIntArray3() {
		char c = 'a';
		char[] cs = { 'z', 'b', 't' };
		TestCase.assertFalse(CharUtils.inArray(c, cs));
		TestCase.assertTrue(CharUtils.notInArray(c, cs));
	}

	public void testIntArray4() {
		char c = 'a';
		char[] cs = null;
		TestCase.assertFalse(CharUtils.inArray(c, cs));
		TestCase.assertTrue(CharUtils.notInArray(c, cs));
	}

	public void testToChar() {
		String s = "a";
		TestCase.assertEquals('a', CharUtils.toChar(s));
		try {
			TestCase.assertEquals('a', CharUtils.toChar("abc"));
			TestCase.assertTrue(false);
		} catch (Exception e) {
			TestCase.assertTrue(true);
		}
	}
}
