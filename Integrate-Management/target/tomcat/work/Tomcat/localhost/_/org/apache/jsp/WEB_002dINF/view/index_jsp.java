/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-05 15:28:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("    \r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("       \t<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\t\t<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("\t\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("\t\t<meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( basePath );
      out.write("static/plugins/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("        <script src=\"");
      out.print( basePath );
      out.write("static/plugins/layui/layui.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.print(basePath );
      out.write("static/js/index.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(basePath );
      out.write("static/css/global.css\" media=\"all\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(basePath );
      out.write("static/plugins/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body >\r\n");
      out.write("\t<div class=\" layui-layout layui-layout-admin\" style=\"border-bottom: solid 5px #1aa094;\">\r\n");
      out.write("\t\t<div class=\"layui-header header header-demo\"></div>\r\n");
      out.write("\t\t<div class=\"layui-side layui-bg-black\" id=\"admin-side\">\r\n");
      out.write("\t\t\t<div class=\"layui-side-scroll\" id=\"admin-navbar-side\" lay-filter=\"side\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-body\" style=\"bottom: 0;border-left: solid 2px #1AA094;\" id=\"admin-body\">\r\n");
      out.write("\t\t\t<div class=\"layui-tab admin-nav-card layui-tab-brief\" lay-filter=\"admin-tab\">\r\n");
      out.write("\t\t\t\t<ul class=\"layui-tab-title\">\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-this\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-dashboard\" aria-hidden=\"true\"></i>\r\n");
      out.write("\t\t\t\t\t\t<cite>主页</cite>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div class=\"layui-tab-content\" style=\"min-height: 150px; padding: 5px 0 0 0;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-tab-item layui-show\">\r\n");
      out.write("\t\t\t\t\t\t<iframe src=\"toMain.do\"></iframe>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-footer footer footer-demo\" id=\"admin-footer\">\r\n");
      out.write("\t\t\t<div class=\"layui-main\">\r\n");
      out.write("\t\t\t\t<p>本系统由石家庄北大青鸟示范班  <font color=\"red\">卢富起  | 豆盼 | 郜响 | 何鹏帅 | 蔡丽薇 | 高玉龙 | 李笑行 </font>  提供技术支持 </p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
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
