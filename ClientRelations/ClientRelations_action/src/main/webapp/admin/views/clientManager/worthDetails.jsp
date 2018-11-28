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
		<title>客户消费记录</title>
		<script src="../../js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="../../assets/css/view.css" />
		<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css" />
		<script src="../../layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			.main_div {
				width: 800px;
				margin: auto;
			}
			
			.float_left {
				float: left;
			}
			
			.width_div {
				width: 270px;
				line-height: 28px;
			}
			
			.infoTrdiv span {
				font-weight: 800;
			}
		</style>
	</head>
	<body>
		
		<div class="main_div">
			<!-- 客户id -->
			<input type="hidden" name="clientId" class="cId" />
			<div class="layui-collapse" lay-accordion>
				<div class="layui-colla-item">
					<h2 class="layui-colla-title">客户信息</h2>
					<div class="layui-colla-content layui-show clientInfo">
						<div class="infoTrdiv">
							<div class="width_div float_left"><span>客户姓名：</span>余卓越</div>
							<div class="width_div float_left"><span>客户生日：</span>1955-20-20</div>
							<div style="clear: both;"></div>
						</div>
						<div class="infoTrdiv">
							<div class="width_div float_left"><span>手机号码：</span>余卓越</div>
							<div class="width_div float_left"><span>办公电话：</span>1955-20-20</div>
							<div style="clear: both;"></div>
						</div>
						<div class="infoTrdiv">
							<div class="width_div float_left"><span>性别：</span>余卓越</div>
							<div class="width_div float_left"><span>邮箱：</span>1955-20-20</div>
							<div style="clear: both;"></div>
						</div>
						<div class="infoTrdiv">
							<div class="width_div float_left"><span>客户生日：</span>余卓越</div>
							<div class="width_div float_left"><span>录入时间：</span>1955-20-20</div>
							<div style="clear: both;"></div>
						</div>
						<div class="infoTrdiv">
							<div class="width_div float_left"><span>客户类型：</span>余卓越</div>
							<div class="width_div float_left"><span>联系地址：</span>1955-20-20</div>
							<div style="clear: both;"></div>
						</div>
						<div class="infoTrdiv">
							<div class="width_div float_left"><span>购买次数：</span>余卓越</div>
							<div class="width_div float_left"><span>消费总金额：</span>1955-20-20</div>
							<div style="clear: both;"></div>
						</div>
						<div class="infoTrdiv">
							<div style="margin-left: 30px;">
								<span>备注信息：</span>余卓越
							</div>
						</div>
					</div>
				</div>
				<div class="layui-colla-item">
					<h2 class="layui-colla-title">消费历史</h2>
					<div class="layui-colla-content layui-show">
						<table class="layui-table">
							<colgroup>
								<col width="80">
								<col width="120">
								<col>
							</colgroup>
							<thead>
								<tr>
									<th>订单号</th>
									<th>订购商品</th>
									<th>订单时间</th>
									<th>订单数量</th>
									<th>订单状态</th>
									<th>配送方式</th>
								</tr>
							</thead>
							<tbody id="content">
								<tr>
									<td>8324843515</td>
									<td>曲率生成器</td>
									<td>2018-9-11</td>
									<td>1</td>
									<td>已完成</td>
									<td>公司送货上门</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script>
			//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
			layui.use('element', function() {
				var element = layui.element;
				//…
			});
			$(function(){
			/* 	$.ajax({
					url:'../../../selectClientInfo',
					data:{
						clientId: $(".cId").val()
					},
					success:function(data){
						console.log(data);
					},error:function(){
						alert("连接网络失败！");
					}
				}); */
			});
			/* windos.onload(){
				
			}; */
			function onLoadCid(){
				var aa = $(".cId").val();
				console.log("hjkhkjhkjufg==id=="+aa);
				$.ajax({
					url:'../../../selectClientInfo',
					data:{
						clientId: $(".cId").val()
					},
					success:function(data){
						console.log(data);
						$(".clientInfo").empty();
						let con = "";
						con +="<div class='infoTrdiv'><div class='width_div float_left'><span>客户姓名：</span>"+data.clientName+"</div><div class='width_div float_left'><span>客户生日：</span>"+data.birthday+"</div><div style='clear: both;'></div></div>"+
			"<div class='infoTrdiv'><div class='width_div float_left'><span>手机号码：</span>"+data.phone+"</div><div class='width_div float_left'><span>办公电话：</span>"+data.workPhone+"</div><div style='clear: both;'></div></div>"+
			"<div class='infoTrdiv'><div class='width_div float_left'><span>性别：</span>"+data.sex+"</div><div class='width_div float_left'><span>邮箱：</span>"+data.email+"</div><div style='clear: both;'></div></div>"+
			"<div class='infoTrdiv'><div class='width_div float_left'><span>客户生日：</span>"+data.birthday+"</div><div class='width_div float_left'><span>录入时间：</span>"+data.inTime+"</div><div style='clear: both;'></div></div>"+
			"<div class='infoTrdiv'><div class='width_div float_left'><span>客户类型：</span>"+data.clientType+"</div><div class='width_div float_left'><span>联系地址：</span>"+data.contactAddress+"</div><div style='clear: both;'></div></div>"+
			"<div class='infoTrdiv'><div class='width_div float_left'><span>购买次数：</span>"+data.consumptionTimes+"</div><div class='width_div float_left'><span>消费总金额：</span>"+data.totalConsumptionAmount+"</div><div style='clear: both;'></div></div>"+
			"<div class='infoTrdiv'><div style='margin-left: 30px;'><span>备注信息：</span>"+data.remark+"</div></div>";
						$(".clientInfo").append(con);
					},error:function(){
						alert("连接网络失败！");
					}
				});
				$.ajax({
					url:'../../../consumptionHistory',
					data: "clientId="+aa,
					success:function(msg){
						console.log(msg);
						$("#content").empty();
						let d = "";
						for (var i = 0; i < msg.data.length; i++) {
							var sa = msg.data[i];
							d += "<tr><td>"+sa.orderCode+"</td><td>"+sa.commodity+"</td><td>"+sa.dealTime+"</td><td>"+sa.commodityNumber+"</td>"+
							"<td>"+sa.orderStatus+"</td><td>"+sa.modeOfDistribution+"</td></tr>";
						}
						if (d == "") {
							d = "<tr colspan='6' align='center'>暂无购买记录</tr>";
						}
						$("#content").append(d);
					}
				});
			}
		</script>
	</body>

</html>