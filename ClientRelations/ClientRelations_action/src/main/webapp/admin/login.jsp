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
	<link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="icon" href="../bitbug_favicon.ico">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <title>花礼网管理后台-登录</title>
</head>
<body class="login-wrap">
	
    <div class="login-container" >
        <form class="login-form" >
        	<p><font style="color: #29adeb;font-size: 17px;">后台管理系统登录</font></p>
            <div class="input-group">
                <input type="text" id="username" name="account" class="input-field">
                <label for="username" class="input-label">
                    <span class="label-title">用户名</span>
                </label>
            </div>
            <div class="input-group">
                <input type="password" id="password" name="pwd" class="input-field">
                <label for="password" class="input-label">
                    <span class="label-title">密码</span>
                </label>
            </div>
            <button type="button" class="login-button">登录<i class="ai ai-enter"></i></button>
        </form>
    </div>
</body>
<script src="assets/layui.js"></script>
<script src="js/login.js" ></script>

</html>