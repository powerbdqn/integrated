/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-10 10:44:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.system.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<title>角色管理</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("static/easyui/themes/default/easyui.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("static/easyui/themes/icon.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("static/css/default.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("static/ztree/zTreeStyle.css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("static/easyui/jquery-1.8.3.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("static/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("static/ztree/jquery.ztree.all-3.5.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("static/js/tool.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t$(\"#grid\").datagrid({\r\n");
      out.write("\t\t\t\ttoolbar : '#tb',\r\n");
      out.write("\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/user_list.do?x='+new Date().getTime(),\r\n");
      out.write("\t\t\t\tcolumns : [[\r\n");
      out.write("\t\t\t\t\t {field : 'id',rowspan : 2,checkbox:true}, \r\n");
      out.write("\t\t\t\t\t {field : 'nickName',title : '称呼',width : 100,rowspan : 2,align : 'center'}, \r\n");
      out.write("\t\t\t\t\t {field : 'identity',title : '身份',width : 100,rowspan : 2,align : 'center'}, \r\n");
      out.write("\t\t\t\t\t {field : 'opt1',title : '所带班级',width : 80,rowspan : 2,align : 'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\t\t  return \"<a href='javascript:showClass();'>点击查看</a>\";\r\n");
      out.write("\t\t\t\t\t  }}, \r\n");
      out.write("\t\t\t\t\t {field : 'opt2',title : '学生信息',width : 80,rowspan : 2,align : 'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\t\t  return \"<a href='javascript:showStudent();'>点击查看</a>\";\r\n");
      out.write("\t\t\t\t\t  }}, \r\n");
      out.write("\t\t\t\t\t  {field : 'status',title : '删除状态',width : 85,rowspan : 2,align:'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\t\t  if(value == \"1\"){\r\n");
      out.write("\t\t\t\t\t\t\t  return \"<font color='green'>未删除</font>\";\r\n");
      out.write("\t\t\t\t\t\t  }else if(value == \"0\"){\r\n");
      out.write("\t\t\t\t\t\t\t return \"<font color='red'>已删除</font>\";\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t  }},\r\n");
      out.write("\t\t\t\t\t  {field : 'prohibition',title : '启用状态',width : 85,rowspan : 2,align:'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\t\t  if(value == \"1\"){\r\n");
      out.write("\t\t\t\t\t\t\t  return \"<font color='green'>已启用</font>\";\r\n");
      out.write("\t\t\t\t\t\t  }else if(value == \"0\"){\r\n");
      out.write("\t\t\t\t\t\t\t return \"<font color='red'>未启用</font>\";\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t  }},\r\n");
      out.write("\t\t\t\t\t  {field : 'createTime',title : '创建时间',rowspan : 2,width : 150,align:'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\t\t  return dateFormatter(value);\r\n");
      out.write("\t\t\t\t\t  }},\r\n");
      out.write("\t\t\t\t\t  {field : 'telephoneA',title : '电话一',width : 140,rowspan : 2,align : 'center'}, \r\n");
      out.write("\t\t\t\t\t  {field : 'telephoneB',title : '电话二',width : 140,rowspan : 2,align : 'center'}, \r\n");
      out.write("\t\t\t\t\t  {field : 'opt',title : '操作',width : 138,rowspan : 2,align:'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\t\t  var str = \"\";\r\n");
      out.write("\t\t\t\t\t\t  str+= \"<a href='javascript:show(\"+index+\");' class='easyui-linkbutton'>详情</a>\";\r\n");
      out.write("\t\t\t\t\t\t  str += \"     /\";\r\n");
      out.write("\t\t\t\t\t\t  str+= \"<a href='javascript:update(\"+index+\");' class='easyui-linkbutton'>修改</a>\";\r\n");
      out.write("\t\t\t\t\t\t  str += \"     /\";\r\n");
      out.write("\t\t\t\t\t\t  str+= \"<a href='javascript:update(\"+index+\");' class='easyui-linkbutton'>启禁</a>\";\r\n");
      out.write("\t\t\t\t\t\t  str += \"     /\";\r\n");
      out.write("\t\t\t\t\t\t  str+= \"<a href='javascript:del(\"+index+\");' class='easyui-linkbutton'>删除</a>\";\r\n");
      out.write("\t\t\t\t\t  \t  return str;\r\n");
      out.write("\t\t\t\t\t  }}\r\n");
      out.write("\t\t\t\t\t]],\r\n");
      out.write("\t\t\t\tpagination:true,\r\n");
      out.write("\t\t\t\tfit:true,\r\n");
      out.write("\t\t\t\trownumbers:true,\r\n");
      out.write("\t\t\t\tsingleSelect:true\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction toPermissionView(){\r\n");
      out.write("\t\t\twindow.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/toAddUserView.do?x='+new Date().getTime();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"tb\">\r\n");
      out.write("\t\t<a onclick=\"toPermissionView()\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\">新增</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<table id=\"grid\"></table>\r\n");
      out.write("</body>\r\n");
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
