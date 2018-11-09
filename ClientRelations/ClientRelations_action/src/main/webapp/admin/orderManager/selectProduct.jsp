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
			
		</style>
	</head>
	<body>
		<div class="div_total">
			<h3>è®¢åç®¡ç >> ä»£ä¸è®¢å >> ä¸åæä½</h3>
			<div style="width: 630px;height: 200px;font-size: 17px;padding-left: 220px;"><br/>
				å®¢æ·å§åï¼å»æå   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;æ§å«ï¼ç·  <br/><br/>
				å®¢æ·ç±»åï¼æ®éå®¢æ·   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;å®¢æ·ç¶æï¼æ­£å¸¸  <br/><br/>
				èç³»çµè¯ï¼15801881818   &nbsp; &nbsp; &nbsp;æå¡ä»£è¡¨ï¼éç  <br/><br/>
				å·²æ¶è´¹æ¬¡æ°ï¼1   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
				 &nbsp; &nbsp; &nbsp; &nbsp; æ¶è´¹æ»é¢ï¼2.6ä¸å 
			</div>
		    <div style="width: 850px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	å¯éè´­ååä¿¡æ¯åè¡¨
			    </span>
		    </div>
			<table class="layui-hide" id="test" lay-filter="test"></table>
		</div>
		<br><br>
		<br><br>
		<div style="margin-left: 450px;">
			<button class="layui-btn" >ä¸ä¸æ­¥</button>
		 	<button class="layui-btn">è¿å</button> 
		</div>
		<script>
			layui.use('table', function(){
			  var table = layui.table;
			  table.render({
			    elem: '#test'
			    ,url:''
			    ,toolbar: '#toolbarDemo'
			    ,cols: [[
			      {type:'checkbox'}
			      ,{field:'id', width:113, title: 'ID'}
			      ,{field:'username', width:140, title: 'ç¨æ·å'}
			      ,{field:'sex', width:135, title: 'æ§å«'}
			      ,{field:'city', width:135, title: 'åå¸'}
			      ,{field:'sign', width:135, title: 'ç­¾å'}
			      ,{field:'experience', width:135, title: 'ç§¯å'}
			    ]]
			    ,page: true
			    ,data:[{id:'1',username:'admin',sex:'å¥³',city:'æ¹å',sign:'sdf',experience:'adfgd'},
			    		{id:'1',username:'admin',sex:'å¥³',city:'æ¹å',sign:'sdf',experience:'adfgd'},
			    		{id:'1',username:'admin',sex:'å¥³',city:'æ¹å',sign:'sdf',experience:'adfgd'},
			    		{id:'1',username:'admin',sex:'å¥³',city:'æ¹å',sign:'sdf',experience:'adfgd'},
			    		{id:'1',username:'admin',sex:'å¥³',city:'æ¹å',sign:'sdf',experience:'adfgd'}
			    ]
			  });
			  
			  //å¤´å·¥å·æ äºä»¶
			  table.on('toolbar(test)', function(obj){
			    var checkStatus = table.checkStatus(obj.config.id); //è·åéä¸­è¡ç¶æ
			    switch(obj.event){
			      case 'getCheckData':
			        var data = checkStatus.data;  //è·åéä¸­è¡æ°æ®
			        layer.alert(JSON.stringify(data));
			      break;
			    };
			  });
			});
		</script>
	</body>
</html>
