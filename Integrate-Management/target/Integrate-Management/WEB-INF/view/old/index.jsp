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
        <link rel="stylesheet" type="text/css" href="<%= basePath %>static/layui/css/layui.css" />
        <script src="<%= basePath %>static/layui/layui.js"></script>
		<script src="<%=basePath %>static/js/index.js" type="text/javascript"></script>
		<script src="<%=basePath %>static/js/nav.js" type="text/javascript"></script>
</head>

<%-- <body class="main_body">
	<div class="layui-layout layui-layout-admin">
		<!-- 左侧导航 -->
<!--动态导航 核心HTML start--->		
		<div class="layui-side layui-bg-black">
			<div class="navBar layui-side-scroll" id="navBar">
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-this">
						</i><cite>后台首页</cite></a>
					</li>
				</ul>
			</div>
		</div>
<!--动态导航 核心 end--->				
		<!-- 右侧内容 -->
		<div class="layui-body layui-form">
			<div class="layui-tab mag0" lay-filter="bodyTab" id="top_tabs_box">
				<ul class="layui-tab-title top_tab" id="top_tabs">
					<li class="layui-this" lay-id=""><!--<i class="layui-icon">&#xe68e;</i> <cite>后台首页</cite></li>-->
				</ul>
				<div class="layui-tab-content clildFrame">
					<div class="layui-tab-item layui-show">
						<iframe src="page/main.html"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath %>static/js/cache.js"></script>
</body> --%>

<body>
		<div class="layui-layout layui-layout-admin" style="border-bottom: solid 5px #1aa094;">
			<div class="layui-header header header-demo">
				<div class="layui-main">
					<div class="admin-login-box">
						<a class="logo" style="left: 0;" href="http://beginner.zhengjinfan.cn/demo/beginner_admin/">
							<span style="font-size: 22px;">BeginnerAdmin</span>
						</a>
						<div class="admin-side-toggle">
							<i class="fa fa-bars" aria-hidden="true"></i>
						</div>
						<div class="admin-side-full">
							<i class="fa fa-life-bouy" aria-hidden="true"></i>
						</div>
					</div>
					<ul class="layui-nav admin-header-item">
						<li class="layui-nav-item">
							<a href="javascript:;">清除缓存</a>
						</li>
                        <li class="layui-nav-item" id="pay">
                            <a href="javascript:;">捐赠我</a>
                        </li>
						<li class="layui-nav-item">
							<a href="javascript:;">浏览网站</a>
						</li>
						<li class="layui-nav-item" id="video1">
							<a href="javascript:;">视频</a>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;" class="admin-header-user">
								<img src="./后台管理模板_files/0.jpg">
								<span>beginner</span>
							<span class="layui-nav-more"></span></a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人信息</a>
								</dd>
								<dd>
									<a href="javascript:;"><i class="fa fa-gear" aria-hidden="true"></i> 设置</a>
								</dd>
								<dd id="lock">
									<a href="javascript:;">
										<i class="fa fa-lock" aria-hidden="true" style="padding-right: 3px;padding-left: 1px;"></i> 锁屏 (Alt+L)
									</a>
								</dd>
								<dd>
									<a href="http://m.zhengjinfan.cn/login.html"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
								</dd>
							</dl>
						</li>
					<span class="layui-nav-bar"></span></ul>
					<ul class="layui-nav admin-header-item-mobile">
						<li class="layui-nav-item">
							<a href="http://m.zhengjinfan.cn/login.html"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
						</li>
					<span class="layui-nav-bar"></span></ul>
				</div>
			</div>
			<div class="layui-side layui-bg-black" id="admin-side">
				<div class="layui-side-scroll" id="admin-navbar-side" lay-filter="side"><ul class="layui-nav layui-nav-tree beg-navbar"><li class="layui-nav-item layui-nav-itemed"><a href="javascript:;"><i class="fa fa-cubes" aria-hidden="true" data-icon="fa-cubes"></i><cite>基本元素</cite><span class="layui-nav-more"></span></a><dl class="layui-nav-child"><dd title="按钮"><a href="javascript:;" data-url="button.html"><i class="layui-icon" data-icon=""></i><cite>按钮</cite></a></dd><dd title="表单"><a href="javascript:;" data-url="form.html"><i class="layui-icon" data-icon=""></i><cite>表单</cite></a></dd><dd title="表格"><a href="javascript:;" data-url="table.html"><i class="layui-icon" data-icon=""></i><cite>表格</cite></a></dd><dd title="导航"><a href="javascript:;" data-url="nav.html"><i class="layui-icon" data-icon=""></i><cite>导航</cite></a></dd><dd title="辅助性元素"><a href="javascript:;" data-url="auxiliar.html"><i class="layui-icon" data-icon=""></i><cite>辅助性元素</cite></a></dd></dl></li><li class="layui-nav-item"><a href="javascript:;"><i class="fa fa-cogs" aria-hidden="true" data-icon="fa-cogs"></i><cite>组件</cite><span class="layui-nav-more"></span></a><dl class="layui-nav-child"><dd title="BTable"><a href="javascript:;" data-url="btable.html"><i class="fa fa-table" data-icon="fa-table" aria-hidden="true"></i><cite>BTable</cite></a></dd><dd title="Navbar组件"><a href="javascript:;" data-url="navbar.html"><i class="fa fa-navicon" data-icon="fa-navicon" aria-hidden="true"></i><cite>Navbar组件</cite></a></dd><dd title="Tab组件"><a href="javascript:;" data-url="tab.html"><i class="layui-icon" data-icon=""></i><cite>Tab组件</cite></a></dd><dd title="Laytpl+Laypage"><a href="javascript:;" data-url="paging.html"><i class="layui-icon" data-icon=""></i><cite>Laytpl+Laypage</cite></a></dd></dl></li><li class="layui-nav-item"><a href="javascript:;"><i class="layui-icon" data-icon="ဂ">ဂ</i><cite>第三方组件</cite><span class="layui-nav-more"></span></a><dl class="layui-nav-child"><dd title="iCheck组件"><a href="javascript:;" data-url="icheck.html"><i class="fa fa-check-square-o" data-icon="fa-check-square-o" aria-hidden="true"></i><cite>iCheck组件</cite></a></dd></dl></li><li class="layui-nav-item"><a href="javascript:;"><i class="fa fa-address-book" aria-hidden="true" data-icon="fa-address-book"></i><cite>地址本</cite><span class="layui-nav-more"></span></a><dl class="layui-nav-child"><dd title="Github"><a href="javascript:;" data-url="https://www.github.com/"><i class="fa fa-github" data-icon="fa-github" aria-hidden="true"></i><cite>Github</cite></a></dd><dd title="QQ"><a href="javascript:;" data-url="http://www.qq.com/"><i class="fa fa-qq" data-icon="fa-qq" aria-hidden="true"></i><cite>QQ</cite></a></dd><dd title="Fly社区"><a href="javascript:;" data-url="http://fly.layui.com/"><i class="layui-icon" data-icon=""></i><cite>Fly社区</cite></a></dd><dd title="新浪微博"><a href="javascript:;" data-url="http://weibo.com/"><i class="fa fa-weibo" data-icon="fa-weibo" aria-hidden="true"></i><cite>新浪微博</cite></a></dd></dl></li><li class="layui-nav-item"><a href="javascript:;" data-url="https://www.baidu.com"><i class="fa fa-stop-circle" aria-hidden="true" data-icon="fa-stop-circle"></i><cite>这是一级导航</cite></a></li><li class="layui-nav-item"><a href="javascript:;"><i class="fa fa-stop-circle" aria-hidden="true" data-icon="fa-stop-circle"></i><cite>其他</cite><span class="layui-nav-more"></span></a><dl class="layui-nav-child"><dd title="子窗体中打开选项卡"><a href="javascript:;" data-url="cop.html"><i class="fa fa-github" data-icon="fa-github" aria-hidden="true"></i><cite>子窗体中打开选项卡</cite></a></dd></dl></li><span class="layui-nav-bar"></span></ul></div>
			</div>
			<div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
				<div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
					<ul class="layui-tab-title">
						<li class="layui-this">
							<i class="fa fa-dashboard" aria-hidden="true"></i>
							<cite>控制面板</cite>
						</li>
					</ul>
					<div class="layui-tab-content ifm" style="min-height: 150px; padding: 5px 0px 0px; height: 466px;">
						<div class="layui-tab-item layui-show">
							<iframe src="./后台管理模板_files/main.html" style="height: 466px;"></iframe>
						</div>
					</div>
				</div>
			</div>
			<div class="layui-footer footer footer-demo" id="admin-footer">
				<div class="layui-main">
					<p>2016 ©
						<a href="http://m.zhengjinfan.cn/">m.zhengjinfan.cn/</a> LGPL license
					</p>
				</div>
			</div>
			<div class="site-tree-mobile layui-hide">
				<i class="layui-icon"></i>
			</div>
			<div class="site-mobile-shade"></div>
			
			<!--锁屏模板 start-->
			<script type="text/template" id="lock-temp">
				<div class="admin-header-lock" id="lock-box">
					<div class="admin-header-lock-img">
						<img src="images/0.jpg"/>
					</div>
					<div class="admin-header-lock-name" id="lockUserName">beginner</div>
					<input type="text" class="admin-header-lock-input" value="输入密码解锁.." name="lockPwd" id="lockPwd" />
					<button class="layui-btn layui-btn-small" id="unlock">解锁</button>
				</div>
			</script>
			<!--锁屏模板 end -->
			
			<script>
				layui.use('layer', function() {
					var $ = layui.jquery,
						layer = layui.layer;

					$('#video1').on('click', function() {
						layer.open({
							title: 'YouTube',
							maxmin: true,
							type: 2,
							content: 'video.html',
							area: ['800px', '500px']
						});
                    });
                    $('#pay').on('click', function () {
                        layer.open({
                            title: false,
                            type: 1,
                            content: '<img src="images/xx.png" />',
                            area: ['500px', '250px'],
                            shadeClose: true
                        });
                    });


				});
			</script>
		</div>
</body>
</html>