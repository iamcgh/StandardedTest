<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<!--引入jQuery-->
		<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
		<!-- 最新版本的 Bootstrap 核心 CSS 和JavaScript文件 -->
		<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<!--
        	作者：offline
        	时间：2019-04-22
        	描述：自己定义的CSS样式
        -->
		<style type="text/css">
			.tips {
				color: red;
			}
		</style>
	</head>

	<body>

		<div id="look_paper" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title"></h4>
					</div>
					<div id="modal-body" class="modal-body">
						txt
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">确定</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		这是上传试卷页面
		<div clas="row">
			<div class="col-md-4 col-md-offset-4">
				<form action="UploadServlet" enctype="multipart/form-data" method="post" onsubmit="return check()">
					<div class="form-group">
						<label for="exampleInputFile">上传试卷文件(*.txt)</label>
						<input type="file" id="exampleInputFile" name="uploadFile" onchange="getFileContent(this.files)">
						<p class="help-block tips">注意点：<br>
							<ul class="tips">
								<li>
									上传的文件必须是txt文件
								</li>
								<li>
									每一题的选项必须以;结尾
								</li>
								<li>
									每一题的结束必须以*****结尾
								</li>
								<li>
									文件的答案必须以%%划分
								</li>
								<li>
									文件中答案与试题必须以$$$$$划分
								</li>
								<li>
									文件中问题与选项必须以$划分
								</li>
								
							</ul>
						</p>
					</div>
					<button id="hasLook" type="button" class="btn btn-primary">
						<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
						预览</button>
					<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
						提交</button>
				</form>
			</div>
		</div>

	</body>

	<script>
		//是否已经预览
		var hasLook = false;

		function check() {
			if(document.getElementById("exampleInputFile").value == "") {
				alert("你没有选择文件");
				return false;
			} else {
				if(hasLook == false) {
					alert("你还没有预览，建议最好预览下再上传哦~");
				} else {
					return true;
				}
				return false;
			}

		}

		//为预览键绑定监听事件
		$('#hasLook').click(function() {
			hasLook = true;
			if(document.getElementById("exampleInputFile").value == "") {

			} else {
				$("#look_paper").modal({
					backdrop: "static"
				});
			}

		});

		
		function getFileContent(files) {
			if(files) {
				var file = files[0];
				$('.modal-title').empty();
				$('.modal-title').append(file.name);
				var reader = new FileReader();
				if(/text+/.test(file.type)) {
					//如果是文本文件
					reader.onload = function() {
						$('.modal-body').empty();
						var ans_pro = new Array(); //定义一个数组存储答案和问题文本及选择
						ans_pro = this.result.split("$$$$$");
						//alert(ans_pro)
						//定义一个存储答案的数组
						var ans_arr = new Array();
						if(ans_pro[0])
							ans_arr = ans_pro[0].split("%%");
						//alert(ans_arr);
						//定义一个存储问题(包括选择)的数组(pro[0]存储问题,pro[1]存储选择)
						var pro = new Array();
						if(ans_pro[1])
							pro = ans_pro[1].split("*****");
						//alert(pro);
						var str = "";
						//$('.modal-body').append("<form></form>").addClass("form-horizontal");
						for(var i = 0; i < ans_arr.length - 1; i++) {
							//$('.form-horizontal').append("<div></div>").addClass("form-group");
							var pro_content = new Array(); //问题跟选项（0,1）
							if(pro[i + 1])
								pro_content = pro[i + 1].split("$"); //此时pro_content[0]是问题
							//alert(pro_content[0]); //test
							var pro_choice = new Array(); //选项
							if(pro_content[1])
								pro_choice = pro_content[1].split(";");
							//alert(pro_choice);
							//问题
							var pro_content_str = pro_content[0];
							//问题答案
							var pro_ans_str = ans_arr[i];
							str += "<label>"+pro_content_str + "</label>";
							for(var j = 0;j < pro_choice.length-1;j++) {
								str +="<br>" + "<input type='radio'>" + pro_choice[j] +"<br>";
							}
							str += "<br><br>";
							
						}
						$('#modal-body').append(str);

					}
					reader.readAsText(file, "UTF-8");
				}
			}
		}
	</script>

</html>