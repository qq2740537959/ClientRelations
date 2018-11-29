<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML >
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/css/layui.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/css/login.css">
    <link rel="icon" href="<%=request.getContextPath() %>/bitbug_favicon.ico">
    <script type="text/javascript" src="<%=request.getContextPath() %>/admin/js/jquery-1.8.3.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/admin/layer/layer.js"></script>
    <title>客户关系管理系统-登录</title>
</head>
<body class="login-wrap">
    <div class="login-container" >
        <form class="login-form" >
        	<p><font style="color: #29adeb;font-size: 17px;">后台管理系统登录</font></p>
            <div class="input-group">
                <input type="text" id="username" name="userName" class="input-field">
                <label for="username" class="input-label">
                    <span class="label-title">用户名</span>
                </label>
            </div>
            <div class="input-group">
                <input type="password" id="password" name="password" class="input-field">
                <label for="password" class="input-label">
                    <span class="label-title">密码</span>
                </label>
            </div>
            <button type="button" class="login-button">登录<i class="ai ai-enter"></i></button>
        </form>
    </div>
</body>
<script src="<%=request.getContextPath() %>/admin/assets/layui.js"></script>
<script src="<%=request.getContextPath() %>/admin/login.js" ></script>

</html>