/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-09 15:59:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" co\tntent=\"IE=edge\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\r\n");
      out.write("\t\t<title>登录</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(basePath );
      out.write("/static/plugins/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("\t\t <script src=\"");
      out.print( basePath );
      out.write("static/plugins/layui/layui.js\"></script>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print( basePath );
      out.write("static/css/login.css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body class=\"beg-login-bg\" style=\"background-image:url(static/images/bg_logo.jpg);background-size:100%,100%;\">\r\n");
      out.write("\t\t<div class=\"beg-login-box\">\r\n");
      out.write("\t\t\t<header>\r\n");
      out.write("\t\t\t\t<h1><font color=\"pink\">石家庄北大青鸟 一体化平台</font></h1>\r\n");
      out.write("\t\t\t</header>\t\t\t\r\n");
      out.write("\t\t\t<div class=\"beg-login-main\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user_login.do\" class=\"layui-form\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"beg-login-icon\">\r\n");
      out.write("                        <i class=\"layui-icon\">&#xe612;</i>\r\n");
      out.write("                    </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"username\" lay-verify=\"requeired\" autocomplete=\"off\" placeholder=\"这里输入登录名\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"beg-login-icon\">\r\n");
      out.write("                        <i class=\"layui-icon\">&#xe642;</i>\r\n");
      out.write("                    </label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\" lay-verify=\"requeired\" autocomplete=\"off\" placeholder=\"这里输入密码\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t  <div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\" style=\"margin-left: 0px;\">\r\n");
      out.write("\t\t\t\t\t      <select name=\"city\" lay-verify=\"required\">\r\n");
      out.write("\t\t\t\t\t        <option value=\"\" >请选择身份</option>\r\n");
      out.write("\t\t\t\t\t        <option value=\"0\">教师</option>\r\n");
      out.write("\t\t\t\t\t        <option value=\"1\">学生</option>\r\n");
      out.write("\t\t\t\t\t        <option value=\"2\">游客</option>\r\n");
      out.write("\t\t\t\t\t      </select>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"beg-pull-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\" layui-btn\" style=\"width:270px\" lay-submit lay-filter=\"login\">\r\n");
      out.write("\t                            <i class=\"layui-icon \">&#xe650;</i> 登录\r\n");
      out.write("\t                        </button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- <div class=\"beg-clear\"></div> -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<footer>\r\n");
      out.write("\t\t\t\t<p style=\"color:#2F4056;\">石家庄北大青鸟示范班&nbsp;技术支持</p>\r\n");
      out.write("\t\t\t</footer>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\tlayui.use('form', function() {\r\n");
      out.write("\t\t\tvar form = layui.form;\r\n");
      out.write("\t\t\t//监听提交\r\n");
      out.write("\t\t\tform.on('submit(*)', function(data) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
