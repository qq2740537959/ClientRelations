<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h3>合同管理 >> 合同执行</h3>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label><input type="text" size="67px;"/>				
			</div>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<div style="float:left">
					<label>合同金额：</label>
					<input type="text"  style="width: 75px;"/>
				</div>
				<div style="float: left;margin-left: 171px;">
					<label>合同类型：</label>
					<input type = "text" />
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 11px;">
					<label>客户方：</label>
					<input type = "text">
				</div>
				<div style="float: left;margin-left: 78px;">
					<label>合同状态：</label>
					<input type = "text">
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 110px;">
				<div style="float: left;">
					<label>创建人：</label>
					<input type = "text">
				</div>
				<div style="float: left;margin-left:79px;">
					<label>创建时间：</label>
					<input type = "text">
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 94px;">
				<div style="float: left;">
					<label>待处理人：</label>
					<input type = "text">
				</div>
				<div style="float: left;margin-left:53px;">
					<label>经营许可证号：</label>
					<input type = "text">
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>合同内容：</label>
				<input style="width: 499px;height: 150px;border: 1px solid;margin-top: 20px;" />
					
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>执行备注：</label>
				<input style="width: 499px;height: 100px;border: 1px solid;margin-top: 20px;">
					
				</input>
			</div>
			<div style="float: left;margin-top: 39px;width:200px ;height: 100px;margin-left: 325px;">
				<input type="submit" value="保存" style = "width:80px; height:30px;"/>
				
				<a href="" style="display: block; width: 58px;height: 23px;border: 1px solid;padding-top: 5px;padding-left: 20px;float: right;">返回</a>
			</div>
		</div>
	</body>
</html>