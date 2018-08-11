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
	<title>菜单管理</title>
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
			$("#grid").datagrid({
				toolbar : '#tb',
				url : '${pageContext.request.contextPath}/menu/menu_list.do?x='+new Date().getTime(),
				columns : [[
					{field : 'id',title : '编号',width : 50,checkbox:true},
					{field : 'title',title : '名称',width : 100,align:'center'},
					{field : 'href',title : '路径',width : 120,align:'center'},
					{field : 'description',title : '描述',width : 110,align:'center'},  
					{field : 'priority',title : '优先级',width : 40,align:'center'},
					{field : 'status',title : '删除状态',width : 75,align:'center',formatter:function(value,row,index){
						  if(value == "1"){
							  return "<font color='green'>未删除</font>";
						  }else if(value == "0"){
							 return "<font color='red'>已删除</font>";
						  }
					  }},
					  {field : 'prohibition',title : '启用状态',width : 75,align:'center',formatter:function(value,row,index){
						  if(value == "1"){
							  return "<font color='green'>已启用</font>";
						  }else if(value == "0"){
							 return "<font color='red'>未启用</font>";
						  }
					  }},
					  {field : 'createUser',title : '创建人',width : 90,align:'center'},
					  {field : 'createTime',title : '创建时间',width : 140,align:'center',formatter:function(value,row,index){
						  return dateFormatter(value);
					  }},
					  {field : 'modifyUser',title : '修改人',width : 90,align:'center'},
					  {field : 'mdifyTime',title : '修改时间',width : 140,align:'center',formatter:function(value,row,index){
						  return dateFormatter(value);
					  }},
					  {field : 'opt',title : '操作',width : 115,align:'center',formatter:function(value,row,index){
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
		
		//新增
		function showAddMenuWindow(){
			$('#menuForm').form("clear");
			$('#menuWin').dialog({    
			    title: '新增',    
			    width: 600,    
			    height: 450,    
			    closed: false,    
			    cache: false,    
			    href: '${pageContext.request.contextPath}/menu/show.do?x='+new Date().getTime(),  
			    modal: true,
			    buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$('#menuForm').form('submit', {    
						    url:'${pageContext.request.contextPath}/menu/menu_save.do?x='+new Date().getTime(),   
						    onSubmit: function(){    
						    	var isValid = $(this).form('validate');
								if (!isValid){
									layer.msg('请补全信息。。。');
								}
								return isValid;	// 返回false终止表单提交
						    },    
						    success:function(data){ 
						    	console.log(data);
						    	$('#menuForm').form("clear");
								$('#menuWin').dialog("close");
								$("#grid").datagrid("reload");
						    	var str = eval('(' + data + ')');  
						    	layer.msg(str.msg);
						    }
						});
					}
				},{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$('#menuForm').form("clear");
						$('#menuWin').dialog("close");
						$("#grid").datagrid("reload"); 
					}
				}]
			});    
		}
		
		//修改
		function update(index){
			var row = $("#grid").datagrid('getData').rows[index];
			var id = row.id;
			$('#menuWin').dialog({    
			    title: '修改',    
			    width: 600,    
			    height: 450,    
			    closed: false,    
			    cache: false,
			    data:{"id":id},
			    href: '${pageContext.request.contextPath}/menu/show.do?id='+id+'&x='+new Date().getTime(),  
			    modal: true,
			    buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$('#menuForm').form('submit', {    
						    url:"${pageContext.request.contextPath}/menu/menu_update.do?id="+id+"&x="+new Date().getTime(),    
						    onSubmit: function(){    
						    	var isValid = $(this).form('validate');
								if (!isValid){
									layer.msg("请补全信息");
								}
								return isValid;	// 返回false终止表单提交
						    },    
						    success:function(data){ 
						    	console.log(data);
						    	$('#menuForm').form("clear");
								$('#menuWin').dialog("close");
								$("#grid").datagrid("reload");
						    	var str = eval('(' + data + ')');  
						    	layer.msg(str.msg);
						    }
						});
					}
				},{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$('#menuForm').form("clear");
						$('#menuWin').dialog("close");
						$("#grid").datagrid("reload"); 
					}
				}]
			});    
		}
		
		function del(index){
			var row = $("#grid").datagrid('getData').rows[index];
			var id = row.id;
			
			if(row.status == "0"){
				$("#grid").datagrid("reload");
				layer.msg("这条记录无法删除");
				return;
			}
			
			$.messager.confirm("友情提示","你确定要逻辑删除吗?",function(r){
				if(r){
					$.ajax({
						type:'POST',
						dataType:'json',
						url:"${pageContext.request.contextPath}/menu/menu_del.do?x="+new Date().getTime(),
						data:{id:id},
						success:function(data){
							$("#grid").datagrid("reload");
							layer.msg(data.msg);
						}
					});
				}
			});
		}
		
		
		function operate(index){
			var row = $("#grid").datagrid('getData').rows[index];
			var id = row.id;
			var prohibition = row.prohibition;
			if(row.status == "0"){
				$("#grid").datagrid("reload");
				layer.msg("这条记录无法操作");
				return;
			}
			$.messager.confirm("友情提示","你确定要操作该条记录吗?",function(r){
				if(r){
					$.ajax({
						type:'POST',
						dataType:'json',
						url:"${pageContext.request.contextPath}/menu/menu_update_operate.do?x="+new Date().getTime(),
						data:{id:id,prohibition:prohibition},
						success:function(data){
							$("#grid").datagrid("reload");
							layer.msg(data.msg);
						}
					});
				}
			});
		}
		
		
		function remove(){
			window.location.href='${pageContext.request.contextPath}/menu/menu_show_remove.do?x='+new Date().getTime();
		}
	</script>
	
	
	
	
</head>
<body>
	<div id="tb" style="padding:5px;">
		&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="showAddMenuWindow()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增菜单</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">恢复/删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
		<table id="grid"></table>
		
	<div id="menuWin"></div>
	
	<div id="remWin"></div>
</body>
</html>