<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入jquery -->
<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
<title>标准化考试系统</title>
</head>
<body>
	<h1>注册</h1>
	<div>
		<div>
			<select id="type">
				<option value="student" selected="selected">学生注册</option>
				<option value="teacher">教师注册</option>
			</select>
		</div>
		<form id="form1" action="RegistServlet" method="post">
			用户名：<input id="username" type="text" name="username" /><br> 密码：<input
				id="password" type="password" name="password"><br>
			确认密码：<input id="check_password" type="password"><br> 学号：<input
				id="number" name="number" type="text"><br> 真实姓名：<input
				id="real_name" name="real_name" type="text"><br> 性别：<input
				id="gender" name="male" value="0" checked="checked" type="radio">男
			<input id="female" name="gender" value="1" type="radio">女<br>
			年龄：<input id="age" name="age" type="text"><br> 所在班级：<input
				id="class" name="classnumber" type="text"><br> 联系方式：<input
				id="phone" name="phone" type="text"><br> 爱好：<br> <input
				id="hobbies" name="hobbies" value="swimming" type="checkbox">游泳<br>
			<input id="hobbies1" name="hobbies" value="drawing" type="checkbox">画画<br>
			<input id="hobbies2" name="hobbies" value="running" type="checkbox">跑步<br>
			<input id="hobbies3" name="hobbies" value="game" type="checkbox">游戏<br>
			<input id="hobbies4" name="hobbies" value="singing" type="checkbox">唱歌<br>
			<br> <input id="reset" type="reset" value="重置"> <input
				id="submit" type="submit" value="注册">
		</form>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		//页面初始化
		var regist_type = $("#type").val();
		if (regist_type == "student") {
			console.log("student");
		} else if (regist_type == "teacher") {
			console.log("teacher");
		}
		//绑定控件的监听事件
		$("#type").change(function() {
			var regist_type = $("#type").val();
			if (regist_type == "student") {
				console.log("student");
			} else if (regist_type == "teacher") {
				console.log("teacher");
			}
		});
	});
	
	function init_student_form() {
		$("#form1").append("")
	}
</script>
</html>