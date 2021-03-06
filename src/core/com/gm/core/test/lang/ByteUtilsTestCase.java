package com.gm.core.test.lang;

import junit.framework.TestCase;

import com.gm.core.lang.BytesUtils;

public class ByteUtilsTestCase extends TestCase {

	public void testToBytesStringString() {
		TestCase.assertNotNull(BytesUtils.toBytes("abc", "iso8859-1"));
		try {
			TestCase.assertNotNull(BytesUtils.toBytes("abcde", "iso8859-xxfdrfe"));
			TestCase.assertTrue(false);
		} catch (Exception e) {
			TestCase.assertTrue(true);
		}
	}

	public void testToBytesString() {
		TestCase.assertNotNull(BytesUtils.toBytes("abc"));
	}

	public void testToBytesStringBuilderString() {
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		TestCase.assertNotNull(BytesUtils.toBytes(sb, "iso8859-1"));
		try {
			TestCase.assertNotNull(BytesUtils.toBytes(sb, "iso8859-xxfdrfe"));
			TestCase.assertTrue(false);
		} catch (Exception e) {
			TestCase.assertTrue(true);
		}
	}

	public void testToBytesStringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		TestCase.assertNotNull(BytesUtils.toBytes(sb));
	}

}
