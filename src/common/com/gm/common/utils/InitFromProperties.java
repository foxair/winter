package com.gm.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取属性文件初始化类属性值 2010-2-2,上午03:29:12
 * 
 * @author azheng
 */
public class InitFromProperties {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InitFromProperties.class);

	private String propFile;

	private Map<String, String> value;

	/**
	 * 反射读取属性 2010-2-2,上午03:29:44
	 * 
	 * @param targetClass
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private Object getStaticProperty(Class targetClass, String fieldName) throws Exception {
		Field field = targetClass.getField(fieldName);
		Object value = field.get(null);
		return value;
	}

	/**
	 * 反射设置属性值 2010-2-2,上午03:30:08
	 * 
	 * @param targetClass
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void setStaticProperty(Class targetClass, String fieldName, Object value) throws Exception {
		Field field = targetClass.getField(fieldName);
		field.set(null, value);
	}

	/**
	 * 初始化指定的类中的属性 2010-2-2,上午03:30:31
	 * 
	 * @param targetClass
	 * @param prop
	 */
	@SuppressWarnings("unchecked")
	private void initProp(Class targetClass, Properties prop) {
		try {
			Enumeration enums = prop.keys();
			while (enums.hasMoreElements()) {
				String key = (String) enums.nextElement();
				value.put(key, prop.getProperty(key));
				String[] keyName = key.split("\\.");
				if (keyName.length == 2) {
					String cname = keyName[0];
					String pname = keyName[1];
					if (getClassName(targetClass.getName()).equals(cname)) {
						// 如果属性key的类名部分相同,则赋值
						String value = prop.getProperty(key);
						setStaticProperty(targetClass, pname, value);
					}
				}
			}
		} catch (NoSuchFieldException nsfe) {
			if (logger.isInfoEnabled()) {
				logger.info("初始化属性:未在类中找到对应的属性");
			}
			nsfe.printStackTrace();
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("初始化属性:设置属性值时发生错误");
			}
			e.printStackTrace();
		}
	}

	/**
	 * 读取属性文件,逐个类初始化 2010-2-2,上午03:30:31
	 */
	@SuppressWarnings("unchecked")
	public void init() {
		Properties prop = new Properties();
		InputStream in = InitFromProperties.class.getResourceAsStream(propFile);
		try {
			prop.load(in);
		} catch (IOException e1) {
			if (logger.isInfoEnabled()) {
				logger.info("初始化属性:属性文件" + propFile + "读取失败");
			}
			// 文件读取异常
			e1.printStackTrace();
		}
		// 取得要设置属性的类
		String classes = prop.getProperty("classes");
		String[] classList = classes.split(",");
		// 逐个类初始化
		for (String classFullName : classList) {
			try {
				Class clazz = Class.forName(classFullName);
				value = new HashMap<String, String>();
				initProp(clazz, prop);// 执行初始化方法
				if (logger.isInfoEnabled()) {
					logger.info("初始化属性:[" + classFullName + "] 从" + propFile + "读取值成功");
				}
			} catch (ClassNotFoundException e) {
				// 设置属性异常
				if (logger.isInfoEnabled()) {
					logger.info("初始化属性:通过类的全路径,未找到相应的类");
				}
				e.printStackTrace();
			}
		}
	}

	/**
	 * 取得属性文件中的值 2010-2-22,上午02:28:06
	 * 
	 * @return
	 */
	public Object getValue(String propKey) {
		return value.get(propKey);
	}

	/**
	 * 通过类全路径名获得类名 2010-2-2,上午06:04:51
	 * 
	 * @param classFullName
	 * @return
	 */
	private static String getClassName(String classFullName) {
		String className = null;
		if (classFullName != null) {
			String[] sname = classFullName.split("\\.");
			className = sname[sname.length - 1].trim();
		}
		return className;
	}

	public void setPropFile(String propFile) {
		this.propFile = propFile;
	}
}
