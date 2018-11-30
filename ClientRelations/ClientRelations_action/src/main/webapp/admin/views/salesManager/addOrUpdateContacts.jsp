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
			.contactsId_span{
				display: inline-block;
				height: 38px;
				line-height: 38px;
			}
			.layui-inline{
				display: inline-block;
				width: 290px;
			}
			.layui-input-inline{
				width: 170px !important;
			}
			.layui-textarea{
				width: 474px;
			}
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
			Object contactsId = request.getParameter("contactsId");
			Object zt ;
			if(contactsId == null){
				zt = "增加联系人";
			}else{
				zt = "修改联系人";
			}
		%>
		<div class="daohan">
			<span class="layui-breadcrumb">
			  <a href="javascript:;">销售管理</a>
			  <a href="javascript:;">联系人管理</a>
			  <a><cite><%=zt %></cite></a>
			</span>
		</div>
		<form class="layui-form" action="" lay-filter="example">
			
			<div class="layui-form-item">
				<%
					if(contactsId!=null){
				%>
					
					<div class="layui-inline">
						<label class="layui-form-label">联系人编码:</label>
						<span class="contactsId_span"><%=contactsId %></span>
					</div>
				<%	
					}
				%>
				
				<div class="layui-inline">
					<label class="layui-form-label">联系人姓名:</label>
					<div class="layui-input-inline">
						<input type="text" name="name" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" >
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">性别:</label>
					<div class="layui-input-inline">
						<input type="radio" name="sex" value="男" title="男" checked="checked">
						<input type="radio" name="sex" value="女" title="女">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">生日:</label>
					<div class="layui-input-inline">
						<input type="text" name="birthday" id="date"  placeholder="" autocomplete="off" class="layui-input">					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">手机号:</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone"  lay-verify="required|phone" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">办公电话:</label>
					<div class="layui-input-inline">
						<input type="text" name="workPhone"  placeholder="" autocomplete="off" class="layui-input" >
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">电子邮箱:</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">家庭电话:</label>
					<div class="layui-input-inline">
						<input type="text" name="familyPhone"  placeholder="" autocomplete="off" class="layui-input" >
					</div>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">联系地址:</label>
				<div class="layui-input-block">
					<textarea placeholder="" name="address" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注信息:</label>
				<div class="layui-input-block">
					<textarea placeholder="" name="remark" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<%
						if(contactsId != null){
							%>
							<button class="layui-btn" lay-submit="" lay-filter="demo1" style="margin-left: 130px;margin-right: 20px;">保存</button>
							<% 
						}else{
							
							%>
							<button class="layui-btn" lay-submit="" lay-filter="demo2" style="margin-left: 130px;margin-right: 20px;">保存</button>
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

				//监听提交
				form.on('submit(demo1)', function(data) {
					/*layer.alert(JSON.stringify(data.field), {
						title: '最终的提交信息'
					})*/
					var formData = $(".layui-form").serialize();
					var contactsId = $(".contactsId_span").text();
					 $.ajax({
						type:"post",
						url:"/ClientRelations_action/updateContacts",
						data:formData+"&contactsId="+contactsId,
						success:function(t){
							closeIndex(t.msg);
						}
					}) 
					return false;
				});
				
				form.on('submit(demo2)', function(data) {
					var formData = $(".layui-form").serialize();
					$.ajax({
						type:"post",
						url:"/ClientRelations_action/addContacts",
						data:formData,
						success:function(t){
							closeIndex(t.msg);
						}
					})
					return false;
				});
				<%
					if(contactsId != null){
				%>
						$.ajax({
							type:"post",
							url:"/ClientRelations_action/getContactsData?contactsId="+<%=contactsId%>,
							success:function(t){
								var data = t.data;
								$(".contactsId_span").text(data.contactsId);
								form.val('example', {
									"name": data.name, // "name": "value"
									"phone":data.phone,
									"birthday":data.birthday,
									"workPhone":data.workPhone,
									"email":data.email,
									"familyPhone":data.familyPhone,
									"remark":data.remark,
									"sex":data.sex,
									"address":data.address,
								})
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
				}
				$(".result").click(function(){
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					parent.layer.close(index); //关闭父窗口
				})
				 
			});
		</script>
	</body>
</html>