<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>主页</title>

<!-- Bootstrap core CSS -->
<link href="${contextPath }/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath }/static/bootstrap/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${contextPath }/static/bootstrap/css/meun.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${contextPath }/static/bootstrap/tab/css/bootstrap.addtabs.css"
	type="text/css" media="screen" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="${contextPath }/static/bootstrap/html5shiv/html5shiv.js"></script>
      <script src="${contextPath }/static/bootstrap/respond/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="navbar navbar-duomi navbar-static-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" id="logo">任务测试 </a>
				<a href="${contextPath }/sysuser/logout.action">退出</a>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2" style="background-color: #c4c4c4;margin: 0;padding: 0;height: 100%">
				<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
					<li  class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab"> <i class="glyphicon glyphicon-th-large"></i>
							首页
					</a></li>
					<li><a href="#systemSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>
							系统管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="systemSetting" class="nav nav-list secondmenu collapse"
							style="height: 0px;">
							<li><a href="javascript:void(0);" data-addtab="user" url="${contextPath }/page/user.action"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
							<li><a href="javascript:void(0);" data-addtab="userdd" url="${contextPath }/page/useddr.action"></i>&nbsp;菜单管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a></li>
						</ul></li>
					<li><a href="#configSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i
							class="glyphicon glyphicon-credit-card"></i> 配置管理 <span
							class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
					</a>
						<ul id="configSetting" class="nav nav-list secondmenu collapse">
							<li><a href="#"><i
									class="glyphicon glyphicon-globe"></i>&nbsp;全局缺省配置</a></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-star-empty"></i>&nbsp;未开通用户配置</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-star"></i>&nbsp;退订用户配置</a></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-text-width"></i>&nbsp;试用用户配置</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-ok-circle"></i>&nbsp;开通用户配置</a></li>
						</ul></li>

					<li><a href="#disSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-globe"></i>
							分发配置 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="disSetting" class="nav nav-list secondmenu collapse">
							<li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;分发包配置</a></li>
						</ul></li>

					<li><a href="#dicSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-bold"></i>
							字典配置 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="dicSetting" class="nav nav-list secondmenu collapse">
							<li><a href="#"><i
									class="glyphicon glyphicon-text-width"></i>&nbsp;关键字配置</a></li>
						</ul></li>
					<li><a href="#"> <i class="glyphicon glyphicon-fire"></i>
							关于系统 <span class="badge pull-right">1</span>
					</a></li>

				</ul>
			</div>
			<div class="col-md-10" style="margin: 0;padding: 0;">
				<div id="tabs">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#home"
							aria-controls="home" role="tab" data-toggle="tab">主页</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="home">主页</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${contextPath }/static/jquery/jquery.min.js"></script>
	<script src="${contextPath }/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="${contextPath }/static/bootstrap/tab/js/bootstrap.addtabs.js"></script>
	<script type="text/javascript">
        $(function () {
            $('#tabs').addtabs({contextmenu:true});
        });
    </script>
</body>
</html>

