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
<body >
	<fieldset  class="layui-elem-field layui-field-title" style="margin-top: 20px;"><legend>试题详情</legend></fieldset>
	
	<form  id="questionFormId" action="${pageContext.request.contextPath}/question/save.do" method="post" class="layui-form layui-form-pane" lay-filter="example" style="padding: 10px;" >
		<div class="layui-form-item layui-form-text" ><!-- style="display:none;" -->
			<div class="layui-input-block">
				<input id="id" name="id" autocomplete="off" class="layui-input" type="text"  />
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">题目</label>
			<div class="layui-input-block">
				<textarea id="nameId" name="name" disabled="true" placeholder="请输入题目"  class="layui-textarea"></textarea>
			</div>
		</div>
		
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<textarea id="contentId" name="content" placeholder="请输入内容" disabled="disabled"  class="layui-textarea"></textarea>
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">解析</label>
			<div class="layui-input-block">
				<textarea id="analysisId" name="analysis"  disabled="disabled" placeholder="请输入试题解析"  class="layui-textarea"></textarea>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">答案</label>
				<div class="layui-input-block">
					<input id="answerId" name="answer" autocomplete="off" disabled="disabled" placeholder="请输入标题"class="layui-input" type="text"  />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">权重</label>
				<div class="layui-input-block">
					<input  id="weightId" name="weight"  disabled="disabled" autocomplete="off" class="layui-input" type="text">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">阶段</label>
				<div class="layui-input-block">
					<input id="stageId" name="stageId" disabled="disabled"  autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">书名</label>
				<div class="layui-input-block">
					<input id="booksid" name="booksName"  disabled="disabled"  autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">章节</label>
				<div class="layui-input-block">
					<input id="chapterNameId" name="chapterName"  disabled="disabled"  autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">类型</label>
				<div class="layui-input-block">
					<input id="questiontypesNameId" name="questiontypesName"  disabled="disabled"   autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">创建人</label>
				<div class="layui-input-block">
					<input id="createById" name="createBy"  disabled="disabled" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">创建时间</label>
				<div class="layui-input-block">
					<input id="createTimeId" name="createTime"  disabled="disabled"  autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">修改人</label>
				<div class="layui-input-block">
					<input id="modifyById" name="modifyBy"   disabled="disabled"  autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">修改时间</label>
				<div class="layui-input-block">
					<input id="modifyTimeId" name="modifyTime"  disabled="disabled"  autocomplete="off" placeholder="请输入标题"  class="layui-input" type="text">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">是否禁用</label>
				<div class="layui-input-block">
					<input id="prohibitionId" name="prohibition" disabled="disabled" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">逻辑删除</label>
				<div class="layui-input-block">
					<input id="statusId" name="status" disabled="disabled" autocomplete="off" placeholder="请输入标题"  class="layui-input" type="text">
				</div>
			</div>
		</div>
	</form>
</body>
<script>
	var $;
	layui.use([ 'form', 'layedit', 'laydate' ],function() {
		var form = layui.form, 
		layer = layui.layer, 
		layedit = layui.layedit, 
		laydate = layui.laydate;
		$ = layui.jquery;
		//创建一个编辑器
		var editIndex = layedit.build('LAY_demo_editor');
	 	form.render();
	});
	
	function child(value){
		$("#nameId").val(value.name);
		$("#contentId").val(value.content);
		$("#analysisId").val(value.analysis);
		$("#weightId").val(value.weight);
		$("#createById").val(value.createBy);
		$("#createTimeId").val(TimeFormatter(value.createTime));
		$("#modifyById").val(value.modifyBy);
		$("#modifyTimeId").val(TimeFormatter(value.modifyTime));
		$("#booksid").val(value.booksName);
		$("#chapterNameId").val(value.chapterName);
		$("#answerId").val(value.answer);
		
		var stage = value.stageId;
		var prohibition = value.prohibition;
		var questionTypes = value.questiontypesId;
		var status = value.status;
		
		if(stage == "1"){$("#stageId").val("S1阶段");}
		else if(stage == "2"){$("#stageId").val("S2阶段");}
		else if(stage == "3"){$("#stageId").val("S3阶段");}
		else if(stage == "4"){$("#stageId").val("Y2阶段");}
		else if(stage == "5"){$("#stageId").val("就业阶段");}
		else{$("#stageId").val("数据加载异常");}

		if(questionTypes == "1"){$("#questiontypesNameId").val("单选题");}
		else if(questionTypes == "2"){$("#questiontypesNameId").val("多选题");}
		else if(questionTypes == "3"){$("#questiontypesNameId").val("判断题");}
		else if(questionTypes == "4"){$("#questiontypesNameId").val("填空题");}
		else if(questionTypes == "5"){$("#questiontypesNameId").val("问答题");}
		else if(questionTypes == "6"){$("#questiontypesNameId").val("上机题");}
		else{$("#stageId").val("数据加载异常");}
	
		if(prohibition == 0){$("#prohibitionId").val("未禁用");}
		else if(prohibition == 1){$("#prohibitionId").val("已禁用");}
		else{$("#stageId").val("数据加载异常");}
		
		if(status == "30"){$("#statusId").val("未被逻辑删除");}
		else if(status == "10"){$("#statusId").val("已被逻辑删除");}
		else{$("#statusId").val("数据加载异常");}
	}
	
	function TimeFormatter(v){
		var date = new Date(v);
	    var y = date.getFullYear();
	    var m = date.getMonth()+1;
	    m = m<10?'0'+m:m;
	    var d = date.getDate();
	    d = d<10?("0"+d):d;
	    var h = date.getHours();
	    h = h<10?("0"+h):h;
	    var M = date.getMinutes();
	    M = M<10?("0"+M):M;
	    var str = y+"-"+m+"-"+d+" "+h+":"+M;
	    return str;
	}
</script>
</html>