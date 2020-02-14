package com.sttest.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sttest.beans.Student;
import com.sttest.utils.DataSourceUtils;

public class StudentDao {

	// 检测教师用户名是否可用
	public boolean checkUserName(String examNumber) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select examNumber from student_table where examNumber=" + examNumber;
		return runner.query(sql, new BeanHandler<String>(String.class)) == null ? true : false;
	}

	// 获取所有学生信息
	public List<Student> getAllStudents() throws SQLException {
		// List<Student> res = new ArrayList<>();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student_table";
		return runner.query(sql, new BeanListHandler<Student>(Student.class));
	}

	// 根据用户名获取学生信息
	public Student getStudentInfoByExamNumber(String examNumber) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student_table where examNumber=" + examNumber;
		return runner.query(sql, new BeanHandler<Student>(Student.class));
	}

	// 新建学生信息
	public boolean regist(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into student_table values(?,?,?,?,?)";
		int query = runner.update(sql, student.getExamNumber(), student.getName(), student.getPassword(),
				student.getPhone(), student.getGender());
		if (query > 0)
			return true;
		else
			return false;

	}

	//UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing' WHERE LastName = 'Wilson'
	// 更新学生信息
	public boolean update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update student_table set name=?,phone=?,gender=? where examNumber=?";
		Object[] params = {student.getName(),student.getPhone(),student.getGender(),student.getExamNumber()};
		runner.update(sql, params);
		return true;
	}

	// test

	/*public static void main(String[] args) {
		Student student = new Student("1234", "张思", "123456", "3236578", "男");
		StudentDao dao = new StudentDao();
		Student student1 = null;
		ArrayList<Student> lists = null;
		try {
//			dao.regist(student);
//			student1 = dao.getStudentInfoByExamNumber("123");
//			lists = (ArrayList<Student>) dao.getAllStudents();
			dao.update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(student1);
		//System.out.println(lists);
	}*/

}
