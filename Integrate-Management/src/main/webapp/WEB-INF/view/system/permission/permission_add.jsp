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
	<title>权限管理-添加</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/default.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/ztree/zTreeStyle.css"/>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/ztree/jquery.ztree.all-3.5.js" ></script>
</head>
<body>
	<form id="permissionForm" method="post" action="${pageContext.request.contextPath}/permission/permission_save.do" style="padding:30px;">
		<input type="hidden" name="id" value="${permission.id}" class="easyui-validatebox" style="margin-bottom:10px" />
		<label>权限名称</label>	
		<input type="text" name="level.name" value="${permission.name}" class="easyui-validatebox" data-options="required:true" style="margin-bottom:10px"/><br/>
		<label>关键 字</label>
		<input type="text" name="keyword"  value="${permission.keyword}" class="easyui-validatebox" data-options="required:true" style="margin-left:10px;margin-bottom:10px"/><br/>
		<label>描述</label>	
		<textarea name="description"  rows="4" cols="60" class="easyui-validatebox" data-options="required:true" style="margin-left:24px;margin-top:10px" >${permission.description}</textarea><br/>
	</form>
</body>
</html>