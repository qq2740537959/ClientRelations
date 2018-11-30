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
		<form method = "post" id = "huy">
		<div class="div_total">
			<input type = "hidden" name = "contractId" class = "contractId" value = "${param.contractId }">
			<h3>合同管理 >> 转让合同</h3>
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
				<div style="float: left;margin-left:184px;">
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
				<div style="float: left;margin-left:161px;">
					<label>经营许可证号：</label>
					<input type = "text" name = "anotherLicence" class = "anotherLicence"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>合同内容：</label>
				<input style="width: 499px;height: 150px;border: 1px solid;margin-top: 20px;" name = "contractContent" class = "contractContent"/>
					
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>备注信息：</label>
				<input style="width: 499px;height: 50px;border: 1px solid;margin-top: 20px;" name = "remarks" class = "remarks"/>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>变更原因：</label>
				<input style="width: 499px;height: 100px;border: 1px solid;margin-top: 20px;" name = "reasonsChange" class = "reasonsChange"/>
			</div>
			<div style="float: left;margin-top: 39px;width:200px ;height: 100px;margin-left: 325px;">
				<input type="button" value="保存" style = "width:80px; height:30px;" id = "Ability"/>
				
				<a href="" style="display: block; width: 58px;height: 23px;border: 1px solid;padding-top: 5px;padding-left: 20px;float: right;">返回</a>
			</div>
		</div>
		</form>
		<script type = "text/javascript">
			function appState(){
				$.ajax({
					url:'../../../authorityAction?contractId='+$(".contractId").val(),
					type:'post',
					success:function(data){
						console.log(data)
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
							$(".performance").val(data[i].performance);
							$(".remarks").val(data[i].remarks);
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
						var pdd = "";
						for(var i = 0;i<data.length;i++){
							pdd+="<option value = "+data[i].shapeId+">"+data[i].shapeName+"</option>";
						}
						$(".contractState").html(pdd);
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
			
			function easyTable(){
				$("#Ability").on("click",function(){
					$.ajax({
						url:'../../../trainAction?con.contractId='+$(".contractId").val(),
						data:$("#huy").serialize(),
						type:'post',
						success:function(data){
							var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
							parent.layer.msg("变更成功！");
							parent.layer.close(index);
							parent.referkop();
						},error:function(){
							alert("网络错误！");
						}
					})
				})
			}
			easyTable();
		</script>
	</body>
</html>