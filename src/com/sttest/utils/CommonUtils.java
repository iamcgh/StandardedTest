package com.sttest.utils;

import java.util.UUID;

public class CommonUtils {
	// ����uuid����
	public static String getUUID() {
		return UUID.randomUUID().toString().substring(0, 16);
	}
}
