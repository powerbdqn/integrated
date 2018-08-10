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
<script type="text/javascript">
            $(function(){
                // 点击保存
                $('#save').click(function(){
                    if($("#permissionForm").form('validate')){
                        $("#permissionForm").submit();
                    }
                });
            });
        </script>
    </head>

    <body class="easyui-layout">
        <div data-options="region:'north'">
            <div class="datagrid-toolbar">
                <a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
            </div>
        </div>
        <div data-options="region:'center'">
            <form id="permissionForm" method="post" action="permission_save.do">
                <table class="table-edit" width="80%" align="center">
                    <tr class="title">
                        <td colspan="2">权限信息</td>
                    </tr>
                    <tr>
                        <td>名称</td>
                        <td>
                            <input type="text" name="name" class="easyui-validatebox" data-options="required:true" />
                        </td>
                    </tr>
                    <tr>
                        <td>关键字</td>
                        <td>
                            <input type="text" name="keyword" class="easyui-validatebox" data-options="required:true" /> 
                        </td>
                    </tr>
                    <tr>
                        <td>描述</td>
                        <td>
                            <textarea name="description" rows="4" cols="60"></textarea>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>

</html>