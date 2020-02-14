package com.sttest.service;

import java.sql.SQLException;

import com.sttest.beans.Student;
import com.sttest.beans.Teacher;
import com.sttest.dao.StudentDao;
import com.sttest.dao.TeacherDao;

public class TeacherService {

	// ����û����Ƿ��Ѿ�����
	public boolean checkUserName(String userName) {
		TeacherDao dao = new TeacherDao();
		try {
			return dao.checkUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// ����ע���ʦ�˺�
	public boolean regist(Teacher teacher) {
		TeacherDao dao = new TeacherDao();
		try {
			return dao.regist(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// ���ڽ�ʦ��¼�Ĺ���
	public boolean login(String userName, String password) {
		TeacherDao dao = new TeacherDao();
		Teacher findTeacher = null;
		try {
			findTeacher = dao.getTeacherInfosByUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (findTeacher != null) {
			if (findTeacher.getUserName().equals(userName) && findTeacher.getPassword().equals(password))
				return true;
			else
				return false;
		}
		return false;

	}

	// ���ڻ�ȡ��ʦ������Ϣ�ĺ���
	public Teacher getTeacherInfosByUserName(String userName) {
		TeacherDao dao = new TeacherDao();
		Teacher teacher = null;
		try {
			teacher = dao.getTeacherInfosByUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	// ���½�ʦ��Ϣ
	public void updateTeacherInfo(Teacher teacher) {
		TeacherDao dao = new TeacherDao();
		try {
			dao.update(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
