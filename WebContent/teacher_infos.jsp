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
	height: 100px;
	font-family: "楷体";
	font-size: 50px;
	background-color: blueviolet;
	text-align: center;
}

.footer {
	display: inline-block;
}

#edit-btn {
	margin-left: "80px";
	height: 80px;
	margin-top: 20px;
	text-align: center;
}

.body {
	text-align: center;
	background-color: #C4E3F3;
}
</style>
</head>
<%
	currentUser = (Teacher) session.getAttribute("user");
	if (currentUser.getUserName() != null) {
		request.setAttribute("userName", currentUser.getUserName());
	}
	if (currentUser.getName() != null) {
		request.setAttribute("name", currentUser.getName());
	}
	if (currentUser.getDept() != null) {
		request.setAttribute("dept", currentUser.getDept());
	}
	if (currentUser.getGender() != null) {
		request.setAttribute("gender", currentUser.getGender().equals("male") ? "男" : "女");
	}
	if (currentUser.getPhone() != null) {
		request.setAttribute("phone", currentUser.getPhone());
	}

	pageContext.setAttribute("APP_PATH", request.getContextPath());//获取接受请求的路径地址，即服务器的根目录
%>
<body>
	<!-- 修改信息模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="teacherUpdateModel" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel2">更新信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="form-update-static"
									name="userName">${userName}</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name"
									id="name_update_input" placeholder="name" value="${name}">
								<span class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">院系</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name"
									id="dept_update_input" placeholder="name" value="${dept}">
								<span class="help-block"></span>
							</div>
						</div>



						<div class="form-group">
							<label class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">

								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1_update_input" value="male"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2_update_input" value="female">
									女
								</label>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-2 control-label">联系方式</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="phone"
									id="phone_update_input" placeholder="phone" value="${phone}">
								<span class="help-block"></span>
							</div>
						</div>



					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="btn_update_teacher">更新</button>
				</div>
			</div>
		</div>
	</div>
	<!-- ********************************************** -->

	<div class="layout">
		<div class="head">
			<label>个人信息</label>
		</div>
		<div id="edit-btn">
			<button id="edit-btn-real" class="btn btn-primary">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
			</button>
		</div>
		<div class="body">
			<hr>
			<label>用户名：</label><label>${userName}</label>
			<hr>
			<label> 姓名：</label><label id="name-l">${name}</label>
			<hr>
			<label> 院系 ：</label><label id="dept_l">${dept}</label>
			<hr>
			<label> 性别：</label><label id="gender_l">${gender}</label>
			<hr>
			<label>联系方式：</label><label id="phone_l">${phone}</label>
			<hr>
		</div>
	</div>
</body>

<script type="text/javascript">
	if ("${gender}" == "男") {
		$('#gender1_update_input').prop('checked', 'checked');
	} else {
		$('#gender2_update_input').prop('checked', 'checked');
	}

	//给编辑按钮添加点击事件
	$('#edit-btn-real').on('click', function() {
		$("#teacherUpdateModel").modal({
			backdrop : "static"
		});
	});

	//给模态框绑定事件
	$('#btn_update_teacher').click(
			function() {
				//1.获取数据
				var name = $('#name_update_input').val();
				alert(name);
				var phone = $('#phone_update_input').val();
				alert(phone);
				var dept = $('#dept_update_input').val();
				alert(dept);
				var gender = $("input[name='gender']:checked").val();
				alert(gender);
				//2.发送ajax请求更新数据
				$.ajax({
					url : "${APP_PATH}/UpdateTeacherInfoServlet",
					type : "POST",
					data : "userName=${userName}" + "&name=" + name + "&phone="
							+ phone + "&dept=" + dept + "&gender=" + gender,
					success : function(result) {
						console.log(result);
						//关闭模态框
						$("#teacherUpdateModel").modal("hide");
						alert("更新成功！");
						//回到本页面
						//to_page(currentPage);
						$('#name_l').html(name);
						$('#phone_l').html(phone);
						$('#dept_l').html(dept);
						$('#gender_l').html(gender == "male" ? "男" : "女");
					}
				});
			});
</script>

</html>