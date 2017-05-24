package com.lsy.shop.utils;

import java.util.UUID;

/**
 * 生成随机字符串的工具类
 * @author lsy
 *
 */
public class UUIDUtils {
	
	/**
	 * 获得随机字符串
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
