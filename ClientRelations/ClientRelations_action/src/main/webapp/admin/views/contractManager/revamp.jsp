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
		</style>
	</head>
	<body>
		<div class="div_total">
			<form method = "post" id = "addCon">
			<h3>合同管理 >> 合同创建</h3>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label><input type="text" size="67px;" name = "contractName"/>				
			</div>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<div style="float:left">
					<label>合同类型：</label>
					<select class = "contractType" name = "contractType">
						
					</select>
				</div>
				<div style="float: left;margin-left: 171px;">
					<label>合同金额：</label>
					<input type = "text" name = "contractMoney"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 27px;">
					<label>甲方：</label>
					<input type = "text" name = "ownCompany"/>
				</div>
				<div style="float: left;margin-left: 105px;">
					<label>乙方：</label>
					<input type = "text" name = "otherCompany"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 43px;">
				<div style="float: left;">
					<label>企业经营许可证号：</label>
					<input type = "text" name = "myselfLicence"/>
				</div>
				<div style="float: left;margin-left:21px;">
					<label>企业经营许可证号：</label>
					<input type = "text" name = "anotherLicence"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>合同内容：</label>
				<input style="width: 499px;height: 150px;border: 1px solid;margin-top: 20px;" name = "contractContent"/>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>备注信息：</label>
				<input style="width: 499px;height: 100px;border: 1px solid;margin-top: 20px;" name = "remarks"/>
			</div>
			<div style="float: left;margin-top: 39px;width:200px ;height: 100px;margin-left: 325px;">
				<input type="button" value="保存" style = "width:80px; height:30px;" id = "embrace"/>
				
				<a href="" style="display: block; width: 58px;height: 23px;border: 1px solid;padding-top: 5px;padding-left: 20px;float: right;">返回</a>
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
						url:'../../../fortifyAction',
						type:'post',
						data:$("#addCon").serialize(),
						success:function(data){
							alert("创建成功！");
						},error:function(){
							alert("网络错误！");
						}
					})
				})
			}
			addContract();
		</script>
	</body>
</html>

