<%@page import="com.bjpowernode.hospitalhr.util.MTimeUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.hospitalhr.entity.*" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 修改离休员工信息</title>
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
						<h5>修改离休员工信息</h5>
					</div>
					<div class="ibox-content">
						<% History history = (History)request.getAttribute("history"); %>
						<form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/retire/<%=history.getId() %>/update.do">
							<div class="form-group">
								<label class="col-sm-3 control-label">工号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="employeeNumber" value="<%=history.getEmployeeNumber() %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">姓名</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="name" value="<%=history.getName() %>" minlength="2" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">性别</label>
								<div class="col-sm-7">
									<div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="男" name="gender" 
                                            <%
												if(history.getGender().equals("男")){
											%>
												checked="checked"
											<%  } %>
                                            > <i></i>男</label>
                                        <i style="margin-left: 25px"></i>
                                        <label>
                                            <input type="radio" value="女" name="gender"
                                            <%
												if(history.getGender().equals("女")){
											%>
												checked="checked"
											<%  } %>
                                            > <i></i>女</label>
                                    </div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">出生年月</label>
								<div class="col-sm-7">
									<% String birthday = MTimeUtil.dateFormat(history.getBirthday()); %>
									<input type="date" class="form-control" name="date" value="<%=birthday %>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" >联系方式</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="telephone" value="<%=history.getTelephone() %>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">邮箱</label>
								<div class="col-sm-7" >
									<input type="text" class="form-control" placeholder="" name="email" value="<%=history.getEmail() %>" email="true">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">籍贯</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="address" value="<%=history.getAddress() %>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">学历</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="education" value="<%=history.getEducation() %>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="" value="<%=history.getDepartment().getName() %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">职称</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="" value="<%=history.getPosition().getName() %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">状态</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="" value="<%=history.getStatus() %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">家庭住址</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="home" value="<%=history.getHome() %>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="notes" value="<%=history.getNotes() %>">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-8">
									<button class="btn btn-primary" type="submit">修&nbsp;&nbsp;改</button>&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn btn-white" type="reset">取&nbsp;&nbsp;消</button>
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
		<script>
	$().ready(function() {
	    $("#commentForm").validate();
	});
	$.validator.setDefaults({
	    submitHandler: function() {
	    	parent.layer.msg('修改成功！',{icon: 1});
	    	form.submit();
	    }
	});
	</script>

</body>
</html>
