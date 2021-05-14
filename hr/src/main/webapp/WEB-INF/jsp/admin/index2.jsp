<%@page import="com.bjpowernode.hospitalhr.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="renderer" content="webkit">
	<title>HR医院人事管理系统 - 主页</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	
	<style type="text/css">
	#line-chart {
		height: 300px;
		width: 800px;
		margin: 0px auto;
		margin-top: 1em;
	}
	</style>
	
	<!--[if lt IE 9]>
    	<meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    
	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow: hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
								<span class="clear"> 
									<span class="block m-t-xs" style="font-size: 20px;"> 
										<i class="fa fa-heartbeat"></i>
										<strong class="font-bold">&nbsp;HR医院</strong>
									</span>
								</span>
							</a>
						</div>
						<div class="logo-element">HR</div>
					</li>
					
					<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
						<span class="ng-scope">个人</span>
					</li>
					<li><a class="J_menuItem" href="<%=path %>/employee/welcome.do">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">主页</span>
                        </a>
                    </li>
                   <% Employee employee = (Employee)session.getAttribute("loged"); %>
					<li><a href="graph_metrics.html"> 
							<i class="fa fa fa-newspaper-o"></i> 
							<span class="nav-label">个人信息</span>
							<span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="<%=path %>/employee/oneself/<%=employee.getId() %>/detial.do">查看个人信息</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/employee/oneself/<%=employee.getId() %>/toUpdate.do">修改个人信息</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/attendance/<%=employee.getEmployeeNumber() %>/oneself.do">查看考勤记录</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/overtime/<%=employee.getEmployeeNumber() %>/oneself.do?pageNo=1">查看加班信息</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/leave/toAdd.do">申请请假</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/leave/oneself.do?pageNo=1">查看请假记录</a>
							</li>
						</ul></li>

					<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
						<span class="ng-scope">员工</span>
					</li>
					<li><a href="graph_metrics.html">
							<i class="fa fa fa-user-md"></i> 
							<span class="nav-label">员工管理</span>
							<span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="<%=path %>/employee/listPage.do?pageNo=1">在职员工管理</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/history/retireListPage.do?pageNo=1">离休员工管理</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/history/list.do">员工档案管理</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/move/list.do">员工调动记录</a>
							</li>
						</ul>
					</li>
					<li><a href="mailbox.html">
							<i class="fa fa-calendar"></i>
							<span class="nav-label">考勤管理 </span>
							<span class="fa arrow"></span>
							<!-- <span class="label label-warning pull-right">16</span> --></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="<%=path %>/attendance/list.do">考勤管理</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/overtime/listPage.do?pageNo=1">加班管理</a>
							</li>
							<li><a class="J_menuItem" href="<%=path %>/leave/list.do">请假记录</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->
		
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="<%=path %>/employee/search.do?pageNo=1" target="J_iframe">
                            <div class="form-group">
                                <input type="text" placeholder="输入查找的员工的姓名 …" class="form-control" name="input" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                    	<li>欢迎：<%=employee.getName() %>&nbsp;</li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-user"></i> <!-- <span class="label label-primary">8</span> -->
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path %>/employee/oneself/<%=employee.getId() %>/detial.do" target="J_iframe">我的账户</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="<%=path %>/employee/login.do">退出登录</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="<%=path %>/employee/logout.do">注销登录</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" name="J_iframe" width="100%" height="100%" src="<%=path %>/employee/welcome.do" frameborder="0" seamless></iframe>
            </div>
        </div>
		<!--右侧部分结束-->
	</div>
	
	<!-- 全局js -->
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path %>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="<%=path %>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="<%=path %>/js/plugins/layer/layer.min.js"></script>
	
	<!-- 自定义js -->
	<script src="<%=path %>/js/hAdmin.js?v=4.1.0"></script>
	<script src="<%=path %>/js/index.js" type="text/javascript"></script>
	
	<!-- 第三方插件 -->
	<script src="<%=path %>/js/plugins/pace/pace.min.js"></script>
</body>

</html>
