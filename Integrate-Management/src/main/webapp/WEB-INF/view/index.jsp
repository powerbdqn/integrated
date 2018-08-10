<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       	<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" type="text/css" href="<%= basePath %>static/plugins/layui/css/layui.css" media="all" />
        <script src="<%= basePath %>static/plugins/layui/layui.js"></script>
		<script src="<%=basePath %>static/js/index.js" type="text/javascript"></script>
		<link rel="stylesheet" href="<%=basePath %>static/css/global.css" media="all">
		<link rel="stylesheet" href="<%=basePath %>static/plugins/font-awesome/css/font-awesome.min.css">
</head>

<body >
	<div class=" layui-layout layui-layout-admin" style="border-bottom: solid 5px #1aa094;">
		<div class="layui-header header header-demo"></div>
		<div class="layui-side layui-bg-black" id="admin-side">
			<div class="layui-side-scroll" id="admin-navbar-side" lay-filter="side"></div>
		</div>
		<div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
			<div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
				<ul class="layui-tab-title">
					<li class="layui-this">
						<i class="fa fa-dashboard" aria-hidden="true"></i>
						<cite>主页</cite>
					</li>
				</ul>
				<div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">
					<div class="layui-tab-item layui-show">
						<iframe src="toMain.do"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-footer footer footer-demo" id="admin-footer">
			<div class="layui-main">
				<p>本系统由石家庄北大青鸟示范班  <font color="red">卢富起  | 豆盼 | 郜响 | 何鹏帅 | 蔡丽薇 | 高玉龙 | 李笑行 </font>  提供技术支持 </p>
			</div>
		</div>
	</div>
</body>

</html>