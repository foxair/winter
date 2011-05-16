package com.gm.mail.reciver.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gm.core.configuration.Configuration;
import com.gm.core.configuration.PropertiesConfiguration;

/**
 * <p>全局配置类</p>
 */
public class Global {

	private static final Log logger = LogFactory.getLog(Global.class);

	//附件存储目录
	private static String attachmentDir = "D:/";
	//程序版本号
	private static String version = "";

	static {
		try {
			//加载配置文件
			Configuration settings = new PropertiesConfiguration("app.properties");
			version = settings.getString("version");
			if (settings.getString("attachmentDir") != null) {
				attachmentDir = settings.getString("attachmentDir");
			}
		} catch (Exception e) {
			logger.error("load system configuration error ,user default value");
		}
	}

	public static String getVersion() {
		return version;
	}

	public static String getAttachmentDir() {
		return attachmentDir;
	}

	public static void main(String[] args) {
		logger.debug(String.format("version >> %s", version));
		logger.debug(String.format("attachment dir >> %s", attachmentDir));
	}
}
