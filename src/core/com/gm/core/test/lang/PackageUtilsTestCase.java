package com.gm.core.test.lang;

import junit.framework.TestCase;

import com.gm.core.lang.reflect.PackageUtils;

public class PackageUtilsTestCase extends TestCase {

	public void testGetClasses() throws ClassNotFoundException {
		TestCase.assertNotNull(PackageUtils.getClasses("com.gm.core.test.lang"));
		try {
			PackageUtils.getClasses("com.gm.core.test.lafdfdfng");
			TestCase.assertTrue(false);
		} catch (ClassNotFoundException e) {
			TestCase.assertTrue(true);
		}
	}

}
