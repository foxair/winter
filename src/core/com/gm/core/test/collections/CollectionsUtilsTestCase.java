package com.gm.core.test.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import com.gm.core.collections.CollectionUtils;

public class CollectionsUtilsTestCase extends TestCase {

	public void testContact() {
		List<String> l1 = new ArrayList<String>();
		l1.add("abc");
		l1.add("abc");
		List<String> l2 = new ArrayList<String>();
		l2.add("zzz");
		l2.add("zz2");
		TestCase.assertEquals(4, CollectionUtils.contact(l1, l2).size());
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add("abc");
		s1.add("def");
		s2.add("abc");
		s2.add("zzz");
		TestCase.assertEquals(3, CollectionUtils.contact(s1, s2).size());
	}

	public void testSubListListOfObjectIntInt() {
		List<String> l1 = new ArrayList<String>();
		l1.add("abc");
		l1.add("abc");
		l1.add("zzz");
		l1.add("zz2");
		TestCase.assertEquals(0, CollectionUtils.subList(l1, 0, 0).size());
		TestCase.assertEquals(1, CollectionUtils.subList(l1, 0, 1).size());
		TestCase.assertEquals(3, CollectionUtils.subList(l1, 1, 10).size());
		TestCase.assertEquals(0, CollectionUtils.subList(l1, 12, 10).size());
		TestCase.assertEquals(0, CollectionUtils.subList(l1, 2, 1).size());
	}

	public void testSubListListOfObjectInt() {
		List<String> l1 = new ArrayList<String>();
		l1.add("abc");
		l1.add("abc");
		l1.add("zzz");
		l1.add("zz2");
		TestCase.assertEquals(4, CollectionUtils.subList(l1, -10).size());
		TestCase.assertEquals(4, CollectionUtils.subList(l1, 0).size());
		TestCase.assertEquals(3, CollectionUtils.subList(l1, 1).size());
		TestCase.assertEquals(1, CollectionUtils.subList(l1, 3).size());
		TestCase.assertEquals(0, CollectionUtils.subList(l1, 4).size());
		TestCase.assertEquals(0, CollectionUtils.subList(l1, 5).size());
	}

	public void testToList() {
		TestCase.assertEquals(3, CollectionUtils.toList("abc", "def", "ghj").size());
	}

	public void testToStringList() {
		TestCase.assertEquals(3, CollectionUtils.toStringList("abc", "def", "ghj").size());
	}

	public void testToIntList() {
		TestCase.assertEquals(3, CollectionUtils.toIntList(3, 2, 1).size());
	}

	public void testSubMap() {
		Map<String, String> sourceMap = new HashMap<String, String>();
		Map<String, String> targetMap = new HashMap<String, String>();
		sourceMap.put("abc.a", "zzz");
		sourceMap.put("abc.z", "abcz");
		sourceMap.put("ddd", "dd");
		TestCase.assertEquals(2, CollectionUtils.subMap(sourceMap, targetMap, "abc.").size());
		TestCase.assertEquals("abcz", targetMap.get("z"));
		TestCase.assertNull(targetMap.get("abc.z"));
	}

	public void testInList() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("eefg");
		list.add("zdr");
		TestCase.assertTrue(CollectionUtils.inList("abc", list));
		TestCase.assertFalse(CollectionUtils.inList("zzz", list));
	}

}
