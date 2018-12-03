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
		<script type = "text/javascript" src = "../../js/jquery.cookie.js"></script>
		<style>
			.div_total{
				width: 1000px;
				height: 610px;
				padding-left:0px;
				margin-top: 0px;
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
		<form method = "post" id = "king">
		<div class="div_total">
			<h3>合同管理 >> 合同审核</h3>
			<input type = "hidden" name = "contractId" class = "contractId" value = "${param.contractId }">
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label>
				<div class = "layui-input-inline">
					<input type="text" size="67px;" name = "contractName" class = "layui-input contractName"/>				
				</div>
			</div>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<div style="float:left">
					<label>合同金额：</label>
					<div class = "layui-input-inline">
						<input type="text"  style="width: 75px;" name = "contractMoney" class = "layui-input contractMoney"/>
					</div>
				</div>
				<div style="float: left;margin-left: 246px;">
					<label class = "layui-form-label">合同类型：</label>
					<div class = "layui-input-inline">
						<select class = "contractType layui-select" name = "contractType" >
							
						</select>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 11px;">
					<label>客户方：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "otherCompany" class = "layui-input otherCompany"/>
					</div>
				</div>
				<div style="float: left;margin-left: 190px;">
					<label>合同状态：</label>
					<div class = "layui-input-inline">
						<select name = "contractState" class = "layui-select contractState">
						
						</select>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 110px;">
				<div style="float: left;">
					<label>创建人：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "establish" class = "layui-input establish"/>
					</div>
				</div>
				<div style="float: left;margin-left:72px;">
					<label>创建时间：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "lastTime" class = "layui-input lastTime"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 94px;">
				<div style="float: left;">
					<label>待处理人：</label>
					<div class = "layui-input-inline">
						<select name = "staffId" class = "layui-select staffId">
						
						</select>
					</div>
				</div>
				<div style="float: left;margin-left:162px;">
					<label>经营许可证号：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "anotherLicence" class = "layui-input anotherLicence"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 58px;">
				<label class = "layui-form-label" style = "margin-top:75px;">合同内容：</label>
				<textarea style="width: 508px;height: 150px;margin-top: 20px;" name = "contractContent" class = "contractContent"></textarea>				
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 58px;">
				<label class = "layui-form-label" style = "margin-top:20px;">审批意见：</label>
				<textarea style="width: 508px;height: 100px;margin-top: 20px;" name = "examine" class = "examine"></textarea>
			</div>
			<div style="float: left;margin-top: 39px;width:249px ;height: 100px;margin-left: 300px;">
				<input type="button" value="通过"  id = "repair" class = "layui-btn"/>
				<input type="button" value="打回"  id = "fight" class = "layui-btn"/>
				<input type="button" value="返回"  id = "back" class = "layui-btn"/>
			</div>
		</div>
		</form>
		<script type = "text/javascript">
			function appState(){
				$.ajax({
					url:'../../../authorityAction?contractId='+$(".contractId").val(),
					type:'post',
					success:function(data){
						var typeId = '';
						var stateId = '';
						for(var i = 0;i<data.length;i++){
							$(".contractName").val(data[i].contractName);
							$(".contractMoney").val(data[i].contractMoney);
							$(".contractType").val(data[i].contractType);
							typeId = data[i].contractType;
							stateId = data[i].contractState;
							$(".otherCompany").val(data[i].otherCompany);
							$(".contractState").val(data[i].contractState);
							$(".establish").val(data[i].establish);
							$(".lastTime").val(data[i].lastTime);
							$(".staffId").val(data[i].staffId);
							$(".anotherLicence").val(data[i].anotherLicence);
							$(".contractContent").val(data[i].contractContent);
							$(".examine").val(data[i].examine);
							
							console.log(data[i].staffIdTwo);
						}
						
						$.ajax({
							url:'../../../voiceAction',
							type:'post',
							success:function(data2){
								$(".contractType").empty();
								var arr = "";
								for(var j = 0;j<data2.length;j++){
									if(data2[j].genreId == typeId){
										arr+="<option value = "+data2[j].genreId+" selected = 'selected'>"+data2[j].genreName+"</option>";
									}else{
										arr+="<option value = "+data2[j].genreId+">"+data2[j].genreName+"</option>";
									}
								}
								$(".contractType").html(arr);
							},error:function(){
								alert("网络错误！");
							}
						})
						
						$.ajax({
							url:'../../../patternAction',
							type:'post',
							success:function(data3){
								$(".contractState").empty();
								var ary = "";
								for(var k = 0;k<data3.length;k++){
									if(data3[k].shapeId == stateId){
										ary+="<option value = "+data3[k].shapeId+" selected = 'selected'>"+data3[k].shapeName+"</option>";
									}else{
										ary+="<option value = "+data3[k].shapeId+">"+data3[k].shapeName+"</option>";
									}
								}
								$(".contractState").html(ary);
							},error:function(){
								alert("网络错误！");
							}
					   })
						
					},error:function(){
						alert("网络错误！");
					}
				})
			}
			appState();
			
			function Antrag(){
				$.ajax({
					url:'../../../presentAction',
					type:'post',
					success:function(data){
						$(".staffId").empty();
						var because = "";
						for(var i = 0;i<data.length;i++){
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
							var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
							parent.layer.msg("打回成功！");
							parent.layer.close(index);
							parent.refershuaxin();
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