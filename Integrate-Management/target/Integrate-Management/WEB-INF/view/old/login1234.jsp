<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>时韵恒通快递管理系统 登陆页面</title>
        <script src="/Integrate-bdqn-Management/static/js/jquery-1.8.3.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="/Integrate-bdqn-Management/static/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="/Integrate-bdqn-Management/static/css/login.css">
        <script src="/Integrate-bdqn-Management/static/css/jigsaw.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="/Integrate-bdqn-Management/static/css/jigsaw.css">
    </head>
<body>
        <div class="loginbox">
        <div class="loginnav">
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                    </div>
                </div>
            </nav>
        </div>
        
        <section class="mainlogin">
            <div class="container">
                <div class="col-md-4 col-md-offset-7 logincontent">
                    <h4>员工登录</h4>
                    <form class="form-horizontal" id="loginform" name="loginform" 
                        method="post" action="user_login.do">
                        <div class="form-group" id="idInputLine">
                            <label for="inputPassword3" class="col-sm-3 control-label">账号</label>
                            <div class="col-sm-8">
                                <input id="loginform:idInput" type="text" name="cUsername" class="form-control" placeholder="请输入手机号/邮箱/用户名">
                            </div>
                        </div>
                        <div class="form-group" id="pwdInputLine">
                            <label id="loginform:pwdInput" class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-8">
                                <input for="pwdInput" type="password" name="cPassword" class="form-control" placeholder="请输入您的密码">
                            </div>
                        </div>
                        
                     <!--    <div class="form-group">
                            
                            <div class="col-sm-offset-3 col-sm-4">
                                <input type="checkbox"><span class="size12">　记住用户名</span>
                            </div>
                            <div class="col-sm-4">
                                <a href="#"><span class="size12 forget">忘记密码</span></a>
                            </div>
                        </div> -->
                        <div class="col-md-offset-3 col-md-8">
                           <!--  <a href="javascript:void(0);" onclick="yanzhengma()" id="loginform:j_id19" name="loginform:j_id19"
                                 class="btn btn-danger" target="_blank">立即登录</a> -->
                                 <input  type="submit" value="登陆"/>
                        </div>
                    </form>
                     <div id="captcha" style="position: relative"></div>
                </div>
            </div>
        </section>

        </div>
        <script type="text/javascript">
                    function yanzhengma(){
                      //  $("#loginform").hide();
                       // jigsaw.init(document.getElementById('captcha'), function () {
                                $('#loginform').submit();
                       //   })
                    }
        </script>
    </body>
</html>