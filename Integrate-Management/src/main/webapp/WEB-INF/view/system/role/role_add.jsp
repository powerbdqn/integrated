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
		
		var id = $("#roleId").val();
		
		// 授权树初始化
		var setting = {
			data : {
				key : {
					name : "title"
				},
				simpleData : {
					enable : true
				}
			},
			check : {
				enable : true,
			}
		};
		
		$.ajax({
			url : '${pageContext.request.contextPath}/menu/list_menu_status.do',
			type : 'POST',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#menuTree"), setting, zNodes);
			},
			error : function(msg) {
				layer.msg('树加载异常!');
			}
		});
		
		// 页面加载后， 获取所有权限数据，生成checkbox列表
		$.get("${pageContext.request.contextPath}/permission/permission_list.do", function(data){
			// 生成checkbox列表 
			$(data).each(function(i,v){
				var checkbox = $("<input id="+v.id+" type='checkbox' name='permissionIds' />");
				checkbox.val(this.id);
				$("#permissionTD").append(checkbox);
				$("#permissionTD").append(this.name); 
			});
		});
		
		//回显权限数据
		$.get("${pageContext.request.contextPath}/permission/findPermissionByRoleId.do?id="+id,function(data){
			$(data).each(function(i,v){
				$("#"+v.id).attr("checked","checked");
			}); 
		});
		
		
		
		
		// 点击保存
		$('#save').click(function(){
			// 获取ztree勾选节点集合 
			var treeObj = $.fn.zTree.getZTreeObj("menuTree");
			var nodes = treeObj.getCheckedNodes(true);
			// 获取所有节点id 
			var array = new Array();
			for(var i=0 ; i< nodes.length ; i++){
				array.push(nodes[i].id);
			}
			var menuIds = array.join(",");
			$("input[name='menuIds']").val(menuIds);
			
			var a = $("input[checked='checked']");
			console.log(nodes);
			console.log(a);
			
			// 提交form
			if($("#roleForm").form('validate')){
				$("#roleForm").form('submit',{
					url:'${pageContext.request.contextPath}/role/role_save.do?x='+new Date().getTime(),
					success:function(data){
						$("#roleForm").form("clear");
						$("#roleTable").datagrid('reload');
						window.location.href="${pageContext.request.contextPath}/role/toRole.do?x="+new Date().getTime();
						console.log(data);
						layer.msg(data.message);
					}
				});
			}else{
				layer.msg("请补全信息");
				return;
			}
		});
	}); 
</script>
</head>
<body class="easyui-layout">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="roleForm" method="post" action="${pageContext.request.contextPath}/role/role_save.do">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">角色信息</td>
					</tr>
					<tr>
						<td>名称</td>
						<td>
							<input id="roleId" type="hidden" name="id" value="${role.id}"/>
							<input type="text" name="name" value="${role.name}" class="easyui-validatebox" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>关键字</td>
						<td>
							<input type="text" name="keyword" value="${role.keyword}" class="easyui-validatebox" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>描述</td>
						<td>
							<textarea name="description" rows="4" cols="60">${role.description}</textarea>
						</td>
					</tr>
					<tr>
						<td>权限选择</td>
						<td id="permissionTD"></td>
					</tr>
					<tr>
						<td>菜单授权</td>
						<td>
							<input id="menuIds" type="hidden" name="menuIds"/>
							<ul id="menuTree" class="ztree"></ul>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>