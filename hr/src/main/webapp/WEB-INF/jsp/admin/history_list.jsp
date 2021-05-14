<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.hospitalhr.entity.*" %>
<%@ page import="com.baomidou.mybatisplus.plugins.Page" %>
<%@ page import="com.bjpowernode.hospitalhr.util.MTimeUtil"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 退休员工列表</title>
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
						<h5>退休员工列表</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>序号</th>
									<th>工号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>电话</th>
									<th>部门名称</th>
									<th>职称</th>
									<th>入职时间</th>
									<th>离休时间</th>
									<th width="60px">类别</th>
									<th>管理</th>
								</tr>
							</thead>
							<tbody>
							<%
                            	List<History> list = (List<History>)request.getAttribute("hList");
                            	int index=1;
                            	for(History history : list){
                            %>
								<tr class="gradeA">
									<td><%=index++ %></td>
									<td><%=history.getEmployeeNumber() %></td>
									<td><%=history.getName() %></td>
									<td><%=history.getGender() %></td>
									<td><%=history.getTelephone() %></td>
									<td><%=history.getDepartment().getName() %></td>
									<td><%=history.getPosition().getName() %></td>
								<%
									String intime = MTimeUtil.dateFormat(history.getInTime());
									String outtime = MTimeUtil.dateFormat(history.getOutTime());
									if(outtime == null) outtime = ""; 
								%>
									<td><%=intime %></td>
									<td><%=outtime %></td>
									<td><%=history.getStatus() %></td>
									<td><a href="<%=path %>/history/<%=history.getId() %>/detail.do" class="btn btn-info">查看</a>&nbsp;&nbsp;
										<a href="<%=path %>/history/<%=history.getId() %>/toUpdate.do" class="btn btn-primary">修改</a>
								</tr>
							<%
                            	}
                             %>
							</tbody>
						</table>
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
    $(document).ready(function () {
        $('.dataTables-example').dataTable();
        
        var oTable = $('#editable').dataTable();
        
        oTable.$('td').editable('../example_ajax.php', {
            "callback": function (sValue, y) {
                var aPos = oTable.fnGetPosition(this);
                oTable.fnUpdate(sValue, aPos[0], aPos[1]);
            },
            "submitdata": function (value, settings) {
                return {
                    "row_id": this.parentNode.getAttribute('id'),
                    "column": oTable.fnGetPosition(this)[2]
                };
            },
            "width": "90%",
            "height": "100%"
        });
    });
    </script>
</body>
</html>
