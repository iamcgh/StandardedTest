package com.sttest.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sttest.beans.TestPaper;
import com.sttest.dao.TestPaperDao;

public class TestPaperService {
	// 存储试卷信息到数据库中
	public void saveFileInfo(TestPaper paper) {
		TestPaperDao dao = new TestPaperDao();
		try {
			dao.addPaperInfo(paper);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 获取所有试卷的名字
	public List<String> getAllTestPaperName() {
		TestPaperDao dao = new TestPaperDao();
		List<TestPaper> lists = null;
		List<String> res = new ArrayList<>();
		try {
			lists = dao.getAllPaperInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (lists != null) {
			for (TestPaper paper : lists) {
				String fileName = paper.getPaperName();
				res.add(fileName);
			}
		}
		return res;
	}

	// 获取所有试卷的编号
	public List<String> getAllTestPaperID() {
		TestPaperDao dao = new TestPaperDao();
		List<TestPaper> lists = null;
		List<String> res = new ArrayList<>();
		try {
			lists = dao.getAllPaperInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (lists != null) {
			for (TestPaper paper : lists) {
				String fileID = paper.getId();
				res.add(fileID);
			}
		}
		return res;
	}
	
	//获取试卷
	public TestPaper getTestPaperByID(String id) {
		TestPaperDao dao = new TestPaperDao();
		TestPaper paper = new TestPaper();
		try {
			paper = dao.getTestPaperInfosByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paper;
	}
}
