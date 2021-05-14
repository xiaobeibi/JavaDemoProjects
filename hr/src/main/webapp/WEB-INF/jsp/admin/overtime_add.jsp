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
	<title>HR医院 - 安排加班</title>
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
						<h5>安排加班</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/overtime/add.do">
							<div class="form-group">
								<label class="col-sm-3 control-label">部门</label>
								<div class="col-sm-7">
									<select class="form-control m-b" id="department" name="departmentNumber" size="1" required >
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
								<label class="col-sm-3 control-label">员工</label>
								<div class="col-sm-7">
									<select class="form-control m-b" id="employee" name="employeeNumber" size="1" required>
										<option value="">--请选择员工--</option>
										<% 
											List<Employee> eList = (List<Employee>) request.getAttribute("eList"); 
											for(Employee employee : eList){
							
										%>
											<option value="<%=employee.getEmployeeNumber() %>">
												<%=employee.getName() %>
											</option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">加班日期</label>
								<div class="col-sm-7">
									<input type="date" class="form-control" size="1" name="date" required>
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
		$(function(){  
		 	$("#department").unbind("change", corpChange ).bind("change", corpChange);  
		 	$("#employee").unbind("change", deptChange).bind("change",deptChange);
		 	<span style="color:#FF0000"></span>  
			$("#department").change();  
		});  
		function corpChange (){  
			var selectedValue = $("#department").val();  
			$("#employee").children("span").each(function(){  
				$(this).children().clone().replaceAll($(this)); 
			});  
			if($.trim(selectedValue) != ""){  
		 		$("#employee").children("option[parentid!='" + selectedValue + "'][value!='']").each(function(){  
					$(this).wrap("<span style='display:none'></span>");  
				});  
			}  
		}  
		function deptChange(){  
			$("#department").val($(this).children("option:selected").attr("parentid"));  
		}  
		</script>  
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
