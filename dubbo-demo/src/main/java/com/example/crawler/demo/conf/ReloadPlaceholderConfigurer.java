package com.example.crawler.demo.conf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 *
 * @desc 加载jar包外的properties文件到spring的上下文中
 */
public class ReloadPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private boolean release = false;
	
	private Properties proOfSystem;
	
	public void setRelease(boolean release) {
		this.release = release;
	}
	
	public void setProOfSystem(Properties properties) {
		this.proOfSystem = properties;
	}
	
	public Properties getProOfSystem() {
		return this.proOfSystem;
	}

	public void setPropertiesFile(Set<String> profiles) {
		StringBuilder filePath = new StringBuilder();
		filePath.append(System.getProperty("user.dir")).append(System.getProperty("file.separator"));
		
		/*if(release) {
			filePath.append("..");
		}else {
			filePath.append("src").append(File.separator).append("main");
		}*/
		if(!release) {
			filePath.append("src").append(File.separator).append("main").append(File.separator);
		}
		filePath.append("conf").append(File.separator);
		
		Properties properties = new Properties();
		for (String profile : profiles) {
			String file = filePath.append(profile).toString();
			try {
				logger.info("loading crawler config properites file from :" + file);
				InputStream in = new BufferedInputStream(new FileInputStream(file));
				Properties prop = new Properties();
				prop.load(in);
				if (prop != null) {
					properties.putAll(prop);
				}
			} catch (Exception e) {
				logger.error("crawler config properties file :[" + file + "] cannot be found.");
			}
		}
		// 关键方法,调用的PropertyPlaceholderConfigurer中的方法,通过这个方法将自定义加载的properties文件加入spring中
		this.setProperties(properties);
		// 用于代码程序中
		this.setProOfSystem(properties);
	}

}

