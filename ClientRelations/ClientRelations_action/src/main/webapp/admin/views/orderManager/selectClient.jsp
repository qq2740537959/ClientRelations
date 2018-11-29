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
		<link rel="stylesheet" href="../../layui/css/layui.css" />
		<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../../layui/layui.js"></script>
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
			<h3>订单管理 >> 代下订单</h3>
			<div class="layui-inline">
		      <div class="layui-input-inline">
		      	<form class="layui-form" id="form_aa">
		      		<div>
		      			<span style="position: relative;left: 215px;top: 66px;">
		      				<select name="distinguish" id="distinguish">
					            <option value="clientName">客户姓名</option>
					            <option value="phone">联系电话</option>
					        </select>
		      			</span>
		      			<span>
		      				<input type="text" name="clientNameOrPhone" id="clientNameOrPhone" style="position: relative;top:28px;left: 315px;" lay-verify="title" class="layui-input">
		      				<button type="button" class="layui-btn refer_but" style="position: relative;top:-10px;left: 498px;">查询</button>
		      				<input type="hidden" value="1" id="staffId" />
		      			</span>
		      		</div>
		      	</form>
		      </div>
		    </div><br>
		    <div style="width: 850px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	客户信息列表
			    </span>
		    </div>
			<table class="layui-hide" id="test" lay-filter="test"></table>
		</div>
		 
		 
		<script type="text/html" id="toolbarDemo">
		  <span class="layui-btn-container">
		    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">查看</button>
		  </span>
 		  <span class="layui-btn-container">
		  	<button class="layui-btn layui-btn-sm" lay-event="order">下 单</button>
		  </span>
		</script>
		          
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  var staffId= $("#staffId").val();
		  table.render({
		    elem: '#test'
		    ,url:'../../../selectClient?staffId='+staffId
		    ,toolbar: '#toolbarDemo'
		    ,cols: [[
		      {type:'radio'}
		      ,{field:'clientName', width:100, title: '客户姓名'}
		      ,{field:'sex', width:120, title: '性别'}
		      ,{field:'clientType', width:110, title: '类型'}
		      ,{field:'state', width:110, title: '状态'}
		      ,{field:'consumptionTimes', width:110, title: '消费次数'}
		      ,{field:'totalConsumptionAmount', width:120, title: '消费金额'}
		      ,{field:'staffName', width:122, title: '销售代表'}
		    ]]
		    ,page: true
		    ,limit:'5'
		    ,limits:[1,2,3,4,5]
		  });
		  
		  $(".refer_but").click(function(){//条件查询
		   		layui.use('table', function(){
		   		   	var table = layui.table;
			   		table.reload('test',
		             {
	                    where: { //这里传参  向后台
	                    	distinguish:$('#distinguish').val(),
	                    	clientNameOrPhone:$('#clientNameOrPhone').val(),
	                    	staffId:$('#staffId').val()
	                    } 
			   			,page:
	                    {
	                        curr: 1 //重新从第 1 页开始
	                    }
			   			,url: '../../../selectClient'//后台做模糊搜索接口路径
			            , method: 'post' 
	                    ,limit:5
		   	  			,limits:[1,2,3,4]
		             });
		   		}); 
		   		return false;
		   	})
		  
		  //头工具栏事件
		  table.on('toolbar(test)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
		    switch(obj.event){
		      case 'getCheckData':
		        var data = checkStatus.data;  //获取选中行数据
		         layer.alert(JSON.stringify("<div style='color:rgb(102,102,102);width: 320px;height: 200px;padding-left: 50px;'><h2 style='margin-left: 40px;'>客户信息</h2><br><div>客户姓名："+data[0].clientName+"</div><div>类型："+data[0].clientType+"</div><div>联系方式："+data[0].phone+"</div><div>性别:"+data[0].sex+"</div><div>服务代表："+data[0].staffName+"</div><div>状态："+data[0].state+"</div><div>消费次数："+data[0].consumptionTimes+"</div><div>消费总金额："+data[0].totalConsumptionAmount+"</div></div>")); 
		        break;
		      case 'order':
			      location.href="selectProduct.jsp?clientId="+checkStatus.data[0].clientId;
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
