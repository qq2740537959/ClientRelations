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
		<link rel="stylesheet" href="../../layui/css/layui.css" />
		<link rel="stylesheet" href="../../css/reset.css">
  		<link rel="stylesheet" href="../../css/carts.css">
		<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<script src="../../js/carts.js" ></script>
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
		<%
			Object clientId = request.getParameter("clientId");
		%>
		<input type="hidden" value="<%=clientId%>" class="clientId"> 
		<div class="div_total">
			<h3>订单管理 >> 代下订单 >> 下单操作</h3>
			<div class="order" style="width: 630px;height: 200px;font-size: 17px;padding-left: 220px;"><br/>
				客户姓名：<span class="clientName"></span>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;性别：<span class="sex"></span>  <br/><br/>
				客户类型：<span class="clientType"></span>   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;客户状态：<span class="state"></span>  <br/><br/>
				联系电话：<span class="phone"></span>   &nbsp; &nbsp; &nbsp;服务代表：<span class="staffName"></span> <br/><br/>
				已消费次数：<span class="consumptionTimes"></span>   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
				 &nbsp; &nbsp; &nbsp; &nbsp; 消费总额：<span class="totalConsumptionAmount"></span>
			</div>
		    <div style="width: 850px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	可选购商品信息列表
			    </span>
		    </div>
			<table class="layui-hide" id="test" lay-filter="test"></table>
			<input type="hidden" class="numbers" value="0"><!-- 数量 -->
			<input type="hidden" class="prices" value="0"><!-- 总金额 -->
		</div>
		<br><br>
		<br><br>
		<div style="margin-left: 450px;">
			<script type="text/html" id="toolbarDemo">
				<button class="layui-btn" lay-event="getCheckData">下一步</button>
				<a href="selectClient.jsp"><button class="layui-btn">返回</button></a>
			</script>
		</div>
		<script>
			var clientId= $(".clientId").val();
			$.ajax({
				url:'../../../selectClientById?clientId='+clientId,
				type:'post',
				success:function(data){
					$(".clientName").html(data.clientName);
					$(".sex").html(data.sex);
					$(".clientType").html(data.clientType);
					$(".state").html(data.state);
					$(".phone").html(data.phone);
					$(".staffName").html(data.staffName);
					$(".consumptionTimes").html(data.consumptionTimes);
					$(".totalConsumptionAmount").html(data.totalConsumptionAmount);
				}
			})
			layui.use('table', function(){
			  var table = layui.table;
			  table.render({
			    elem: '#test'
			    ,url:'../../../selectProduct'
			    ,toolbar: '#toolbarDemo'
			    ,cols: [[
			      {type:'checkbox'}
			      ,{field:'productId', width:115, title: 'ID'}
			      ,{field:'productName', width:140, title: '商品名称'}
			      ,{field:'productTypeNumber', width:140, title: '商品型号'}
			      ,{field:'price', width:140, title: '单价'}
			      ,{field:'number', width:140, title: '数量',templet:'#demo'}
			      ,{field:'productNumber', width:115, title: '库存',templet:'#inventoryLet'}
			    ]]
			    ,page: true
			    ,limit:'5'
			    ,limits:[1,2,3,4,5]
			  });
			  
			  //头工具栏事件
			  table.on('toolbar(test)', function(obj){
			    var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
			    switch(obj.event){
			      case 'getCheckData':
			        var data = checkStatus.data;  //获取选中行数据
			       	var product = "";
			       	var num = $(".numbers").val();
			       	var count = 0;
			       	var prices = 0
			        for(var a=0;a<data.length;a++){
			        	product += data[a].productId+",";
			        	count++;
			        	var price = $(".prices").val();
			        	$(".prices").val(parseInt(price)+data[a].price);
			        	prices = parseInt(price)+data[a].price;
			        }
			        $(".numbers").val(parseInt(num)+count)
			        var number = parseInt(num)+count;
			        if(product.length == 0){
			        	alert("请选择要购买的商品");
			        }else{
			        	location.href= "orderSettleAccounts.jsp?clientId="+clientId+"&product="+product+"&number="+number+"&price="+prices;
			        }
			      break;
			    };
			  });
			});
		</script>
		<script type="text/html" id="inventoryLet">
		 	 	{{d.productNumber==0?'售罄':'有货'}}
		</script>
		<script type="text/html" id="demo">
			<ul class="order_lists" >
	            <li class="list_amount" >
	                <div class="amount_box">
	                    <a href="javascript:;" class="reduce reSty" onclick="bb(this,{{d.price}})" style="margin-top: -20px;">-</a>
	                    <input type="text" value="1" class="sum" style="margin-top: -15px;">
	                    <a href="javascript:;" class="plus" onclick="aa(this,{{d.productNumber}},{{d.price}});" style="margin-top: -20px;">+</a>
	                </div>
	            </li>
	        </ul>
		</script>
		<script type="text/javascript">
			function bb(th,money){
				if (parseInt($(th).next().val()) > 1) {
					var m = parseInt($(th).next().val())-1;
					alert((m*money));
					$(th).next().val(parseInt($(th).next().val())-1);
					var num = $(".numbers").val();
					 $(".numbers").val(parseInt(num)-1);
					 var price = $(".prices").val();
					 $(".prices").val(parseInt(price)-money);
				}else{
					$(th).next().val(1);
					 $(".numbers").val(1);
				}
			}
			function aa(th,number,money){
				if(number > 1){
					 var a = parseInt($(th).prev().val())+1;
					 $(th).prev().val(parseInt($(th).prev().val())+1);
					 alert((a*money))
					 var num = $(".numbers").val();
					 $(".numbers").val(parseInt(num)+1);
					 var price = $(".prices").val();
					 $(".prices").val(parseInt(price)+money);
				}else{
					$(th).next().val(0);
					 $(".numbers").val(0);
				}
			}
		</script>
	</body>
</html>
