<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 最新版本的 Bootstrap 核心 CSS 和JavaScript文件 -->
<!--引入jQuery-->
<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style type="text/css">
body{
	background-color: #C4E3F3;
}
h1{
	text-align: center;
	background-color: #C4E3F3;
}
#right_part {
	border-raius: 5px;
	border: solid black 5px;
	padding: 50px;
}

#left_part {
	border-raius: 5px;
	border: solid black 5px;
	height: 100px;
	padding: 20px;
}

#selector {
	margin:10px;
}

#start {
	margin: 20px;
}

#pro-div {
	display: none;
}

#foot-div {
	display: none;
	padding:50px;
}

#right_part{
	display:none;
}
</style>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());//获取接受请求的路径地址，即服务器的根目录
%>
</head>
<body>
	<h1>请选择试题</h1>
	<div class="container">
		<div class="row">
		<div>
			<div id="left_part" class="col-md-12">
				<select id="selector">
				</select>
				<button id="start" class="btn btn-primary">
					确定 <span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
				</button>
			</div>
			<div id="right_part" class="col-md-12">
				<form id="form" action="PostAnsServlet" method="post">
					<div id="pro-div"></div>
					<div id="foot-div">
						<input type="reset" id="rest-btn" class="btn btn-warnning"
							value="重置"> <input type="submit" id="submit-btn"
							class="btn btn-primary" value="提交">
					</div>
				</form>
			</div>
		</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	getPaperPath();
	function getPaperPath() {
		$.ajax({
			url : "${APP_PATH}/TestPaperID",
			type : "get",
			success : function(result) {
				//alert(result);
				$.each(result, function(i, item) {
					$('#selector').append(
							"<option value='"+item+"'>" + item + "</option>");
				});
			}
		});
	}

	//为开始考试按钮绑定监听事件
	$('#start').on('click',function() {
					var fileID = $('#selector').val();
					//alert(fileID);
					alert("开始考试！");

					$.ajax({
							url : "${APP_PATH}/GetProblemServlet?"+"fileID='" + fileID + "'",
							//data : {"fileID":fileID},
							type : "get",
							success : function(result) {
							//alert(result);
								var parsedJson = $.parseJSON(result);
								var ele = $('#pro-div');
								var str = "";
								ele.empty();
								for (var i = 0; i < parsedJson.length; i++) {
									str += "<div><label>" + (i + 1)+ ".";
									str += parsedJson[i].context;
									str += "</label>";
									$.each(parsedJson[i].choice,function(j) {
										//alert(parsedJson[i].choice[j]);
											str += "<p><input type='radio' id='"+j+"' value='"+j+"' name='"+(i+1)+"' />"
													+ parsedJson[i].choice[j]
													+ "<br/>";
									});
									str += "</div>"
											//alert(parsedJson[i].ans);
											//alert(parsedJson[i].context);
											//alert(parsedJson[i].choice);
								}
								ele.append(str);
								$('#pro-div').show();
								$('#foot-div').show();
								$('#right_part').show();
								//ele.append("<input type='submit' id='submit-btn' class='btn btn-primary'>");
							}
					});
			});
</script>
</html>