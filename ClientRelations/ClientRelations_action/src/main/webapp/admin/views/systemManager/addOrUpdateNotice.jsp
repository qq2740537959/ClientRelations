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
	<link rel="stylesheet" href="<%=request.getContextPath() %>/admin/layui/css/layui.css" />
	<script src="<%=request.getContextPath() %>/admin/layui/layui.js" charset="UTF-8"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/admin/assets/css/view.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/admin/js/jquery-1.8.3.min.js" ></script>
    <meta charset="UTF-8">
  	<style>
  		body{
  			padding: 20px;
  		}
  		textarea{
  			padding:5px;
  			  height: 90px;
    			width: 338px;
  		}
  		.layui-input{
  			width: 350px;
  		}
  	</style>
  </head>
  <body>
	<form class="layui-form" id="addOrUpdateNotice"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <c:if test="${notice.noticeId ne null }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">公告编码：</label>
	    <div class="layui-input-block">
	      <input type="text" name="noticeId" readonly="readonly" value="${notice.noticeId }" required="required" placeholder="" autocomplete="off" class="layui-input layui-disabled">
	    </div> 	
	  </div>
  </c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">公告标题：</label>
    <div class="layui-input-block">
      <input type="text" name="noticeTitle" value="${notice.noticeTitle }" required="required" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
  <c:if test="${notice.noticeId ne null }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">发布时间：</label>
	    <div class="layui-input-block">
	      <input type="text" readonly="readonly" value='<fmt:formatDate value="${notice.releaseTime }" type="both"/>' required="required" placeholder="" autocomplete="off" class="layui-input layui-disabled">
	    </div>
	  </div>
  </c:if>
  <div class="layui-form-item" style="width: 460px;">
    <label class="layui-form-label">公告类型：</label>
    <div class="layui-input-block">
   		<select name="noticeType" lay-verify="" lay-search>
			  <option value="1" ${'1'==notice.noticeType?'selected':'' }>全体公告</option>
			  <option value="2" ${'2'==notice.noticeType?'selected':'' }>部门公告</option>
			  <option value="3" ${'3'==notice.noticeType?'selected':'' }>行政公告</option>
			  <option value="4" ${'4'==notice.noticeType?'selected':'' }>通知</option>
		</select> 
    </div>
  </div>
  <c:if test="${notice.noticeId ne null }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">发布人：</label>
	    <div class="layui-input-block">
	    	<input type="text" readonly="readonly" value="${notice.releasePersonName }" required="required" placeholder="" autocomplete="off" class="layui-input layui-disabled">
	    </div>
	  </div>
  </c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">发布内容：</label>
    <div class="layui-input-block">
    	<textarea name="releaseContent">${notice.releaseContent}</textarea>
    </div>
  </div>
  <div class="layui-form-item" style="margin-left:20px;">
    <div class="layui-input-block">
      <button type="button" class="layui-btn addOrUpdateBtn" lay-submit lay-filter="*">立即提交</button>
  		<button type="reset" class="layui-btn slayui-btn-primary">重置</button>
    </div>
  </div>
  <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>
<script type="text/javascript">
$(".addOrUpdateBtn").on('click',function(){
	$.ajax({
		url:"<%=request.getContextPath()%>/addOrUpdateNotice",
		type:"post",
		data:$("#addOrUpdateNotice").serialize(),
		success:function(data){
			console.log(data);
			layui.use('layer', function(){
   				var layer = layui.layer;
   				layer.msg(""+data.msg,{time:1100,icon:1},function(){
   					var index=parent.layer.getFrameIndex(window.name);
       				parent.layer.close(index);
   				})
    		});
		}
	})
})

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
