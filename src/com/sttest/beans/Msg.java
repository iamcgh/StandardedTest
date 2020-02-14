package com.sttest.beans;

import java.util.HashMap;
import java.util.Map;


/**
 * 作为一个后台传往前端的通用的消息类
 * @author ASUS
 *
 */
public class Msg {
	private int status;//状态码:200成功，404失败
	private String message;//提示信息
	
	private Map<String,Object> extend = new HashMap<>();//扩展信息，用来传递前台请求的类对象

	//处理成功调用的函数
	public static Msg success() {
		Msg result = new Msg();
		result.setStatus(200);
		result.setMessage("处理成功！");
		return result;
	}
	
	//处理失败调用的函数
	public static Msg fail() {
		Msg result = new Msg();
		result.setStatus(404);
		result.setMessage("处理失败！");
		return result;
	}
	
	//添加对象
	public Msg add(String key,Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
