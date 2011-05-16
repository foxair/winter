package com.gm.core.test.beans;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.gm.core.lang.reflect.ClassUtils;
import com.gm.core.lang.reflect.ReflectUtils;

public class BeanUtilsTestCase extends TestCase {

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

		private String nickName;

		public String getNickName() {
			return nickName;
		}

		private int age;
	}

	public void testCopy() {
		Person p1 = new Person();
		Person p2 = new Person();
		p1.setName("peng");
		p1.setAge(20);
		ReflectUtils.copy(p1, p2, "age");
		TestCase.assertEquals("peng", p2.getName());
		TestCase.assertEquals(0, p2.getAge());
	}

	public void testGetSetMethodName() {
		TestCase.assertEquals("setName", ReflectUtils.getSetMethodName("name"));
	}

	public void testGetGetMethodName() {
		TestCase.assertEquals("getName", ReflectUtils.getGetMethodName("name"));
	}

	public void testInjectStringMapOfStringObject() throws InstantiationException, ClassNotFoundException,
			IllegalAccessException {
		String str = "com.gm.core.test.beans.BeanUtilsTestCase$Person";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 11);
		map.put("name", "azheng");
		Person p = (Person) ReflectUtils.inject(str, map);
		TestCase.assertEquals("azheng", p.getName());
		TestCase.assertEquals(11, p.getAge());
	}

	public void testInjectClassOfQMapOfStringObject() throws InstantiationException, ClassNotFoundException,
			IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 11);
		map.put("name", "azheng");
		Person p = (Person) ReflectUtils.inject(Person.class, map);
		TestCase.assertEquals("azheng", p.getName());
		TestCase.assertEquals(11, p.getAge());
	}

	public void testInjectObjectMapOfStringObject() throws InstantiationException, ClassNotFoundException,
			IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 11);
		map.put("name", "azheng");
		Person p = new Person();
		ReflectUtils.inject(p, map);
		TestCase.assertEquals("azheng", p.getName());
		TestCase.assertEquals(11, p.getAge());
	}

	public void testInjectField() {
		Person p = new Person();
		// has set method
		ReflectUtils.injectField(p, ClassUtils.getField(p, "name"), "peng");
		// no set method
		ReflectUtils.injectField(p, ClassUtils.getField(p, "nickName"), "dd");
		TestCase.assertEquals("peng", p.getName());
		TestCase.assertEquals("dd", p.getNickName());
		// no exists field name
		try {
			ReflectUtils.injectField(p, ClassUtils.getField(p, "nName"), "dd");
			TestCase.assertTrue(false);
		} catch (Exception e) {
			TestCase.assertTrue(true);
		}
	}

	public void testIsBasicType() {
		TestCase.assertTrue(ReflectUtils.isBasicType(java.util.Date.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(String.class));

		TestCase.assertTrue(ReflectUtils.isBasicType(int.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(double.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(float.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(short.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(byte.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(char.class));

		TestCase.assertTrue(ReflectUtils.isBasicType(int[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(double[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(float[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(short[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(byte[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(char[].class));

		TestCase.assertTrue(ReflectUtils.isBasicType(Integer[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Double[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Float[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Short[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Byte[].class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Character[].class));

		TestCase.assertTrue(ReflectUtils.isBasicType(Integer.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Double.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Float.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Short.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Byte.class));
		TestCase.assertTrue(ReflectUtils.isBasicType(Character.class));

		TestCase.assertFalse(ReflectUtils.isBasicType(Person.class));
	}

}
