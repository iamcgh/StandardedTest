package com.sttest.service;

import java.sql.SQLException;

import com.sttest.beans.Student;
import com.sttest.dao.StudentDao;
import com.sttest.dao.TeacherDao;

public class StudentService {
	
	//���׼��֤���Ƿ����
	public boolean checkNumber(String examNumber) {
		StudentDao dao = new StudentDao();
		try {
			return dao.checkUserName(examNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//ע�Ṧ��
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
	
	//���ڵ�¼�ĺ���
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
	
	//��ȡѧ����Ϣ
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
	
	//����ѧ����Ϣ
	public void updateStudentInfo(Student student) {
		StudentDao dao = new StudentDao();
		try {
			dao.update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
