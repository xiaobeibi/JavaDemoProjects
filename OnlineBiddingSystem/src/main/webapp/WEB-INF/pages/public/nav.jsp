<%@ page import="com.bjpowernode.entity.Users" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<nav>
    <ul class="nav nav-pills pull-right" id="menu">

        <li id="tenderMenu" role="presentation"><a href="<%=basePath%>tender/goIndexPage">招标公示</a></li>

        <c:if test="${sessionScope.get('users') != null}">

            <li id="bidMenu" role="presentation"><a href="<%=basePath%>bid/goIndexPage">投标公示</a></li>
            <c:if test="${sessionScope.get('isAdmin') != null}">
                <li id="createTender" role="presentation"><a href="<%=basePath%>tender/createTenderPage">发布招标</a></li>
                <li id="usersMenu" role="presentation"><a href="<%=basePath%>users/goShowAllUsersIndexPage">服务商管理</a>
                </li>
            </c:if>

            <li id="myMenu" role="presentation" class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                   aria-expanded="false">
                    <%=((Users) session.getAttribute("users")).getUserName()%> <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="<%=basePath%>users/goUpdateUsersIndexPage?usersId=<%=((Users) session.getAttribute("users")).getUserId()%>">个人中心</a>
                    </li>
                    <li id="myOrderFormMenu" role="presentation"><a
                            href="<%=basePath%>bid/goMyIndexPage">我的投标</a></li>
                    <li><a href="<%=basePath%>login/loginOut">退出登录</a></li>
                </ul>
            </li>
        </c:if>

        <c:if test="${sessionScope.get('users') == null}">
            <li id="loginMenu" role="presentation"><a href="<%=basePath%>login/goIndexPage">服务商登录</a></li>
            <li id="registerMenu" role="presentation"><a href="<%=basePath%>users/goCreateUsersIndexPage">服务商注册</a>
            </li>
        </c:if>

    </ul>
</nav>
<h3 class="text-muted">${applicationScope.projectName}</h3>

<script>

    //菜单激活控制
    var activeMenu = '${activeMenu}';
    if (activeMenu) {
        $("#menu").find("li .active").removeClass("active");
        $("#" + activeMenu).addClass("active");
    }

</script>
