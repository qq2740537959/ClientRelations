﻿<%@ page language="java" contentType="text/html; charset=utf-8"
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
    <link rel="stylesheet" href="../../layui/css/layui.css" />
		<script src="../../layui/layui.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../../js/jquery-1.8.3.min.js" ></script>
  	<style>
  		body{
  			padding: 20px;
  		}
  		textarea{
  			  height: 90px;
    			width: 350px;
  		}
  		.layui-input{
  			width: 350px;
  		}
  	</style>
  </head>
  <body>
	<form class="layui-form" id="updateUserform"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <input type="hidden" name="userId" value="${u.userId }">
  <input type="hidden" name="state" value="${u.state }">
  <input type="hidden" name="email" value="${u.email }">
  <input type="hidden" name="headPath" value="${u.headPath }">
  <div class="layui-form-item">
    <label class="layui-form-label">组织编码</label>
    <div class="layui-input-block">
      <input type="text" name="nickName" value="${u.nickName }" required="required" placeholder="" autocomplete="off" class="layui-input nickName">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">组织简称</label>
    <div class="layui-input-block">
      <input type="text" name="nickName" value="${u.nickName }" required="required" placeholder="" autocomplete="off" class="layui-input nickName">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">组织全称</label>
    <div class="layui-input-block">
      <input type="text" name="nickName" value="${u.nickName }" required="required" placeholder="" autocomplete="off" class="layui-input nickName">
    </div>
  </div>
  <div class="layui-form-item" style="width: 460px;">
    <label class="layui-form-label">组织全称</label>
    <div class="layui-input-block">
    		
    		<select name="city" lay-verify="" lay-search>
				  <option value="0">无</option>
				  <option value="0">总经办</option>
				  <option value="0">综合部</option>
				  <option value="0">市场发展部</option>
				  <option value="0">业务一部</option>
				  <option value="0">业务二部</option>
				</select> 
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">部门简介</label>
    <div class="layui-input-block">
    		<textarea></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注信息</label>
    <div class="layui-input-block">
    		<textarea></textarea>
    </div>
  </div>
  <div class="layui-form-item" style="margin-left:20px;">
    <div class="layui-input-block">
      <button class="layui-btn addUserSub" lay-submit lay-filter="*">立即提交</button>
  		<button class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
  <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>
<script type="text/javascript">
$(".addUserSub").on('click',function(){
	$.ajax({
		url:"addOrUpdateUser",
		type:"post",
		data:$("#updateUserform").serialize(),
		success:function(data){
			console.log(data+"");
			if (data.code == 1) {
				layui.use('layer', function(){
    				var layer = layui.layer;
    				layer.msg("操作成功！",{time:1100,icon:1},function(){
    					var index=parent.layer.getFrameIndex(window.name);
        				parent.layer.close(index);
    				})
	    		});
			}else if(data.code == 0){
				layui.use('layer', function(){
    				var layer = layui.layer;
    				layer.msg("操作成功！",{time:1100,icon:1});
	    		});
			}
		},error:function(){
			//layui.msg("网络错误",{icon:2});
		}
	})
	return false;
})

layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //执行一个laydate实例
	  laydate.render({
	    elem: '.time' //指定元素
	  });
});
renderForm();
function renderForm(){
 layui.use('form', function(){
 var form = layui.form();//高版本建议把括号去掉，有的低版本，需要加()
 form.render();
 });
 }
</script>
   
  </body>
</html>
