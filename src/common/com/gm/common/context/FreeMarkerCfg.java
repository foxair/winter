package com.gm.common.context;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

/**
 * 读取 properties bean 配置的 properties 文件中的属性到 freemarker 模板全局变量
 * 
 * @author azheng
 */
public class FreeMarkerCfg extends FreeMarkerConfigurer {

	PropertiesProvider propertiesProvider;

	public void setPropertiesProvider(PropertiesProvider propertiesProvider) {
		this.propertiesProvider = propertiesProvider;
	}

	Logger log = Logger.getLogger(FreeMarkerCfg.class);

	public void afterPropertiesSet() throws IOException, TemplateException {
		super.afterPropertiesSet();
		setSharedVariable();
	}

	/**
	 * 读取properties设置模板全局变量
	 */
	public void setSharedVariable() {
		Configuration configuration = getConfiguration();
		Properties properties = propertiesProvider.getProperties();
		try {
			Enumeration enums = properties.keys();
			while (enums.hasMoreElements()) {
				String key = (String) enums.nextElement();
				if (log.isInfoEnabled()) {
					log.info("Add Freemarker Shared Variable : [" + key + "=" + properties.get(key) + "]");
				}
				configuration.setSharedVariable(key, properties.get(key));
			}
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
	}

}