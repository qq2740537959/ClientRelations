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
    <link rel="stylesheet" href="assets/css/admin.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
   <!--  <link rel="icon" href="../bitbug_favicon.ico"> -->
    <title>客户关系管理系统</title>
    <style type="text/css">
    	.exit-a:hover{
    		color: #fff!important;
    	}
    </style>
</head>
<body class="layui-layout-body">
	
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header custom-header">
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item slide-sidebar" lay-unselect>
                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
                </li>
            </ul>

            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                    	<img src="assets/images/ddr.jpg" class="layui-nav-img">
   						admin
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="exit">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>

        <div class="layui-side custom-admin">
            <div class="layui-side-scroll">

                <div class="custom-logo">
                    <img src="assets/images/logo.png" alt=""/>
                    <h1>LXIT_HUA</h1>
                </div>
                <ul id="Nav" class="layui-nav layui-nav-tree">
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe652;</i>
                            <em>系统设置</em>
                        </a>
                        <dl class="layui-nav-child">
                        	<dd><a href="">角色管理</a></dd>
                        	<dd><a href="views/organizationManager/organization.html">组织结构</a></dd>
                        	<dd><a href="">员工管理</a></dd>
                        	<dd><a href="">公告管理</a></dd>
                        	<dd><a href="">个人信息</a></dd>
                        	<dd><a href="">基础信息</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe652;</i>
                            <em>销售管理</em>
                        </a>
                        <dl class="layui-nav-child">
                        	<dd><a href="views/salesManager/salesPlan.html">销售计划</a></dd>
                        	<dd><a href="views/salesManager/salesForecast.html">销售预测</a></dd>
                        	<dd><a href="views/salesManager/salesPerformance.html">销售绩效</a></dd>
                        	<dd><a href="views/salesManager/chanceManager.html">机会管理</a></dd>
                        	<dd><a href="views/salesManager/contacts.html">联系人管理</a></dd>
                        	<dd><a href="views/salesManager/vieManager.html">竞争管理</a></dd>
                        	<dd><a href="">销售分析</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe770;</i>
                            <em>客户管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="views/clientManager/chanceManager.html">客户资源管理</a></dd>
                            <dd><a href="views/clientManager/developPlan.html">客户发展计划</a></dd>
                            <dd><a href="views/clientManager/worthManager.html">客户价值管理</a></dd>
                            <dd><a href="views/clientManager/satisfactionManager.html">客户满意度管理</a></dd>
                            <dd><a href="views/clientManager/creditManager.html">客户信誉管理</a></dd>
                            <dd><a href="views/clientManager/clientGreetings.html">客户关怀</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe6b2;</i>
                            <em>服务管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="views/serveManager/foundServe.html">服务创建</a></dd>
                            <dd><a href="views/serveManager/allocationServe.html">服务分配</a></dd>
                            <dd><a href="views/serveManager/disposeServe.html">服务处理</a></dd>
                            <dd><a href="views/serveManager/feedbackServe.html">服务反馈</a></dd>
                            <dd><a href="views/serveManager/pigeonholeServe.html">服务归档</a></dd>
                            <dd><a href="views/serveManager/issuesManage.html">常见问题处理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe6b2;</i>
                            <em>订单管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="views/orderManager/selectClient.jsp">代下订单</a></dd>
                            <dd><a href="views/orderManager/orderQuery.jsp">订单查询</a></dd>
                            <dd><a href="views/orderManager/orderStatistics.jsp">订单统计</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe770;</i>
                            <em>合同管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="views/contractManager/compact.jsp">合同创建</a></dd>
                            <dd><a href="">合同审核</a></dd>
                            <dd><a href="">合同管理</a></dd>
                        </dl>
                    </li>
                   <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe770;</i>
                            <em>统计分析</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="">客户构成统计</a></dd>
                            <dd><a href="">客户流失统计</a></dd>
                            <dd><a href="">客户贡献统计</a></dd>
                            <dd><a href="">客户服务统计</a></dd>
                        </dl>
                    </li>
                </ul>
                <ul style="margin-top: 10px;">
                	<li>
                        <a href="login.jsp" style="margin-left:18px;color: rgba(255,255,255,.7);padding-top: 5px;padding-bottom: 5px;" class="exit-a">
                            <i class="layui-icon" style="margin-right: 5px;">&#x1006;</i>
                           	 退出系统
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
             <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
                <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
                <div id="appTabPage" class="layui-tab-content"></div>
            </div>
        </div>
        <div class="mobile-mask"></div>
    </div>
    <script src="assets/layui.js"></script>
    <script src="index.js" data-main="home"></script>
    <script type="text/javascript">
    	$(".exit").click(function(){
    		$.ajax({
    			type:"post",
    			url:"../exitAdminAction",
    			success:function(t){
    				location.href="login.jsp";
    			}
    		})
    	})
    </script>
</body>
</html>