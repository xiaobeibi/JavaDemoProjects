<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>服务商管理-新建服务商-<%=application.getAttribute("projectName")%>
    </title>
    <style>

        .col-sm-10 {
            max-width: 330px;
        }


    </style>
</head>
<body>
<div class="container" style="width:70%">
    <%--<jsp:include page="./../public/nav.jsp"/>--%>
    <div>

        <form class="form-horizontal">
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">服务商名</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userName" placeholder="服务商名">
                </div>
            </div>
            <div class="form-group">
                <label for="passWd" class="col-sm-2 control-label">密码</label>

                <div class="col-sm-10">
                    <input type="password" class="form-control" id="passWd" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <label for="passWd" class="col-sm-2 control-label">确认密码</label>

                <div class="col-sm-10">
                    <input type="password" class="form-control" id="passWdConfirm" placeholder="确认密码">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">电话</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" placeholder="电话">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" placeholder="邮箱">
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">地址</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" placeholder="地址">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-warning" id="create">新建</button>
                </div>
            </div>
        </form>

    </div>
</div>


</body>
</html>

<script>


    $(function () {

        /**
         * 创建用户按钮事件
         */
        $("#create").click(function () {

            var userName = $("#userName").val();
            var passWd = $("#passWd").val();
            var passWdConfirm = $("#passWdConfirm").val();
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
                url: "<%=basePath%>" + "users/createUsers",
                data: {
                    "method": "createUser",
                    "userName": userName,
                    "passWd": passWd,
                    "phone": phone,
                    "email": email,
                    "address": address
                },
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        setTimeout(window.location.href = "<%=basePath%>" + "login/goIndexPage", 3000);
                        alert("用户注册成功！");
                    } else {
                        MSG.showErrorMsg("用户名已存在！");
                    }
                },
                error: function () {
                }
            });
        });
    });

</script>
