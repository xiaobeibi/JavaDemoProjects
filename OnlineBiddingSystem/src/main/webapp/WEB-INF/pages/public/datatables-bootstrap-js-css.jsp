<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<link href="<%=basePath%>resources/datatables/css/dataTables.bootstrap.min.css" rel="stylesheet">

<link href="<%=basePath%>resources/datatables/css/buttons.bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>resources/datatables/css/select.bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>resources/datatables/css/editor.bootstrap.min.css" rel="stylesheet">


<script type="application/javascript" src="<%=basePath%>resources/datatables/js/jquery.dataTables.min.js"></script>

<script type="application/javascript" src="<%=basePath%>resources/datatables/js/dataTables.bootstrap.min.js"></script>
<script type="application/javascript" src="<%=basePath%>resources/datatables/js/dataTables.buttons.min.js"></script>
<script type="application/javascript" src="<%=basePath%>resources/datatables/js/buttons.bootstrap.min.js"></script>
<script type="application/javascript" src="<%=basePath%>resources/datatables/js/dataTables.select.min.js"></script>
<%--<script type="application/javascript" src="<%=basePath%>resources/datatables/js/dataTables.editor.min.js"></script>
<script type="application/javascript" src="<%=basePath%>resources/datatables/js/editor.bootstrap.min.js"></script>--%>
