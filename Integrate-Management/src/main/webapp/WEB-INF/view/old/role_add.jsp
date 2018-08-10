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
                // 授权树初始化
                var setting = {
                    data : {
                        key : {
                            title : "t"
                        },
                        simpleData : {
                            enable : true
                        }
                    },
                    check : {
                        enable : true,
                    }
                };
                
                $.ajax({
                    url : 'menu_showmenu.do',
                    type : 'POST',
                    dataType : 'text',
                    success : function(data) {
                    	//console.log(data);
                        var zNodes = eval("(" + data + ")");
                        console.log(zNodes);
                        $.fn.zTree.init($("#menuTree"), setting, zNodes);
                    },
                    error : function(msg) {
                        alert('树加载异常!');
                    }
                });
                
                // 点击保存
                $('#save').click(function(){
                    // 获取ztree勾选节点集合 
                    var treeObj = $.fn.zTree.getZTreeObj("menuTree");
                    var nodes = treeObj.getCheckedNodes(true);
                    // 获取所有节点id 
                    console.log(nodes);
                    var array = new Array();
                    for(var i=0 ; i< nodes.length ; i++){
                    	alert(nodes[i]);
                        array.push(nodes[i].id);
                    }
                    var menuIds = array.join(",");
                    $("input[name='menuIds']").val(menuIds);
                    
                    // 提交form
                    if($("#roleForm").form('validate')){
                        $("#roleForm").submit();
                    }
                });
                
                // 页面加载后， 获取所有权限数据，生成checkbox列表
                $.get("permission_list.do", function(data){
                    // 生成checkbox列表 
                    $(data).each(function(){
                        var checkbox = $("<input type='checkbox' name='permissionIds' />");
                        checkbox.val(this.cId);
                        $("#permissionTD").append(checkbox);
                        $("#permissionTD").append(this.name);
                    });
                });
            });
        </script>
    </head>

    <body class="easyui-layout">
        <div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
            <div class="datagrid-toolbar">
                <a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
            </div>
        </div>
        <div region="center" style="overflow:auto;padding:5px;" border="false">
            <form id="roleForm" method="post" action="role_save.do">
                <table class="table-edit" width="80%" align="center">
                    <tr class="title">
                        <td colspan="2">角色信息</td>
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
                    <tr>
                        <td>权限选择</td>
                        <td id="permissionTD">
                        </td>
                    </tr>
                    <tr>
                        <td>菜单授权</td>
                        <td>
                            <input type="hidden" name="menuIds"  />
                            <ul id="menuTree" class="ztree"></ul>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>