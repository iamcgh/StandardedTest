package com.sttest.service;

import java.sql.SQLException;
import java.util.List;

import com.sttest.beans.Score;
import com.sttest.dao.ScoreDao;

public class ScoreService {
	
	//��ӷ�����Ϣ
	public void addScore(Score score) {
		ScoreDao dao = new ScoreDao();
		try {
			dao.addScore(score);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//����׼��֤�Ż�ȡ���гɼ���Ϣ
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
