<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.hospitalhr.entity.*" %>
<% String path = request.getContextPath(); %>
<%@page import="com.bjpowernode.hospitalhr.util.MTimeUtil"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 查看员工请假信息</title>
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

	<!-- Data Tables -->
	<link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
		rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>查看员工请假信息</h5>
					</div>
					<div class="ibox-content">
						<% Leave leave = (Leave)request.getAttribute("leave"); %>
						<form method="post" class="form-horizontal" action="">
						    <div class="form-group">
						    	<div class="col-md-2"></div>
								<div class="col-md-5">
							        <label class="col-sm-8 control-label">工号：</label>
							        <p class="form-control-static"><%=leave.getEmployeeNumber() %></p>
						   		</div>
							</div>
							<div class="form-group">
						    	<div class="col-md-2"></div>
								<div class="col-md-5">
							        <label class="col-sm-8 control-label">姓名：</label>
							        <p class="form-control-static"><%=leave.getEmployee().getName() %></p>
						   		</div>
							</div>
							<div class="form-group">
						    	<div class="col-md-2"></div>
								<div class="col-md-5">
							        <label class="col-sm-8 control-label">起始时间：</label>
							    <%
									String starttime = MTimeUtil.dateFormat(leave.getStartTime());
									String endtime = MTimeUtil.dateFormat(leave.getStartTime());
								%>
							        <p class="form-control-static"><%=starttime %></p>
						   		</div>
							</div>
							<div class="form-group">
						    	<div class="col-md-2"></div>
								<div class="col-md-5">
							        <label class="col-sm-8 control-label">结束时间：</label>
							        <p class="form-control-static"><%=endtime %></p>
						   		</div>
							</div>
							<div class="form-group">
								<div class="col-md-2"></div>
								<div class="col-md-5">
							        <label class="col-sm-8 control-label">天数：</label>
							        <p class="form-control-static"><%=leave.getDays() %></p>
						   		</div>
							</div>
							<div class="form-group">
								<div class="col-md-2"></div>
								<div class="col-md-5">
							        <label class="col-sm-8 control-label">类型：</label>
							        <p class="form-control-static"><%=leave.getType() %></p>
						   		</div>
							</div>
							<div class="form-group">
								<div class="col-md-2"></div>
								<div class="col-md-5">
							        <label class="col-sm-8 control-label">请假原因：</label>
							        <p class="form-control-static"><%=leave.getReason() %></p>
						   		</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-8">
									<a href="<%=path %>/leave/<%=leave.getId() %>/update.do" class="btn btn-primary">批&nbsp;&nbsp;准</a>&nbsp;&nbsp;
									<a href="<%=path %>/leave/listPage.do?pageNo=1" class="btn btn-info">返&nbsp;&nbsp;回</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 全局js -->
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- 自定义js -->
	<script src="<%=path %>/js/content.js?v=1.0.0"></script>

</body>
</html>
