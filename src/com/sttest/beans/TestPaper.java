package com.sttest.beans;

import java.util.Date;

public class TestPaper {
	
	private String id;	//�Ծ���
	
	private String paperName;	//�Ծ���
	
	private String paperType;	//�Ծ�����
	
	private String upLoadTime;	//�ϴ�ʱ��
	
	private String provider;	//�ṩ���û���

	public TestPaper() {
		super();
	}

	public TestPaper(String id, String paperName, String paperType, String upLoadTime, String provider) {
		super();
		this.id = id;
		this.paperName = paperName;
		this.paperType = paperType;
		this.upLoadTime = upLoadTime;
		this.provider = provider;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getUpLoadTime() {
		return upLoadTime;
	}

	public void setUpLoadTime(String upLoadTime) {
		this.upLoadTime = upLoadTime;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "TestPaper [id=" + id + ", paperName=" + paperName + ", paperType=" + paperType + ", upLoadTime="
				+ upLoadTime + ", provider=" + provider + "]";
	}
	
	

}
