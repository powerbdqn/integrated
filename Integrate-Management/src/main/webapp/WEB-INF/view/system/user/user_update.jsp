<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>角色管理-添加</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/default.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/ztree/zTreeStyle.css"/>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/ztree/jquery.ztree.all-3.5.js" ></script>
	<script type="text/javascript" src="<%=basePath%>static/js/tool.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/plugins/layer/layer.js"></script>
	<script type="text/javascript">
			$(function(){
				$("body").css({visibility:"visible"});
				var reg = /^[1-9](\d{16}|\d{13})[0-9xX]$/;
				$('#save').click(function(){
					
					$("#form").form('submit',{
						url:"${pageContext.request.contextPath}/user/user_save.do?x=" + new Date().getTime(),
						onSubmit:function(){
							var vali = $("#form").form('validate');
							if(!vali){
								parent.layer.msg("请补全信息...");
								$("#errorId").text("页面上的选项不要忘了哦");
								return vali;
							}
						},
						success:function(data){
							$("#form").form("clear");
							window.location.href="${pageContext.request.contextPath}/user/toUser.do?x="+ new Date().getTime();
							$("#grid").datagrid("reload");
							parent.layer.msg(data.message);
						}
					});
				});
				
				//获取部门level
				$.ajax({
					type:'POST',
					dataType:'json',
					url:'${pageContext.request.contextPath}/level/level_list.do?x='+ new Date().getTime(),
					success:function(data){
		                var arr = [{ 'name': '--------------请选择--------------', 'id': ''}]; 
						$.each(data,function(i,v){
							arr.push({ "name": v.name, "id": v.id });
						 }); 
		                $("#level").combobox("loadData", arr);
					}
				});
				//获取身份
				$.ajax({
					type:'POST',
					dataType:'json',
					url:'${pageContext.request.contextPath}/identity/identity_list.do?x='+ new Date().getTime(),
					success:function(data){
		                var arr = [{ 'name': '--------------请选择--------------', 'id': ''}]; 
						$.each(data,function(i,v){
							arr.push({ "name": v.name, "id": v.id });
						 }); 
		                $("#identity").combobox("loadData", arr);
					}
				});
				
				// 获取所有角色信息，生成checkbox列表
				$.get('${pageContext.request.contextPath}/role/role_list.do?x='+new Date().getTime(), function(data){
					// 遍历所有角色数据
					$(data).each(function(){
						// 多选checkbox  单选radio
						var checkbox = $("<input type='radio' name='roleIds' />");
						checkbox.val(this.id);
						$("#roleTD").append(checkbox);
						$("#roleTD").append(this.name);
					});
				});
			});
	</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<span><font id="errorId" color='red'>${data.obj.msg}</font></span>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="form" method="post"> 
				<table class="table-edit" width="95%" align="center">
					<tr class="title">
						<td colspan="4">基本信息</td>
					</tr>
					<tr>
						<td>登录账号</td>
						<td>
							<input id="username" name="username" value="${user.username}" type="text" class="easyui-validatebox" required="true" readonly="readonly" />
						</td>
						<td>登录密码</td>
						<td>
							<input id="password" name="password" value="${user.password}" type="text" class="easyui-validatebox" required="true" validType="minLength[5]" />
						</td>
					</tr>
					
					<tr>
						<td>真实姓名</td>
						<td>
							<input id="nickName" name="nickName"  value="${user.nickName}" type="text" class="easyui-validatebox" required="true" readonly="readonly"/>
						</td>
						
						<td>身份证号</td>
						<td>
							<input id="cord" name="cord"  value="${user.cord}" type="text" class="easyui-validatebox" required="true" readonly="readonly" />
						</td>
					</tr>
					
					
					<tr class="title" style="margin-top:20px;">
						<td colspan="4">重要信息</td>
					</tr>
					
					<tr>
						<td>用户身份</td>
						<td>
							 <input id="identity" name="identity" value="${user.identity}" class="easyui-combobox" style="width: 175px;" data-options="valueField:'id', textField:'name', panelHeight:'auto'" readonly="readonly"></input>
						</td>
						<td>所在部门</td>
						 <td>
							 <input id="level" name="level"  value="${user.level}" class="easyui-combobox" style="width: 175px;" data-options="valueField:'id', textField:'name', panelHeight:'auto'" readonly="readonly"></input>
						</td>
							
					</tr>
					<tr>
						<td>赋予角色</td>
						<td id="roleTD" colspan="3">
							<input type='radio' name='roleIds' value="">无</input>
						</td>
					</tr>
					
					<tr class="title">
						<td colspan="4">其他信息</td>
					</tr>
					
					<tr>
						<td>常用邮箱</td>
						<td>
							<input id="email" name="email"  value="${user.email}" type="text" class="easyui-validatebox" validType='email' required="true" />
						</td>
					</tr>
					
					<tr>
						<td>用户性别</td>
						<td>
							<input id="man" type="radio" name="sex" value="1" >男
							<input id="woman" type="radio" name="sex" value="0" >女
						</td>
						<td>用户地址</td>
						<td>
							<input id="address" name="address" value="${user.address}" type="text" class="easyui-validatebox" style="width: 330px;"/>
						</td>
					</tr>
					<tr>
						<td>联系电话一</td>
						<td>
							<input id="telephoneA" name="telephoneA"  value="${user.telephoneA}" type="text" class="easyui-validatebox" required="true" />
						</td>
						<td>联系电话二</td>
						<td>
							<input id="telephoneB" name="telephoneB"  value="${user.telephoneB}" type="text" class="easyui-validatebox"/>
						</td>
					</tr>
					<tr>
						<td>备注:</td>
						<td colspan="3">
							<textarea id="description" name="description" style="width:750px;height:150px" required="true">${user.description}</textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>