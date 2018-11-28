<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../../layui/css/layui.css" />
		<script src="../../layui/layui.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../../js/jquery-1.8.3.min.js" ></script>
		<style>
			.div_total{
				width: 1000px;
				height: 610px;
				padding-left:0px;
				margin-top: 0px;
			}
		</style>
	</head>
	<body>
		<form method = "post" id = "king">
		<div class="div_total">
			<h3>合同管理 >> 合同审核</h3>
			<input type = "hidden" name = "contractId" class = "contractId" value = "${param.contractId }">
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label><input type="text" size="67px;" name = "contractName" class = "contractName"/>				
			</div>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<div style="float:left">
					<label>合同金额：</label>
					<input type="text"  style="width: 75px;" name = "contractMoney" class = "contractMoney"/>
				</div>
				<div style="float: left;margin-left: 171px;">
					<label>合同类型：</label>
					<select class = "contractType" name = "contractType">
						
					</select>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 11px;">
					<label>客户方：</label>
					<input type = "text" name = "otherCompany" class = "otherCompany"/>
				</div>
				<div style="float: left;margin-left: 78px;">
					<label>合同状态：</label>
					<select name = "contractState" class = "contractState">
						
					</select>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 110px;">
				<div style="float: left;">
					<label>创建人：</label>
					<select name = "establish" class = "establish">
						
					</select>
				</div>
				<div style="float: left;margin-left:186px;">
					<label>创建时间：</label>
					<input type = "text" name = "lastTime" class = "lastTime"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 94px;">
				<div style="float: left;">
					<label>待处理人：</label>
					<select name = "staffId" class = "staffId">
						
					</select>
				</div>
				<div style="float: left;margin-left:162px;">
					<label>经营许可证号：</label>
					<input type = "text" name = "anotherLicence" class = "anotherLicence"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>合同内容：</label>
				<input style="width: 499px;height: 150px;border: 1px solid;margin-top: 20px;" name = "contractContent" class = "contractContent"/>
					
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>审批意见：</label>
				<input style="width: 499px;height: 100px;border: 1px solid;margin-top: 20px;" name = "examine" class = "examine"/>
					
			</div>
			<div style="float: left;margin-top: 39px;width:249px ;height: 100px;margin-left: 300px;">
				<input type="button" value="通过" style = "width:80px; height:30px;" id = "repair" />
				<input type="button" value="打回" style = "width:80px; height:30px;" id = "fight"/>
				<input type="button" value="返回" style = "width:80px; height:30px;" id = "back"/>
			</div>
		</div>
		</form>
		<script type = "text/javascript">
			function appState(){
				$.ajax({
					url:'../../../authorityAction?contractId='+$(".contractId").val(),
					type:'post',
					success:function(data){
						for(var i = 0;i<data.length;i++){
							$(".contractName").val(data[i].contractName);
							$(".contractMoney").val(data[i].contractMoney);
							$(".contractType").val(data[i].contractType);
							$(".otherCompany").val(data[i].otherCompany);
							$(".contractState").val(data[i].contractState);
							$(".establish").val(data[i].establish);
							$(".lastTime").val(data[i].lastTime);
							$(".staffId").val(data[i].staffId);
							$(".anotherLicence").val(data[i].anotherLicence);
							$(".contractContent").val(data[i].contractContent);
							$(".examine").val(data[i].examine);
						}
					},error:function(){
						alert("网络错误！");
					}
				})
			}
			appState();
			
			function voice(){
				$.ajax({
					url:'../../../voiceAction',
					type:'post',
					success:function(data){
						$(".contractType").empty();
						var arr = "";
						for(var i = 0;i<data.length;i++){
							arr+="<option value = "+data[i].genreId+">"+data[i].genreName+"</option>";
						}
						$(".contractType").html(arr);
					},error:function(){
						alert("网络错误！");
					}
				})
			}
			voice();
			
			function pattern(){
				$.ajax({
					url:'../../../patternAction',
					type:'post',
					success:function(data){
						$(".contractState").empty();
						var ary = "";
						for(var i = 0;i<data.length;i++){
							ary+="<option value = "+data[i].shapeId+">"+data[i].shapeName+"</option>";
						}
						$(".contractState").html(ary);
					},error:function(){
						alert("网络错误！");
					}
				})
			}
			pattern();
			
			function Antrag(){
				$.ajax({
					url:'../../../presentAction',
					type:'post',
					success:function(data){
						$(".staffId").empty();
						var because = "";
						for(var i = 0;i<data.length;i++){
							console.log(data[i])
							if(data[i].roleIdentity == 2){
								because += "<option value = "+data[i].staffId+">"+data[i].staffName+"</option>"
							}
						}
						$(".staffId").append(because)
					},error:function(){
						alert("网络错误！");
					}
				})
			}
			Antrag();
			
			function active(){
				$.ajax({
					url:'../../../presentAction',
					type:'post',
					success:function(data){
						$(".establish").empty();
						var hry = "";
						for(var i = 0;i<data.length;i++){
							hry += "<option value = "+data[i].staffId+">"+data[i].staffName+"</option>"
						}
						$(".establish").append(hry);
					},error:function(){
						alert("网络错误！");
					}
				})
			}
			active();
			
			function  weldHoldaing(){
				$("#repair").on("click",function(){
					$.ajax({
						url:'../../../processAction?con.contractId='+$(".contractId").val(),
						data:$("#king").serialize(),
						type:'post',
						success:function(data){
							var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
							parent.layer.msg("审核成功！");
							parent.layer.close(index);
							parent.referhuy();
						},error:function(){
							alert("网络错误！");
						}
					})
				})
			}
			weldHoldaing();
			
			function facebook(){
				$("#back").on("click",function(){
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					parent.layer.msg("返回成功！");
					parent.layer.close(index);
					parent.refershuaxin();
				})
			}
			facebook();
			
			function basketball(){
				$("#fight").on("click",function(){
					$.ajax({
						url:'../../../beachAction?con.contractId='+$(".contractId").val(),
						type:'post',
						data:$("#king").serialize(),
						success:function(data){
							console.log(data);
						},error:function(){
							alert("网络错误！");
						}
					})
				})
			}
			basketball();
		</script>
	</body>
</html>