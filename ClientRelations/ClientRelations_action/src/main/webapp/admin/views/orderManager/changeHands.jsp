<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
		.successBut{
			display:block;
			width: 85px;
			height: 40px;
			border:0px;
			color: white;
			background-color: rgb(26,132,229);
			text-align: center;
			line-height: 40px;
			font-size: 16px;
		}	
		.successBut:hover{
			color: white;
		}	
		.layui-btn{
			background-color:rgb(31,147,231);
		}	
	</style>
</head>
<body><br><br><br><br><br><br><br><br><br>
	<div>
		<h1 style="margin-left: 460px;color: rgb(26,132,229);">订单交易成功</h1><br><br><br><br><br>
		<div>
			<a href="admin/views/orderManager/orderQuery.jsp" class="successBut" style="margin-left: 400px;">订单查询 </a>
			<a href="admin/views/orderManager/selectClient.jsp" class="successBut" style="margin-top: -40px;margin-left: 650px;">返回 </a>
		</div>
	</div>
</html>