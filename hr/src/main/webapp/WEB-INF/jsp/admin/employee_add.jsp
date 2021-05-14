<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.hospitalhr.entity.*" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 添加员工</title>
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
						<h5>添加员工</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/employee/add.do">
							<div class="form-group">
								<label class="col-sm-3 control-label">工号</label>
								<div class="col-sm-7">
									<% Integer employeeNumber = (Integer)request.getAttribute("employeeNumber"); %>
									<input type="text" class="form-control" name="employeeNumber" value="<%=employeeNumber %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">姓名</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="name" minlength="2" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">密码</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" placeholder="" id="password" name="password" minlength="4" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">确认密码</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" placeholder="" name="password2" equalTo="#password" minlength="4" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">性别</label>
								<div class="col-sm-7">
									<div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="男" name="gender" checked="checked"> <i></i>男</label>
                                        <i style="margin-left: 25px"></i>
                                        <label>
                                            <input type="radio" value="女" name="gender"> <i></i>女</label>
                                    </div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">出生日期</label>
								<div class="col-sm-7">
									<input type="date" class="form-control" size="1" name="date">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">联系方式</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="telephone">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">邮箱</label>
								<div class="col-sm-7" >
									<input type="text" class="form-control" placeholder="" name="email" email="ture">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">籍贯</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="address">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">学历</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="education">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门</label>
								<div class="col-sm-7">
									<select class="form-control m-b" name="departmentNumber" size="1" required>
										<option value="">--请选择部门--</option>
									<% 
										List<Department> dList = (List<Department>) request.getAttribute("dList"); 
										for(Department department : dList){
							
									%>
										<option value="<%=department.getDepartmentNumber() %>">
											<%=department.getName() %>
										</option>
									<%
										}
									%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">职称</label>
								<div class="col-sm-7">
									<select class="form-control m-b" name="positionNumber" size="1" required>
										<option value="">--请选择职称--</option>
										<% 
											List<Position> pList = (List<Position>) request.getAttribute("pList"); 
											for(Position position : pList){
							
										%>
											<option value="<%=position.getPositionNumber() %>">
												<%=position.getName() %>
											</option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="notes">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-8">
									<button class="btn btn-success" type="submit">添&nbsp;&nbsp;加</button>&nbsp;&nbsp;&nbsp;&nbsp;
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
	
	<!-- 表单验证 -->
	<script src="<%=path %>/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="<%=path %>/js/plugins/validate/messages_zh.min.js"></script>
	
	<!-- layer javascript -->
    <script src="js/plugins/layer/layer.min.js"></script>
	<script>
	$().ready(function() {
	    $("#commentForm").validate();
	});
	$.validator.setDefaults({
	    submitHandler: function() {
	    	parent.layer.alert('添加成功！',{icon: 1}),
	    	form.submit();
	    }
	});
	</script>
</body>
</html>
