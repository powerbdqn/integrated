/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-06 06:56:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class question_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("static/plugins/layui/css/layui.css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("static/plugins/layui/layui.all.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("static/plugins/layui/css/modules/laydate/default/laydate.css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("static/js/tool.js\"></script>\r\n");
      out.write("<title>单选题列表</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"main-body\">\t\r\n");
      out.write("\t<div class=\"layui-body\" style=\"position: absolute;left:0px;\">\r\n");
      out.write("\t\t<div style=\"padding:15px;\">\r\n");
      out.write("\t\t\t<!--试题管理-->\r\n");
      out.write("\t\t\t<div class=\"layui-btn-container\" style=\"margin-left:60px;\">\r\n");
      out.write("\t\t\t\t<button class=\"layui-btn\">发布试题</button>\r\n");
      out.write("\t\t\t\t<button id=\"importQuestionId\" class=\"layui-btn\">导入试题</button>\r\n");
      out.write("\t\t\t\t<button class=\"layui-btn\">批量删除</button>\r\n");
      out.write("\t\t\t\t<button class=\"layui-btn\">下载模板</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr class=\"layui-bg-green\" style=\"margin-bottom: 20px;\">\r\n");
      out.write("\t\t\t<form class=\"layui-form\" method=\"post\" action=\"question/dynSearch.do\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\" style=\"margin-left:60px;\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<select lay-filter=\"addOptionsOfStage\" name=\"stage\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">按阶段查询</option>\r\n");
      out.write("\t\t\t\t\t\t\t<optgroup id=\"stage\" label=\"请选择题目阶段\"></optgroup>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<select lay-filter=\"addOptionsOfBooks\" name=\"books\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">按书名查询</option>\r\n");
      out.write("\t\t\t\t\t\t\t<optgroup id=\"books\" label=\"请选择书名\"></optgroup>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<select name=\"chapter\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">按章节查询</option>\r\n");
      out.write("\t\t\t\t\t\t\t<optgroup id=\"chapter\" label=\"请选择章节\"></optgroup>\r\n");
      out.write("\t\t\t\t\t\t</select>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\" >\r\n");
      out.write("\t\t\t\t\t\t <input id=\"startTime\" type=\"text\" name=\"startTime\" lay-filter=\"timeValidate\" placeholder=\"起始时间\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t <input id=\"endTime\" type=\"text\" name=\"endTime\" lay-filter=\"timeValidate\" placeholder=\"结束时间\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\" style=\"margin-left:60px;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\" >\r\n");
      out.write("\t\t\t\t\t\t<select lay-filter=\"addOptionsOfQuestionTypes\" name=\"questionTypes\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">按题型查询</option>\r\n");
      out.write("\t\t\t\t\t\t\t<optgroup id=\"questionTypes\" label=\"请选择题目题型\"></optgroup>\r\n");
      out.write(" \t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\t<!-- required lay-verify=\"required\" -->\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"title\"  placeholder=\"请输入题目名称\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\t<!-- required lay-verify=\"required\" -->\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"title\"  placeholder=\"请输入题目内容\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\" style=\"width:400px\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"layui-btn\" lay-submit lay-filter=\"submitFormFilter\" style=\"width:190px\">查询</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"reset\" class=\"layui-btn layui-btn-primary\" style=\"width:190px\">重置</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<hr class=\"layui-bg-green\" style=\"margin-bottom: 20px;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<table  lay-skin=\"nob\" id=\"test\" lay-filter=\"tableFilter\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/html\" id=\"tableBar\">\r\n");
      out.write("  <a class=\"layui-btn layui-btn-primary layui-btn-xs\" lay-event=\"show\" style=\"height: 30px;line-height: 30px;padding: 0 10px;\" >详情</a>\r\n");
      out.write("  <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\" style=\"height: 30px;line-height: 30px;padding: 0 10px;\" >编辑</a>\r\n");
      out.write("  <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\" style=\"height: 30px;line-height: 30px;padding: 0 10px;\" >删除</a>\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/html\" id=\"checkboxTpl\">\r\n");
      out.write("  <input type=\"checkbox\" name=\"lock\" value=\"{{d.prohibition}}\" title=\"禁用中\" lay-filter=\"lockDemo\" {{ d.prohibition == 1 ? 'checked' : '' }}>\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("layui.use(['form','laydate', 'laypage', 'layer', 'table', 'carousel','upload', 'element' ], function() {\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t   layui控件声明                                                              //  \r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("\tvar layer = layui.layer;\r\n");
      out.write("\tvar laydate = layui.laydate;\r\n");
      out.write("\tvar form = layui.form;\r\n");
      out.write("\tvar element = layui.element;\r\n");
      out.write("\tvar table = layui.table;\r\n");
      out.write("\tvar $ = layui.jquery;\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t        页面加载欢迎词                                                               //  \r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("\tform.render();\r\n");
      out.write("\tlayer.msg('你好,欢迎来到题库列表页面');\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t   layui下拉框事件                                                           //  \r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\r\n");
      out.write("\t//题目类型\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\tdataType:'json',\r\n");
      out.write("\t\ttype:'POST',\r\n");
      out.write("\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/questionTypes/listQuestionTypes.do?x='+new Date().getTime(),\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t$.each(data,function(i,v){\r\n");
      out.write("\t\t\t\t$(\"#questionTypes\").append(\"<option value='\"+v.id+\"'>\"+v.name+\"</option>\");\r\n");
      out.write("\t\t\t});\t\r\n");
      out.write("\t\t\tform.render('select');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t//阶段\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\tdataType:'json',\r\n");
      out.write("\t\ttype:'POST',\r\n");
      out.write("\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/stage/liststages.do?x='+new Date().getTime(),\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t$.each(data,function(i,v){\r\n");
      out.write("\t\t\t\t$(\"#stage\").append(\"<option value='\"+v.id+\"'>\"+v.name+\"</option>\");\r\n");
      out.write("\t\t\t});\t\r\n");
      out.write("\t\t\tform.render('select');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//form.render('select');\r\n");
      out.write("\t//-------------------\r\n");
      out.write("\t//监听select 选中其值\r\n");
      out.write("\tform.on('select(addOptionsOfQuestionTypes)', function(data){\r\n");
      out.write("\t \t//alert(data.value);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//通过监听阶段select ajax书名集合\r\n");
      out.write("\tform.on('select(addOptionsOfStage)', function(data){\r\n");
      out.write("\t\t$(\"#books\").empty();\r\n");
      out.write("\t\t$(\"#chapter\").empty();\r\n");
      out.write("\t\t var index = data.value;\r\n");
      out.write("\t\t $.ajax({\r\n");
      out.write("\t\t\tdataType:'json',\r\n");
      out.write("\t\t\t\ttype:'POST',\r\n");
      out.write("\t\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\tstageId:index\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/books/getBooksByStageId.do?x='+new Date().getTime(),\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t$.each(data,function(i,v){\r\n");
      out.write("\t\t\t\t\t\t$(\"#books\").append(\"<option value='\"+v.id+\"'>\"+v.name+\"</option>\");\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t\t\t\tform.render('select');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t });\r\n");
      out.write("\t});  \r\n");
      out.write("\t\r\n");
      out.write("\t//通过监听书名select ajax章节集合\r\n");
      out.write("\tform.on('select(addOptionsOfBooks)',function(data){\r\n");
      out.write("\t\t$(\"#chapter\").empty();\r\n");
      out.write("\t\tvar a = data.stageId;\r\n");
      out.write("\t\tvar index = data.value;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\tdataType:'json',\r\n");
      out.write("\t\t\ttype:'POST',\r\n");
      out.write("\t\t\tdata:{\r\n");
      out.write("\t\t\t\tbooksId:index\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/chapter/getChapterByBooksId.do?x='+new Date().getTime(),\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t$.each(data,function(i,v){\r\n");
      out.write("\t\t\t\t\t$(\"#chapter\").append(\"<option value='\"+v.id+\"'>\"+v.name+\"</option>\");\r\n");
      out.write("\t\t\t});\t\r\n");
      out.write("\t\t\tform.render('select');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t });\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t   layui表单提交                                                              //  \r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\r\n");
      out.write("\tform.on('submit(submitFormFilter)', function(data) {\r\n");
      out.write("\t\t//layer.msg(JSON.stringify(data.field));\r\n");
      out.write("\t\talert(\"a\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t});\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t\t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t           layui日期控件                                                              //  \r\n");
      out.write("//\t\t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar startDate=laydate.render({\r\n");
      out.write("\t            elem: '#startTime',\r\n");
      out.write("\t            mark: {\r\n");
      out.write("\t                '0-0-1': '月考'\r\n");
      out.write("\t                  } ,\r\n");
      out.write("\t            type: 'date',\r\n");
      out.write("\t            max:\"2030-12-31\",//设置一个默认最大值\r\n");
      out.write("\t            done: function(value, date){\r\n");
      out.write("\t                endDate.config.min ={\r\n");
      out.write("\t                    year:date.year,\r\n");
      out.write("\t                    month:date.month-1, //关键\r\n");
      out.write("\t                    date: date.date/* ,\r\n");
      out.write("\t                    hours: 0,\r\n");
      out.write("\t                    minutes: 0,\r\n");
      out.write("\t                    seconds : 0 */\r\n");
      out.write("\t                };\r\n");
      out.write("\t            }\r\n");
      out.write("\t        });\r\n");
      out.write("\tvar endDate= laydate.render({\r\n");
      out.write("\t          elem: '#endTime',//选择器结束时间\r\n");
      out.write("\t          mark: {\r\n");
      out.write("\t                '0-0-1': '月考'\r\n");
      out.write("\t                  } ,\r\n");
      out.write("\t          type: 'date',\r\n");
      out.write("\t          min:\"2018-08-01\",//设置min默认最小值\r\n");
      out.write("\t          done: function(value,date){\r\n");
      out.write("\t              startDate.config.max={\r\n");
      out.write("\t                  year:date.year,\r\n");
      out.write("\t                  month:date.month-1,//关键\r\n");
      out.write("\t                  date: date.date/* ,\r\n");
      out.write("\t                  hours: 0,\r\n");
      out.write("\t                  minutes: 0,\r\n");
      out.write("\t                  seconds : 0 */\r\n");
      out.write("\t              }\r\n");
      out.write("\t          },\r\n");
      out.write("\t          change: function(value, date, endDate){\r\n");
      out.write("\t        \t  endDate.hint(value); //在控件上弹出value值\r\n");
      out.write("\t          }\r\n");
      out.write("\t      });\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//                     layui表格控件                                                              //  \r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("\ttable.render({\r\n");
      out.write("\t\telem:'#test',\r\n");
      out.write("\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/question/list.do?x=\"+new Date().getTime(),\r\n");
      out.write("\t\tpage:true,\r\n");
      out.write("\t\tcols:[[\r\n");
      out.write("\t\t\t{type:'checkbox',width:20},\r\n");
      out.write("\t\t\t{field : 'id'},\r\n");
      out.write("\t\t\t{field : 'name',title:'题干',width:180,align : 'center',templet:\r\n");
      out.write("\t\t\t\t'<div><span title=\"{{d.name}}\">{{d.name.substring(0,7)}}...</span></div>'},\r\n");
      out.write("\t\t\t{field : 'content',title:'内容',width:180,align : 'center',templet:\r\n");
      out.write("\t\t\t\t'<div><span title=\"{{d.content}}\">{{d.content.substring(0,7)}}...</span></div>'},\r\n");
      out.write("\t\t\t{field : 'stageId',title:'阶段',width:120,align : 'center',templet:function(d){\r\n");
      out.write("\t\t\t\tvar stageId = d.stageId;\r\n");
      out.write("\t\t\t\tif(\"1\" == stageId){return \"S1阶段\";}\r\n");
      out.write("\t\t\t\telse if(\"2\" == stageId){return \"S2阶段\";}\r\n");
      out.write("\t\t\t\telse if(\"3\" == stageId){return \"S3阶段\";}\r\n");
      out.write("\t\t\t\telse if(\"4\" == stageId){return \"Y2阶段\";}\r\n");
      out.write("\t\t\t\telse if(\"就业\" == stageId){return \"就业阶段\";}\r\n");
      out.write("\t\t\t\telse{return \"出现异常,请联系管理员\";}\r\n");
      out.write("\t\t\t}},\r\n");
      out.write("\t\t\t{field : 'booksName',title:'书名',width:180,align : 'center',templet:\r\n");
      out.write("\t\t\t\t'<div><span title=\"{{d.booksName}}\">{{d.booksName.substring(0,7)}}...</span></div>'},\r\n");
      out.write("\t\t\t{field : 'chapterName',title:'章节',width:180,align : 'center'},\r\n");
      out.write("\t\t\t{field : 'questionTypesName',title:'类型',width:80,align : 'center'},\r\n");
      out.write("\t\t\t{field : 'createTime',title:'创建时间',width:150,align : 'center',templet:function(d){return TimeFormatter(d.createTime);}},\r\n");
      out.write("\t\t\t{field : 'lock', title:'是否禁用', width:110, templet: '#checkboxTpl',align : 'center', unresize: true},\r\n");
      out.write("\t\t\t{field : 'opt',title:'操作',width:180,align : 'center',toolbar:'#tableBar'}\r\n");
      out.write("\t\t]],\r\n");
      out.write("\t\tdone: function(res, curr, count){\r\n");
      out.write("\t\t\t$(\"[data-field='id']\").css('display','none');\r\n");
      out.write("\t\t} \r\n");
      out.write("\t});\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t\t\t按钮事件                                                              //  \r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\t\r\n");
      out.write("\t$(document).on('click', '#importQuestionId', function(index) {\r\n");
      out.write("\t\t layer.open({\r\n");
      out.write("\t\t\ttitle : '导入试题模板',\r\n");
      out.write("\t\t\tcontent : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/question/showButtons.do?x='+new Date().getTime(),//内容  类型：String/DOM/Array，默认：''\r\n");
      out.write("\t\t\ttype : 2,//\r\n");
      out.write("\t\t\tbtnAlign : 'r', //按钮排列  'l' 按钮左对齐  'c'按钮居中对齐  'r' 按钮右对齐。默认值，不用设置\r\n");
      out.write("\t\t\tshadeClose : true,//是否点击遮罩关闭\r\n");
      out.write("\t\t\tfixed : true, //是否固定\r\n");
      out.write("\t\t\tresize : false,\r\n");
      out.write("\t\t\tanim : 1,//动画  0-6\r\n");
      out.write("\t\t\tarea : [ '670px', '250px' ], //大小   'auto'\r\n");
      out.write("\t\t\tshade : [ 0.3, '#000' ], //遮罩\r\n");
      out.write("\t\t\tbtn : ['关闭'], //底部按钮\r\n");
      out.write("\t\t\tyes : function(index, layero) {//按钮回调\r\n");
      out.write("\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t$(\".layui-laypage-btn\")[0].click();\r\n");
      out.write("\t\t\t\tlayer.msg(\"您取消了上传操作\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t\t   行内按钮事件                                                              //  \r\n");
      out.write("//\t                                                       //\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("\ttable.on('tool(tableFilter)',function(obj){\r\n");
      out.write("\t\tvar data = obj.data;\r\n");
      out.write("\t\tvar event = obj.event;\r\n");
      out.write("\t\tvar id = data.id;\r\n");
      out.write("\t\tif(\"show\" == event){\r\n");
      out.write("\t\t\tlayer.open({\r\n");
      out.write("\t\t\t\ttitle : '查看详情',\r\n");
      out.write("\t\t\t\tcontent : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/question/show.do?x='+new Date().getTime(),\r\n");
      out.write("\t\t\t\ttype : 2,//\r\n");
      out.write("\t\t\t\tbtnAlign : 'r', //按钮排列  'l' 按钮左对齐  'c'按钮居中对齐  'r' 按钮右对齐。默认值，不用设置\r\n");
      out.write("\t\t\t\tshadeClose : true,//是否点击遮罩关闭\r\n");
      out.write("\t\t\t\tfixed : true, //是否固定\r\n");
      out.write("\t\t\t\tresize : false,\r\n");
      out.write("\t\t\t\tanim : 1,//动画  0-6\r\n");
      out.write("\t\t\t\tarea : [ '900px', '450px' ], //大小   'auto'\r\n");
      out.write("\t\t\t\tmaxWidth : 900, //自适应最大宽度\r\n");
      out.write("\t\t\t\tmaxHeight : 700,//自适应最小宽度\r\n");
      out.write("\t\t\t\tshade : [ 0.3, '#000' ], //遮罩\r\n");
      out.write("\t\t\t\tsuccess:function(layero, index){\r\n");
      out.write("\t\t\t\t\tvar iframe = window['layui-layer-iframe' + index];\r\n");
      out.write("\t\t\t\t\tiframe.child(data);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tbtn : ['关闭'], //底部按钮\r\n");
      out.write("\t\t\t\tyes : function(index, layero) {//按钮回调\r\n");
      out.write("\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}else if('edit' == event){\r\n");
      out.write("\t\t\tlayer.open({\r\n");
      out.write("\t\t\t\ttitle : '查看详情',\r\n");
      out.write("\t\t\t\tcontent : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/question/show.do?x='+new Date().getTime(),\r\n");
      out.write("\t\t\t\ttype : 2,//\r\n");
      out.write("\t\t\t\tbtnAlign : 'r', //按钮排列  'l' 按钮左对齐  'c'按钮居中对齐  'r' 按钮右对齐。默认值，不用设置\r\n");
      out.write("\t\t\t\tshadeClose : true,//是否点击遮罩关闭\r\n");
      out.write("\t\t\t\tfixed : true, //是否固定\r\n");
      out.write("\t\t\t\tresize : false,\r\n");
      out.write("\t\t\t\tanim : 1,//动画  0-6\r\n");
      out.write("\t\t\t\tarea : [ '900px', '450px' ], //大小   'auto'\r\n");
      out.write("\t\t\t\tmaxWidth : 900, //自适应最大宽度\r\n");
      out.write("\t\t\t\tmaxHeight : 700,//自适应最小宽度\r\n");
      out.write("\t\t\t\tshade : [ 0.3, '#000' ], //遮罩\r\n");
      out.write("\t\t\t\tsuccess:function(layero, index){\r\n");
      out.write("\t\t\t\t\tvar iframe = window['layui-layer-iframe' + index];\r\n");
      out.write("\t\t\t\t\tiframe.child(data);\r\n");
      out.write("\t\t\t\t\tvar childNameElement = iframe.document.getElementById(\"nameId\");\r\n");
      out.write("\t\t\t\t\tvar childContentElement = iframe.document.getElementById(\"contentId\");\r\n");
      out.write("\t\t\t\t\tvar childAnalysisElement = iframe.document.getElementById(\"analysisId\");\r\n");
      out.write("\t\t\t\t\tvar childAnswerElement = iframe.document.getElementById(\"answerId\");\r\n");
      out.write("\t\t\t\t\t$(childNameElement).removeAttr(\"disabled\");\r\n");
      out.write("\t\t\t\t\t$(childContentElement).removeAttr(\"disabled\");\r\n");
      out.write("\t\t\t\t\t$(childAnalysisElement).removeAttr(\"disabled\");\r\n");
      out.write("\t\t\t\t\t$(childAnswerElement).removeAttr(\"disabled\");\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tbtn : ['保存','关闭'], //底部按钮\r\n");
      out.write("\t\t\t\tyes : function(index, layero) {//按钮回调\r\n");
      out.write("\t\t\t\t\tvar iframe = window['layui-layer-iframe' + index];\r\n");
      out.write("\t\t\t\t\tvar questionForm = iframe.document.getElementById(\"questionFormId\");\r\n");
      out.write("\t\t\t\t\t$(questionForm).submit();\r\n");
      out.write("\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t$(\".layui-laypage-btn\")[0].click();//刷新表格\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tbtn1:function(index,layero){\r\n");
      out.write("\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}else if('del' == event){\r\n");
      out.write("\t\t\tlayer.confirm('您确定要删除吗?', function(index){\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\tdataType:'json',\r\n");
      out.write("\t\t\t\t\ttype:'POST',\r\n");
      out.write("\t\t\t\t\tdata:{id:id},\r\n");
      out.write("\t\t\t\t\turl:'question/del.do',\r\n");
      out.write("\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\tif(data.status == \"200\"){\r\n");
      out.write("\t\t\t\t\t\t$(\".layui-laypage-btn\")[0].click();//刷新表格\r\n");
      out.write("\t\t\t\t\t\t\tlayer.msg(data.msg);\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\tlayer.msg(data.msg);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}); \r\n");
      out.write("\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t           启禁按钮监听                                                                //  \r\n");
      out.write("//\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\t\r\n");
      out.write("  form.on('checkbox(lockDemo)', function(obj){\r\n");
      out.write("    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);\r\n");
      out.write("  });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/////////////////////////////////////////////////////////////\t\r\n");
      out.write("//   \t\t\t\t\t\t\t\t\t\t\t\t\t   //\r\n");
      out.write("//\t\t\t\t\t日期格式化(毫秒值转日期)                     //  \r\n");
      out.write("//                                                         //\r\n");
      out.write("/////////////////////////////////////////////////////////////\r\n");
      out.write("function TimeFormatter(v){\r\n");
      out.write("\tvar date = new Date(v);\r\n");
      out.write("    var y = date.getFullYear();\r\n");
      out.write("    var m = date.getMonth()+1;\r\n");
      out.write("    m = m<10?'0'+m:m;\r\n");
      out.write("    var d = date.getDate();\r\n");
      out.write("    d = d<10?(\"0\"+d):d;\r\n");
      out.write("    var h = date.getHours();\r\n");
      out.write("    h = h<10?(\"0\"+h):h;\r\n");
      out.write("    var M = date.getMinutes();\r\n");
      out.write("    M = M<10?(\"0\"+M):M;\r\n");
      out.write("    var str = y+\"-\"+m+\"-\"+d+\" \"+h+\":\"+M;\r\n");
      out.write("    return str;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
