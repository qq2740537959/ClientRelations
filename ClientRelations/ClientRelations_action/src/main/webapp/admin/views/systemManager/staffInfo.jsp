<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title></title>
	</head>
	<link rel="stylesheet" href="../../layui/css/layui.css" />
	<script src="../../layui/layui.js" charset="UTF-8"></script>
	<link rel="stylesheet" href="../../assets/css/view.css" />
	<link rel="icon" href="/favicon.ico">
	<script type="text/javascript" src="../../js/jquery-1.8.3.min.js" ></script>
	<style>
		input[type=number] {
    -moz-appearance:textfield;
}
input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

		.layui-tab-card {
		    box-shadow: 0 2px 5px 0 #009688!important;
		}
		
		.layui-this{
		    background-color: #009688!important;
   			 color: white!important;
   			 margin:0px!important;
    	}
				
		.layui-input-block {
			line-height:38px;
			width:500px;
		}
		.layui-input {
			height:40px;
			float:left;
			width:200px;
		}
		.pwdmsg{
		    text-decoration: underline;
		    position: relative;
		    font-size: 13px;
		    top: 11px;
		    margin-left: 10px;
		    font-weight: bold;
		    color:#737373;
		    
		    text-align: center;
        background-image: -webkit-linear-gradient(right, #147B76, #E6D205 25%, #147B96 50%, #E6D205 75%, #147B96);
        -webkit-text-fill-color: transparent;
        -webkit-background-clip: text;
        -webkit-background-size: 200% 100%;
        -webkit-animation: masked-animation 4s infinite linear;
		}
    @-webkit-keyframes masked-animation {
         0%{ background-position: 0 0;}
         100% { background-position: -100% 0;}
    }
	</style>
	</head>
	<body class="layui-view-body">
	<div class="layui-tab layui-tab-card" style="height:40px;">
  <ul class="layui-tab-title">
    <li class="layui-this">个人资料</li>
    <li>修改密码</li>
  </ul>
  <div class="layui-tab-content" style="height: 100px;">
    <div class="layui-tab-item layui-show">
    	<div class="layui-form-item" style="margin-top:30px;">
	    <label class="layui-form-label">员工姓名:</label>
	    <div class="layui-input-block">
	     ${userInfo.staffName}
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">员工编号:</label>
	    <div class="layui-input-block">
	     ${userInfo.staffId}
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">所在部门:</label>
	    <div class="layui-input-block">
	     ${userInfo.departmentAbbreviation}
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">员工姓名:</label>
	    <div class="layui-input-block">
	     ${userInfo.staffName}
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">当前状态:</label>
	    <div class="layui-input-block">
	    	<c:choose>
	    		<c:when test="${userInfo.state eq 0 }">
	    			冻结
	    		</c:when>
	    		<c:otherwise>
	    			正常
	    		</c:otherwise>
	    	</c:choose>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">系统角色:</label>
	    <div class="layui-input-block">
	     ${userInfo.roleName}
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">创建时间:</label>
	    <div class="layui-input-block">
	     <fmt:formatDate value="${userInfo.lastTime}" type="both"/>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">登录账号</label>
	    <div class="layui-input-block">
	      <input type="text" required onkeyup="this.value=this.value.replace(/\s+/g,'')" readonly="readonly" value="${userInfo.userName }"  placeholder="" autocomplete="off" class="layui-input userNameInput layui-disabled">
	    	<button class="layui-btn layui-btn-normal" onclick="updatebtn(this)">修改</button>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">手机号码</label>
	    <div class="layui-input-block">
	      <input type="number" required onkeyup="this.value=this.value.replace(/\s+/g,'')" readonly="readonly" value="${userInfo.contactMode }"  placeholder="" autocomplete="off" class="layui-input phoneInput layui-disabled">
	    	<button class="layui-btn layui-btn-normal" onclick="updatephonebtn(this)">修改</button>
	    </div>
	  </div>
    </div>
    <div class="layui-tab-item">
    	<form action="" style="margin-top:20px;">
	    	<div class="layui-form-item">
		    	<label class="layui-form-label">原密码:</label>
		    	<div class="layui-input-block">
		    		<input type="text" required onkeyup="this.value=this.value.replace(/\s+/g,'')"  placeholder="" autocomplete="off" class="layui-input yuanpwd">
		    	</div>
		  	</div>
		  	<div class="layui-form-item">
		    	<label class="layui-form-label">新密码:</label>
		    	<div class="layui-input-block">
		    		<input type="text" required onkeyup="this.value=this.value.replace(/\s+/g,'')"  placeholder="" autocomplete="off" class="layui-input newpwd">
		    		<span class="pwdmsg">注:密码只能是字母+数字组合并且6-18位格式</span>
		    	</div>
		  	</div>
		  	<div class="layui-form-item">
		    	<label class="layui-form-label">确认新密码:</label>
		    	<div class="layui-input-block">
		    		<input type="text" required onkeyup="this.value=this.value.replace(/\s+/g,'')"  placeholder="" autocomplete="off" class="layui-input twonewpwd">
		    	</div>
		  	</div>
		  	<div class="layui-form-item">
		  		<label class="layui-form-label"></label>
		  		<div class="layui-input-block">
		  			<button type="button" class="layui-btn" onclick="updatePwd(this)">修改</button>
		    		<button type="reset" class="layui-btn layui-btn-warm">重置</button>
		    	</div>
		  	</div>
	  	</form>
	  </div>
    </div>
  </div>	
  
<script type="text/javascript">

	function updatePwd(th){
		var yuanpwd = $(".yuanpwd").val();
		var newpwd = $(".newpwd").val();
		var twonewpwd = $(".twonewpwd").val();
		if (yuanpwd == "" || newpwd == "" || twonewpwd == "") {
			layer.msg("请将表单填写完成!");
			return false;
		}
		if (!(/^[a-zA-Z]\w{5,17}$/.test(newpwd))) {
			layer.msg("新密码格式不正确!");
			return false;
		}
		if (!(/^[a-zA-Z]\w{5,17}$/.test(twonewpwd))) {
			layer.msg("确认密码格式不正确!");
			return false;
		}
		if (newpwd != twonewpwd) {
			layer.msg("二次密码输入不一致!");
			return false;
		}
		$.ajax({
			url:"../../../updatePwd",
			type:"post",
			data:{
				ypassword:yuanpwd,
				npassword:newpwd
			},
			success:function(data){
				if (data.code == 1) {
					var yuanpwd = $(".yuanpwd,.newpwd,.twonewpwd").val("");
					layer.msg(data.msg+"",{icon:1});
				}else{
					layer.msg(data.msg);
				}
			}
		})
		return false;
	}

	function updatephonebtn(th){
		$(th).text("保存");
		$(th).attr("onclick","submitphonebtn(this)");
		$(".phoneInput").removeClass("layui-disabled");
		$(".phoneInput").removeAttr("readonly");
		$(th).removeClass("layui-btn-normal");
	}
	
	function submitphonebtn(th){
		var phone = $(".phoneInput").val();
		if(!(/^1[34578]\d{9}$/.test(phone))){ 
			layer.msg("请输入正确的11位手机号");
			return false; 
		}
		$.ajax({
			url:"../../../updateStaffPhone",
			type:"post",
			data:{
				"contactMode":phone
			},
			success:function(data){
				if (data.code == 1) {
					$(th).text("修改");
					$(th).attr("onclick","updatephonebtn(this)");
					$(th).addClass("layui-btn-normal");
					$(".phoneInput").attr("readonly","readonly");
					$(".phoneInput").addClass("layui-disabled");
					layer.msg(""+data.msg, {icon: 1});
				} else if (data.code == 2) {
					$(th).text("修改");
					$(th).attr("onclick","updatephonebtn(this)");
					$(th).addClass("layui-btn-normal");
					$(".phoneInput").attr("readonly","readonly");
					$(".phoneInput").addClass("layui-disabled");
					layer.msg(""+data.msg, {icon: 3});
				} else{
					layer.msg(""+data.msg, {icon: 2});
				}
			}
		})
	}
	
	
	function updatebtn(th){
		$(th).text("保存");
		$(th).attr("onclick","submitbtn(this)");
		$(".userNameInput").removeClass("layui-disabled");
		$(".userNameInput").removeAttr("readonly");
		$(th).removeClass("layui-btn-normal");
	}
	
	function submitbtn(th){
		var userName = $(".userNameInput").val();
		if (!(/^(?![\d]+$)(?![a-zA-Z]+$)(?![!#$%^&*]+$)[\da-zA-Z!#$%^&*]{6,10}$/.test(userName))) {
			layer.msg("登录账号只能是数字+字母组合6-10位！");
			return ;
		}
		$.ajax({
			url:"../../../updateStaffUserName",
			type:"post",
			data:{
				"userName":userName
			},
			success:function(data){
				console.log(data);
				if (data.code == 1) {
					$(th).text("修改");
					$(th).attr("onclick","updatebtn(this)");
					$(th).addClass("layui-btn-normal");
					$(".userNameInput").attr("readonly","readonly");
					$(".userNameInput").addClass("layui-disabled");
					layer.msg(""+data.msg, {icon: 1});
				} else if (data.code == 2) {
					$(th).text("修改");
					$(th).attr("onclick","updatebtn(this)");
					$(th).addClass("layui-btn-normal");
					$(".userNameInput").attr("readonly","readonly");
					$(".userNameInput").addClass("layui-disabled");
					layer.msg(""+data.msg, {icon: 3});
				} else{
					layer.msg(""+data.msg, {icon: 2});
				}
			}
		})
	}
</script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  layui.use('element', function(){
	  var element = layui.element;
	});
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
	</body>
</html>
