<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/admin/layui/css/layui.css" />
	<script src="<%=request.getContextPath() %>/admin/layui/layui.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/admin/js/jquery-1.8.3.min.js" ></script>
	<style>
			div.layui-form.layui-border-box.layui-table-view{
				width: 1100px;
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
			.layui-btn{
				background-color:rgb(31,147,231);
			}
			.layui-laypage .layui-laypage-curr .layui-laypage-em {
				background-color:rgb(31,147,231);
			}
			div.layui-form.layui-border-box.layui-table-view{
				margin-left: 100px;
			}
			div.layui-form.layui-border-box.layui-table-view{
				width:950px;
			}
		</style>
	</head>
	<body>
		<div class="div_total">
			<br/>
			<br/>
			<br/>
			<h3 style = "margin-left: 50px;">合同管理 >> 合同创建</h3>
			<div class="layui-inline">
		      <div class="layui-input-inline">
		      	<form class="layui-form">
		      		<div style="float: left;margin-top: 30px;margin-left: 240px;">
		      			<span style="float: left;">
		      				 <label style="font-size: 18px;" class = "layui-form-mid">合同名称：</label>
		      			</span>
		      			<span style="float: left;">
		      				<input type="text" name="contractName" class="layui-input contractName">
		      			</span>
		      			<div style="clear: both;"></div>
		      		</div>
		      		<div style="float: left;margin-left: 20px;margin-top: 30px;">
	      				<h3 class = "layui-form-mid">类型：</h3>
	      				<div style="float:left;">
		      				<select name = "contractType" class = "contractType">
		      					
		      				</select>
	      				</div>
      				</div>
      				<div style="float: left;margin-left: 20px;margin-top: 30px;">
	      				<h3 class = "layui-form-mid">状态：</h3>
	      				<div style="float: left;">
		      				<select name = "contractState" class = "contractState">
		      					
		      				</select>
	      				</div>
      				</div>
      				<div style="float:left;margin-left: 10px;margin-top: 30px;">
      					<button class="layui-btn" id = "refer">查询</button>
      				</div>
		      	</form>
		      </div>
		    </div><br>
		    <div style="width: 1052px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
			    <div class="span_btn" style="margin-left: -251px">
			    	<button class="layui-btn fabricate">创建</button>
			    </div>
		    </div>
			<table class="layui-hide" id="test" lay-filter="test"></table>
		</div>
		 
		<script type="text/html" id="toolbarDemo">
  			<div class="layui-btn-container">
    			<button class="layui-btn layui-btn-sm" lay-event="update">修改</button>
    			<button class="layui-btn layui-btn-sm" lay-event="query">查看</button>
    			<button class="layui-btn layui-btn-sm" lay-event="audit">提交</button>
  			</div>
		</script>
		      
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  var layer = layui.layer;
		  table.render({
		    elem: '#test'
		    ,url:'../../../demandAction'
		    ,toolbar: '#fool'
		    ,cols: [[
		      ,{field:'contractId', width:46, title: 'id'}
		      ,{field:'contractName', width:165, title: '合同名称'}
		      ,{field:'genreName', width:150, title: '合同类型'}
		      ,{field:'shapeName', width:130, title: '状态'}
		      ,{field:'lastTime', width:130, title: '最后操作时间'}
		      ,{field:'staffName', width:120, title: '待处理人 '}
		      ,{width:200,title:'操作',toolbar:'#toolbarDemo'}
		    ]]
		    ,page: true,
		    limits:[1,5,10,15]
		  });
		  
		  table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			   	var data = obj.data; //获得当前行数据
			   	var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			   	var tr = obj.tr; //获得当前行 tr 的DOM对象
			   	var con = data.contractId;
			   	var staff = data.staffId;
			   	if(layEvent == 'query') { //查看
					layer.open({
						type:2,
						area:['800px','600px'],
						content:"details.jsp?contractId="+con,
					})
			   	} else if(layEvent === 'update') { //修改
		   			 $.ajax({
		   				 url:'../../../delegateAction',
		   				 type:'post',
		   				 success:function(data){
		   					 if(data.a == 4){
		   						layer.open({
		   							type:2,
		   							area:['800px','600px'],
		   							content:"clearly.jsp?contractId="+con,
		   						})
		   					 }else{
		   						 alert("修改合同只能由销售代表修改！");
		   					 }
		   				 },error:function(){
		   					 alert("网络错误！");
		   				 }
		   			 })
			   	}else if(layEvent === 'audit'){
			   		 if(data.shapeName == '已订立'){
			   			 $.ajax({
			   				 url:'../../../delegateAction',
			   				 type:'post',
			   				 success:function(data){
			   					 if(data.a == 4){
			   						layer.open({
			   				   			type:2,
			   				   			area:['800px','600px'],
			   				   			content:"tasklet.jsp?contractId="+con,
			   				   		})	
			   					 }else{
			   						 alert("合同只能由销售代表提交！");
			   					 }
			   				 },error:function(){
			   					 alert("网络错误！");
			   				 }
			   			 })
			   		}else{
			   			alert("合同已订立才能提交！");
			   		}
			   	}
			   	
			});
		  
		  function fledged(){
			  $(".fabricate").on("click",function(){
				  $.ajax({
					  url:'../../../delegateAction',
					  type:'post',
					  success:function(data){
						  if(data.a == 4){
								 layer.open({
									type:2,
									area:['800px','600px'],
									content:"revamp.jsp",
								})
						  }else{
							  alert(data.msg);
						  }
						  console.log(data)
					  },error:function(){
						  alert("网络错误！");
					  }
				  })
			  })
		  }
		  fledged();
			
		});
		renderForm();
		function renderForm(){
		  layui.use('form', function(){
		   var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
		   form.render();
		  });
		 }
	</script>
	<script type = "text/javascript">
		function pattern(){
			$.ajax({
				url:'../../../patternAction',
				type:'post',
				success:function(data){
					$(".contractState").empty();
					var ary ="<option value = ''>全部</option>";
					for(var i = 0;i<data.length;i++){
						ary+="<option value = "+data[i].shapeId+">"+data[i].shapeName+"</option>";
					}
					$(".contractState").html(ary);
					renderForm();
				},error:function(){
					alert("网络错误！");
				}
			})
		}
		pattern();
		
		function voice(){
			$.ajax({
				url:'../../../voiceAction',
				type:'post',
				success:function(data){
					$(".contractType").empty();
					var arr = "<option value = ''>全部</option>";
					for(var i = 0;i<data.length;i++){
						arr+="<option value = "+data[i].genreId+">"+data[i].genreName+"</option>";
					}
					$(".contractType").html(arr);
					renderForm();
				},error:function(){
					alert("网络错误！");
				}
			})
		}
		voice();
		
		function refershuaxin(){
			$("#refer").click();
		}
		
		$('#refer').on('click', function(){
			layui.use('table', function(){
				var table = layui.table;
				table.reload('test', {
				  where: { //设定异步数据接口的额外参数，任意设
					  'contractName':$(".contractName").val(),
					  'contractType':$(".contractType").val(),
					  'contractState':$(".contractState").val(),
				  }
				  ,page: {
					curr: 1 //重新从第 1 页开始
				  }
				});
			});
			return false;
		 });
	</script>
	</body>
</html>