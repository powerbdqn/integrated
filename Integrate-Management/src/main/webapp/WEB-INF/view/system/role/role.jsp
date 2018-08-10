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
	<title>角色管理</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/default.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/ztree/zTreeStyle.css"/>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/ztree/jquery.ztree.all-3.5.js" ></script>
	<script type="text/javascript" src="<%=basePath%>static/js/tool.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#grid").datagrid({
				toolbar : '#tb',
				url : '${pageContext.request.contextPath}/role/role_list.do?x='+new Date().getTime(),
				columns : [[
					{field : 'id',title : '编号',checkbox:true},
					{field : 'name',title : '名称',width : 100,align:'center'}, 
					{field : 'keyword',title : '关键字',width : 100,align:'center'}, 
					{field : 'description',title : '描述',width : 100,align:'center'}, 
				  {field : 'status',title : '删除状态',width : 85,align:'center',formatter:function(value,row,index){
					  if(value == "1"){
						  return "<font color='green'>未删除</font>";
					  }else if(value == "0"){
						 return "<font color='red'>已删除</font>";
					  }
				  }},
				  {field : 'prohibition',title : '启用状态',width : 85,align:'center',formatter:function(value,row,index){
					  if(value == "1"){
						  return "<font color='green'>已启用</font>";
					  }else if(value == "0"){
						 return "<font color='red'>未启用</font>";
					  }
				  }},
				  {field : 'createUser',title : '创建人',width : 100,align:'center'},
				  {field : 'createTime',title : '创建时间',width : 150,align:'center',formatter:function(value,row,index){
					  return dateFormatter(value);
				  }},
				  {field : 'modifyUser',title : '修改人',width : 100,align:'center'},
				  {field : 'mdifyTime',title : '修改时间',width : 150,align:'center',formatter:function(value,row,index){
					  return dateFormatter(value);
				  }},
				  {field : 'opt',title : '操作',width : 125,align:'center',formatter:function(value,row,index){
					  var str = "";
					  str+= "<a href='javascript:update("+index+");' class='easyui-linkbutton'>修改</a>";
					  str += "     /";
					  str+= "<a href='javascript:update("+index+");' class='easyui-linkbutton'>启禁</a>";
					  str += "     /";
					  str+= "<a href='javascript:del("+index+");' class='easyui-linkbutton'>删除</a>";
				  	  return str;
				  }}
				]],
				pagination:true,
				fit:true,
				rownumbers:true,
				singleSelect:true
			});
		});
		
		function toPermissionView(){
			window.location.href='${pageContext.request.contextPath}/role/toAddRoleView.do?x='+new Date().getTime();
		}
		
	</script>
</head>
<body>
	<div id="tb">
		<a onclick="toPermissionView()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
	</div>
		<table id="grid"></table>
</body>
</html>