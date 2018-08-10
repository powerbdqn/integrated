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
<script src="<%=basePath%>static/js/tool.js"></script>
<title>多选题列表</title>


</head>
<body class="main-body">	
	<div class="layui-body" style="position: absolute;left:0px;">
		<div style="padding:15px;">
			<!--试题管理-->
			<div class="layui-btn-container" style="margin-left:60px;">
				<button class="layui-btn">发布试题</button>
				<button id="importQuestionId" class="layui-btn">导入试题</button>
				<button class="layui-btn">批量删除</button>
				<button class="layui-btn">下载模板</button>
			</div>
			<hr class="layui-bg-green" style="margin-bottom: 20px;">
			<form class="layui-form" method="post" action="question/dynSearch.do">
				<div class="layui-form-item" style="margin-left:60px;">
					
					<div class="layui-input-inline">
						<select lay-filter="addOptionsOfStage" name="stage">
							<option value="">按阶段查询</option>
							<optgroup id="stage" label="请选择题目阶段"></optgroup>
						</select>
					</div>
					<div class="layui-input-inline">
						<select lay-filter="addOptionsOfBooks" name="books">
							<option value="">按书名查询</option>
							<optgroup id="books" label="请选择书名"></optgroup>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="chapter">
							<option value="">按章节查询</option>
							<optgroup id="chapter" label="请选择章节"></optgroup>
						</select>						
					</div>
					<div class="layui-input-inline" >
						 <input id="startTime" type="text" name="startTime" lay-filter="timeValidate" placeholder="起始时间" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline">
						 <input id="endTime" type="text" name="endTime" lay-filter="timeValidate" placeholder="结束时间" autocomplete="off" class="layui-input">
					</div>
				</div>	
				<div class="layui-form-item" style="margin-left:60px;">
					<div class="layui-input-inline" >
						<select lay-filter="addOptionsOfQuestionTypes" name="questionTypes">
							<option value="">按题型查询</option>
							<optgroup id="questionTypes" label="请选择题目题型"></optgroup>
 						</select>
					</div>
					<div class="layui-input-inline">	<!-- required lay-verify="required" -->
						<input type="text" name="title"  placeholder="请输入题目名称" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline">	<!-- required lay-verify="required" -->
						<input type="text" name="title"  placeholder="请输入题目内容" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" style="width:400px">
						<button class="layui-btn" lay-submit lay-filter="submitFormFilter" style="width:190px">查询</button>
						<button type="reset" class="layui-btn layui-btn-primary" style="width:190px">重置</button>
					</div>
				</div>
			</form>
		
			<hr class="layui-bg-green" style="margin-bottom: 20px;">
		
			<table  lay-skin="nob" id="test" lay-filter="tableFilter"></table>
		</div>
	</div>
</body>
	
<script type="text/html" id="tableBar">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="show" style="height: 30px;line-height: 30px;padding: 0 10px;" >详情</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit" style="height: 30px;line-height: 30px;padding: 0 10px;" >编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" style="height: 30px;line-height: 30px;padding: 0 10px;" >删除</a>
</script>
<script type="text/html" id="checkboxTpl">
  <input type="checkbox" name="lock" value="{{d.prohibition}}" title="禁用中" lay-filter="lockDemo" {{ d.prohibition == 1 ? 'checked' : '' }}>
</script>
<script type="text/javascript">
layui.use(['form','laydate', 'laypage', 'layer', 'table', 'carousel','upload', 'element' ], function() {
/////////////////////////////////////////////////////////////	
//	   													   //
//					   layui控件声明                                                              //  
//	   													   //
/////////////////////////////////////////////////////////////	
	var layer = layui.layer;
	var laydate = layui.laydate;
	var form = layui.form;
	var element = layui.element;
	var table = layui.table;
	var $ = layui.jquery;
/////////////////////////////////////////////////////////////	
//	   													   //
//					        页面加载欢迎词                                                               //  
//	   													   //
/////////////////////////////////////////////////////////////	
	form.render();
	layer.msg('你好,欢迎来到题库列表页面');
/////////////////////////////////////////////////////////////	
//	   													   //
//					   layui下拉框事件                                                           //  
//	   													   //
/////////////////////////////////////////////////////////////
	//题目类型
	$.ajax({
		dataType:'json',
		type:'POST',
		url:'${pageContext.request.contextPath}/questionTypes/listQuestionTypes.do?x='+new Date().getTime(),
		success:function(data){
			$.each(data,function(i,v){
				$("#questionTypes").append("<option value='"+v.id+"'>"+v.name+"</option>");
			});	
			form.render('select');
		}
	});
	//阶段
	$.ajax({
		dataType:'json',
		type:'POST',
		url:'${pageContext.request.contextPath}/stage/liststages.do?x='+new Date().getTime(),
		success:function(data){
			$.each(data,function(i,v){
				$("#stage").append("<option value='"+v.id+"'>"+v.name+"</option>");
			});	
			form.render('select');
		}
	});
	
	//form.render('select');
	//-------------------
	//监听select 选中其值
	form.on('select(addOptionsOfQuestionTypes)', function(data){
	 	//alert(data.value);
	});
	
	//通过监听阶段select ajax书名集合
	form.on('select(addOptionsOfStage)', function(data){
		$("#books").empty();
		$("#chapter").empty();
		 var index = data.value;
		 $.ajax({
			dataType:'json',
				type:'POST',
				data:{
					stageId:index
				},
				url:'${pageContext.request.contextPath}/books/getBooksByStageId.do?x='+new Date().getTime(),
				success:function(data){
					$.each(data,function(i,v){
						$("#books").append("<option value='"+v.id+"'>"+v.name+"</option>");
				});	
				form.render('select');
			}
		 });
	});  
	
	//通过监听书名select ajax章节集合
	form.on('select(addOptionsOfBooks)',function(data){
		$("#chapter").empty();
		var a = data.stageId;
		var index = data.value;
		$.ajax({
		dataType:'json',
			type:'POST',
			data:{
				booksId:index
			},
			url:'${pageContext.request.contextPath}/chapter/getChapterByBooksId.do?x='+new Date().getTime(),
			success:function(data){
				$.each(data,function(i,v){
					$("#chapter").append("<option value='"+v.id+"'>"+v.name+"</option>");
			});	
			form.render('select');
		}
	 });
	});
	
/////////////////////////////////////////////////////////////	
//	   													   //
//					   layui表单提交                                                              //  
//	   													   //
/////////////////////////////////////////////////////////////
	form.on('submit(submitFormFilter)', function(data) {
		//layer.msg(JSON.stringify(data.field));
		alert("a");
		return false;
	});
/////////////////////////////////////////////////////////////	
//														   //
//			           layui日期控件                                                              //  
//														   //
/////////////////////////////////////////////////////////////


	var startDate=laydate.render({
	            elem: '#startTime',
	            mark: {
	                '0-0-1': '月考'
	                  } ,
	            type: 'date',
	            max:"2030-12-31",//设置一个默认最大值
	            done: function(value, date){
	                endDate.config.min ={
	                    year:date.year,
	                    month:date.month-1, //关键
	                    date: date.date/* ,
	                    hours: 0,
	                    minutes: 0,
	                    seconds : 0 */
	                };
	            }
	        });
	var endDate= laydate.render({
	          elem: '#endTime',//选择器结束时间
	          mark: {
	                '0-0-1': '月考'
	                  } ,
	          type: 'date',
	          min:"2018-08-01",//设置min默认最小值
	          done: function(value,date){
	              startDate.config.max={
	                  year:date.year,
	                  month:date.month-1,//关键
	                  date: date.date/* ,
	                  hours: 0,
	                  minutes: 0,
	                  seconds : 0 */
	              }
	          },
	          change: function(value, date, endDate){
	        	  endDate.hint(value); //在控件上弹出value值
	          }
	      });
/////////////////////////////////////////////////////////////	
//	   													   //
//                     layui表格控件                                                              //  
//	   													   //
/////////////////////////////////////////////////////////////	
	table.render({
		elem:'#test',
		url:"${pageContext.request.contextPath}/question/list.do?x="+new Date().getTime(),
		page:true,
		cols:[[
			{type:'checkbox',width:20},
			{field : 'id'},
			{field : 'name',title:'题干',width:180,align : 'center',templet:
				'<div><span title="{{d.name}}">{{d.name.substring(0,7)}}...</span></div>'},
			{field : 'content',title:'内容',width:180,align : 'center',templet:
				'<div><span title="{{d.content}}">{{d.content.substring(0,7)}}...</span></div>'},
			{field : 'stageId',title:'阶段',width:120,align : 'center',templet:function(d){
				var stageId = d.stageId;
				if("1" == stageId){return "S1阶段";}
				else if("2" == stageId){return "S2阶段";}
				else if("3" == stageId){return "S3阶段";}
				else if("4" == stageId){return "Y2阶段";}
				else if("就业" == stageId){return "就业阶段";}
				else{return "出现异常,请联系管理员";}
			}},
			{field : 'booksName',title:'书名',width:180,align : 'center',templet:
				'<div><span title="{{d.booksName}}">{{d.booksName.substring(0,7)}}...</span></div>'},
			{field : 'chapterName',title:'章节',width:180,align : 'center'},
			{field : 'questionTypesName',title:'类型',width:80,align : 'center'},
			{field : 'createTime',title:'创建时间',width:150,align : 'center',templet:function(d){return TimeFormatter(d.createTime);}},
			{field : 'lock', title:'是否禁用', width:110, templet: '#checkboxTpl',align : 'center', unresize: true},
			{field : 'opt',title:'操作',width:180,align : 'center',toolbar:'#tableBar'}
		]],
		done: function(res, curr, count){
			$("[data-field='id']").css('display','none');
		} 
	});
/////////////////////////////////////////////////////////////	
//	   													   //
//							按钮事件                                                              //  
//	   													   //
/////////////////////////////////////////////////////////////		
	$(document).on('click', '#importQuestionId', function(index) {
		layer.open({
			title : '导入试题模板',
			content : '${pageContext.request.contextPath}/question/showButtons.do?x='+new Date().getTime(),//内容  类型：String/DOM/Array，默认：''
			type : 2,//
			btnAlign : 'r', //按钮排列  'l' 按钮左对齐  'c'按钮居中对齐  'r' 按钮右对齐。默认值，不用设置
			shadeClose : true,//是否点击遮罩关闭
			fixed : true, //是否固定
			resize : false,
			anim : 1,//动画  0-6
			area : [ '670px', '250px' ], //大小   'auto'
			shade : [ 0.3, '#000' ], //遮罩
			btn : ['关闭'], //底部按钮
			yes : function(index, layero) {//按钮回调
				layer.close(index);
				$(".layui-laypage-btn")[0].click();
				layer.msg("您取消了上传操作");
				
			}
		});
	});
	

/////////////////////////////////////////////////////////////	
//	   													   //
//						   行内按钮事件                                                              //  
//	                                                       //
/////////////////////////////////////////////////////////////	
	table.on('tool(tableFilter)',function(obj){
		var data = obj.data;
		var event = obj.event;
		var id = data.id;
		if("show" == event){
			layer.open({
				title : '查看详情',
				content : '${pageContext.request.contextPath}/question/show.do?x='+new Date().getTime(),
				type : 2,//
				btnAlign : 'r', //按钮排列  'l' 按钮左对齐  'c'按钮居中对齐  'r' 按钮右对齐。默认值，不用设置
				shadeClose : true,//是否点击遮罩关闭
				fixed : true, //是否固定
				resize : false,
				anim : 1,//动画  0-6
				area : [ '900px', '450px' ], //大小   'auto'
				maxWidth : 900, //自适应最大宽度
				maxHeight : 700,//自适应最小宽度
				shade : [ 0.3, '#000' ], //遮罩
				success:function(layero, index){
					var iframe = window['layui-layer-iframe' + index];
					iframe.child(data);
				},
				btn : ['关闭'], //底部按钮
				yes : function(index, layero) {//按钮回调
					layer.close(index);
				}
			});
		}else if('edit' == event){
			layer.open({
				title : '查看详情',
				content : '${pageContext.request.contextPath}/question/show.do?x='+new Date().getTime(),
				type : 2,//
				btnAlign : 'r', //按钮排列  'l' 按钮左对齐  'c'按钮居中对齐  'r' 按钮右对齐。默认值，不用设置
				shadeClose : true,//是否点击遮罩关闭
				fixed : true, //是否固定
				resize : false,
				anim : 1,//动画  0-6
				area : [ '900px', '450px' ], //大小   'auto'
				maxWidth : 900, //自适应最大宽度
				maxHeight : 700,//自适应最小宽度
				shade : [ 0.3, '#000' ], //遮罩
				success:function(layero, index){
					var iframe = window['layui-layer-iframe' + index];
					iframe.child(data);
					var childNameElement = iframe.document.getElementById("nameId");
					var childContentElement = iframe.document.getElementById("contentId");
					var childAnalysisElement = iframe.document.getElementById("analysisId");
					var childAnswerElement = iframe.document.getElementById("answerId");
					$(childNameElement).removeAttr("disabled");
					$(childContentElement).removeAttr("disabled");
					$(childAnalysisElement).removeAttr("disabled");
					$(childAnswerElement).removeAttr("disabled");
				},
				btn : ['保存','关闭'], //底部按钮
				yes : function(index, layero) {//按钮回调
					var iframe = window['layui-layer-iframe' + index];
					var questionForm = iframe.document.getElementById("questionFormId");
					$(questionForm).submit();
					layer.close(index);
					$(".layui-laypage-btn")[0].click();//刷新表格
				},
				btn1:function(index,layero){
					layer.close(index);
				} 
			});
		}else if('del' == event){
			layer.confirm('您确定要删除吗?', function(index){
				$.ajax({
					dataType:'json',
					type:'POST',
					data:{id:id},
					url:'question/del.do',
					success:function(data){
						if(data.status == "200"){
						$(".layui-laypage-btn")[0].click();//刷新表格
							layer.msg(data.msg);
						}else{
							layer.msg(data.msg);
						}
					}
				});
			});
		}
	}); 

/////////////////////////////////////////////////////////////	
//	   													   //
//					           启禁按钮监听                                                                //  
//	   													   //
/////////////////////////////////////////////////////////////		
  form.on('checkbox(lockDemo)', function(obj){
    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
  });
});


/////////////////////////////////////////////////////////////	
//   													   //
//					日期格式化(毫秒值转日期)                     //  
//                                                         //
/////////////////////////////////////////////////////////////
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