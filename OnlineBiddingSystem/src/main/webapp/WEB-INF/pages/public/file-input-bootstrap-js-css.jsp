<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<link href="<%=basePath%>resources/bootstrap/fileInput/css/fileinput.min.css" rel="stylesheet">

<script type="application/javascript" src="<%=basePath%>resources/bootstrap/fileInput/js/fileinput.min.js"></script>
<script type="application/javascript"
        src="<%=basePath%>resources/bootstrap/fileInput/js/fileinput_locale_zh.js"></script>
