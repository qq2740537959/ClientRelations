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
		<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../../layui/layui.js"></script>
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
				订单管理 >> 代下订单 >> 下单结算</h3>
			<div style="width: 685px;height: 330px;margin-left: 100px;"><br/><hr />
				填写并核对订单信息
				<hr>
				<div style="font-size: 17px;">
					&nbsp;&nbsp;&nbsp;&nbsp;
					收货人信息 &nbsp;&nbsp;
					<button data-method="notice" class="layui-btn ddr">修改</button><br>
					<div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 廖昌勇  &nbsp;&nbsp; 15801881818 <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
       					北京 &nbsp;&nbsp; 海淀区  &nbsp;&nbsp;海淀南路188号院2号楼
					</div><hr>
					
					&nbsp;&nbsp;&nbsp;&nbsp;
					 支付及配送方式                      <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="payDispatching" checked="checked">
					  货到付款 &nbsp;&nbsp;<font style="font-size: 12px;">公司送货上门</font>
      				 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="payDispatching">
					  在线支付 &nbsp;&nbsp;<font style="font-size: 12px;">快递包邮</font><hr />
					 
					 &nbsp;&nbsp;&nbsp;&nbsp;
					  发票信息                      <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="invoice" checked="checked">
					 	个人明细
      				 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="radio" name="invoice">
						公司明细
				</div>
			</div>
		    <div style="width: 685px;margin-left: 100px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	商品清单
			    </span>
			    <span class="span_btn">
			    	<% 
			    		Object product =  request.getParameter("product");
			    		Object clientId = request.getParameter("clientId");
			    	%>
			    	<input type="hidden" class="product" value="<%=product %>">
			    	<a href="selectProduct.jsp?clientId=<%=clientId %>">
			    		<button class="layui-btn layui-btn-radius">返回</button>
			    	</a>
			    </span>
		    </div>
			<table class="layui-hide" id="test"></table>
			<div class="div_c">
			 	<font color="red">2</font> 件商品，总商品金额：    ￥53000.00元
			</div>
			<div class="div_c">
			 	 运费：  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       ￥0.00元
			</div> 
			<div class="div_c">
			 	 应付总额：      ￥53000.00元
			</div>
			<div style="width: 685px;margin-left: 100px;">
		    	<hr>
		    </div>
		    <div style="font-size: 18px;margin-left: 100px;width: 685px;height: 70px;line-height:70px;text-align: right;">
		    	应付总额：<font color="red">￥53000.00元 </font>&nbsp; &nbsp; &nbsp;
		    	<button class="layui-btn">提交订单</button> 
		    </div>
		</div>
		
		<script>
			var product = $(".product").val();
			layui.use(['table','layer'], function(){
			  var table = layui.table;
			  table.render({
			    elem: '#test'
			    ,url:'../../../selectProductByIdAction?product='+product
			    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			    ,cols: [[
			      {field:'productName', width:135, title: '商品名称'}
			      ,{field:'productTypeNumber', width:135, title: '型号'}
			      ,{field:'price', width:135, title: '单价(单位:万元)'}
			      ,{field:'productNumber', width:135, title: '数量'}
			      ,{field:'productNumber', title: '库存', width: '30%', width: 138,templet:'#inventoryLet'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
			    ]]
			  });
			  $(".ddr").click(function(){
			  	layer.open({
			  		type:1,
			  		title:"收货地址"
			  		,content:"<div>fds</div>"
			  		,area: ['390px', '260px']
			  		,btn: ['火速围观', '残忍拒绝']
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
		<script type="text/html" id="inventoryLet">
		 	 {{d.productNumber==0?'售罄':'有货'}}
		</script>
	</body>
</html>
