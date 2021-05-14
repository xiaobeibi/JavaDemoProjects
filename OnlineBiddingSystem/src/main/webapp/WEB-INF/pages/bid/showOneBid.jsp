<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>投标信息，投标编号${bidId}-${applicationScope.projectName}</title>
    <jsp:include page="../public/datatables-bootstrap-js-css.jsp"/>
</head>
<body>
</body>
</html>

<script>
    window.location.href = "<%=basePath%>bid/downPDF?bidId=${bidId}"
</script>
