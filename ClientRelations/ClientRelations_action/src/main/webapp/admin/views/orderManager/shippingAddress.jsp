<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ClientRelations_action/admin/layui/css/layui.css" />
<script type="text/javascript" src="/ClientRelations_action/admin/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/ClientRelations_action/admin/layui/layui.js"></script>
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
	<div style='margin-top: 20px;'>
		<form class='layui-form' id='order-form'>
			<div class='layui-form-item'>
				<label class='layui-form-label'>收货人：</label>
				<div class='layui-input-block'>
					<input type='text' name='consignee' lay-verify="required" lay-verify='title'
						autocomplete='off' placeholder='请输入收货人姓名'
						class='consignee layui-input'>
				</div>
			</div>
			<div class='layui-form-item'>
				<label class='layui-form-label'>手机号码：</label>
				<div class='layui-input-block'>
					<input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="phone layui-input">
				</div>
			</div>
			<span style='margin-left: 20px;'>所在地区：&nbsp;&nbsp;</span>
			<div class='province layui-input-inline'>
				<select name='province' lay-filter='province' class='provin'><option
						value='' selected=''>请选择省</option>
					<option value='浙江'>浙江省</option></select>
			</div>
			&nbsp;&nbsp;
			<div class='layui-input-inline'>
				<select name='city' class='city' lay-filter='city'><option
						value=''>请选择市</option>
					<option value='杭州'>杭州</option></select>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<div class='layui-input-inline'>
				<select name='area' class='area'><option value=''>请选择县/区</option>
					<option value='西湖区'>西湖区</option></select>
			</div><br /><br />
			<div class='layui-form-item layui-form-text'>
				<label class='layui-form-label'>详细地址：</label>
				<div class='layui-input-block'>
					<textarea name="detailAddress" lay-verify="required" placeholder='如道路、门牌号、小区、楼栋号、单元室' class='detailAddress layui-textarea'></textarea>
				</div>
			</div>
			<div>
				<button class="layui-btn btn" lay-submit="" lay-filter="drSub" style="margin-left: 200px">立即提交</button>
			</div>
		</form>
		<%
			Object clientId = request.getParameter("clientId");
		%>
	</div>
	<script>
		 var clientId = <%=clientId%>;
		 // 查询客户的收货地址
		 //重新渲染表单
		 layui.use(['form'], function() {
	        form=layui.form;
			form.on('select(province)', function(data){   
				  var val=data.value;
				 cityOrArae(1,val,"");
			});
			form.on('select(city)', function(data){   
				  var val=data.value;
				  cityOrArae(2,val,"");
			});
			form.on('submit(drSub)', function(data){
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				parent.layer.close(index);
				parent.test($("#order-form").serializeArray());//test是父窗口的方法
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
			
		});
		var city = "";
		var area = "";
	    $.ajax({
		  url:'<%=request.getContextPath()%>/selectAddressByClidentId',
		  type:'post',
		  data:'clientId='+clientId,
		  dataType:'json',
		  success:function(result){
			  if(result != null){
				  $(".consignee").val(result.consigneeName);
				  $(".phone").val(result.phone);
				  $(".detailAddress").val(result.detailAddress);
				  province(result.province); 
				  city = result.city;
				  area = result.area;
			  }else{
				  province("");
			  }
			 
		  }
	  });
   	 function province(defaultProvince){
		$.ajax({
			url:'<%=request.getContextPath()%>/selectTpTreeAll',
			type:'post',
			success:function(data){
				$(".provin").empty();
				var sum = "";
				for (var i = 0; i < data.length; i++) {
					if(defaultProvince == data[i].name){
						sum+="<option value='"+data[i].id+"' selected='selected'>"+data[i].name+"</option>";
					}else{
						sum+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
					}
				}
				$(".provin").html(sum);     
				renderForm();
				var id = $(".provin").val();
				cityOrArae(1,id,city);
				renderForm();
			}
		});
	 }
 	 function cityOrArae(th,id,defaultCityOrArea){
		$.ajax({
			url:'<%=request.getContextPath()%>/selectTpTreeById?id='+id,
			type:'post',
			success:function(data){
				if(th == "1"){
					$(".city").empty();
					var sum = "";
					for (var i = 0; i < data.length; i++) {
						if(defaultCityOrArea == data[i].name){
							sum+="<option value='"+data[i].id+"' selected='selected'>"+data[i].name+"</option>";
						}else{
							sum+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
						}
					}
					$(".city").html(sum);
					var id = $(".city").val();
					cityOrArae(2,id,area);
					renderForm();
				}else if(th == "2"){
					$(".area").empty();
					var sum = "";
					for (var i = 0; i < data.length; i++) {
						if(defaultCityOrArea == data[i].name){
							sum+="<option value='"+data[i].id+"' selected='selected'>"+data[i].name+"</option>";
						}else{
							sum+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
						}
					}
					$(".area").html(sum);
				}
				renderForm();
			}
		});
	}
	    
	 renderForm();
	 function renderForm(){
	  	layui.use('form', function(){
	   		var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
	   	    form.render();
	  	});
 	}
		
		
	</script>
</body>
</html>