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
				url : '${pageContext.request.contextPath}/user/user_list.do?x='+new Date().getTime(),
				columns : [[
					 {field : 'id',rowspan : 2,checkbox:true}, 
					 {field : 'nickName',title : '称呼',width : 100,rowspan : 2,align : 'center'}, 
					 {field : 'identity',title : '身份',width : 100,rowspan : 2,align : 'center',formatter:function(value,row,index){
						 if("1" == value) return "管理员";
						 if("2" == value) return "教员";
						 if("3" == value) return "助教";
						 if("4" == value) return "班主任";
						 if("5" == value) return "市场";
						 if("6" == value) return "人事";
						 if("7" == value) return "行政";
						 if("8" == value) return "高层";
						 if("9" == value) return "学生";
						 if("10" == value) return "游客";
					 }}, 
					 {field : 'level',title : '部门',width : 80,rowspan : 2,align : 'center',formatter:function(value,row,index){
						  if("1" == value) return "教学部";
						  if("2" == value) return "教质部";
						  if("3" == value) return "市场部";
						  if("4" == value) return "人事部";
						  if("5" == value) return "行政部";
					  }}, 
					 {field : 'opt2',title : '学生信息',width : 80,rowspan : 2,align : 'center',formatter:function(value,row,index){
						  return "<a href='javascript:showStudent();'>点击查看</a>";
					  }}, 
					  {field : 'status',title : '删除状态',width : 85,rowspan : 2,align:'center',formatter:function(value,row,index){
						  if(value == "1"){
							  return "<font color='green'>未删除</font>";
						  }else if(value == "0"){
							 return "<font color='red'>已删除</font>";
						  }
					  }},
					  {field : 'prohibition',title : '启用状态',width : 85,rowspan : 2,align:'center',formatter:function(value,row,index){
						  if(value == "1"){
							  return "<font color='green'>已启用</font>";
						  }else if(value == "0"){
							 return "<font color='red'>未启用</font>";
						  }
					  }},
					  {field : 'createTime',title : '创建时间',rowspan : 2,width : 150,align:'center',formatter:function(value,row,index){
						  return dateFormatter(value);
					  }},
					  {field : 'telephoneA',title : '电话一',width : 140,rowspan : 2,align : 'center'}, 
					  {field : 'telephoneB',title : '电话二',width : 140,rowspan : 2,align : 'center'}, 
					  {field : 'opt',title : '操作',width : 138,rowspan : 2,align:'center',formatter:function(value,row,index){
						  var str = "";
						  str+= "<a href='javascript:show("+index+");' class='easyui-linkbutton'>详情</a>";
						  str += "     /";
						  str+= "<a href='javascript:update("+index+");' class='easyui-linkbutton'>修改</a>";
						  str += "     /";
						  str+= "<a href='javascript:operate("+index+");' class='easyui-linkbutton'>启禁</a>";
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
			window.location.href='${pageContext.request.contextPath}/user/toAddUserView.do?x='+new Date().getTime();
		}
		
		function del(index){
			var row = $("#grid").datagrid("getData").rows[index];
			var id = row.id;
			
			$.messager.confirm("友情提示","您确定要删除吗?",function(r){
				if(r){
					$.ajax({
						type:'POST',
						dataType:'json',
						url:'${pageContext.request.contextPath}/user/del_user.do?x=' + new Date().getTime()+"&id="+id,
						success:function(data){
							$("#grid").datagrid("reload");
							parent.layer.msg(data.message);
						}
					});
				}else{
					parent.layer.msg("您取消了删除操作");
				}
			});
		}
		
		function operate(index){
			var row =  $("#grid").datagrid("getData").rows[index];
			
			var id = row.id;
			var prohibition = row.prohibition;
			
			$.messager.confirm("友情提示","您确定要操作吗?",function(r){
				if(r){
					$.ajax({
						type:'POST',
						dataType:'json',
						data:{"id":id,"prohibition":prohibition},
						url:'${pageContext.request.contextPath}/user/operate_user.do?x=' + new Date().getTime(),
						success:function(data){
							$("#grid").datagrid("reload");
							parent.layer.msg(data.message);
						}
					});
				}else{
					parent.layer.msg("您取消了启禁操作");
				}
			});
		}
		
		function update(index){
			var row =  $("#grid").datagrid("getData").rows[index];
			var id = row.id;
			window.location.href='${pageContext.request.contextPath}/user/update_user.do?id='+id+'&x=' + new Date().getTime();
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