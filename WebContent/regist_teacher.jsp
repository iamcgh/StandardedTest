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
<style>
body {
	text-align: center;
	background-color: #C4E3F3;
}
</style>
</head>
<body>
	<h1>这是教师注册页面</h1>
	<form action="RegistTeacherServlet" method="post">
		<div>
			<label>用户名：</label><input type="text" name="userName" />
		</div>
		<div>
			<label>密码：</label><input type="password" name="password" />
		</div>
		<div>
			<label>确认密码：</label><input type="password" name="re_password" />
		</div>
		<div>
			<label>姓名：</label><input type="text" name="name" />
		</div>
		<div>
			<label>院系：</label><input type="text" name="dept" />
		</div>
		<div>
			<label>性别：</label><input type="radio" name="gender" value="male" />男
			<input type="radio" name="gender" value="female" />女
		</div>
		<div>
			<label>电话：</label><input type="text" name="phone" />
		</div>

		<div>
			<input id="back" type="button" value="返回" /> <input type="submit"
				value="注册" />
		</div>
	</form>
</body>
<script type="text/javascript">
	$('#back').click(function() {
		window.location.href = "index.jsp";
	});
</script>
</html>