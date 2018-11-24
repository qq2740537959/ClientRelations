<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML >
<html lang="UTF-8">
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
			.layui-form-select .layui-input{
				width:120px;
			}
			.layui-input,.layui-textarea{
				width: 200px;
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
				<% 
		    		Object product =  request.getParameter("product");
		    		Object clientId = request.getParameter("clientId");
		    		Object number = request.getParameter("number");
		    		Object price = request.getParameter("price");
		    	%>
				<input type="hidden" name="consigneeName" class="consigneeName">
				<input type="hidden" name="phone" class="phone">
				<input type="hidden" name="province" class="province">
				<input type="hidden" name="city" class="city">
				<input type="hidden" name="detailAddress" class="detailAddress">
				<form action="../../../projectPay" method="post">
					<div style="font-size: 17px;">
						&nbsp;&nbsp;&nbsp;&nbsp;
						收货人信息 &nbsp;&nbsp;
						<span class="ddr" style='display:block;width:60px;height: 30px;margin-top: -25px;margin-left: 150px;text-align: center;line-height: 30px;background-color: rgb(0,150,136);color: white;'>修改</span><br>
						<div class="shippingAddress">
						</div><hr>
						&nbsp;&nbsp;&nbsp;&nbsp;
						 支付及配送方式                      <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 <input type="radio" name="modeOfPayment" value="货到付款" checked="checked">
						  货到付款 &nbsp;&nbsp;<font style="font-size: 12px;">公司送货上门</font>
	      				 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 <input type="radio" name="modeOfPayment" value="支付宝">
						  在线支付 &nbsp;&nbsp;<font style="font-size: 12px;">快递包邮</font><hr />
						 
						 &nbsp;&nbsp;&nbsp;&nbsp;
						  发票信息                      <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 <input type="radio" value="个人" name="commercialVoucher" checked="checked">
						 	个人明细
	      				 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 <input type="radio" value="公司" name="commercialVoucher">
							公司明细
					</div>
					<input type="hidden" name="orderMoney" value="<%=price %>">
			    	<input type="hidden" name="commodity" class="commodity">
			    	<input type="hidden" name="commodityNumber" value="<%=number %>">
			    	<input type="hidden" value="<%=clientId %>" name="clientId" class="client">
		   			<input type="hidden" value="<%=clientId %>" name="staffId">
				</form>
			</div>
		    <div style="width: 685px;margin-left: 100px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	商品清单
			    </span>
			    <span class="span_btn">
			    	<input type="hidden"  name="product" class="product" value="<%=product %>">
			    	<a href="selectProduct.jsp?clientId=<%=clientId %>">
			    		<button class="layui-btn layui-btn-radius">返回</button>
			    	</a>
			    </span>
		    </div>
			<table class="layui-hide" id="test"></table>
			<div class="div_c">
			 	<font color="red"><%=number %></font> 件商品，总商品金额：    ￥<%=price %>元
			</div>
			<div class="div_c">
			 	 运费：  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   ￥0.00元
			</div> 
			<div class="div_c">
			 	 应付总额：      ￥<%=price %>元
			</div>
			<div style="width: 685px;margin-left: 100px;">
		    	<hr>
		    </div>
		    <div style="font-size: 18px;margin-left: 100px;width: 685px;height: 70px;line-height:70px;text-align: right;">
		    	应付总额：<font color="red">￥<%=price %>元 </font>&nbsp; &nbsp; &nbsp;
		    	<div class="sub-order layui-btn">提交订单</div> 
		    </div>
		</div>
		<script type="text/javascript">
			var clientId = $(".client").val();
			var product = $(".product").val();
			layui.use(['table','layer'], function(){
			  var table = layui.table;
			  table.render({
			    elem: '#test'
			    ,url:'../../../selectProductById?product='+product
			    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			    ,cols: [[
			      {field:'productName', width:135, title: '商品名称'}
			      ,{field:'productTypeNumber', width:135, title: '型号'}
			      ,{field:'price', width:135, title: '单价(单位:万元)'}
			      ,{field:'productNumber', width:135, title: '数量'}
			      ,{field:'productNumber', title: '库存', width: '30%', width: 138,templet:'#inventoryLet'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
			    ]]
			  });
			  /* 查询客户的收货地址 */
			  $.ajax({
				  url:'../../../selectAddressByClidentId?clientId='+clientId,
				  type:'post',
				  dataType:'json',
				  success:function(data){
					  if(data != null){
						$(".consigneeName").val(data.consigneeName);
						$(".phone").val(data.phone);
						$(".province").val(data.province);
						$(".city").val(data.city);
						$(".area").val(data.area);
						$(".detailAddress").val(data.detailAddress);
						$(".shippingAddress").empty();
						$(".shippingAddress").empty();
	 					$(".shippingAddress").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+data.consigneeName+"  &nbsp;&nbsp; "+data.phone+" <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+data.province+" &nbsp;&nbsp; "+data.city+"  &nbsp;&nbsp;"+data.area+"&nbsp;&nbsp;"+data.detailAddress+"  ");
					  }
				  }
			  });
			  $(".ddr").click(function(){
			  	layer.open({
			  		type:2,
			  		title:"收货地址"
			  		,content:"shippingAddress.jsp?clientId="+clientId
					,area: ['550px', '430px']
			  	})
			  })
			});
			$.ajax({
				url:'../../../selectProductByIdes?product='+product,
				type:'post',
				success:function(data){
					$(".commodity").val(data);
				}
			});
			function test(a){
				console.log(a);
				var city = "";
				city += a[2].value+",";
				city += a[3].value+",";
				city += a[4].value+",";
				var province = "";
				var citys = "";
				var area = "";
				
				$.ajax({
					url:'../../../selectTpById?city='+city,
					type:'post',
					dataType:'json',
					success:function(data){
						for (var i = 0; i < data.length; i++) {
							if(i == 0){
								province = data[i].name;
							}else if(i == 1){
								citys = data[i].name;
							}else if(i == 2){
								area = data[i].name;
							}
						}
						// 查询客户收货地址 
						 $.ajax({
							  url:'../../../selectAddressByClidentId?clientId='+clientId,
							  type:'post',
							  dataType:'json',
							  success:function(data){
								  var address = "";
								  if(data == null){
									  // 不存在就添加收货地址 
									  address = "addAddress";
								  }else{
									  // 存在就修改收货地址 
									  address = "updateAddress";
								  }
								  $.ajax({
									url:'../../../'+address,
									type:'post',
									data:'consigneeName='+a[0].value+'&phone='+a[1].value+'&province='+province+'&city='+citys+'&area='+area+'&detailAddress='+a[5].value+'&clientId='+clientId,
									success:function(data){
									}
								}); 
							  }
						  });
						$(".consigneeName").val(a[0].value);
						$(".phone").val(a[1].value);
						$(".province").val(province);
						$(".city").val(citys);
						$(".area").val(area);
						$(".detailAddress").val(a[5].value);
						$(".shippingAddress").empty();
						 //拼接显示到页面
						$(".shippingAddress").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+a[0].value+"  &nbsp;&nbsp; "+a[1].value+" <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+province+" &nbsp;&nbsp; "+citys+"  &nbsp;&nbsp;"+area+"&nbsp;&nbsp;"+a[5].value+"  ");
					}
				});
			}
			$(".sub-order").click(function(){
				var modeOfPayment = $("input[name='modeOfPayment']:checked").val();
				var consigneeName = $(".consigneeName").val();
				var prov = $(".province").val();
				var c = $(".city").val();
				var area = $(".area").val();
				var detail = $(".detailAddress").val();
				if(consigneeName.length != 0 && prov.length != 0 && c.length != 0 && area.length != 0 && detail.length != 0){
					if(modeOfPayment == '货到付款'){
						location.href="changeHands.jsp";
					}else if(modeOfPayment == '支付宝'){
						$("form").submit();
					}
				}else{
					alert("请将收货地址信息填写完整！");
				}
			});
			
		</script>
		<script type="text/html" id="inventoryLet">
		 	 {{d.productNumber==0?'售罄':'有货'}}
		</script>
	</body>
</html>
