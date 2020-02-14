package com.sttest.service;

import java.sql.SQLException;
import java.util.List;

import com.sttest.beans.Score;
import com.sttest.dao.ScoreDao;

public class ScoreService {
	
	//添加分数信息
	public void addScore(Score score) {
		ScoreDao dao = new ScoreDao();
		try {
			dao.addScore(score);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//根据准考证号获取所有成绩信息
	public List<Score> getScoreInfoByID(String id) {
		ScoreDao dao = new ScoreDao();
		try {
			return dao.getScoreRecordBySid(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
