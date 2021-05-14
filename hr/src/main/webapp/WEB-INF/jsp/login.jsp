<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title> HR医院人事管理系统 - 登录</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css" rel="stylesheet">
	<link href="<%=path %>/css/login.css" rel="stylesheet">
	<!--[if lt IE 9]>
    	<meta http-equiv="refresh" content="0;ie.html" />
    	<![endif]-->
	<script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>
</head>
<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-12">
				<form method="post" action="<%=path %>/employee/checkLogin.do">
					<h4 class="no-margins">
						<font color="#6C6C6C">登录：</font>
					</h4>
					<p class="m-t-md">
						<font color="#6C6C6C">欢迎登录HR医院人事管理系统</font>
					</p>
					<input type="text" class="form-control uname" placeholder="用户名" name="employeeNumber" />
					<input type="password" class="form-control pword m-b" placeholder="密码" name="password" />
					<p></p>
					<a href="">忘记密码了？</a>
					<button class="btn btn-success btn-block" type="submit">登录</button>
				</form>
			</div>
		</div>
		<div class="signup-footer">
			<div class="pull-left">&copy; 小贝比</div>
		</div>
	</div>
</body>

</html>
