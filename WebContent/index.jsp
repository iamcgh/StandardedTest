<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<!-- 最新版本的 Bootstrap 核心 CSS 和JavaScript文件 -->
		<!--引入jQuery-->
		<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<style>
		
			.layout {
				margin: auto;
				position: absolute;
				top: 0;
				right: 0;
				left: 0;
				bottom: 0;
				border: solid blue 5px;
				border-radius: 10px;
				width: 400px;
				height: 600px;
			}
			
			.head {
				height: 200px;
				font-family: "楷体";
				font-size: 50px;
				background-color: blueviolet;
			}
			
			.body {
				height: 300px;
				background-color: #D9EDF7;
			}
			
			.foot {
				height: 90px;
				background-color: #D9EDF7;
			}
			
			.layout-head {
				text-align: center;
				color: #E3E3E3;
			}
			
			.input-group {
				height: 40px;
				border-radius: 8px;
				width: 280px;
			}
			
			#student-input {
				background-color: #D9EDF7;
				display: block;
			}
			
			#teacher-input {
				background-color: #D9EDF7;
				display: none;
			}
			
			#regist_btn{
				margin-left:50px;
				margin-right:50px;
			}
			
			#type{
				margin-left:50px;
				margin-bottom: 10px;
				margin-right: 20px;
			}
		</style>
	</head>

	<body>
		<div class="layout">
			<div class="head">
				<div class="layout-head">
					<label style="margin-top: 50px;">标准化考试系统</label>
				</div>
			</div>
			<form action="Login" method="post">
				<div class="body">
					<div id="student-input">
						
						<label>准考证号：</label><input class="input-group" type="text" name="number" placeholder="请输入准考证号" /><hr>
						<label>姓       名：</label><input class="input-group" type="text" name="name" placeholder="请输入姓名" /><hr>
						<label>密       码：</label><input class="input-group" type="password" name="password" placeholder="请输入密码" /><hr>
					</div>
					<div id="teacher-input">
						<label>用户名：</label><input class="input-group" type="text" name="userName" placeholder="请输入用户名"/><br>
						<label>密码：</label><input class="input-group" type="password" name="teacher_password" placeholder="请输入密码"/><br>
					</div>
				</div>
				<div class="foot">
					<div id="other-choice">
						<div>
							<select id="type" name="type">
								<option value="student" selected="selected">学生登录</option>
								<option value="teacher">教师登录</option>
							</select>

							<a href="find_psw.jsp">
								<span>忘记密码？找回密码</span>
							</a>
						</div>
						<div>
							<button id="regist_btn" type="button" class="btn btn-success">注册</button>
							<input id="log_in" type="submit" class="btn btn-primary" value="登录" />
						</div>
					</div>
				</div>
			</form>

		</div>
	</body>
	<script>
		$('#type').change(function() {
			var node = $(this).children('option:selected').val();
			if(node == 'student') {
				$('#student-input').show();
				$('#teacher-input').hide();
			} else {
				$('#teacher-input').show();
				$('#student-input').hide();
			}
		});
		//为注册按钮绑定事件
		$('#regist_btn').on('click',function(){
			var node = $('#type').children('option:selected').val();
			if(node == 'student') {
				window.location.href="regist_student.jsp";
			} else {
				window.location.href="regist_teacher.jsp";
			}
		});
	</script>

</html>