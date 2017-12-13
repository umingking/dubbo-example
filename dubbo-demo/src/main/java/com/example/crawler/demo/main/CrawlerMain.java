package com.example.crawler.demo.main;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;

import com.alibaba.dubbo.container.Main;

/**
 *
 * @desc 启动的爬虫的主程序
 */
public class CrawlerMain {

	/**启动前加载jar包外的日志配置文件**/
	static {   
		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "conf" + File.separator   
                + "log4j.properties");
    }
	
	public static void main(String[] args) {
		/**Dubbo微服务启动调用**/
		Main.main(args);
	}

}

