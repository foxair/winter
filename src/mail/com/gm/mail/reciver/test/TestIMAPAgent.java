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
 * <p>测试IMAP邮件接收</p>

 * 1:43:32 PM Jul 22, 2009 
 */
public class TestIMAPAgent {

	private static final Log logger = LogFactory.getLog(TestIMAPAgent.class);

	public static void main(String[] args) {
		Setting setting = SettingFactory.getSetting("imap");
		setting.setHostAddress("imap.gmail.com");
		setting.setUserName("azheng@gmail.com");
		setting.setPwd("123456");
		setting.setPort(993);
		setting.setNeedSSL(true);
		MailAgent agent = MailAgentFactory.getAgent("imap");
		agent.setReciverSetting(setting);
		try {
			agent.login("inbox");
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
			ignoreList.add("1");
			logger.debug(agent.fetchMailMessage(ignoreList));

			logger.debug("test case4");
			logger.debug(agent.fetchUnSeenMailMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
