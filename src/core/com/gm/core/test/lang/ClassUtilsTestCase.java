package com.gm.core.test.lang;

import java.util.Date;

import junit.framework.TestCase;

import com.gm.core.lang.reflect.ClassUtils;

public class ClassUtilsTestCase extends TestCase {

	public static class Person {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public static int getTestStaticField() {
			return testStaticField;
		}

		public static void setTestStaticField(int testStaticField) {
			Person.testStaticField = testStaticField;
		}

		public static int getTeststaticfinalfield() {
			return testStaticFinalField;
		}

		public int getTestfinalField() {
			return testfinalField;
		}

		private int age;
		private static final int testStaticFinalField = 1;
		private final int testfinalField = 2;
		private static int testStaticField = 3;
	}

	public void testIsSameTypeObjectObject() {
		TestCase.assertTrue(ClassUtils.isSameType("", "abc"));
		Person p1 = new Person();
		Person p2 = new Person();
		TestCase.assertTrue(ClassUtils.isSameType(p1, p2));
		TestCase.assertFalse(ClassUtils.isSameType("", p2));
	}

	public void testIsSameTypeClassClass() {
		TestCase.assertTrue(ClassUtils.isSameType("".getClass(), "abc".getClass()));
		Person p1 = new Person();
		Person p2 = new Person();
		TestCase.assertTrue(ClassUtils.isSameType(p1.getClass(), p2.getClass()));
		TestCase.assertFalse(ClassUtils.isSameType("".getClass(), p2.getClass()));
	}

	public void testGetField() {
		Person p1 = new Person();
		TestCase.assertNotNull(ClassUtils.getField(p1, "name"));
		TestCase.assertNotNull(ClassUtils.getField(p1, "testStaticFinalField"));
		try {
			ClassUtils.getField(p1, "namexxx");
			TestCase.assertTrue(false);
		} catch (Exception e) {
			if (e instanceof NoSuchFieldException) {
				TestCase.assertTrue(true);
			}
		}
	}

	public void testGetNoStaticNorFinalFieldArray() throws NoSuchFieldException {
		Person p1 = new Person();
		TestCase.assertEquals(2, ClassUtils.getNoStaticNorFinalFieldArray(p1).length);
	}

	public void testGetNoStaticNorFinalFieldList() {
		Person p1 = new Person();
		TestCase.assertEquals(2, ClassUtils.getNoStaticNorFinalFieldList(p1).size());
	}

	public void testGetNoStaticFieldArray() {
		Person p1 = new Person();
		TestCase.assertEquals(3, ClassUtils.getNoStaticFieldArray(p1).length);
	}

	public void testGetNoStaticFieldList() {
		Person p1 = new Person();
		TestCase.assertEquals(3, ClassUtils.getNoStaticFieldList(p1).size());
	}

	public void testGetNoStaticNorFinalField() throws NoSuchFieldException {
		Person p1 = new Person();
		TestCase.assertNotNull(ClassUtils.getNoStaticNorFinalField(p1, "name"));
		try {
			ClassUtils.getNoStaticNorFinalField(p1, "namexxx");
			TestCase.assertTrue(false);
		} catch (Exception e) {
			if (e instanceof NoSuchFieldException) {
				TestCase.assertTrue(true);
			}
		}
		try {
			ClassUtils.getNoStaticNorFinalField(p1, "testStaticFinalField");
			TestCase.assertTrue(false);
		} catch (Exception e) {
			if (e instanceof NoSuchFieldException) {
				TestCase.assertTrue(true);
			}
		}
		try {
			ClassUtils.getNoStaticNorFinalField(p1, "testfinalField");
			TestCase.assertTrue(false);
		} catch (Exception e) {
			if (e instanceof NoSuchFieldException) {
				TestCase.assertTrue(true);
			}
		}
		try {
			ClassUtils.getNoStaticNorFinalField(p1, "testStaticField");
			TestCase.assertTrue(false);
		} catch (Exception e) {
			if (e instanceof NoSuchFieldException) {
				TestCase.assertTrue(true);
			}
		}
	}

	public void testIsSystemClass() {
		TestCase.assertTrue(ClassUtils.isSystemClass("abc".getClass()));
		Date date = new Date();
		TestCase.assertTrue(ClassUtils.isSystemClass(date.getClass()));
		Integer integer = new Integer(2);
		TestCase.assertTrue(ClassUtils.isSystemClass(integer.getClass()));
		TestCase.assertTrue(ClassUtils.isSystemClass(Boolean.class));
		TestCase.assertFalse(ClassUtils.isSystemClass(Person.class));
	}

}
