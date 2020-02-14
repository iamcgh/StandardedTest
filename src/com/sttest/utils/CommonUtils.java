package com.sttest.utils;

import java.util.UUID;

public class CommonUtils {
	// 生成uuid方法
	public static String getUUID() {
		return UUID.randomUUID().toString().substring(0, 16);
	}
}
