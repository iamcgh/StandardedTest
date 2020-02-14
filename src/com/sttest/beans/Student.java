package com.sttest.beans;

public class Student {
	
	private String examNumber;//准考证号
	
	private String name;//姓名
	
	private String password;//密码
	
	private String phone;	//联系方式
	
	private String gender;	//性别

	public Student() {
		super();
	}

	public Student(String examNumber, String name, String password, String phone, String gender) {
		super();
		this.examNumber = examNumber;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
	}

	public String getExamNumber() {
		return examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [examNumber=" + examNumber + ", name=" + name + ", password=" + password + ", phone=" + phone
				+ ", gender=" + gender + "]";
	}
	
	

}
