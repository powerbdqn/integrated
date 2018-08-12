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
				//$('.panel-tool-close').hide();
				/* var reg = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}$)/; */
				var reg = /^[1-9](\d{16}|\d{13})[0-9xX]$/;
				
				var result = $("input [name='sex']").val();
				if(result == '1'){
					$("input [name='sex']").attr("checked","checked");
				}
				console.log(result);
				$.messager.prompt('用户信息校验', '请输入您要添加的用户身份证号码', function(r){
					if (r){
						if(reg.test(r) === false){
							window.location.href="${pageContext.request.contextPath}/user/toUser.do?x="+ new Date().getTime();
							parent.layer.msg("您输入的身份证不合法");
						}else{
							$.ajax({
								type:'POST',
								dataType:'json',
								data:{"card":r},
								url:'${pageContext.request.contextPath}/user/check_card.do?x='+ new Date().getTime(),
								success:function(data){
									console.log(data);
									if(data.code == 2000){
										$("#username").val(data.obj.username);
										$("#password").val(data.obj.password);
										$("#birthday").val(dateFormatter(data.obj.birthday));
										$("#cord").val(data.obj.cord);
										$("#address").val(data.obj.address);
										$("#errorId").text(data.obj.msg);
									}else if(data.code == 5000){
										window.location.href="${pageContext.request.contextPath}/user/toUser.do?x="+ new Date().getTime();
										parent.layer.msg(data.message);
									}else{
										if(data.code == '' || data.code == null || data.code == undefined){
											data.code = 5000;
											return;
										}
									}
								}
							});
						}
					}else{
						window.location.href="${pageContext.request.contextPath}/user/toUser.do?x="+ new Date().getTime();
						parent.layer.msg("您取消了添加操作");
					}
				});
				
			
				
				$('#save').click(function(){
					$('#form').submit();
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
				
				
				
				
				function undo(){
					$("#form").form('clear');
					$("#grid").datagrid('reload');
					window.location.href="${pageContext.request.contextPath}/user/toUser.do?x="+ new Date().getTime();
					parent.layer.msg("您取消了添加操作");
				}
			});
			
			function checkUsername(){
				var username = $("#username").val();
				if(username == null || username == ''){
					parent.layer.msg("用户名不能为空");
					return;
				}
			}
		
			
			
	</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="undo" icon="icon-undo" href="#" class="easyui-linkbutton" plain="true">返回</a>
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<span><font id="errorId" color='red'>${data.obj.msg}</font></span>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="form" method="post" action="../../user_save.action"> 
				<table class="table-edit" width="95%" align="center">
					<tr class="title">
						<td colspan="4">基本信息</td>
					</tr>
					<tr>
						<td>登录账号</td>
						<td>
							<input id="username" name="username" type="text"   class="easyui-validatebox" required="true" disabled="disabled" />
						</td>
						<td>登录密码</td>
						<td>
							<input id="password" name="password" type="text"   class="easyui-validatebox" required="true" validType="minLength[5]" />
						</td>
					</tr>
					
					<tr>
						<td>真实姓名</td>
						<td>
							<input id="nickName" name="nickName" type="text"   class="easyui-validatebox" required="true" />
						</td>
						
						<td>身份证号</td>
						<td>
							<input id="cord" name="cord" type="text" class="easyui-numberbox" required="true" disabled="disabled" />
						</td>
					</tr>
					
					
					<tr class="title" style="margin-top:20px;">
						<td colspan="4">重要信息</td>
					</tr>
					
					<tr>
						<td>用户身份</td>
						<td>
							<select name="station" id="station" class="easyui-combobox" style="width: 175px;">
								<option value="">请选择</option>
								<option value="总公司">总公司</option>
								<option value="分公司">分公司</option>
								<option value="厅点">厅点</option>
								<option value="基地运转中心">基地运转中心</option>
								<option value="营业所">营业所</option>
							</select>
						</td>
						<td>所在部门</td>
						<td>
							<select name="station" id="station" class="easyui-combobox" style="width: 175px;">
								<option value="">请选择</option>
								<option value="总公司">总公司</option>
								<option value="分公司">分公司</option>
								<option value="厅点">厅点</option>
								<option value="基地运转中心">基地运转中心</option>
								<option value="营业所">营业所</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>赋予角色</td>
						<td id="roleTD" colspan="3"></td>
					</tr>
					
					<tr class="title">
						<td colspan="4">其他信息</td>
					</tr>
					
					<tr>
						<td>常用邮箱</td>
						<td>
							<input id="email" name="email" type="text" class="easyui-validatebox" validType='email' required="true" />
						</td>
						<td>用户生日</td>
						<td>
							<input id="birthday" name="birthday" type="text" class="easyui-validatebox" disabled="disabled" />
						</td>
					</tr>
					
					<tr>
						<td>用户性别</td>
						<td>
							<input type="radio" name="sex" value="1" >男
							<input type="radio" name="sex" value="0" >女
						</td>
						<td>用户地址</td>
						<td>
							<input id="address" name="address" type="text" class="easyui-validatebox"  style="width: 570px;"/>
						</td>
					</tr>
					<tr>
						<td>联系电话一</td>
						<td>
							<input id="telephoneA" name="telephoneA" type="text"   class="easyui-validatebox" required="true" />
						</td>
						<td>联系电话二</td>
						<td>
							<input id="telephoneB" name="telephoneB" type="text"   class="easyui-validatebox"/>
						</td>
					</tr>
					<tr>
						<td>备注:</td>
						<td colspan="3">
							<textarea style="width:750px;height:150px"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>