package com.sttest.dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sttest.beans.Score;
import com.sttest.utils.DataSourceUtils;

public class ScoreDao {
	
	//��ӳɼ���¼
	public void addScore(Score score) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into score_table(studentID,paperID,uploadTime,score) values(?,?,?,?)";
		runner.update(sql, score.getStudentID(),
				score.getPaperID(),
				score.getUploadTime(),
				score.getScore());	
	}
	
	//����׼��֤�Ż�ȡ���гɼ���¼
	public List<Score> getScoreRecordBySid(String id) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from score_table where studentID="+id;
		return runner.query(sql, new BeanListHandler<Score>(Score.class));
	}
	
	public static void main(String[] args) {
		ScoreDao dao= new ScoreDao();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(date);
		ArrayList<Score> scores = null;
		try {
			scores = (ArrayList<Score>) dao.getScoreRecordBySid("123");
			System.out.println("��ӳɹ�");
			System.out.println(scores);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
