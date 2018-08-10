<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- 导入jquery核心类库 -->
        <script type="text/javascript" src="/Integrate-bdqn-Management/static/js/jquery-1.8.3.js"></script>
        <!-- 导入easyui类库 -->
        <link id="easyuiTheme" rel="stylesheet" type="text/css" href="/Integrate-bdqn-Management/static/js/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="/Integrate-bdqn-Management/static/js/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="/Integrate-bdqn-Management/static/css/default.css">
        <script type="text/javascript" src="/Integrate-bdqn-Management/static/js/easyui/jquery.easyui.min.js"></script>
        <!-- 导入ztree类库 -->
        <link rel="stylesheet" href="/Integrate-bdqn-Management/static/js/ztree/zTreeStyle.css" type="text/css" />
        <script src="/Integrate-bdqn-Management/static/js/ztree/jquery.ztree.all-3.5.js" type="text/javascript"></script>
        <script src="/Integrate-bdqn-Management/static/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<title>Insert title here</title>
<script type="text/javascript">
            $(function(){
                $("#grid").datagrid({
                    toolbar : [
                        {
                            id : 'add',
                            text : '添加权限',
                            iconCls : 'icon-add',
                            handler : function(){
                                location.href='to_permission_add.do';
                            }
                        }           
                    ],
                    url : 'permission_list.do',
                    columns : [[
                      {
                          field : 'id',
                          title : '编号',
                          width : 200
                      },
                      {
                          field : 'name',
                          title : '名称',
                          width : 200
                      }, 
                      {
                          field : 'keyword',
                          title : '关键字',
                          width : 200
                      },
                      {
                          field : 'description',
                          title : '描述',
                          width : 200
                      }
                    ]]
                });
            });
        </script>
    </head>

    <body class="easyui-layout">
        <div data-options="region:'center'">
            <table id="grid"></table>
        </div>
    </body>

</html>