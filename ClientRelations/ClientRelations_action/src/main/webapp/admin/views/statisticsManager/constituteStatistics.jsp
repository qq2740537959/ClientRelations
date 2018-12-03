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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="../../layui/css/layui.css">
<link rel="stylesheet" href="../../assets/css/view.css" />
<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
<title>客户构成统计</title>
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
				<span class="layui-breadcrumb"> <a href="">统计分析</a><a><cite>客户构成统计</cite></a>
				</span>
				<h2 class="title">客户构成统计</h2>
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
						<div style="width: 500px;float: left;line-height: 38px;">客户构成统计信息列表</div>
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
	  table.on('toolbar(test)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
		    switch(obj.event){
		      case 'details':
		        var data = checkStatus.data;  //获取选中行数据
		        layer.open({
			   		 type:2,
			   		 area: ['800px', '600px'],
			   		 content:'index.html',
			   		 success:function(layero,index){
						 var body = layer.getChildFrame('body',index);
						 console.log(data[0]);
						/*  body.find(".planId").text(data[0].planId); */
						 
					}
			   		}); 
		      break;
		    };
		  });
	   	//第一个实例
	   	table.render({
	   	  elem: '#demo'
	   	  ,url: '../../../selectConstitute' //数据接口
	   	  ,page: true //开启分页
	   	  ,limit:5
	   	  ,toolbar: '#toolbarDemo'
	   	  ,limits:[5,10,15,20]
	   	  ,cols: [[ //表头
	   	  	{type:'radio'}
	   	    ,{field: 'statisticsId', title: '编号',sort: true,width:100}
	   	    ,{field: 'statisticsCustomerNumber', title: '客户数量',width:100}
	   	    ,{field: 'statisticsDate',title: '月份',width:100,templet: "<div>{{layui.util.toDateString(d.statisticsDate, 'yyyy-MM')}}</div>"}
	   	    ,{field: 'statisticsSameTimeRatio', title: '环比',width:100,templet: "<div>{{a(d.statisticsCustomerNumber,d.statisticsSameTimeRatio)}}%</div>"}
	   	    ,{field: 'statisticsRingRatio', title: '同比',width:100,templet: "<div>{{b(d.statisticsCustomerNumber,d.statisticsRingRatio)}}%</div>"}
	   	  ]]
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
	   	$(".details").on("click",function(){
	   		console.log("2333");
	   		layer.open({
	   		 type:2,
	   		 area: ['800px', '600px'],
	   		 content:'index.html'
	   		}); 
	   	})
	});
	
    layui.use(['laydate'], function(){
       var $ = layui.$;
       var laydate = layui.laydate;
       var nowTime = new Date().valueOf();
       var max = null;
       
          var start = laydate.render({
           elem: '#start_time',
           type: 'month',
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
           type: 'month',
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
	function a(number,numberTwo){
		if(numberTwo==0){
			return 0;
		} else {
			var tb=(number-numberTwo)/numberTwo*0.1;
			return tb;
		}
	}
	function b(number,numberTwo){
		if(numberTwo==0){
			return 0;
		} else {
			var hb=(number-numberTwo)/numberTwo*0.1;
			return hb;
		}
	}
    </script>
</body>
</html>