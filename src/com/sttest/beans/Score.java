package com.sttest.beans;

import java.util.Date;

public class Score {

	private int id; // 分数（并不赋值，让数据库该字段自增）

	private String StudentID; // 准考证号

	private String paperID; // 试卷编号

	private String uploadTime; // 提交时间

	private String score; // 分数

	public Score() {
		super();
	}

	public Score(String studentID, String paperID, String uploadTime, String score) {
		super();
		StudentID = studentID;
		this.paperID = paperID;
		this.uploadTime = uploadTime;
		this.score = score;
	}

	public Score(int id, String studentID, String paperID, String uploadTime, String score) {
		super();
		this.id = id;
		StudentID = studentID;
		this.paperID = paperID;
		this.uploadTime = uploadTime;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}

	

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", StudentID=" + StudentID + ", paperID=" + paperID + ", uploadTime=" + uploadTime
				+ ", score=" + score + "]";
	}
	
	

}
