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
		<br>
		
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
					        <input type="text"  class="date layui-input" id="test6" placeholder=" - ">
					        <button type="submit" class="order_but layui-btn" style="position: relative;top:-38px;left: 230px;">查询</button>
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
		//展示数据
		layui.use('table', function(){
		  var table = layui.table;
		  table.render({
		    elem: '#test'
		    ,url:'../../../orderStatistics'
		    ,toolbar: '#toolbarDemo'
		    ,cols: [[
		      {type:'radio'}
		      ,{field:'months', width:130, title: '月份'}
		      ,{field:'totalOrderNumber', width:130, title: '订单数量'}
		      ,{field:'totalOrderMoney', width:150, title: '总金额（万元）'}
		      ,{field:'target', width:150, title: '本月目标（万元）'}
		      ,{field:'percentageComplete', width:234, title: '完成率',templet:'#titleTpl'}
		    ]]
		    ,page: true
		    ,limit:'2'
		    ,limits:[1,2,3,4,5]
		  });
		  $(".order_but").click(function(){//条件查询
		   		layui.use('table', function(){
		   		   	var table = layui.table;
			   		table.reload('test',
		             {
	                    where: { //这里传参  向后台
	                    	date:$('.date').val(),
	                    } 
			   			,page:true
			   			,url: '../../../orderStatistics'//后台做模糊搜索接口路径
			            , method: 'post' 
	                    ,limit:'2'
		   	  			,limits:[1,2,3,4]
		             });
		   		}); 
		   		return false;
		   	})
		  
		  
		  //查看
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
		
		//日期范围
		layui.use('laydate', function(){
	  		var laydate = layui.laydate;
			 //日期范围
			  laydate.render({
			    elem: '#test6'
			    ,range: true
			  });
		})
		
		//进度条
		layui.use('element', function(){
		  var $ = layui.jquery
		  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		  
		  //触发事件
		  var active = {
		    setPercent: function(){
		      //设置50%进度
		      element.progress('demo', '70%')
		    }
		    ,loading: function(othis){
		      var DISABLED = 'layui-btn-disabled';
		      if(othis.hasClass(DISABLED)) return;
		    
		      //模拟loading
		      var n = 0, timer = setInterval(function(){
		        n = n + Math.random()*10|0;  
		        if(n>100){
		          n = 100;
		          clearInterval(timer);
		          othis.removeClass(DISABLED);
		        }
		        element.progress('demo', n+'%');
		      }, 300+Math.random()*1000);
		      
		      othis.addClass(DISABLED);
		    }
		  };
		  
		  $('.site-demo-active').on('click', function(){
		    var othis = $(this), type = $(this).data('type');
		    active[type] ? active[type].call(this, othis) : '';
		  });
		});
	</script>
	<script type="text/html" id="titleTpl">
		<div class="layui-progress layui-progress-big" lay-showpercent="true">
		  <div class="layui-progress-bar" style="width:{{d.percentageComplete}};text-align:center">{{d.percentageComplete}}</div>
		</div>
	</script>

</body>
</html>
