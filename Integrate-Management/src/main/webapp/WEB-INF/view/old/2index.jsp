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
        <link rel="stylesheet" type="text/css" href="/Integrate-bdqn-Management/static/layui/css/layui.css" />
        <script src="/Integrate-bdqn-Management/static/layui/layui.js"></script>
        <script type="text/javascript">
      //菜单循环遍历打印拼接操作
      
      layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){
    	  
    	  var $ = layui.jquery;
    	  var element = layui.element;
          $.ajax( {
              url : 'menu_showmenu.do',
              type : 'post',
              dataType : 'json',
              success : function(data) {
                  var menu = ""; //定义变量存储
                  for(var i = 0;i<data.length;i++){
                      menu += "<li class='layui-nav-item '>"
                      if(data[i].pid == 0){ //取出父元素的菜单，拼进页面
                          menu +=        "<a href='javascript:;'>"+data[i].name+"</a>"
                          for(var j = 0;j<data.length;j++){ //继续遍历这几条数据
                              if(data[j].id > data[i].id && data[j].id < (data[i].id)+1000){ //取出这个父元素所对应的子元素
                                  menu +=    "<dl class='layui-nav-child'>"
                                  menu +=        "<dd>"
                                  menu +=            "<a href='"+data[j].page+"' target='option'>"+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data[j].name+"</a>"
                                  menu +=        "</dd>"
                                  menu +=    "</dl>"
                              }
                          }
                      }
                      menu +=    "</li>";
                  }
                  $("#nav").html(menu);
                  
                  element.init()//初始化element事件，使菜单展开
              }
          });
    	  
      });
   
        </script>
    </head>

    <body class="easyui-layout">
        <div data-options="region:'north',border:false" style="height:80px;padding:10px;background:url('./images/header_bg.png') no-repeat right;"></div>
        
        <div data-options="region:'west',split:true,title:'菜单导航'" style="width:200px">
            <div class="easyui-accordion" fit="true" border="false" id="one">
                <div title="基本功能" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
                    <ul id="treeMenu" class="ztree"></ul>
                </div>
            </div>
        </div>
        
        <div data-options="region:'center'">
            <div id="tabs" fit="true" class="easyui-tabs" border="false"></div>
        </div>
    </body>

</html>