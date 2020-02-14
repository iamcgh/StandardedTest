<%@page import="java.util.List"%>
<%@page import="com.sttest.beans.Score"%>
<%@page import="com.sttest.beans.Student"%>
<%@page import="com.sttest.dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标准化考试系统</title>
<!-- 最新版本的 Bootstrap 核心 CSS 和JavaScript文件 -->
<!--引入jQuery-->
<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<%
	Student student = (Student) session.getAttribute("user");
	ScoreDao dao = new ScoreDao();
	String id = student.getExamNumber();
	List<Score> scoreList = (List<Score>) dao.getScoreRecordBySid(id);
%>
</head>
<body>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<table class="table table-hover">
				<tr>
					<th>考试编号</th>
					<th>准考证号</th>
					<th>试卷编号</th>
					<th>姓名</th>
					<th>提交时间</th>
					<th>成绩</th>
				</tr>
				<%
					for (int i = 0; i < scoreList.size(); i++) {
						Score score = scoreList.get(i);
				%>
				<tr>
					<td><%=score.getId()%>></td>
					<td><%=score.getStudentID()%></td>
					<td><%=score.getPaperID()%></td>
					<td><%=student.getName()%></td>
					<td><%=score.getUploadTime()%></td>
					<td><%=score.getScore()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>