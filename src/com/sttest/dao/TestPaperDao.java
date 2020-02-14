package com.sttest.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sttest.beans.Student;
import com.sttest.beans.TestPaper;
import com.sttest.utils.DataSourceUtils;

public class TestPaperDao {
	
	//获取所有试卷信息
	public List<TestPaper> getAllPaperInfo() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from test_paper_table";
		return runner.query(sql, new BeanListHandler<TestPaper>(TestPaper.class));
	}
	
	//根据试卷编号获取试卷信息
	public TestPaper getTestPaperInfosByID(String id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from test_paper_table where id="+id;
		//Object[] params= {id};
		return runner.query(sql, new BeanHandler<TestPaper>(TestPaper.class));
	}
	
	//根据试卷编号删除试卷信息
	public boolean deletePaperInfosByID(String id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from test_paper_table where id='"+id+"'";
		return runner.update(sql)>0;
	}
	
	//上传试卷信息
	public boolean addPaperInfo(TestPaper paper) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into test_paper_table values(?,?,?,?,?)";
		int query = runner.update(sql, paper.getId(),
										paper.getPaperName(),
										paper.getPaperType(),
										paper.getUpLoadTime(),
										paper.getProvider());
		return query > 0;
	}
	
	/*public static void main(String[] args) {
		//Date date = new Date();
		//DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String dateStr = format.format(date);
		//Timestamp stamp = new Timestamp(date);
		//TestPaper paper = new TestPaper("123", "试卷1", "java", dateStr, "李四");
		TestPaper paper = null;
		TestPaperDao dao = new TestPaperDao();
		try {
			dao.deletePaperInfosByID("123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(paper);
	}*/
	
	public static void main(String[] args) {
		String id = "'6c07574e-4e83-4d'";
		TestPaperDao dao = new TestPaperDao();
		try {
			System.out.println(dao.getTestPaperInfosByID(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
