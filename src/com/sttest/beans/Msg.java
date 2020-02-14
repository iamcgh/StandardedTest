package com.sttest.beans;

import java.util.HashMap;
import java.util.Map;


/**
 * ��Ϊһ����̨����ǰ�˵�ͨ�õ���Ϣ��
 * @author ASUS
 *
 */
public class Msg {
	private int status;//״̬��:200�ɹ���404ʧ��
	private String message;//��ʾ��Ϣ
	
	private Map<String,Object> extend = new HashMap<>();//��չ��Ϣ����������ǰ̨����������

	//����ɹ����õĺ���
	public static Msg success() {
		Msg result = new Msg();
		result.setStatus(200);
		result.setMessage("����ɹ���");
		return result;
	}
	
	//����ʧ�ܵ��õĺ���
	public static Msg fail() {
		Msg result = new Msg();
		result.setStatus(404);
		result.setMessage("����ʧ�ܣ�");
		return result;
	}
	
	//��Ӷ���
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
