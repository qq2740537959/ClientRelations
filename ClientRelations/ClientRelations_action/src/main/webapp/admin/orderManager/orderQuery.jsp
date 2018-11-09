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
			<h3>订单管理 >> 订单查询</h3>
			<div class="layui-inline">
		      <div class="layui-input-inline">
		      	<form class="layui-form">
		      		<div>
		      			<span style="position: relative;top: 66px;">
		      				<select name="quiz">
					            <option value="你工作的第一个城市">客户姓名</option>
					            <option value="你的工号">联系电话</option>
					        </select>
		      			</span>
		      			<span>
		      				<input type="text" name="title" style="position: relative;top:28px;left: 100px;" lay-verify="title" class="layui-input">
		      				<button type="submit" class="layui-btn" style="position: relative;top:-10px;left: 750px;">查询</button>
		      			</span>
		      			<span style="position: relative;top:-49px;left: 392px;">
		      				<span style="position: relative;top:40px;left: -130px;font-size:18px ;">时间：</span>
		      				<select name="quiz">
					            <option value="你工作的第一个城市">不限</option>
					            <option value="你的工号">近三个月</option>
					            <option value="你工作的第一个城市">今年内</option>
					            <option value="你的工号">今年前</option>
					        </select>
		      			</span>
		      			<span style="position: relative;top:-111px;left: 605px;">
		      				<span style="position: relative;top:31px;left: -65px;font-size:18px ;">状态：</span>
		      				<select name="quiz">
					            <option value="你工作的第一个城市">等待付款</option>
					            <option value="你的工号">等待自提</option>
					            <option value="你工作的第一个城市">等待收货</option>
					            <option value="你的工号">已完成</option>
					            <option value="你的工号">已取消</option>
					        </select>
		      			</span>
		      		</div>
		      	</form>
		      </div>
		    </div><br>
		    <div style="margin-top: -80px;">
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
		      ,{field:'orderType', width:100, title: '订单类型'}
		      ,{field:'orderNumber', width:122, title: '订单号'}
		      ,{field:'product', width:120, title: '商品'}
		      ,{field:'consignee', width:110, title: '收货人'}
		      ,{field:'orderMoney', width:110, title: '订单金额'}
		      ,{field:'orderTime', width:110, title: '下单时间'}
		      ,{field:'status', width:120, title: '状态'}
		    ]]
		    ,page: true
		    ,data:[{orderType:'1',orderNumber:'admin',product:'女',consignee:'湖南',orderMoney:'sdf',orderTime:'adfgd',status:'sdf'},
		    		{orderType:'1',orderNumber:'admin',product:'女',consignee:'湖南',orderMoney:'sdf',orderTime:'adfgd',status:'sdf'},
		    		{orderType:'1',orderNumber:'admin',product:'女',consignee:'湖南',orderMoney:'sdf',orderTime:'adfgd',status:'sdf'},
		    		{orderType:'1',orderNumber:'admin',product:'女',consignee:'湖南',orderMoney:'sdf',orderTime:'adfgd',status:'sdf'},
		    		{orderType:'1',orderNumber:'admin',product:'女',consignee:'湖南',orderMoney:'sdf',orderTime:'adfgd',status:'sdf'}
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
	</script>

</body>
</html>
