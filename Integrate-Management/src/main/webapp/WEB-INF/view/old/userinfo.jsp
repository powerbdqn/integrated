<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                $("body").css({visibility:"visible"});
                $('#save').click(function(){
                    $('#form').submit();
                });
                
                // 获取所有角色信息，生成checkbox列表
                $.get("role_list.do" , function(data){
                    // 遍历所有角色数据
                    $(data).each(function(){
                        // 生成checkbox 
                        var checkbox = $("<input type='checkbox' name='cRoleIds' />");
                        checkbox.val(this.id);
                        $("#roleTD").append(checkbox);
                        $("#roleTD").append(this.name);
                    });
                });
            });
        </script>
    </head>

    <body class="easyui-layout" style="visibility:hidden;">
        <div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
            <div class="datagrid-toolbar">
                <a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
            </div>
        </div>
        <div region="center" style="overflow:auto;padding:5px;" border="false">
            <form id="form" method="post" action="../../user_save.action"> 
                <table class="table-edit" width="95%" align="center">
                    <tr class="title">
                        <td colspan="4">基本信息</td>
                    </tr>
                    <tr>
                        <td>用户名:</td>
                        <td>
                            <input type="text" name="cUsername" id="username" class="easyui-validatebox" required="true" />
                        </td>
                        <td>口令:</td>
                        <td>
                            <input type="password" name="cPassword" id="password" class="easyui-validatebox" required="true" validType="minLength[5]" />
                        </td>
                    </tr>
                    <tr>
                        <td>真实姓名:</td>
                        <td colspan="3">
                            <input type="text" name="cPickname" id="nickname" class="easyui-validatebox" required="true" />
                        </td>
                    </tr>
                    <tr class="title">
                        <td colspan="4">其他信息</td>
                    </tr>
                    <tr>
                        <td>工资:</td>
                        <td>
                            <input type="text" name="cSalary" id="salary" class="easyui-numberbox" />
                        </td>
                        <td>生日:</td>
                        <td>
                            <input type="text" name="cBirthday" id="birthday" class="easyui-datebox" />
                        </td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td>
                            <select name="cGender" id="gender" class="easyui-combobox" style="width: 150px;">
                                <option value="">请选择</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </td>
                        <td>单位:</td>
                        <td>
                            <select name="cStation" id="station" class="easyui-combobox" style="width: 150px;">
                                <option value="">请选择</option>
                                <option value="总公司">总公司</option>
                                <option value="分公司">分公司</option>
                                <option value="厅点">厅点</option>
                                <option value="基地运转中心">基地运转中心</option>
                                <option value="营业所">营业所</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>联系电话</td>
                        <td colspan="3">
                            <input type="text" name="cTelephone" id="telephone" class="easyui-validatebox" required="true" />
                        </td>
                    </tr>
                    <tr>
                        <td>角色:</td>
                        <td id="roleTD" colspan="3">
                        </td>
                    </tr>
                    <tr>
                        <td>备注:</td>
                        <td colspan="3">
                            <textarea style="width:80%"></textarea>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>