package com.sttest.service;

import java.sql.SQLException;

import com.sttest.beans.Student;
import com.sttest.beans.Teacher;
import com.sttest.dao.StudentDao;
import com.sttest.dao.TeacherDao;

public class TeacherService {

	// 检测用户名是否已经存在
	public boolean checkUserName(String userName) {
		TeacherDao dao = new TeacherDao();
		try {
			return dao.checkUserName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 用于注册教师账号
	public boolean regist(Teacher teacher) {
		TeacherDao dao = new TeacherDao();
		try {
			return dao.regist(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 用于教师登录的功能
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

	// 用于获取教师所有信息的函数
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

	// 更新教师信息
	public void updateTeacherInfo(Teacher teacher) {
		TeacherDao dao = new TeacherDao();
		try {
			dao.update(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
