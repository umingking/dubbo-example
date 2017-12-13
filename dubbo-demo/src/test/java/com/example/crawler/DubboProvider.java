package com.example.crawler;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @描述: 启动Dubbo服务用的MainClass.
 * @版本: 1.0 .
 */
public class DubboProvider {
	
	/**启动前加载jar包外的日志配置文件**/
	static {   
		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator+"src/main"+File.separator + "conf" + File.separator   
                + "log4j.properties");
    }
	
	private static final Logger logger = Logger.getLogger(DubboProvider.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();
		} catch (Exception e) {
			logger.error("== DubboProvider context start error:",e);
		}
		synchronized (DubboProvider.class) {
			while (true) {
				try {
					DubboProvider.class.wait();
				} catch (InterruptedException e) {
					logger.error("== synchronized error:",e);
				}
			}
		}
	}
    
}