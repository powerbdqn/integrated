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
        <!-- 导入jquery核心类库 -->
        <script type="text/javascript" src="<%=basePath %>static/js/jquery-1.8.3.js"></script>
        <!-- 导入easyui类库 -->
        <link id="easyuiTheme" rel="stylesheet" type="text/css" href="<%=basePath %>static/js/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="<%=basePath %>static/js/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/default.css">
        <script type="text/javascript" src="<%=basePath %>static/js/easyui/jquery.easyui.min.js"></script>
        <!-- 导入ztree类库 -->
        <link rel="stylesheet" href="<%=basePath %>static/js/ztree/zTreeStyle.css" type="text/css" />
        <script src="<%=basePath %>static/js/ztree/jquery.ztree.all-3.5.js" type="text/javascript"></script>
        <script src="<%=basePath %>static/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <script type="text/javascript">
            /* $(function() {
               
                   Ztree菜单通用配置 
                
                var setting = {
                    data : {
                        simpleData : { // 简单数据 
                            enable : true
                        },
                        key: {
                        	name: "name"
                        }
                    },
                    callback : {
                        onClick : function(event, treeId, treeNode, clickFlag) {
                            // 判断树菜单节点是否含有 page属性
                            if (treeNode.page!=undefined && treeNode.page!= "") {
                                if ($("#tabs").tabs('exists', treeNode.name)) {// 判断tab是否存在
                                    $('#tabs').tabs('select', treeNode.name); // 切换tab
                                } else {
                                    // 开启一个新的tab页面
                                    var content = '<div style="width:100%;height:100%;overflow:hidden;">'
                                            + '<iframe src="'
                                            + treeNode.page
                                            + '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
                    
                                    $('#tabs').tabs('add', {
                                        title : treeNode.name,
                                        content : content,
                                        closable : true,
                                        tools:[{ 
                                            iconCls:'icon-reload', // 刷新按钮
                                            handler : function(){
                                                var tab = $('#tabs').tabs('getTab',treeNode.name);
                                                $("iframe[src='"+treeNode.page+"']").get(0).contentWindow.location.reload(true);
                                            }
                                        }] 
                                    });
                                }
                            }
                        }
                    }
                };
                
                // 基本功能菜单加载 ./menu_showmenu.action
                $.post("menu_showmenu.do",function(data){
                	
                    $.fn.zTree.init($("#treeMenu"), setting, data.menus);
                    if(data.flag){
                        $("#one").accordion('remove','系统管理');
                    }
                },"json");  
                
            });
            
            function onClick(event, treeId, treeNode, clickFlag) {
                // 判断树菜单节点是否含有 page属性
                if (treeNode.cPage!=undefined && treeNode.cPage!= "") {
                    if ($("#tabs").tabs('exists', treeNode.name)) {// 判断tab是否存在
                        $('#tabs').tabs('select', treeNode.name); // 切换tab
                    } else {
                        // 开启一个新的tab页面
                        var content = '<div style="width:100%;height:100%;overflow:hidden;">'
                                + '<iframe src="'
                                + treeNode.cPage
                                + '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
        
                        $('#tabs').tabs('add', {
                            title : treeNode.name,
                            content : content,
                            closable : true,
                            tools:[{ 
                                iconCls:'icon-reload', // 刷新按钮
                                handler : function(){
                                    var tab = $('#tabs').tabs('getTab',treeNode.name);
                                    $("iframe[src='"+treeNode.cPage+"']").get(0).contentWindow.location.reload(true);
                                }
                            }] 
                        });
                    }
                }
            } 
         */
         $(function() {
             /** 
                Ztree菜单通用配置 
             */
             var setting = {
                 data : {
                     simpleData : { // 简单数据 
                         enable : true
                     }
                 },
                 callback : {
                     onClick : onClick
                 }
             };
             
             // 基本功能菜单加载 ./menu_showmenu.action
             $.post("menu_showmenu.do",function(data){
                 $.fn.zTree.init($("#treeMenu"), setting, data.menus);
                 if(data.flag){
                     $("#one").accordion('remove','系统管理');
                 }
             },"json");
             
             
             // 系统管理菜单加载
        /*      $.post("./data/admin.json",function(data){
                 $.fn.zTree.init($("#adminMenu"), setting, data);
             },"json"); */
             
             // 页面加载后 右下角 弹出窗口
             window.setTimeout(function(){
                 $.messager.show({
                     title:"消息提示",
                     msg:'欢迎登录，超级管理员！ <a href="javascript:void" onclick="top.showAbout();">联系管理员</a>',
                     timeout:5000
                 });
             },3000);
             
             $("#btnCancel").click(function(){
                 $('#editPwdWindow').window('close');
             });
             
             $("#btnEp").click(function(){
                 alert("修改密码");
             });
             
             // 设置全局变量 保存当前正在右键的tabs 标题 
             var currentRightTitle  ;
             
             // 为选项卡，添加右键菜单 
             $('#tabs').tabs({
                 onContextMenu : function(e,title,index){
                     currentRightTitle = title ; 
                     $('#mm').menu('show', { 
                         left: e.pageX,
                         top: e.pageY 
                     });
                     e.preventDefault(); // 禁用原来的右键效果 
                 }
             });
             
             $('#mm').menu({ 
                 onClick:function(item){ 
                     if(item.name==='Close'){
                         $('#tabs').tabs('close',currentRightTitle);
                     }else if(item.name === 'CloseOthers'){
                         var tabs = $('#tabs').tabs('tabs');
                         $(tabs).each(function(){
                             if($(this).panel('options').title != '消息中心' && $(this).panel('options').title != currentRightTitle){
                                 $('#tabs').tabs('close',$(this).panel('options').title);
                             }
                         });
                     }else if(item.name === 'CloseAll'){
                         var tabs = $('#tabs').tabs('tabs');
                         $(tabs).each(function(){
                             if($(this).panel('options').title != '消息中心'){
                                 $('#tabs').tabs('close',$(this).panel('options').title);
                             }
                         });
                     }
                 } 
             }); 
         });
         
         function onClick(event, treeId, treeNode, clickFlag) {
             // 判断树菜单节点是否含有 page属性
             if (treeNode.page!=undefined && treeNode.page!= "") {
                 if ($("#tabs").tabs('exists', treeNode.name)) {// 判断tab是否存在
                     $('#tabs').tabs('select', treeNode.name); // 切换tab
                 } else {
                     // 开启一个新的tab页面
                     var content = '<div style="width:100%;height:100%;overflow:hidden;">'
                             + '<iframe src="'
                             + treeNode.page
                             + '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
     
                     $('#tabs').tabs('add', {
                         title : treeNode.name,
                         content : content,
                         closable : true,
                         tools:[{ 
                             iconCls:'icon-reload', // 刷新按钮
                             handler : function(){
                                 var tab = $('#tabs').tabs('getTab',treeNode.name);
                                 $("iframe[src='"+treeNode.page+"']").get(0).contentWindow.location.reload(true);
                             }
                         }] 
                     });
                 }
             }
         }
     
         /*******顶部特效 *******/
         /**
          * 更换EasyUI主题的方法
          * @param themeName
          * 主题名称
          */
         changeTheme = function(themeName) {
             var $easyuiTheme = $('#easyuiTheme');
             var url = $easyuiTheme.attr('href');
             var href = url.substring(0, url.indexOf('themes')) + 'themes/'
                     + themeName + '/easyui.css';
             $easyuiTheme.attr('href', href);
             var $iframe = $('iframe');
             if ($iframe.length > 0) {
                 for ( var i = 0; i < $iframe.length; i++) {
                     var ifr = $iframe[i];
                     $(ifr).contents().find('#easyuiTheme').attr('href', href);
                 }
             }
         };
         // 退出登录
         function logoutFun() {
             $.messager
             .confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {
                 if (isConfirm) {
                     location.href = './user_logout.action';
                 }
             });
         }
         // 修改密码
         function editPassword() {
             $('#editPwdWindow').window('open');
         }
         // 版权信息
         function showAbout(){
             $.messager.alert("时韵恒通 v1.0","<br/> QQ: 1323232302");
         }
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