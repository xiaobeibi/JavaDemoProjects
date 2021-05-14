<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>用户管理-修改服务商-<%=application.getAttribute("projectName")%>
    </title>
</head>
<body>
<div class="container" style="width:70%">
    <%--<jsp:include page="./../public/nav.jsp"/>--%>
    <div>

        <form class="form-horizontal">

            <span style="display:none" id="userId" readonly>${updateUsers.userId}</span>
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">服务商名</label>

                <div class="col-sm-10">

                    <input type="text" class="form-control" id="userName" readonly=true
                           value="${updateUsers.userName}">
                </div>
            </div>
            <div class="form-group">
                <label for="passWd" class="col-sm-2 control-label">密码</label>

                <div class="col-sm-10">
                    <input type="password" class="form-control" id="passWd" placeholder="密码"
                           value="${updateUsers.passWd}">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">电话</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" placeholder="电话" value="${updateUsers.phone}">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>

                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" placeholder="邮箱" value="${updateUsers.email}">
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">地址</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" placeholder="地址"
                           value="${updateUsers.address}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-warning" id="update">修改</button>
                </div>
            </div>
        </form>

    </div>
</div>


</body>
</html>

<script>
    $(function () {

        var $userName = $("#userName");
        if ($userName.val() === 'admin') {
            $userName.attr("readonly", true);
        }
        $("#update").click(function () {
            var userId = '${updateUsers.userId}';
            var userName = $("#userName").val();
            var passWd = $("#passWd").val();
            var phone = $("#phone").val();
            var email = $("#email").val();
            var address = $("#address").val();
            if (userName == "" || passWd == "") {
                $("#entity").modal("toggle");
                MSG.showErrorMsg("用户名密码必填");
                return;
            }

            $.ajax({
                type: "POST",
                url: "<%=basePath%>" + "users/updateUser",
                data: {
                    "method": "updateUser",
                    "userId": userId,
                    "userName": userName,
                    "passWd": passWd,
                    "phone": phone,
                    "email": email,
                    "address": address
                },
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        MSG.showSucceedMsg("修改成功！");
                    } else {
                        MSG.showErrorMsg("用户名已存在！");
                    }
                }
            });
        });
    });

</script>
