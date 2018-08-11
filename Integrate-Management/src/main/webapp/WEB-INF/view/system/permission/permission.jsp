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
	<title>权限管理</title>
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
			$("#permissionTable").datagrid({
				toolbar : '#tb',
				url : '${pageContext.request.contextPath}/permission/permission_list.do?x='+new Date().getTime(),
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
		
		function showAddPermissionWindow(){
			$('#permissionForm').form("clear");
			$('#permissionWindow').dialog({    
			    title: '新增',    
			    width: 600,    
			    height: 450,    
			    closed: false,    
			    cache: false,    
			    href: '${pageContext.request.contextPath}/permission/show.do?x='+new Date().getTime(),  
			    modal: true,
			    buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$('#permissionForm').form('submit', {    
						    url:'${pageContext.request.contextPath}/permission/permission_save.do?x='+new Date().getTime(),   
						    onSubmit: function(){    
						    	var isValid = $(this).form('validate');
								if (!isValid){
									layer.msg('请补全信息。。。');
								}
								return isValid;	// 返回false终止表单提交
						    },    
						    success:function(data){ 
						    	console.log(data);
						    	$('#permissionForm').form("clear");
								$('#permissionWindow').dialog("close");
								$("#permissionTable").datagrid("reload");
						    	var str = eval('(' + data + ')'); 
						    	layer.msg(str.message);
						    }
						});
					}
				},{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$('#permissionForm').form("clear");
						$('#permissionWindow').dialog("close");
						$("#permissionTable").datagrid("reload"); 
					}
				}]
			});    
		}
		
		function update(index){
			var row = $("#permissionTable").datagrid('getData').rows[index];
			var id = row.id;
			var prohibition = row.prohibition;
			if("0" == prohibition){
				$.messager.alert("错误提示","该记录无法操作","error");
				return ;
			}
			
			$('#permissionWindow').dialog({    
			    title: '修改',    
			    width: 600,    
			    height: 450,    
			    closed: false,    
			    cache: false,
			    data:{"id":id},
			    href: '${pageContext.request.contextPath}/permission/show.do?id='+id+'&x='+new Date().getTime(),  
			    modal: true,
			    buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$('#permissionForm').form('submit', {    
						    url:"${pageContext.request.contextPath}/permission/permission_update.do?x="+new Date().getTime(),    
						    onSubmit: function(){    
						    	var isValid = $(this).form('validate');
								if (!isValid){
									layer.msg("请补全信息");
								}
								return isValid;	// 返回false终止表单提交
						    },    
						    success:function(data){ 
						    	console.log(data);
						    	$('#permissionForm').form("clear");
								$('#permissionWindow').dialog("close");
								$("#permissionTable").datagrid("reload");
						    	var str = eval('(' + data + ')');  
						    	layer.msg(str.message);
						    }
						});
					}
				},{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$('#permissionForm').form("clear");
						$('#permissionWindow').dialog("close");
						$("#permissionTable").datagrid("reload"); 
					}
				}]
			});    
		}
		
function operate(index){
	var row = $("#permissionTable").datagrid('getData').rows[index];
	var id = row.id;
	var prohibition = row.prohibition;
	if(row.status == "0"){
		$("#permissionTable").datagrid("reload");
		layer.msg("这条记录无法操作");
		return;
	}
	$.messager.confirm("友情提示","你确定要操作该条记录吗?",function(r){
		if(r){
			$.ajax({
				type:'POST',
				dataType:'json',
				url:"${pageContext.request.contextPath}/permission/permission_update_operate.do?x="+new Date().getTime(),
				data:{id:id,prohibition:prohibition},
				success:function(data){
					$("#permissionTable").datagrid("reload");
					layer.msg(data.message);
				}
			});
		}
	});
}

function del(index){
	var row = $("#permissionTable").datagrid('getData').rows[index];
	var id = row.id;
	
	if(row.status == "0"){
		$("#permissionTable").datagrid("reload");
		layer.msg("这条记录无法删除");
		return;
	}
	
	$.messager.confirm("友情提示","你确定要逻辑删除吗?",function(r){
		if(r){
			$.ajax({
				type:'POST',
				dataType:'json',
				url:"${pageContext.request.contextPath}/permission/permission_del.do?x="+new Date().getTime(),
				data:{id:id},
				success:function(data){
					$("#permissionTable").datagrid("reload");
					if(data.code == 2000){
						layer.msg(data.message);
					}else if(data.code == null || data.code == ''){
						data.code = 5000;
						layer.msg(data.message);
					}
				}
			});
		}
	});
}

function remove(){
	window.location.href='${pageContext.request.contextPath}/permission/permission_show_remove.do?x='+new Date().getTime();
}

</script>
</head>
<body>
	<div id="tb" style="padding:5px;">
		<a onclick="showAddPermissionWindow()" class="easyui-linkbutton" style="margin-left:10px;" data-options="iconCls:'icon-add'">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">恢复/删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	
	<table id="permissionTable"></table>
	
	<div id="permissionWindow"></div>	
		
		
</body>
</html>