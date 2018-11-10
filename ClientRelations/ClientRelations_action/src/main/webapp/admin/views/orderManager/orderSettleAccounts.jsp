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
				width: 685px;
				margin-left: 100px;
			}
			.span_title{
				float: left;
				width: 325px;
				display: block;
				padding-left: 100px;
				height: 70px;
				font-size: 20px;
    			font-weight: bold;
			}
			.span_btn{
				float: left;
				width: 355px;
				padding-right: 70px;
				display: block;
				text-align: right;
			}
			.div_title_btn{
				width: 850px;
				height: 70px;
    			line-height: 70px;
			}
			.div_total{
				width:880px;
				height: 800px;
				margin-left: 100px;
				padding-top: 30px;
				margin-top: 50px;
				border: 1px solid rgb(230,230,230);
			}
			.layui-table-cell {
				width: 130px;	
			}
			.div_c{
				width: 280px;
				height: 40px;
				margin-left: 500px;
				text-align: right;
				line-height: 40px;
				font-size: 16px;
			}
		</style>
	</head>
	<body>
		<div class="div_total">
			<h3>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				è®¢åç®¡ç >> ä»£ä¸è®¢å >> ä¸åç»ç®</h3>
			<div style="width: 685px;height: 330px;margin-left: 100px;"><br/><hr />
				å¡«åå¹¶æ ¸å¯¹è®¢åä¿¡æ¯
				<hr>
				<div style="font-size: 17px;">
					&nbsp;&nbsp;&nbsp;&nbsp;
					æ¶è´§äººä¿¡æ¯ &nbsp;&nbsp;
					<button data-method="notice" class="layui-btn ddr">ä¿®æ¹</button><br>
					<div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 å»æå  &nbsp;&nbsp; 15801881818 <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
       					åäº¬ &nbsp;&nbsp; æµ·æ·åº  &nbsp;&nbsp;æµ·æ·åè·¯188å·é¢2å·æ¥¼
					</div><hr>
					
					&nbsp;&nbsp;&nbsp;&nbsp;
					 æ¯ä»åééæ¹å¼                      <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="payDispatching" value="ç·" title="ç·" checked="">
					  è´§å°ä»æ¬¾ &nbsp;&nbsp;<font style="font-size: 12px;">å¬å¸éè´§ä¸é¨</font>
      				 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="payDispatching" value="ç·" title="ç·" checked="">
					  å¨çº¿æ¯ä» &nbsp;&nbsp;<font style="font-size: 12px;">å¿«éåé®</font><hr />
					 
					 &nbsp;&nbsp;&nbsp;&nbsp;
					  åç¥¨ä¿¡æ¯                      <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="invoice" value="ç·" title="ç·" checked="">
					 	ä¸ªäººæç»
      				 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="invoice" value="ç·" title="ç·" checked="">
						å¬å¸æç»
				</div>
			</div>
		    <div style="width: 685px;margin-left: 100px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	ååæ¸å
			    </span>
			    <span class="span_btn">
			    	<button class="layui-btn layui-btn-radius">è¿å</button>
			    </span>
		    </div>
			<table class="layui-hide" id="test"></table>
			<div class="div_c">
			 	<font color="red">2</font> ä»¶ååï¼æ»ååéé¢ï¼    ï¿¥53000.00å
			</div>
			<div class="div_c">
			 	 è¿è´¹ï¼  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       ï¿¥0.00å
			</div> 
			<div class="div_c">
			 	 åºä»æ»é¢ï¼      ï¿¥53000.00å
			</div>
			<div style="width: 685px;margin-left: 100px;">
		    	<hr>
		    </div>
		    <div style="font-size: 18px;margin-left: 100px;width: 685px;height: 70px;line-height:70px;text-align: right;">
		    	åºä»æ»é¢ï¼<font color="red">ï¿¥53000.00å </font>&nbsp; &nbsp; &nbsp;
		    	<button class="layui-btn">æäº¤è®¢å</button> 
		    </div>
		</div>
		
		<script>
			layui.use(['table','layer'], function(){
			  var table = layui.table;
			  
			  table.render({
			    elem: '#test'
			    ,url:''
			    ,cellMinWidth: 80 //å¨å±å®ä¹å¸¸è§ååæ ¼çæå°å®½åº¦ï¼layui 2.2.1 æ°å¢
			    ,cols: [[
			      {field:'id', width:135, title: 'ID'}
			      ,{field:'username', width:135, title: 'ç¨æ·å'}
			      ,{field:'sex', width:135, title: 'æ§å«'}
			      ,{field:'city', width:135, title: 'åå¸'}
			      ,{field:'sign', title: 'ç­¾å', width: '30%', width: 138} //minWidthï¼å±é¨å®ä¹å½åååæ ¼çæå°å®½åº¦ï¼layui 2.2.1 æ°å¢
			    ]]
			    ,data:[ {id:'1',username:'admin',sex:'å¥³',city:'æ¹å',sign:'sdf'},
			    		{id:'1',username:'admin',sex:'å¥³',city:'æ¹å',sign:'sdf'},
				    ]
			  });
			  $(".ddr").click(function(){
			  	layer.open({
			  		type:1,
			  		title:"æ¶è´§å°å"
			  		,content:"<div>fds</div>"
			  		,area: ['390px', '260px']
			  		,btn: ['ç«éå´è§', 'æ®å¿æç»']
			  		,success: function(layero){
			          var btn = layero.find('.layui-layer-btn');
			          btn.find('.layui-layer-btn0').attr({
			            href: 'selectProduct.html'
			            ,target: '_blank'
			          });
			        }
			  	})
			  })
			});
		
		</script>
		
	</body>
</html>
