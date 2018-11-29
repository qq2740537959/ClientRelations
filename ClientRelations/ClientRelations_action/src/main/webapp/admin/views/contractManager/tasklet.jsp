<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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
			.layui-btn{
				background-color:rgb(31,147,231);
			}
			.layui-laypage .layui-laypage-curr .layui-laypage-em {
				background-color:rgb(31,147,231);
			}
		</style>
	</head>
	<body>
		<form method = "post" id = "she">
		<div class="div_total" id = "total">
			<input type="hidden" name="contractId" class="contractId" value="${param.contractId}" />
			
			<h3>合同管理 >> 提交合同</h3>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label>
				<div class = "layui-input-inline">
					<input type="text" size="67px;" name = "contractName" class="layui-input contractName" />
				</div>				
			</div>
			<div style="margin-top: 30px;margin-left: 70px;float: left;">
				<div style="float:left">
					<label class = "layui-form-label">合同类型：</label>
					<div class = "layui-input-inline">
						<select class = "contractType layui-select" name = "contractType" >
							
						</select>
					</div>
				</div>
				<div style="float: left;margin-left: 171px;">
					<label>合同金额：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "contractMoney" class = "layui-input contractMoney"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 27px;">
					<label>甲方：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "ownCompany" class = "layui-input ownCompany"/>
					</div>
				</div>
				<div style="float: left;margin-left: 102px;">
					<label>乙方：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "otherCompany" class = "layui-input otherCompany"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 43px;">
				<div style="float: left;">
					<label>企业经营许可证号：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "myselfLicence" class = "layui-input myselfLicence"/>
					</div>
				</div>
				<div style="float: left;margin-left:19px;">
					<label>企业经营许可证号：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "anotherLicence" class = "layui-input anotherLicence"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 431px;">
				<div style="float: left;">
					<label>待处理人：</label>
					<div class = "layui-input-inline">
						<select name = "staffId" class = "layui-select staffId">
						
						</select>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 62px;">
				<label class = "layui-form-label" style = "margin-top:75px;">合同内容：</label>
				<textarea style="width: 513px;height: 150px;margin-top: 20px;" name = "contractContent" class = "contractContent"></textarea>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 62px;">
				<label class = "layui-form-label" style = "margin-top:51px;">备注信息：</label>
				<textarea style="width: 513px;height: 100px;margin-top: 20px;" name = "remarks" class = "remarks"></textarea>
			</div>
			<div style="float: left;margin-top: 39px;width:200px ;height: 100px;margin-left: 325px;">
				<input type="button" value="提交"  id = "gucation" class = "layui-btn"/>
				
				<input type="button" value="返回"  id = "back" class = "layui-btn"/>
			</div>
		</div>
		</form>
		<script type = "text/javascript">
			function voice(){
			}
			voice();
			
			$.ajax({
	 	  		url:'../../../singnAction?contractId='+$(".contractId").val(),
	 	  		type:'post',
	 	  		success:function(data){
	 	  			var typeId = '';
	 	  			for(var i = 0;i<data.length;i++){
	 	  				$(".contractName").val(data[i].contractName);
	 	  				$(".contractType").val(data[i].contractType);
	 	  				typeId = data[i].contractType;
	 	  				$(".contractMoney").val(data[i].contractMoney);
	 	  				$(".ownCompany").val(data[i].ownCompany);
	 	  				$(".otherCompany").val(data[i].otherCompany);
	 	  				$(".myselfLicence").val(data[i].myselfLicence);
	 	  				$(".anotherLicence").val(data[i].anotherLicence);
	 	  				$(".contractContent").val(data[i].contractContent);
	 	  				$(".remarks").val(data[i].remarks);
	 	  				$(".staffName").val(data[i].staffName);
	 	  			}
	 	  			
	 	  			$.ajax({
						url:'../../../voiceAction',
						type:'post',
						success:function(data2){
							$(".contractType").empty();
							var arr = "";
							for(var j = 0;j<data2.length;j++){
								if(data2[j].genreId == typeId){
									arr += "<option value = "+data2[j].genreId+" selected = 'selected'>"+data2[j].genreName+"</option>";
								}else{
									arr += "<option value = "+data2[j].genreId+">"+data2[j].genreName+"</option>";
								}
							}
							$(".contractType").html(arr);
						},error:function(){
							alert("网络错误！");
						}
					})
	 	  		},error:function(){
	 	  			alert("网络错误！");
	 	  		}
	 	  	})
	 	  	
	 	   	function modification(){
				$("#embrace").on("click",function(){
					alert(1)
					$.ajax({
						url:'../../../transformAction?con.contractId='+$(".contractId").val(),
						type:'post',
						data:$("#hey").serialize(),
						success:function(data){
							console.log(data)
						},error:function(){
							alert("网络错误！");	
						} 
					})
				})
			}
			modification();
			
			function Antrag(){
				$.ajax({
					url:'../../../presentAction',
					type:'post',
					success:function(data){
						$(".staffId").empty();
						var because = "";
						console.log(data)
						for(var i = 0;i<data.length;i++){
							if(data[i].roleIdentity == 3){
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
			
			function babyTrage(){
				$("#gucation").on("click",function(){
					$.ajax({
						url:'../../../someBodyAction?con.contractId='+$(".contractId").val(),
						data:$("#she").serialize(),
						type:'post',
						success:function(data){
							var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
							parent.layer.msg("提交成功！");
							parent.layer.close(index);
							parent.refershuaxin();
						},error:function(){
							alert("网络错误！");
						}
					})
				})
			}
			babyTrage();
			
			function duack(){
				$("#back").on("click",function(){
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					parent.layer.msg("返回成功！");
					parent.layer.close(index);
					parent.refershuaxin();
				})
			}
			duack();
		</script>
	</body>
</html>