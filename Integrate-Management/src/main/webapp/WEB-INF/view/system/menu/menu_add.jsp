<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>菜单管理-添加</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/default.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/ztree/zTreeStyle.css"/>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/ztree/jquery.ztree.all-3.5.js" ></script>
	<style>
		
	</style>
</head>
<body >
	<form id="menuForm" method="post" action="${pageContext.request.contextPath}/menu/menu_save.do" style="padding:30px;">
		<c:if test="${not empty menu.href }">
			<label>菜单名称</label>	
			<input type="text" name="title" value="${menu.title}" class="easyui-validatebox" data-options="required:true" style="margin-bottom:10px"/><br/>
			<label>菜单路径</label>
			<input type="text" name="href"  value="${menu.href}" class="easyui-validatebox" data-options="required:true" style="margin-bottom:10px"/><br/>
		</c:if>
		<label>优先级</label>
		<input type="text" name="priority"  value="${menu.priority}" class="easyui-numberbox" data-options="required:true" style="margin-left:12px;margin-bottom:10px" /><br/>
		<c:if test="${not empty menu.href }">
			<label>父项菜单</label>
				<input id="selectComb" name="parentMenu.id" value="${menu.pid}" class="easyui-combobox" 
					data-options="valueField:'id',textField:'title',url:'${pageContext.request.contextPath}/menu/parent_menu_list.do'" /><br/>
		</c:if>
		<label>描述</label>	
		<textarea name="description"  rows="4" cols="60" class="easyui-validatebox" data-options="required:true" style="margin-left:24px;margin-top:10px" >${menu.description}</textarea><br/>
	</form>
</body>

</html>