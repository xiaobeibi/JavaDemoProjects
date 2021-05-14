<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- Footer -->
<footer class="footer" style="margin-top: 15px">
    <p>@${applicationScope.projectAuthor} </p>
</footer>
