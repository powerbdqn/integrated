<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/plugins/layui/css/layui.css" />
<script src="<%=basePath%>static/plugins/layui/layui.all.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/plugins/layui/css/modules/laydate/default/laydate.css" />
<title>题库</title>
</head>
<body>
<!-- 	<div class="layui-btn-container" style="margin-top:5px;margin-left:60px;">
		<button class="layui-btn">下载单选题模板</button>
		<button class="layui-btn">下载多选题模板</button>
		<button class="layui-btn">下载判断题模板</button>
		<button class="layui-btn">下载简单题模板</button>
		<button class="layui-btn">下载填空题模板</button>
		<button class="layui-btn">下载问答题模板</button>
		<button class="layui-btn">下载问答题模板</button>
	</div> -->
	
  <div class="layui-form-item" style="margin-top:30px;margin-left:50px;">
    <div class="layui-input-inline">
      <button class="layui-btn">导入单选题试题</button>
    </div>
    
    <div class="layui-input-inline">
      <button class="layui-btn">导入多选题试题</button>
    </div>
    
    <div class="layui-input-inline">
      <button class="layui-btn">导入填空题试题</button>
    </div>
  </div>
  
  <div class="layui-form-item" style="margin-top:30px;margin-left:50px;">
    <div class="layui-input-inline">
      <button class="layui-btn">导入判断题试题</button>
    </div>
    
    <div class="layui-input-inline">
      <button class="layui-btn">导入问答题试题</button>
    </div>
    
    <div class="layui-input-inline">
      <button class="layui-btn">导入上机题试题</button>
    </div>
  </div>
</body>
</html>