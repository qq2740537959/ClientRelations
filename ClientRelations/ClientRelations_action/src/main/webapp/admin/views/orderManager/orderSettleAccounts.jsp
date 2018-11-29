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
		<script type="text/javascript" src="../../js/jquery.cookie.js"></script>
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
			.layui-btn{
				background-color:rgb(31,147,231);
			}
			.layui-laypage .layui-laypage-curr .layui-laypage-em {
				background-color:rgb(31,147,231);
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
		    		Object clientId = request.getParameter("clientId");
					
		    	%>
				<input type="hidden" name="consigneeName" class="consigneeName">
				<input type="hidden" name="phone" class="phone">
				<input type="hidden" name="province" class="province">
				<input type="hidden" name="city" class="city">
				<input type="hidden" name="area" class="area">
				<input type="hidden" name="detailAddress" class="detailAddress">
				<form action="../../../projectPay" method="post">
					<div style="font-size: 17px;">
						&nbsp;&nbsp;&nbsp;&nbsp;
						收货人信息 &nbsp;&nbsp;
						<span class="ddr" style='display:block;width:60px;height: 30px;margin-top: -25px;margin-left: 150px;text-align: center;line-height: 30px;background-color: rgb(31,147,231);color: white;'>修改</span><br>
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
					<input type="hidden" name="orderMoney" class="orderMoney">
			    	<input type="hidden" name="commodity" class="commodity">
			    	<input type="hidden" name="commodityNumber" class="commodityNumber">
			    	<input type="hidden" value="<%=clientId %>" name="clientId" class="client">
		   			<input type="hidden" value="${userInfo.staffId }" name="staffId" class="staffId">
		   			<input type="hidden" name="shippingAddressId" class="shippingAddressId">
		   			<input type="hidden" name="shippingDetail" class="shippingDetail">
				</form>
			</div>
		    <div style="width: 685px;margin-left: 100px;margin-top: 50px;">
		    	<hr>
		    </div>
		    <div class="div_title_btn">
		    	<span class="span_title">
			    	商品清单
			    </span>
			    <span class="span_btn">
			    	<input type="hidden"  name="product" class="product" value="30>">
			    	<a href="selectProduct.jsp?clientId=<%=clientId %>">
			    		<button class="layui-btn layui-btn-radius">返回</button>
			    	</a>
			    </span>
		    </div>
			<table class="shopping" border="1" bordercolor="#E6E6E6" style="margin-left:90px;text-align:center;width:690px;font-size: 14px;color: #666;">
			</table><br />
			<div class="div_c">
			 	<font color="red" class="totalNumber">20</font> 件商品，总商品金额：    ￥<span class="totalMoney"></span>元
			</div>
			<div class="div_c">
			 	 运费：  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   ￥0.00元
			</div> 
			<div class="div_c">
			 	 应付总额：      ￥<span class="totalMoney"></span>元
			</div>
			<div style="width: 685px;margin-left: 100px;">
		    	<hr>
		    </div>
		    <div style="font-size: 18px;margin-left: 100px;width: 685px;height: 70px;line-height:70px;text-align: right;">
		    	应付总额：<font color="red">￥<span class="totalMoney"></span>元 </font>&nbsp; &nbsp; &nbsp;
		    	<div class="sub-order layui-btn">提交订单</div> 
		    </div>
		</div>
	<script type="text/javascript">
		var ary = new Array();
		var ddd = $.cookie('the_cookie');
		ary=ddd.split(","); //字符分割 
		let subArrayNum = 5;
		var dataArr = new Array(Math.ceil(ary.length / subArrayNum));
        for(let i = 0; i < dataArr.length;i++) {
            dataArr[i] = new Array();
            for(let j = 0; j < subArrayNum; j++) {
                dataArr[i][j] = '';
            }
        }
        for(let i = 0; i < ary.length;i++) {
            dataArr[parseInt(i / subArrayNum)][i % subArrayNum] = ary[i]; 
        }
        $(".shopping").empty();
        var totalMoney = 0;//总数量
		var totalNumber = 0;//总金额
		var productNumber = "";
		var product = "";
		var shippingDetail = "";
        var a = "<tr style='height:45px;' bgcolor='#F2F2F2'><th>商品名称</th><th>型号</th><th>单价（单位：万元）</th><th>数量</th></tr>";
        for (var i = 0; i < dataArr.length; i++) {
        	a+="<tr style='height:45px;'><td>"+dataArr[i][1]+"</td><td>"+dataArr[i][2]+"</td><td>"+dataArr[i][3]+"</td><td>x"+dataArr[i][4]+"</td></tr>";
        	totalMoney += parseInt(dataArr[i][3]);
        	totalNumber += parseInt(dataArr[i][4]);
        	productNumber += parseInt(dataArr[i][0])+","+parseInt(dataArr[i][4])+"-";
        	shippingDetail += dataArr[i][1]+" x"+dataArr[i][4]+",";
        	product += dataArr[i][1]+",";
		}
        $(".shippingDetail").val(shippingDetail);
        $(".commodity").val(product);
        $(".totalMoney").empty();
        $(".totalNumber").empty();
        $(".totalMoney").html(totalMoney);
        $(".totalNumber").html(totalNumber);
        $(".commodityNumber").val(totalNumber);
        $(".orderMoney").val(totalMoney);
        $(".shopping").append(a);
		var clientId = $(".client").val();
		var product = $(".product").val();
			layui.use(['table','layer'], function(){
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
	 					$(".shippingAddressId").val(data.id);
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
			function test(a){
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
									success:function(a){
										if(a == 'success'){
											if(data == null){
												$.ajax({
													  url:'../../../selectAddressByClidentId?clientId='+clientId,
													  type:'post',
													  dataType:'json',
													  success:function(dd){
														  if(dd != null){
															$(".shippingAddressId").val(dd.id);
														  }
													  }
												  });
											} 
										}
										
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
					$.ajax({
						url:'../../../reduceProductNumber',
						type:'post',
						data:'productNumber='+productNumber,
						success:function(data){
							console.log(data);
						}
					});
					if(modeOfPayment == '货到付款'){
						location.href = "../../../cashOnDelivery?orderIndent="+$("form").serialize();
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
