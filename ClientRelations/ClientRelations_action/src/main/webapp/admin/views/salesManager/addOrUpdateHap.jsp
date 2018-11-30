<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/ClientRelations_action/admin/layui/css/layui.css">
		<link rel="icon" href="/favicon.ico">
		<script type="text/javascript" src="/ClientRelations_action/admin/js/jquery-1.8.3.min.js"></script>
		<title></title>
		<style type="text/css">
			.chanceId_span{
				display: inline-block;
				height: 38px;
				line-height: 38px;
			}
			
			
			/* .layui-textarea{
				width: 300px;
			} */
			.layui-breadcrumb{
				font-size: 17px;
			}
			.daohan{
				    margin-top: 20px;
				    margin-left: 21px;
				    margin-bottom: 20px;
			}
			.layui-form{
				padding: 0px 50px;
			}
		</style>
	</head>

	<body class="layui-view-body">
		<%
			Object chanceId = request.getParameter("chanceId");
			Object zt ;
			if(chanceId == null){
				zt = "增加机会";
			}else{
				zt = "修改机会";
			}
		%>
		<div class="daohan">
			<span class="layui-breadcrumb">
			  <a href="javascript:;">销售管理</a>
			  <a href="javascript:;">机会管理</a>
			  <a><cite><%=zt %></cite></a>
			</span>
		</div>
		<form class="layui-form" action="" lay-filter="example">
			<div class="layui-form-item">
				<%
					if(chanceId!=null){
				%>
					
						<label class="layui-form-label">机会编码:</label>
						<span class="chanceId_span"><%=chanceId %></span>
				<%	
					}else{
				%>
					<label class="layui-form-label">客户:</label>
					<div class="layui-input-block" style="width: 165px;">
				     <select name="clientId" lay-filter="aihao" class="clientId">
				      </select>
				    </div>
					
				<% 
					}
				%>
			</div>
    
			<div class="layui-form-item">
				<label class="layui-form-label">机会姓名:</label>
				<div class="layui-input-block">
					<input type="text" name="chanceName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
			    </div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">机会类型:</label>
				<div class="layui-input-block" style="width: 165px;">
			      <select name="typeId" lay-filter="aihao" class="dr_select">
			        <option value="1">官网流量</option>
			        <option value="2">转介绍</option>
			        <option value="3">客户来访</option>
			        <option value="4">媒体进线</option>
			      </select>
			    </div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">机会内容:</label>
				<div class="layui-input-block">
					<textarea placeholder="" name="chanceContent" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注:</label>
				<div class="layui-input-block">
					<textarea placeholder="" name="remark" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<%
						if(chanceId != null){
							%>
							<button class="layui-btn" lay-submit="" lay-filter="demo1" style="margin-right: 20px;">保存</button>
							<% 
						}else{
							
							%>
							<button class="layui-btn" lay-submit="" lay-filter="demo2" style="margin-right: 20px;">保存</button>
						<%
						}
					%>
					
					<button  class="layui-btn result">返回</button>
				</div>
			</div>
		</form>

		<script src="/ClientRelations_action/admin/layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui.use(['form', 'layedit', 'laydate','element'], function() {
				var form = layui.form,
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate;
					element = layui.element;

				//日期
				laydate.render({
					elem: '#date'
				});

				//修改
				form.on('submit(demo1)', function(data) {
					/*layer.alert(JSON.stringify(data.field), {
						title: '最终的提交信息'
					})*/
					var formData = $(".layui-form").serialize();
					var chanceId = $(".chanceId_span").text();
					$.ajax({
						type:"post",
						url:"/ClientRelations_action/updateHap",
						data:formData+"&chanceId="+chanceId,
						success:function(t){
							closeIndex(t.msg);
						}
					})
					return false;
				});
				/* 增加 */
				form.on('submit(demo2)', function(data) {
					
					var formData = $(".layui-form").serialize();
					var entryId = /* $(".entryId").val() */1;
					$.ajax({
						type:"post",
						url:"/ClientRelations_action/addHapData",
						data:formData+"&entryId="+entryId+"&handleId="+entryId,
						success:function(t){
							closeIndex(t.msg);
						}
					})
					return false;
				});
				<%
					if(chanceId != null){
				%>
						$.ajax({
							type:"post",
							url:"/ClientRelations_action/getHapData?chanceId="+<%=chanceId%>,
							success:function(t){
								var data = t.data;
								$(".chanceId_span").text(data.chanceId);
								
								form.val('example', {
								 	"chanceName": data.chanceName, // 格式"name": "value"
									"chanceContent":data.chanceContent,
									"remark":data.remark,
									"typeId":data.typeId,
								}) 
							}
						})
				<%
					}else{
				%>
					$.ajax({
						type:"post",
						url:"/ClientRelations_action/getClientData",
						success:function(t){
							var data = t.data;
							var trData = "";
							for (var i=0;i<data.length;i++){
								trData+="<option value='"+data[i].clientId+"'>"+data[i].clientName+"<option>"
							}
							$(".clientId").empty();
							$(".clientId").append(trData);
							referForm();
						}
					})
				<%
					}
				
				%>
				//表单初始赋值
				function closeIndex(msg){
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					parent.layer.msg(msg);
					parent.layer.close(index);
					parent.refreshTable();
				}
				$(".result").click(function(){
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					parent.layer.close(index); //关闭父窗口
				})
				function referForm(){
					 form.render();
				} 
				 
			});
		</script>
	</body>
</html>