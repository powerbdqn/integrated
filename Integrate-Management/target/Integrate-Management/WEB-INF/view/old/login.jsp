<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="<%= basePath %>static/layui/css/layui.css" />
        <link rel="stylesheet" type="text/css" href="<%= basePath %>static/css/deng.css" />
        <script src="<%= basePath %>static/layui/layui.js"></script>
		<script src="<%= basePath %>static/js/login.js"></script>
	</head>

	<body background="<%= basePath %>static/images/b3.jpg" style="background-size: 100%,100%S;background-repeat:no-repeat ;">
		<img src="<%= basePath %>static/images/logo1.png" style="float: left; margin-left: 50px; margin-top: 50px;"/>
		<div id="middle">
			<form action="user_login.do" method="post">
				<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" >
			    <div class="layadmin-user-login-main">
			      <div class="layadmin-user-login-box layadmin-user-login-header">
			        <h2 style="text-align: center;color:red;">石家庄北大青鸟</h2>
			      </div>
			      
			      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
			        <div class="layui-form-item" style="z-index: 2;">
			          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
			          <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input layui-form-danger">
			        </div>
			        <div class="layui-form-item" style="position: relative;top: -10px;">
			          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
			          <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
			        </div>
			        <div class="layui-form-item">
			         <label class="form-inline">
							<div class="form-inline-input">
								<div class="code-box" id="code-box">
									<input type="text" name="code" class="code-input" />
									<p></p>
									<span>>>></span>
								</div>
							</div>
						</label>
			        </div>
			        <div class="layui-form-item">
			          <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">登 入</button>
			        </div>
			   
			      </div>
			    </div>			 			    			    
			  </div>
				
			</form>
			
		</div>
	
	</body>

	<script>
		layui.use('form', function() {
			var form = layui.form;
			//监听提交
			form.on('submit(formDemo)', function(data) {
				layer.msg(JSON.stringify(data.field));
				return false;
			});
		});
	</script>
</html>