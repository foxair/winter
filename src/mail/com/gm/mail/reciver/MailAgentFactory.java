/*
 *@# MailAgentFactory.java 6:06:04 PM Jul 21, 2009

 */
package com.gm.mail.reciver;

import org.apache.commons.lang.StringUtils;

import com.gm.mail.reciver.agent.IMAPAgent;
import com.gm.mail.reciver.agent.MailAgent;
import com.gm.mail.reciver.agent.POP3Agent;
import com.gm.mail.reciver.agent.YahooIMAPAgent;

/**
 * <p>邮件抓取代理工厂类，负责产生不同的邮件抓取代理</p>

 * 6:06:04 PM Jul 21, 2009 
 */
public class MailAgentFactory {

	/**
	 * <p>按协议名获取对应的MailAgent，etc. pop3 imap</p>
	 * @param type protocol name
	 * @return
	 */
	public static MailAgent getAgent(String type) {
		if (StringUtils.isBlank(type)) {
			throw new IllegalArgumentException("type cannot be blank");
		} else if ("pop3".equalsIgnoreCase(type)) {
			return new POP3Agent();
		} else if ("imap".equalsIgnoreCase(type)) {
			return new IMAPAgent();
		} else if ("yahooimap".equalsIgnoreCase(type)) {
			return new YahooIMAPAgent();
		} else {
			throw new IllegalArgumentException(String.format("type %s is not exists", type));
		}
	}
}
