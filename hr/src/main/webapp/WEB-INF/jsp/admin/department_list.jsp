<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.hospitalhr.entity.*" %>
<%@ page import="com.baomidou.mybatisplus.plugins.Page" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 部门列表</title>
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
						<h5>部门列表</h5>
					</div>
					<div class="ibox-content">
						<div>
							<a href="<%=path %>/department/toAdd.do" class="btn btn-success">添加部门</a>
						</div>
						<table class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>序号</th>
									<th>部门号</th>
									<th>部门名称</th>
									<th>电话</th>
									<th>地址</th>
									<th width="180px">备注</th>
									<th>管理</th>
								</tr>
							</thead>
							<tbody>
							<%
								Page<Department> pe=(Page<Department>)request.getAttribute("page");
	                            if(null != pe && null != pe.getRecords() && pe.getRecords().size()>0){
	                            	List<Department> list = pe.getRecords();
	                            	int index=1;
	                            	for(Department department : list){
                            %>
								<tr class="gradeA">
									<td><%=index++ %></td>
									<td><%=department.getDepartmentNumber() %></td>
									<td><%=department.getName() %></td>
									<td><%=department.getTelephone() %></td>
									<td><%=department.getAddress() %></td>
									<td><%=department.getNotes() %></td>
									<td><a href="<%=path %>/department/<%=department.getId() %>/toUpdate.do" class="btn btn-primary">修改</a>&nbsp;&nbsp;
										<a href="<%=path %>/department/<%=department.getId() %>/delete.do" class="btn btn-danger">删除</a></td>
								</tr>
							<%
                            		}
                           		 }
                             %>
							</tbody>
						</table>
						<div>
							<span style="float: left; padding: 5px">
								当前&nbsp;<span style="color: red;"><%=pe.getCurrent() %></span>&nbsp;/&nbsp;<b><%=pe.getPages() %></b>&nbsp;页&nbsp;&nbsp;
								总共&nbsp;<b><%=pe.getTotal() %></b>&nbsp;条</span>
							<nav aria-label="Page navigation" style="margin: 0 auto; width: 240px">
								<ul class="pagination" style="margin: 0;">
									<li>
										<a href="<%=path %>/department/listPage.do?pageNo=<%=pe.getCurrent()-1>1?pe.getCurrent()-1:1 %>"
											aria-label="Previous"> <span aria-hidden="true">前一页</span>
										</a>
									</li>
								<%
	 								for(int i=1;i<=pe.getPages();i++){
								%>
									<li><a href="<%=path %>/department/listPage.do?pageNo=<%=i%>"><%=i %></a></li>
								<%
	 								 }
								%>
									<li><a href="<%=path %>/department/listPage.do?pageNo=<%=pe.getCurrent()+1<pe.getPages()?pe.getCurrent()+1:pe.getPages() %>"
										aria-label="Next"> <span aria-hidden="true">后一页</span>
									</a></li>
								</ul>
							</nav>
						</div>
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
