package com.sttest.beans;

public class Teacher {
	
	private String userName;	//用户名
	
	private String password;	//密码
	
	private String name;	//姓名
	
	private String dept;	//院系
	
	private String gender;	//性别
	
	private String phone;	//联系方式

	public Teacher() {
		super();
	}

	public Teacher(String userName, String password, String name, String dept, String gender, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.dept = dept;
		this.gender = gender;
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Teacher [userName=" + userName + ", password=" + password + ", name=" + name + ", dept=" + dept
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}
	
	
}
