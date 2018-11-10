<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="../../layui/css/layui.css" />
	<script src="../../layui/layui.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../../js/jquery-1.8.3.min.js" ></script>
	<style>
			div.layui-form.layui-border-box.layui-table-view{
				width: 840px;
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
			 
			.layui-form-select{
				width: 100px;
			}
		</style>
	</head>
	<body>
		<div class="div_total">
			<h3>合同管理 >> 合同创建</h3>
			<div class="layui-inline">
		      <div class="layui-input-inline">
		      	<form class="layui-form">
		      		<div style="float: left;margin-top: 30px;margin-left: 126px;">
		      			<span style="float: left;">
		      				<select name="quiz">
					            <option value="你工作的第一个城市">合同名称：</option>
					        </select>
		      			</span>
		      			<span style="float: left;">
		      				<input type="text" name="title" class="layui-input">
		      			</span>
		      			<div style="clear: both;"></div>
		      		</div>
		      		<div style="float: left;margin-left: 20px;margin-top: 30px;">
	      				<h3 class = "layui-form-mid">类型：</h3>
	      				<div style="float:left;">
		      				<select>
		      					<option>类型</option>
		      					<option>类型</option>
		      					<option>类型</option>
		      				</select>
	      				</div>
      				</div>
      				<div style="float: left;margin-left: 20px;margin-top: 30px;">
	      				<h3 class = "layui-form-mid">状态：</h3>
	      				<div style="float: left;">
		      				<select>
		      					<option>状态</option>
		      					<option>状态</option>
		      					<option>状态</option>
		      				</select>
	      				</div>
      				</div>
      				<div style="float:left;margin-left: 10px;margin-top: 30px;">
      					<button class="layui-btn">查询</button>
      				</div>
		      	</form>
		      </div>
		    </div><br>
		    <div style="width: 700px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	客户信息列表
			    </span>
			    <span class="span_btn">
			    	<button class="layui-btn">创建</button>
			    	<button class="layui-btn">修改</button>
			    	<button class="layui-btn">查看</button>
			    	<button class="layui-btn">提交</button>
			    </span>
		    </div>
			<table class="layui-hide" id="test" lay-filter="test"></table>
		</div>
		 
		 
		<script type="text/html" id="toolbarDemo">
		  <div class="layui-btn-container">
		    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
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
		      ,{field:'id', width:38, title: ''}
		      ,{field:'', width:100, title: '', type :'radio'}
		      ,{field:'contractName', width:165, title: '合同名称'}
		      ,{field:'contractType', width:150, title: '合同类型'}
		      ,{field:'contractState', width:130, title: '状态'}
		      ,{field:'lastTime', width:130, title: '最后操作时间'}
		      ,{field:'handlePeople', width:120, title: '处理人 '}
		    ]]
		    ,page: true
		    ,data:[{id:'1',contractName:'admin',contractType:'销售合同',contractState:'已订立',lastTime:'2018-10-11',handlePeople:'李富华'},
		    		{id:'1',contractName:'admin',contractType:'销售合同',contractState:'已订立',lastTime:'2018-10-11',handlePeople:'李富华'},
		    		{id:'1',contractName:'admin',contractType:'销售合同',contractState:'已订立',lastTime:'2018-10-11',handlePeople:'李富华'},
		    		{id:'1',contractName:'admin',contractType:'销售合同',contractState:'已订立',lastTime:'2018-10-11',handlePeople:'李富华'},
		    		{id:'1',contractName:'admin',contractType:'销售合同',contractState:'已订立',lastTime:'2018-10-11',handlePeople:'李富华'}
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