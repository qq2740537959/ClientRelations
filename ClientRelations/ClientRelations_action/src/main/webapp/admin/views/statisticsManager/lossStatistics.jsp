﻿<%@ page language="java" contentType="text/html; charset=utf-8"
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="../../layui/css/layui.css">
<link rel="stylesheet" href="../../assets/css/view.css" />
<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
<title>客户流失统计</title>
<style type="text/css">
.layui-table-cell {
	text-align: center;
}
</style>
</head>
<body class="layui-view-body">
	<div class="layui-content">
		<div class="layui-page-header">
			<div class="pagewrap">
				<span class="layui-breadcrumb"> <a href="">统计分析</a><a><cite>客户流失统计</cite></a>
				</span>
				<h2 class="title">客户流失统计</h2>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-card">
				<div class="layui-card-body">
					<div class="form-box">
						<div class="layui-form layui-form-item">
							<div class="layui-inline">
								<div class="layui-input-inline" style="width: 150px;">
									<input type="dateTime" name="start_time" class="layui-input" id="start_time" placeholder="开始时间">
								</div>
								<button class="layui-btn layui-btn-blue refer_but">查询</button>
								<button class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
						<hr/>
						<div style="width: 500px;float: left;line-height: 38px;">客户构成统计信息列表</div><button class="layui-btn layui-btn-blue refer_but">查看</button>
						<table id="demo" lay-filter="test"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../../layui/layui.js"></script>
	<script>
    layui.use('table', function(){
	  var table = layui.table;
	   	//第一个实例
	   	table.render({
	   	  elem: '#demo'
	   	  ,url: '' //数据接口
	   	  ,page: true //开启分页
	   	  ,limit:5
	   	  ,limits:[5,10,15,20]
	   	  ,cols: [[ //表头
	   	  	{type:'radio'}
	   	    ,{field: 'id', title: '编号',sort: true,width:100}
	   	    ,{field: 'statisticsLossQuantity', title: '流失数量',width:100}
	   	    ,{field: 'month',title: '月份',width:100}
	   	    ,{field: 'yearOnYear', title: '同比',width:100}
	   	    ,{field: 'ringRatio', title: '环比',width:100}
	   	  ]],
	   	  data:[
			{id:'1',customerNumber:'1',month:'2018-9-16',yearOnYear:'10',ringRatio:'30%'},
			{id:'2',customerNumber:'2',month:'2018-8-16',yearOnYear:'20',ringRatio:'40%'},
	   	  ]
	   	});
	   	$(".refer_but").click(function(){
	   		layui.use('table', function(){
	   		   	var table = layui.table;
		   		table.reload('demo',
	             {
                    where: { //这里传参  向后台
		   				startTime:$("#start_time").val(),
                    } 
		   			,page:
                    {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,limit:5
	   	  			,limits:[5,10,15,20]
	             });
	   		}); 
	   		return false;
	   	})
	});
	
    layui.use(['laydate'], function(){
       var $ = layui.$;
       var laydate = layui.laydate;
       var nowTime = new Date().valueOf();
       var max = null;
       
          var start = laydate.render({
           elem: '#start_time',
           type: 'date',
           max: nowTime,
           btns: ['clear', 'confirm'],
           done: function(value, date){
               endMax = end.config.max;
               end.config.min = date;
               end.config.min.month = date.month -1;
           }
       });
       var end = laydate.render({
           elem: '#end_time',
           type: 'date',
           max: nowTime,
           done: function(value, date){
               if($.trim(value) == ''){
                   var curDate = new Date();
                   date = {'date': curDate.getDate(), 'month': curDate.getMonth()+1, 'year': curDate.getFullYear()};
               }
               start.config.max = date;
               start.config.max.month = date.month -1;
           }
       });
    });
	
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "H+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	
	function test(val){
		layui.use('table', function(){
   		   	var table = layui.table;
	   		table.reload('demo',
             {
             	limit:5,
             	limits:[5,10,15,20]
                ,where: { //这里传参  向后台
                	context:$(".context").val(),
	   				typeName:$(".typeName").val(),
	   				startTime:$("#start_time").val(),
	   				endTime:$("#end_time").val(),
	   				categoryId:$(".categoryId").val(),
                }
             });
   		});
		layer.msg(val,{icon:1});
	}
	 
	function Format(datetime,fmt) {
	  if (parseInt(datetime)==datetime) {
	    if (datetime.length==10) {
	      datetime=parseInt(datetime)*1000;
	    } else if(datetime.length==13) {
	      datetime=parseInt(datetime);
	    }
	  }
	  datetime=new Date(datetime);
	  var o = {
	  "M+" : datetime.getMonth()+1,                 //月份   
	  "d+" : datetime.getDate(),                    //日   
	  "h+" : datetime.getHours(),                   //小时   
	  "m+" : datetime.getMinutes(),                 //分   
	  "s+" : datetime.getSeconds(),                 //秒   
	  "q+" : Math.floor((datetime.getMonth()+3)/3), //季度   
	  "S"  : datetime.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	  fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	  if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;
	}
	function xiangQing(id){
		$.ajax({
			type:"post",
			url:"",
			data:"id="+id,
			success:function(t){
				layer.open({
				  type: 1,
				  content:"<div>"+t.data.particulars+"</div>",
				  closeBtn: 0,
				  anim: 4,
				  area: ['767px', '600px'],
				  shade:0.2,
				  shadeClose :true,
				});
			}
		})
	}
    </script>
</body>
</html>