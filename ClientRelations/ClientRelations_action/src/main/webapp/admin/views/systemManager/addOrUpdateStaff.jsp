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
  <c:if test="${staff.staffId ne null }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">员工编码：</label>
	    <div class="layui-input-block">
	      <input type="text" name="staffId" readonly="readonly" value="${staff.staffId }" required="required" placeholder="" autocomplete="off" class="layui-input layui-disabled">
	    </div> 	
	  </div>
  </c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">员工姓名：</label>
    <div class="layui-input-block">
      <input type="text" name="staffName" value="${staff.staffName }" required="required" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">员工性别：</label>
    <div class="layui-input-block">
    	<input type="radio" name="sex" value="男" title="男" ${staff.sex eq '男'?'checked':''}>
		<input type="radio" name="sex" value="女" title="女" ${staff.sex eq '女'?'checked':''}>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">员工状态：</label>
    <div class="layui-input-block">
    	<input type="radio" name="state" value="0" title="冻结" ${staff.state eq '0'?'checked':''}>
		<input type="radio" name="state" value="1" title="正常" ${staff.state eq '1'?'checked':''}>
	</div>
  </div>
  <div class="layui-form-item" style="width: 460px;">
    <label class="layui-form-label">所属部门：</label>
    <div class="layui-input-block">
   		<select name="departmentId" lay-verify="" lay-search>
			<c:forEach items="${departmentList }" var = "d">
				<c:choose>
					<c:when test="${d.departmentAbbreviation eq staff.departmentAbbreviation }">
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
    <label class="layui-form-label">角色身份：</label>
    <div class="layui-input-block">
    	<select name="roleIdentity" lay-verify="" lay-search>
  			<c:forEach items="${roleList }" var = "r">
  				<c:choose>
					<c:when test="${r.roleName eq staff.roleName }">
						<option value="${r.roleId }" selected>${r.roleName }</option>
					</c:when>
					<c:otherwise>
						<option value="${r.roleId }">${r.roleName }</option>
					</c:otherwise>
				</c:choose>
  			</c:forEach>
		</select> 
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注信息：</label>
    <div class="layui-input-block">
    	<textarea name="remarksInfo">${staff.remarksInfo}</textarea>
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
		url:"<%=request.getContextPath()%>/addOrUpdateStaff",
		type:"post",
		data:$("#addOrUpdateStaff").serialize(),
		success:function(data){
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
