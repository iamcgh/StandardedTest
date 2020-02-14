<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.sttest.beans.*"%>
<%@ page import="com.sttest.utils.*"%>
<jsp:useBean id="currentUser" class="com.sttest.beans.Teacher"
	scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<!-- 最新版本的 Bootstrap 核心 CSS 和JavaScript文件 -->
<!--引入jQuery-->
<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<style>
</style>
<%
	Teacher teacher = (Teacher)session.getAttribute("user");
	//currentUser = (Teacher) session.getAttribute("teacher");
	String genderStr = null;
	if(teacher.getGender() != null){
		genderStr = teacher.getGender().equals("male")? "先生":"女士";
	} else {
		genderStr = "";
	}
	pageContext.setAttribute("APP_PATH", request.getContextPath());//获取接受请求的路径地址，即服务器的根目录
%>
</head>

<body>
	<div class="page-header">
		<h1>
			欢迎使用标准化考试系统 <small><%=teacher.getName() + genderStr %> </small>
		</h1>
	</div>
	<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a id="default" class="navbar-brand active" href="default.jsp"
						target="pageContent">首页</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav" id="choice">
						<!-- <li><a href="test.jsp" target="pageContent">进入考试 <span
								class="sr-only">(current)</span></a></li> -->
						<li><a href="fileUpLoad.jsp" target="pageContent">上传试题</a></li>
						<li><a href="teacher_infos.jsp" target="pageContent">个人信息</a></li>
						<!--<li><a href="" target="pageContent">成绩管理</a></li>-->
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="${APP_PATH }/LogOutServlet">退出登录</a></li>

					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
	<iframe id="mainiframe" name="pageContent" width="100%" height="600"
		frameborder="0" scrolling="auto"></iframe>
</body>

</html>
<script>
	function changeFrameHeight() {
		var ifm = document.getElementById("mainiframe");
		ifm.height = document.documentElement.clientHeight - 56;
	}
	window.onresize = function() {
		changeFrameHeight();
	}
	$(function() {
		changeFrameHeight();
	});
	//控制高亮提示切换
	$(function() {
		$("#choice li").click(function() {
			$(this).siblings('li').removeClass('active'); // 删除其他兄弟元素的样式
			$(this).addClass('active'); // 添加当前元素的样式
		});
	});
	//给首页链接绑定监听事件
	/*$("#default").click(function(){
		$("#choice li").each({
			$(this).removeClass('active');
		});
	});*/
</script>