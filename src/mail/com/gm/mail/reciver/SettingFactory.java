/*
 *@# SettingFactory.java 1:52:36 PM Jul 21, 2009

 */
package com.gm.mail.reciver;

import org.apache.commons.lang.StringUtils;

import com.gm.mail.reciver.setting.IMAPSetting;
import com.gm.mail.reciver.setting.POP3Setting;
import com.gm.mail.reciver.setting.Setting;

/**
 * <p>设置工厂，产生配置信息</p>

 * 1:52:36 PM Jul 21, 2009 
 */
public class SettingFactory {

	/**
	 * <p>按协议名获取对应的设置，etc. pop3 imap</p>
	 * @param type protocol name
	 * @return
	 */
	public static Setting getSetting(String type) {
		if (StringUtils.isBlank(type)) {
			throw new IllegalArgumentException("type cannot be blank");
		} else if ("pop3".equalsIgnoreCase(type)) {
			return new POP3Setting();
		} else if ("imap".equalsIgnoreCase(type)) {
			return new IMAPSetting();
		} else {
			throw new IllegalArgumentException(String.format("type %s is not exists", type));
		}
	}
}
