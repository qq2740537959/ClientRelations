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
		<form method = "post" id = "hey">
		<div class="div_total" id = "total">
			<input type="hidden" name="contractId" class="contractId" value="${param.contractId}" />
			<h3>合同管理 >> 修改合同</h3>
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
						<input type = "text" name = "contractMoney" class = "contractMoney layui-input"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 27px;">
					<label>甲方：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "ownCompany" class = "ownCompany layui-input"/>
					</div>
				</div>
				<div style="float: left;margin-left: 105px;">
					<label>乙方：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "otherCompany" class = "otherCompany layui-input"/>
					</div>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 43px;">
				<div style="float: left;">
					<label>企业经营许可证号：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "myselfLicence" class = "myselfLicence layui-input"/>
					</div>
				</div>
				<div style="float: left;margin-left:21px;">
					<label>企业经营许可证号：</label>
					<div class = "layui-input-inline">
						<input type = "text" name = "anotherLicence" class = "anotherLicence layui-input"/>
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
				<input type="button" value="保存"  id = "embrace" class = "layui-btn"/>
				
				<input type="button" value="返回"  id = "back" class = "layui-btn"/>
			</div>
		</div>
		</form>
		<script type = "text/javascript">
			function voice(){
			}
			voice();
			
			$.ajax({
	 	  		url:'../../../examineAction?contractId='+$(".contractId").val(),
	 	  		type:'post',
	 	  		success:function(data){
	 	  			console.log(data)
	 	  			var typeId = '';
	 	  			for(var i = 0;i<data.length;i++){
	 	  				data[i].contractType
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
	 	  			}
	 	  			
	 	  			$.ajax({
 						url:'../../../voiceAction',
 						type:'post',
 						success:function(data2){
 							$(".contractType").empty();
 							var arr = "";
 							for(var j = 0;j<data2.length;j++){
 								if (data2[j].genreId == typeId) {
									arr += "<option value = "+data2[j].genreId+" selected=\"selected\">"+data2[j].genreName+"</option>"
								}else{
									arr +="<option value = "+data2[j].genreId+">"+data2[j].genreName+"</option>";
								}
 							}
 							$(".contractType").append(arr);
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
					$.ajax({
						url:'../../../transformAction?con.contractId='+$(".contractId").val(),
						type:'post',
						data:$("#hey").serialize(),
						success:function(data){
							var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
							parent.layer.msg("修改成功！");
							parent.layer.close(index);
							parent.refershuaxin();
						},error:function(){
							alert("网络错误！");	
						} 
					})
				})
			}
			modification();
			
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

