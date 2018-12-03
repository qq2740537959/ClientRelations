<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../../layui/css/layui.css" />
		<script src="../../layui/layui.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../../js/jquery-1.8.3.min.js" ></script>
		<style>
			.div_total{
				width: 1000px;
				height: 610px;
				padding-left:0px;
				margin-top: 0px;
			}
			
			.layui-btn{
				background-color:rgb(31,147,231);
			}
			.layui-laypage .layui-laypage-curr .layui-laypage-em {
				background-color:rgb(31,147,231);
			}
		</style>
	</head>
	<body>
		<div class="div_total">
			<form method = "post" id = "addCon">
			<h3>合同管理 >> 合同创建</h3>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label>
				<div class = "layui-input-inline">
					<input type="text" size="67px;" name = "contractName" class = "contractName layui-input"/>				
				</div>
			</div>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<div style="float:left">
					<label>合同类型：</label>
					<div class = "layui-input-inline">
						<select class = "contractType layui-select" name = "contractType" >
							
						</select>
					</div>
				</div>
				<div style="float: left;margin-left: 176px;">
					<label>合同金额：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "contractMoney" class = "layui-input"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 27px;">
					<label>甲方：</label>
					<div class = "layui-input-inline"> 
						<input type = "text" name = "ownCompany" class = "layui-input"/>
					</div>
				</div>
				<div style="float: left;margin-left: 100px;">
					<label>乙方：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "otherCompany" class = "layui-input"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 43px;">
				<div style="float: left;">
					<label>企业经营许可证号：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "myselfLicence" class = "layui-input"/>
					</div>
				</div>
				<div style="float: left;margin-left:16px;">
					<label>企业经营许可证号：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "anotherLicence" class = "layui-input"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 62px;">
				<label class = "layui-form-label" style = "margin-top:75px;">合同内容：</label>
				<textarea style="width: 508px;height: 150px;margin-top: 20px;" name = "contractContent" class = "contractContent"></textarea>				
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 62px;">
				<label class = "layui-form-label" style = "margin-top:23px;">备注信息：</label>
				<textarea style="width: 508px;height: 50px;margin-top: 20px;" name = "remarks" class = "remarks"></textarea>
			</div>
			<div style="float: left;margin-top: 39px;width:200px ;height: 100px;margin-left: 325px;">
				<input type="button" value="保存"  id = "embrace" class = "layui-btn"/>
				
				<input type="button" value="返回"  id = "back" class = "layui-btn"/>
			</div>
			</form>
		</div>
		<script type = "text/javascript">
			function voice(){
				$.ajax({
					url:'../../../voiceAction',
					type:'post',
					success:function(data){
						console.log(data)
						$(".contractType").empty();
						var arr = "";
						for(var i = 0;i<data.length;i++){
							arr+="<option value = "+data[i].genreId+">"+data[i].genreName+"</option>";
						}
						$(".contractType").html(arr);
					},error:function(){
						alert("网络错误！");
					}
				})
			}
			voice();
			
			function addContract(){ 
				$("#embrace").on("click",function(){
					$.ajax({
						url:'../../../princeAction',
						type:'post',
						success:function(data){
							var contractName = $(".contractName").val();
							var index = 1;
							for(var i = 0;i<data.length;i++){
								if(data[i].contractName == contractName){
									index = 2;
								}
							}
							if (index == 1) {
									$.ajax({
										url:'../../../fortifyAction',
										type:'post',
										data:$("#addCon").serialize(),
										success:function(data){
											var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
											parent.layer.msg("创建成功！");
											parent.layer.close(index);
											parent.refershuaxin();
										},error:function(){
											alert("网络错误！");
										}
									})
							}else{
								alert("该合同名称已经存在！");
							}
						},error:function(){
							alert("网络错误！");
						}
					})
				})
			}
			addContract();
			
			function duack(){
				$("#back").on("click",function(){
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					parent.layer.msg("返回成功！");
					parent.layer.close(index);
					parent.refershuaxin();
				})
			}
			duack();
		</script>
	</body>
</html>

