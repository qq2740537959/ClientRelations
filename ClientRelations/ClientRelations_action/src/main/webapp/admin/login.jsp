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
    <style>
    	.title{
     background-image: -webkit-linear-gradient(left, #147B96, #FDB90B 25%, #147B96 50%, #FDB90B 75%, #147B96);
     -webkit-text-fill-color: transparent;
     -webkit-background-clip: text;
     -webkit-background-size: 200% 100%;
     -webkit-animation: masked-animation 3s infinite linear;
}

.title2{
     background-image: -webkit-linear-gradient(right, #FDB90B, #147B96 25%, #FDB90B 50%, #147B96 75%, #FDB90B);
     -webkit-text-fill-color: transparent;
     -webkit-background-clip: text;
     -webkit-background-size: 200% 100%;
     -webkit-animation: masked-animation 3s infinite linear;
}

 @-webkit-keyframes masked-animation {
         0%{ background-position: 0 0;}
         100% { background-position: -100% 0;}
    }
    	
    </style>
</head>
<body class="login-wrap">
    <div class="login-container" >
        <form class="login-form" >
        	<p>
        		<img src="<%=request.getContextPath() %>/admin/assets/images/logo.png" style="width:70px;">
        		<font class="title title2" style="color: #29adeb;font-size: 17px;">ORM客户管理系统</font>
        	</p>
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