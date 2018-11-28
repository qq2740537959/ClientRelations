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
		</style>
	</head>
	<body>
		<div class="div_total" id = "total">
			<input type="hidden" name="contractId" class="contractId" value="${param.contractId}" />
			<h3>合同管理 >> 合同详情</h3>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<label>合同名称：</label><input type="text" size="67px;" name = "con.contractName" class = "contractName"/>				
			</div>
			<div style="margin-top: 30px;margin-left: 100px;float: left;">
				<div style="float:left">
					<label>合同类型：</label>
					<select class = "contractType" name = "con.contractType" >
						
					</select>
				</div>
				<div style="float: left;margin-left: 171px;">
					<label>合同金额：</label>
					<input type = "text" name = "con.contractMoney" class = "contractMoney"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<div style="float: left;margin-left: 27px;">
					<label>甲方：</label>
					<input type = "text" name = "con.ownCompany" class = "ownCompany"/>
				</div>
				<div style="float: left;margin-left: 105px;">
					<label>乙方：</label>
					<input type = "text" name = "con.otherCompany" class = "otherCompany"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 43px;">
				<div style="float: left;">
					<label>企业经营许可证号：</label>
					<input type = "text" name = "con.myselfLicence" class = "myselfLicence"/>
				</div>
				<div style="float: left;margin-left:21px;">
					<label>企业经营许可证号：</label>
					<input type = "text" name = "con.anotherLicence" class = "anotherLicence"/>
				</div>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>合同内容：</label>
				<input style="width: 499px;height: 150px;border: 1px solid;margin-top: 20px;" name = "con.contractContent" class = "contractContent"/>
			</div>
			<div style="margin-top: 30px;float: left;margin-left: 100px;">
				<label>备注信息：</label>
				<input style="width: 499px;height: 100px;border: 1px solid;margin-top: 20px;" name = "con.remarks" class = "remarks"/>
			</div>
		</div>
		<script type = "text/javascript">
			$.ajax({
	 	  		url:'../../../examineAction?contractId='+$(".contractId").val(),
	 	  		type:'post',
	 	  		success:function(data){
	 	  			for(var i = 0;i<data.length;i++){
	 	  				$(".contractName").val(data[i].contractName);
	 	  				$(".contractType").val(data[i].contractType);
	 	  				$(".contractMoney").val(data[i].contractMoney);
	 	  				$(".ownCompany").val(data[i].ownCompany);
	 	  				$(".otherCompany").val(data[i].otherCompany);
	 	  				$(".myselfLicence").val(data[i].myselfLicence);
	 	  				$(".anotherLicence").val(data[i].anotherLicence);
	 	  				$(".contractContent").val(data[i].contractContent);
	 	  				$(".remarks").val(data[i].remarks);
	 	  			}
	 	  		},error:function(){
	 	  			alert("网络错误！");
	 	  		}
	 	  	})
	 	  	
			function voice(){
				$.ajax({
					url:'../../../voiceAction',
					type:'post',
					success:function(data){
						var suv = $(".contractType").val();
						console.log(suv)
						
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
			
		</script>
	</body>
</html>

