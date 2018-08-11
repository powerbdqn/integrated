<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" co	ntent="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>登录</title>
		<link rel="stylesheet" href="<%=basePath %>/static/plugins/layui/css/layui.css" media="all" />
		 <script src="<%= basePath %>static/plugins/layui/layui.js"></script>
		<link rel="stylesheet" href="<%= basePath %>static/css/login.css" />
	
	</head>

	<body class="beg-login-bg" style="background-image:url(static/images/bg_logo.jpg);background-size:100%,100%;">
		<div class="beg-login-box">
			<header>
				<h1><font color="pink">石家庄北大青鸟 一体化平台</font></h1>
			</header>			
			<div class="beg-login-main">
			
				<form action="${pageContext.request.contextPath}/user_login.do" class="layui-form" method="post">
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input type="text" name="username" lay-verify="requeired" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password" name="password" lay-verify="requeired" autocomplete="off" placeholder="这里输入密码" class="layui-input">
					</div>
					
					
					  <div class="layui-form-item">
					    <div class="layui-input-block" style="margin-left: 0px;">
					      <select name="city" lay-verify="required">
					        <option value="" >请选择身份</option>
					        <option value="0">教师</option>
					        <option value="1">学生</option>
					        <option value="2">游客</option>
					      </select>
					    </div>
  					</div>
					  
					  
					<div class="layui-form-item">
						<div class="beg-pull-right">
							<button class=" layui-btn" style="width:270px" lay-submit lay-filter="login">
	                            <i class="layui-icon ">&#xe650;</i> 登录
	                        </button>
						</div>
						<!-- <div class="beg-clear"></div> -->
					</div>
				</form>
			</div>
			<footer>
				<p style="color:#2F4056;">石家庄北大青鸟示范班&nbsp;技术支持</p>
			</footer>
		</div>
		<script>
		layui.use('form', function() {
			var form = layui.form;
			//监听提交
			form.on('submit(*)', function(data) {
				return false;
			});
		});
		</script>
	</body>

</html>