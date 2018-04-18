<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户列表</title>

<!-- Bootstrap -->
<link href="${contextPath }/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath }/static/bootstrap/table/bootstrap-table.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="${contextPath }/static/html5shiv/html5shiv.min.js"></script>
      <script src="${contextPath }/static/respond.js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<input type="hidden" id="contextPath" value="${contextPath }" />
	<div class="container-fluid">
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button id="btn_info" type="button" class="btn btn-default">
				<span class="fa fa-info" aria-hidden="true"></span>详情
			</button>
		</div>
		<table id="table_sysUser"></table>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${contextPath }/static/jquery/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${contextPath }/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="${contextPath }/static/bootstrap/table/bootstrap-table.js"></script>
	<script src="${contextPath }/static/bootstrap/table/locale/bootstrap-table-zh-CN.js"></script>
	<script src="${contextPath }/static/entity/user/sysUser.js"></script>
</body>
</html>
