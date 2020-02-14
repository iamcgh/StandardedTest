package com.sttest.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sttest.beans.Student;
import com.sttest.beans.Teacher;
import com.sttest.utils.DataSourceUtils;

public class TeacherDao {
	
	//检测教师用户名是否可用
	public boolean checkUserName(String userName) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select userName from teacher_table where userName='"+userName+"'";
		System.out.println(sql);
		return runner.query(sql, new BeanHandler<String>(String.class)) == null? true:false;
	}
	
	
	//根据用户名获取教师信息
	public Teacher getTeacherInfosByUserName(String userName) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from teacher_table where userName='"+userName+"'";
		return runner.query(sql, new BeanHandler<Teacher>(Teacher.class));
	}
	
	//注册教师信息
	public boolean regist(Teacher teacher) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into teacher_table values(?,?,?,?,?,?)";
		int query = runner.update(sql, teacher.getUserName(),
										teacher.getPassword(),
										teacher.getName(),
										teacher.getDept(),
										teacher.getGender(),
										teacher.getPhone());
		if(query > 0)
			return true;
		else
			return false;
	}
	
	//更新教师信息
	public boolean update(Teacher teacher) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update teacher_table set name=?,phone=?,dept=?,gender=? where userName=?";
		Object[] params = {teacher.getName(),teacher.getPhone(),teacher.getDept(),teacher.getGender(),teacher.getUserName()};
		runner.update(sql, params);
		return true;
	}
	
	/*public static void main(String[] args) {
		//Teacher teacher = new Teacher("userName", "12345", "王五", "计算机系", "男", "123456");
		TeacherDao dao = new TeacherDao();
		try {
			//System.out.println(dao.getTeacherInfosByUserName("userName"));
			System.out.println(dao.checkUserName("1234"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
