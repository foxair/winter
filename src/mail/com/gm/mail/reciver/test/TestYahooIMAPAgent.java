/*
 *@# TestIMAPAgent.java 1:43:32 PM Jul 22, 2009

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
 * <p>测试IMAP邮件接收</p>

 * 1:43:32 PM Jul 22, 2009 
 */
public class TestYahooIMAPAgent {

	private static final Log logger = LogFactory.getLog(TestYahooIMAPAgent.class);

	public static void main(String[] args) {
		Setting setting = SettingFactory.getSetting("imap");
		setting.setHostAddress("imap.mail.yahoo.com");
		setting.setUserName("azheng");
		setting.setPwd("123456");
		//setting.setPort(993);
		//setting.setNeedSSL(true);
		MailAgent agent = MailAgentFactory.getAgent("yahooimap");
		agent.setReciverSetting(setting);
		try {
			//这里出现了一个问题，Yahoo系统发的第一封欢迎邮件总会导致各种错误，暂未弄清楚
			agent.login("INBOX");
			//			logger.debug("test case1");
			//			logger.debug(agent.fetchMailMessage());
			logger.debug("test case2-1");
			logger.debug(agent.fetchMailMessage(2, 4));
			//			logger.debug("test case2-2");
			//			logger.debug(agent.fetchMailMessage( -100 ,300));
			//			logger.debug("test case2-3");
			//			logger.debug(agent.fetchMailMessage( -100 , -300));
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
