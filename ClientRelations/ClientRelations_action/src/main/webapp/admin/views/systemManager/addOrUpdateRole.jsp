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
	<form class="layui-form" id="addOrUpdateStaff"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <c:if test="${roleInfo ne null}">
	  <div class="layui-form-item">
	    <label class="layui-form-label">角色编码：</label>
	    <div class="layui-input-block">
	      <input type="text" name="roleId" readonly="readonly" value="${roleInfo.roleId }" required="required" placeholder="" autocomplete="off" class="layui-input layui-disabled">
	    </div> 	
	  </div>
  </c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">角色名称：</label>
    <div class="layui-input-block">
      <input type="text" name="roleName" value="${roleInfo.roleName }" required="required" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item" style="width: 460px;">
    <label class="layui-form-label">所属部门：</label>
    <div class="layui-input-block">
   		<select name="departmentId" lay-verify="" lay-search required="required">
			<c:forEach items="${departmentList }" var = "d">
				<c:choose>
					<c:when test="${d.departmentId eq roleInfo.departmentId }">
						<option value="${d.departmentId }" selected>${d.departmentAbbreviation }</option>
					</c:when>
					<c:otherwise>
						<option value="${d.departmentId }">${d.departmentAbbreviation }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> 
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注信息：</label>
    <div class="layui-input-block">
    	<textarea name="remarksExplain">${roleInfo.remarksExplain}</textarea>
    </div>
  </div>
  <div class="layui-form-item" style="margin-left:20px;">
    <div class="layui-input-block">
      <button class="layui-btn addOrUpdateBtn" lay-submit lay-filter="*">立即提交</button>
  		<button type="reset" class="layui-btn slayui-btn-primary">重置</button>
    </div>
  </div>
  <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>
<script type="text/javascript">
$(".addOrUpdateBtn").on('click',function(){
	$.ajax({
		url:"<%=request.getContextPath()%>/addOrUpdateRole",
		type:"post",
		data:$("#addOrUpdateStaff").serialize(),
		success:function(data){
			if (data.code == "1") {
				layui.use('layer', function(){
	   				var layer = layui.layer;
	   				layer.msg(""+data.msg,{time:1100,icon:1},function(){
	   					var index=parent.layer.getFrameIndex(window.name);
	       				parent.layer.close(index);
	   				})
	    		});
			}else{
				layui.use('layer', function(){
	   				var layer = layui.layer;
	   				layer.msg(""+data.msg)
	    		});
			}
		}
	})
	return false;
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
