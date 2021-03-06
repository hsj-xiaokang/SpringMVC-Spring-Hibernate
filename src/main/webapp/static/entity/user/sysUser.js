//项目根目录
var path = $("#contextPath").val();
$(document).ready(function() {
	//初始化Table
	var oTable = new TableInit();
	oTable.Init();

	//初始化页面上面的按钮事件
	$("#btn_add").click(function(){
		//新增
	});
	$("#btn_edit").click(function(){
		//编辑
	});
	$("#btn_info").click(function(){
		//详情
	});
	$("#btn_delete").click(function(){
		//删除
	});
});
var TableInit = function () {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function () {
		$('#table_sysUser').bootstrapTable({
			url: path+'/sysuser/findUser.action',         //请求后台的URL（*）
			method: 'post',                      //请求方式（*）
			toolbar: '#toolbar',                //工具按钮用哪个容器
			striped: true,                      //是否显示行间隔色
			cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,                   //是否显示分页（*）
			sortable: true,                     //是否启用排序
			sortName:"id",
			sortOrder: "desc",                   //排序方式
			queryParams: oTableInit.queryParams,//传递参数（*）
			queryParamsType: 'limit',
			sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
			pageNumber:1,                       //初始化加载第一页，默认第一页
			pageSize: 15,                       //每页的记录行数（*）
			pageList: [10, 15, 20, 50],        //可供选择的每页的行数（*）
			search: true,                       //是否显示表格搜索
			strictSearch: true,
			showColumns: true,                  //是否显示所有的列
			showRefresh: true,                  //是否显示刷新按钮
			minimumCountColumns: 2,             //最少允许的列数
			clickToSelect: true,                //是否启用点击选中行
			//height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId: "id",                     //每一行的唯一标识，一般为主键列
			showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
			cardView: false,                    //是否显示详细视图
			detailView: false,                   //是否显示父子表
			contentType: "application/x-www-form-urlencoded", //解决POST提交问题
			columns: [
			          {checkbox: true },
			          {title:'登录账号',field: 'loginAccount',sortable:true },
			          {title:'昵称',field: 'userName',sortable:true },
			          {title:'头像',field: 'userHead',sortable:true },
			          {title:'手机',field: 'userPhone',sortable:true,
			        	  formatter:function(v,r,i){
			        		  if(v){
			        			  return v.substring(0,3)+"****"+v.substring(7,4);
			        		  }
			        		  return v;
			        	  }
			          },
			          {title:'邮箱',field: 'userEmail',sortable:true },
			          {title:'性别',field: 'userSex',sortable:true,
			        	  formatter:function(v,r,i){
			        		  var str = "";
			        		  switch(v){
			        		  case 1:
			        			  str = "男";
			        			  break;
			        		  case 2:
			        			  str = "女";
			        			  break;
			        		  default:
			        			  str = "未知";
			        		  break;
			        		  }
			        		  return str;
			        	  }
			          },
			          {title:'生日',field: 'userBirthday',sortable:true },
			          {title:'注册时间',field: 'registerTime',sortable:true },
			          {title:'所属部门',field:'departmentKey',sortable:true}]
		});
	};

	//得到查询的参数
	oTableInit.queryParams = function (params) {
		var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				pageSize: params.limit,   //页面大小
				pageNumber: params.pageNumber, //页码
				sortName: params.sort,	//排序列名
				sortOrder:params.order,	//排序方式
				searchText:params.search//搜索框参数
		};
		return temp;
	};
	return oTableInit;
};