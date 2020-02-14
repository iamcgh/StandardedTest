package com.sttest.beans;

import java.util.Date;

public class Score {

	private int id; // ������������ֵ�������ݿ���ֶ�������

	private String StudentID; // ׼��֤��

	private String paperID; // �Ծ���

	private String uploadTime; // �ύʱ��

	private String score; // ����

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
