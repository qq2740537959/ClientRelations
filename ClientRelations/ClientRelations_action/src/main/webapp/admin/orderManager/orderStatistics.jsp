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
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="../layui/css/layui.css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../layui/layui.js"></script>
		<style>
			div.layui-form.layui-border-box.layui-table-view{
				width: 850px;
			}
			.span_title{
				float: left;
				width: 415px;
				display: block;
				padding-left: 10px;
				height: 70px;
				font-size: 20px;
    			font-weight: bold;
			}
			.span_btn{
				float: left;
				width: 415px;
				padding-right: 10px;
				display: block;
				text-align: right;
			}
			.div_title_btn{
				width: 850px;
				height: 70px;
    			line-height: 70px;
			}
			.div_total{
				width: 1000px;
				height: 610px;
				padding-left: 100px;
				margin-top: 50px;
			}
			.layui-form-select{
				width: 100px;
			}
		</style>
	</head>
	<body>
		<div class="div_total">
			<h3>订单管理 >> 订单查询</h3><br><br>
			<div class="layui-inline">
		      <div class="layui-input-inline">
		      	<form class="layui-form">
		      		<div style="margin-left: 170px;">
		      			<div class="layui-inline">
					      <label class="layui-form-label" style="font-size:16px;text-align:center;width: 180px;height: 30px;">
					      	开始日期 - 结束日期：</label>
					      <div class="layui-input-inline">
					        <input type="text" class="layui-input" id="test6" placeholder=" - ">
					        <button type="submit" class="layui-btn" style="position: relative;top:-38px;left: 230px;">查询</button>
					      </div>
					    </div>
		      		</div>
		      	</form>
		      </div>
		    </div><br><br><br><br><br><br>
		    <div style="margin-top: -80px;"><br>
		    	<div style="width: 850px;">
			    	<hr>
			    </div>
			    <div class="div_title_btn">
			    	<span class="span_title">
				    	订单信息列表
				    </span>
			    </div>
				<table class="layui-hide" id="test" lay-filter="test"></table>
		    </div>
		</div>
		<script type="text/html" id="toolbarDemo">
		  <div class="layui-btn-container">
		    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">查看</button>
		  </div>
		</script>
		          
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  table.render({
		    elem: '#test'
		    ,url:''
		    ,toolbar: '#toolbarDemo'
		    ,cols: [[
		      {type:'radio'}
		      ,{field:'month', width:130, title: '月份'}
		      ,{field:'orderNumber', width:130, title: '订单数量'}
		      ,{field:'totalMoney', width:150, title: '总金额（万元）'}
		      ,{field:'target', width:150, title: '本月目标（万元）'}
		      ,{field:'percentageComplete', width:234, title: '完成率'}
		    ]]
		    ,page: true
		    ,data:[{month:'1',orderNumber:'admin',totalMoney:'女',target:'湖南',percentageComplete:'sdf'},
		    		{month:'1',orderNumber:'admin',totalMoney:'女',target:'湖南',percentageComplete:'sdf'},
		    		{month:'1',orderNumber:'admin',totalMoney:'女',target:'湖南',percentageComplete:'sdf'},
		    		{month:'1',orderNumber:'admin',totalMoney:'女',target:'湖南',percentageComplete:'sdf'},
		    		{month:'1',orderNumber:'admin',totalMoney:'女',target:'湖南',percentageComplete:'sdf'}
		    ]
		  });
		  
		  //头工具栏事件
		  table.on('toolbar(test)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
		    switch(obj.event){
		      case 'getCheckData':
		        var data = checkStatus.data;  //获取选中行数据
		        layer.alert(JSON.stringify(data));
		      break;
		    };
		  });
		});
		renderForm();
		function renderForm(){
		  layui.use('form', function(){
		   var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
		   form.render();
		  });
		 }
		layui.use('laydate', function(){
  		var laydate = layui.laydate;
		 //日期范围
		  laydate.render({
		    elem: '#test6'
		    ,range: true
		  });
		})
	</script>

</body>
</html>
