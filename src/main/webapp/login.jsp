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
<link href="${contextPath }/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath }/static/bootstrap/css/font-awesome.min.css" rel="stylesheet">
<link href="${contextPath }/static/alert/jquery-confirm.min.css" rel="stylesheet">
<style type="text/css">
body {
	background: url(${contextPath }/static/img/login/bg.jpg) no-repeat;
	background-size: cover;
	font-size: 16px;
}

.form {
	background: rgba(255, 255, 255, 0.2);
	width: 400px;
	margin: 100px auto;
}

#login_form {
	display: block;
}

#register_form {
	display: none;
}

.fa {
	display: inline-block;
	top: 27px;
	left: 6px;
	position: relative;
	color: #ccc;
}

input[type="text"], input[type="password"] {
	padding-left: 26px;
}

.checkbox {
	padding-left: 21px;
}
</style>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="${contextPath }/static/bootstrap/html5shiv/html5shiv.js"></script>
      <script src="${contextPath }/static/bootstrap/respond/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="container">
		<div class="form row">
			<form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form">
				<h3 class="form-title">登录</h3>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i> <input
							class="form-control required" type="text" placeholder="请输入账号"
							name="loginAccount" autofocus="autofocus" maxlength="20" />
					</div>
					<div class="form-group">
						<i class="fa fa-lock fa-lg"></i> <input
							class="form-control required" type="password"
							placeholder="请输入密码" name="loginPass" maxlength="8" />
					</div>
					<div class="form-group">
						<label class="checkbox"> <input type="checkbox"
							name="rememberMe" value="1" /> 记住我
						</label>
						<hr />
						<a href="javascript:;" id="register_btn" class="">注册？</a>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success pull-right" value="登录 " />
					</div>
				</div>
			</form>
		</div>

		<div class="form row">
			<form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form">
				<h3 class="form-title">注册</h3>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i> <input
							class="form-control required" type="text" placeholder="请输入账号"
							name="loginAccount" autofocus="autofocus" id="register_account" />
					</div>
					<div class="form-group">
						<i class="fa fa-lock fa-lg"></i> <input
							class="form-control required" type="password"
							placeholder="请输入密码" id="register_password" name="loginPass" />
					</div>
					<div class="form-group">
						<i class="fa fa-check fa-lg"></i> <input
							class="form-control required" type="password"
							placeholder="请输入确认密码" name="rloginPass" />
					</div>
					<div class="form-group">
						<i class="fa fa-envelope fa-lg"></i> <input
							class="form-control eamil" type="text" placeholder="Email"
							name="userEmail" id="register_email"/>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success pull-right"
							value="注册" /> <input type="submit"
							class="btn btn-info pull-left" id="back_btn" value="返回" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="${contextPath }/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${contextPath }/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${contextPath }/static/alert/jquery-confirm.min.js" ></script>
	<script type="text/javascript" src="${contextPath }/static/jquery/jquery.validate.min.js" ></script>
	<script type="text/javascript" src="${contextPath }/static/login/login.js" ></script>
</body>
</html>
