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
        <link rel="stylesheet" type="text/css" href="/Integrate-Management/static/layui/css/layui.css" />
        <link rel="stylesheet" type="text/css" href="/Integrate-Management/static/css/deng.css" />
        <script src="/Integrate-Management/static/layui/layui.js"></script>
</head>
<body>
        <div id="middle">
            <form action="user_login.do" method="post">
                <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" >
                <div class="layadmin-user-login-main">
                  <div class="layadmin-user-login-box layadmin-user-login-header">
                    <h2 style="text-align: center;">石家庄北大青鸟 一体化办公平台</h2>
                  </div>
                  
                  <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                    <div class="layui-form-item">
                      <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                      <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input layui-form-danger">
                    </div>
                    <div class="layui-form-item">
                      <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                      <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
                    </div>
                    <!-- <div class="layui-form-item">
                      <div class="layui-row">
                        <div class="layui-col-xs7">
                          <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                          <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                        </div>
                        <div class="layui-col-xs5">
                          <div style="margin-left: 10px;">
                            <img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="layui-form-item" style="margin-bottom: 20px; position: relative; right: 10px;">
                      <input type="checkbox" name="remember" lay-skin="primary" title="记住密码" ><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>记住密码</span><i class="layui-icon layui-icon-ok"></i></div>
                      <a href="#" class="layadmin-user-jump-change layadmin-link" id="wang-pws"  style="margin-top: 7px;">忘记密码？</a>
                    </div> -->
                    <div class="layui-form-item">
                      <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">登 入</button>
                    </div>
                   <!--  <div class="layui-trans layui-form-item layadmin-user-login-other">
                      <label style="color: #666;">社交账号登入</label>
                      <a href="javascript:;"><i class="layui-icon layui-icon-login-qq san-fang" style="color: #3492ED;"></i></a>
                      <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat san-fang" style="color: #CF1900;"></i></a>
                      
                      <a href="reg.html" class="layadmin-user-jump-change layadmin-link" style="float: right;">注册帐号</a>
                    </div> -->
                  </div>
                </div>                                          
              </div>
            </form>
        </div>
    </body>

    <script>
        //Demo
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