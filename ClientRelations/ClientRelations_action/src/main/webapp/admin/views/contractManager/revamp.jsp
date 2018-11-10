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
				padding-left: 100px;
				margin-top: 50px;
			}
		</style>
	</head>
	<body>
		<div class="div_total">
			<h3>合同管理 >> 合同修改</h3>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label><input type="text" size="100px;"/>				
			</div>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<div style="float:left">
					<label>合同类型：</label>
					<select>
						<option>类型</option>	
					</select>
				</div>
				<div style="float: left;margin-left: 428px;">
					<label>合同金额：</label>
					<input type = "text" />
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 27px;">
					<label>甲方：</label>
					<input type = "text">
				</div>
				<div style="float: left;margin-left: 334px;">
					<label>乙方：</label>
					<input type = "text">
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 43px;">
				<div style="float: left;">
					<label>企业经营许可证号：</label>
					<input type = "text">
				</div>
				<div style="float: left;margin-left:250px;">
					<label>企业经营许可证号：</label>
					<input type = "text">
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>合同内容：</label>
				<div style="width: 800px;height: 150px;border: 1px solid;margin-top: 20px;">
					
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>备注信息：</label>
				<div style="width: 800px;height: 100px;border: 1px solid;margin-top: 20px;">
					
				</div>
			</div>
		</div>
	</body>
</html>