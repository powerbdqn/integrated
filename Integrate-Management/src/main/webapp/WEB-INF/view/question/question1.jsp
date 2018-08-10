<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>后台管理系统</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/plugins/layui/css/layui.css" />
<script src="<%=basePath%>static/plugins/layui/layui.js"></script>
<%-- <script src="<%=basePath%>static/layui/modules/table.js"></script> --%>
</head>
<body>
	<div>
		<div class="layui-btn-container">
			<button id="del" class="layui-btn">批量删除</button>
			<button id="add" class="layui-btn">新增</button>
		</div>
	</div>
	<!-- 墨绿分割线 -->
	<hr class="layui-bg-green">
	<div>
		<table class="layui-hide" id="test" lay-filter="tableFilter"></table>
	</div>



	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script>
		layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel',
				'upload', 'element' ], function() {
			var table = layui.table; //表格
			var $ = layui.$;
			var layer = layui.layer;
			layer.msg('你好,石家庄北大青鸟');

			//执行一个 table 实例
			table.render({
				elem : '#test',
				height : 332,
				url : 'seller/table.do' //数据接口
				,
				page : true //开启分页
				,
				cols : [ [ //表头
				{checkbox : true,fixed : true}, {
					field : 'id',
					title : 'ID',
					width : 80,
					sort : true,
					fixed : 'left'
				}, {
					field : 'username',
					title : '用户名',
					width : 80
				}, {
					field : 'sex',
					title : '性别',
					width : 80,
					sort : true,
					templet : function(d) {
						return "123" + d.sex;
					}
				}, {
					field : 'city',
					title : '城市',
					width : 80
				}, {
					field : 'sign',
					title : '签名',
					width : 170
				}, {
					field : 'experience',
					title : '积分',
					width : 80,
					sort : true
				}, {
					field : 'score',
					title : '评分',
					width : 80,
					sort : true
				}, {
					field : 'classify',
					title : '职业',
					width : 80
				}, {
					field : 'wealth',
					title : '财富',
					width : 135,
					sort : true
				}, {
					field : 'opt',
					titile : '操作',
					width : 165,
					align : 'center',
					toolbar : '#barDemo'
				} //fixed: 'right'
				] ],
				text : {
					none : '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
				}
			});

			//监听表格复选框选择
			table.on('checkbox(tableFilter)', function(obj) {
				console.log(obj.data);
				console.log(obj.checked);
				var a = obj.data.city;
				// alert(a);
			});

			//注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			table.on('tool(tableFilter)', function(obj) {

				var data = obj.data; //获得当前行数据
				var layEvent = obj.event; //获得lay-event的值

				var tr = obj.tr;

				if (layEvent == 'del') {
					alert(data.id);
				}

			});

			//删除按钮
			$(document).on('click', '#del', function(index) {
				var rows = table.checkStatus('test');

				console.log(rows.data) //获取选中行的数据
				console.log(rows.data.length) //获取选中行数量，可作为是否有选中行的条件
				console.log(rows.isAll) //表格是否全选

				//获得选中的id并拼接字符串
				var array = [];
				for (var i = 0; i < rows.data.length; i++) {
					array.push(rows.data[i].id);
				}
				var str = array.join(",");
				console.log(str);

			});

			$(document).on('click', '#add', function(index) {
				layer.open({
					title : '在线调试',
					content : 'seller/show.do'//内容  类型：String/DOM/Array，默认：''
					//,iframe:{src:'seller/toList.do'}
					,
					type : 2,//
					btnAlign : 'r', //按钮排列  'l' 按钮左对齐  'c'按钮居中对齐  'r' 按钮右对齐。默认值，不用设置
					shadeClose : true,//是否点击遮罩关闭
					fixed : true, //是否固定
					resize : false,
					anim : 1,//动画  0-6
					area : [ '600px', '600px' ], //大小   'auto'
					maxWidth : 900, //自适应最大宽度
					maxHeight : 700,//自适应最小宽度
					shade : [ 0.3, '#000' ], //遮罩
					btn : [ '保存', '关闭', '开心么' ], //底部按钮
					yes : function(index, layero) {//按钮回调
						layer.alert("保存的回调");
					},
					btn2 : function(index, layero) {
						layer.alert("关闭的回调");
					},
					btn3 : function(index, layero) {
						layer.msg("开心");
						layer.close(index);//只是为了留住代码,该代码的意思是执行完关闭窗体
						return false;
					}
				});
			});
		});
	</script>
</body>
</html>