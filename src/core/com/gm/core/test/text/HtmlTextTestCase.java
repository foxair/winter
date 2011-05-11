package com.gm.core.test.text;

import junit.framework.TestCase;

import com.gm.core.text.HtmlText;

public class HtmlTextTestCase extends TestCase {

	public void testRemoveTags() {
		String html = "<html><head></head><body><br/>&nbsp;&nbsp;haha<body></html>";
		TestCase.assertEquals("haha", HtmlText.removeTags(html));
	}

}
