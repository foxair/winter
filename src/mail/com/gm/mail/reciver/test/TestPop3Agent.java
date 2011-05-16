/*
 *@# TestPop3.java 6:04:12 PM Jul 21, 2009
 */
package com.gm.mail.reciver.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gm.mail.reciver.MailAgentFactory;
import com.gm.mail.reciver.SettingFactory;
import com.gm.mail.reciver.agent.MailAgent;
import com.gm.mail.reciver.setting.Setting;

/**
 * <p>POP3收取邮件测试</p>

 * 6:04:12 PM Jul 21, 2009 
 */
public class TestPop3Agent {

	private static final Log logger = LogFactory.getLog(TestPop3Agent.class);

	public static void main(String[] args) {

		Setting set = SettingFactory.getSetting("pop3");
		set.setUserName("fox.hu@corp.globalmarket.com");
		set.setPwd("123456");//password
		set.setHostAddress("pop.globalmarket.com");

		MailAgent agent = MailAgentFactory.getAgent("pop3");
		agent.setReciverSetting(set);
		try {
			agent.login("inbox");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			logger.debug("test case1");
			logger.debug(agent.fetchMailMessage());
			logger.debug("test case2-1");
			logger.debug(agent.fetchMailMessage(1, 3));
			logger.debug("test case2-2");
			logger.debug(agent.fetchMailMessage(-100, 300));
			logger.debug("test case2-3");
			logger.debug(agent.fetchMailMessage(-100, -300));
			logger.debug("test case3");
			List<String> ignoreList = new ArrayList<String>();
			ignoreList.add("1tbitAZ+2EX9cfkcCwAAsz");
			ignoreList.add("1tbiqg9x2Ee9J-aehQAAs8");
			ignoreList.add("1tbiqg5w2Ee9J-IbqAAAsQ");
			ignoreList.add("1tbi4w512EkZmdaQ0QAAse");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
