package com.example.crawler.demo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.crawler.demo.api.DemoApi;

/**
 *
 * @desc
 */
@Service("demoApi")
public class DemoImpl implements DemoApi {

	public static final Logger logger = Logger.getLogger(DemoImpl.class);
	
	@Override
	public String testDemo(String param) {
		System.out.println("coming in demo progress ["+param+"]");
		return param;
	}

}

