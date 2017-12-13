package com.example.crawler.demo.util;

import java.lang.reflect.Type;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 *
 * @desc
 */
public class JsonUtil {
	
	private static final Logger logger = Logger.getLogger(JsonUtil.class);
	
	private static Gson gson = new Gson();
	
	public static <T> String jsonFromObject(T bean) {
		String json = null;
		try {
			json = gson.toJson(bean);
		} catch (Exception e) {
			logger.error("对象转json出错"+e);
		}
		return json;
	}
	
	public static <T> T jsonToObject(String json, Class<T> clazz) {
		T bean = null;
		try {
			bean = gson.fromJson(json, clazz);
		} catch (JsonSyntaxException e) {
			logger.error("json转对象出错："+e);
		}
		return bean;
	}
	
	public static <T> T jsonToObject(String json, Type type) {
		T bean = null;
		try {
			bean = gson.fromJson(json, type);
		} catch (JsonSyntaxException e) {
			logger.error("json转对象出错："+e);
		}
		return bean;
	}

}

