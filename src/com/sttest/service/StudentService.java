package com.sttest.service;

import java.sql.SQLException;

import com.sttest.beans.Student;
import com.sttest.dao.StudentDao;
import com.sttest.dao.TeacherDao;

public class StudentService {
	
	//检测准考证号是否可用
	public boolean checkNumber(String examNumber) {
		StudentDao dao = new StudentDao();
		try {
			return dao.checkUserName(examNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//注册功能
	public boolean rigist(Student student) {
		StudentDao dao = new StudentDao();
		try {
			if(dao.regist(student))
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//用于登录的函数
	public boolean login(String examNumber,String name,String password) {
		StudentDao dao = new StudentDao();
		Student findStudent = null;
		try {
			findStudent = dao.getStudentInfoByExamNumber(examNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(findStudent != null) {
			if(findStudent.getName().equals(name)
					&& findStudent.getPassword().equals(password)) {
				return true;
			} else 
				return false;
		}
		return false;
	}
	
	//获取学生信息
	public Student getInfosByExamNumber(String examNumber) {
		StudentDao dao = new StudentDao();
		Student student = null;
		try {
			student = dao.getStudentInfoByExamNumber(examNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	//更新学生信息
	public void updateStudentInfo(Student student) {
		StudentDao dao = new StudentDao();
		try {
			dao.update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
