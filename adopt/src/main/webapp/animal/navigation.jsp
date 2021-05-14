<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 24255
  Date: 2019/8/24
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        <sitemesh:write property='title' /></title>
    <sitemesh:write property='head' />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!-- Owl-Carousel-CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
</head>
<body>
<!-- sticky navigation -->
<div class="nav-links">
    <nav class='navbar navbar-default'>
        <div class='container'>
            <div class='collapse navbar-collapse'>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/animal/index.jsp">主页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/animal/about.jsp">流浪猫狗知识</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/animal/service.jsp">领养中心</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/animal/teamBlog.jsp">团队活动</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/animal/team.jsp">团队展示</a>
                    </li>

                    <!-- 判断是否登录 显示哪个内容 -->
                    <%
                        boolean isLogin=false;
                        Object user = request.getSession().getAttribute("user");
                        if (user!=null){
                            isLogin = true;
                        }
                        request.getSession().setAttribute("isLogin",isLogin);
                    %>
                    <c:if test="${sessionScope.isLogin}" var="flage" scope="session">
                        <li id="edit_logout">
                            <div class="img"><img src="/images/${user.getPic()}" alt="" width="60px" style="border-radius:50% " value="${user.getId()}" id="user_edit_modal_btn"></div>
                        </li>
                        <a id="logout">退出</a>
                    </c:if>
                    <c:if test="${!flage}" var="flage" scope="session">
                        <li id="login_register">
                            <button class="btn-primary btn-lg" data-toggle="modal" data-target="#login">注册/登录</button>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- 注册登录模块框 -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">
                    <div role="tabpanel">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" aria-controls="login" role="tab" data-toggle="tab">登录</a>
                            </li>
                            <li role="presentation">
                                <a href="#tab" aria-controls="register" role="tab" data-toggle="tab">注册</a>
                            </li>
                        </ul>
                    </div>
                </h4>
            </div>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="modal-body">
                        <form class="form-horizontal" id="user_login_form">
                            <div class="form-group">
                                <label for="new_loginName" class="col-sm-2 control-label">账号</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="new_loginName" placeholder="账号"
                                           name="userName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="new_loginPwd" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="new_loginPwd" placeholder="密码"
                                           name="password">
                                </div>
                            </div>
                            <input type="submit" value="" id="dologin" style="display: none">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class=" btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn-primary" id="user_login_btn">登录</button>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="tab">
                    <div class="modal-body">
                        <form class="form-horizontal" id="user_register_form" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="new_userName" class="col-sm-2 control-label">
                                    用户名字
                                </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="new_userName" placeholder="用户名称" name="userName">
                                </div>
                                <label for="new_password" class="col-sm-2 control-label">
                                    用户密码
                                </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="new_password" placeholder="用户密码" name="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="new_sex" class="col-sm-2 control-label">
                                    性别
                                </label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="new_sex" name="sex">
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                                <label for="new_age" class="col-sm-2 control-label">
                                    年龄
                                </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="new_age" placeholder="年龄" name="age">
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="new_telephone" class="col-sm-2 control-label">
                                    电话号码
                                </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="new_telephone" placeholder="电话" name="telephone">
                                </div>
                                <label for="new_Email" class="col-sm-2 control-label">
                                    Email
                                </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="new_Email" placeholder="Email"  name="Email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="new_address" class="col-sm-2 control-label">
                                    地址
                                </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="new_address" placeholder="地址" name="address">
                                </div>
                                <label for="new_state" class="col-sm-2 control-label">
                                    经历
                                </label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="new_state" name="state">
                                        <option value="0">有领养经历</option>
                                        <option value="1">无领养经历</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class=" btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class=" btn-primary" id="user_register_btn">注册</button>
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 注册登录模块框 -->
<!--个人信息修改的模态框-->
<div class="modal fade" id="editUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabe">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabe">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="user_edit_form" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="edit_id" name="id">
                    <div class="form-group">
                        <label for="edit_userName" class="col-sm-2 control-label">
                            用户名称
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_userName" placeholder="用户名称" name="userName" value="${user.userName}">
                        </div>
                        <label for="edit_password" class="col-sm-2 control-label">
                            用户密码
                        </label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="edit_password" placeholder="用户密码" name="password" value="${user.password}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_age" class="col-sm-2 control-label">
                            年龄
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_age" placeholder="年龄" name="age" value="${user.age}">
                        </div>
                        <label for="edit_sex" class="col-sm-2 control-label">
                            性别
                        </label>
                        <div class="col-sm-4">
                            <select class="form-control" id="edit_sex" name="sex" value="${user.sex}">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="edit_telephone" class="col-sm-2 control-label">
                            电话号码
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_telephone" placeholder="电话" name="telephone" value="${user.telephone}">
                        </div>
                        <label for="edit_Email" class="col-sm-2 control-label">
                            Email
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_Email" placeholder="Email"  name="Email" value="${user.email}">
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="edit_address" class="col-sm-2 control-label">
                            地址
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_address" placeholder="地址" name="address" value="${user.address}">
                        </div>
                        <label for="edit_state" class="col-sm-2 control-label">
                            经历
                        </label>
                        <div class="col-sm-4">
                            <select class="form-control" id="edit_state" name="state" value="${user.state}">
                                <option value="0">有领养经历</option>
                                <option value="1">无领养经历</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class=" btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class=" btn-primary" id="user_update_btn">保存修改</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">


    $("#user_login_btn").click(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/user/login.action",
            type:"POST",
            data:$("#user_login_form").serialize(),
            success:function (result) {
                alert("登录成功");
                window.location.reload();
            },
            error:function (result) {
                alert("登陆失败");
            }
        });
    });

    //清空表单样式及内容
    function reset_form(ele){
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击编辑按钮弹出模态框。
    $("#user_edit_modal_btn").click(function(){
        // //1、发送ajax,根据id获取用户信息
        // //清除表单数据（表单完整重置（表单的数据，表单的样式））
        // reset_form("#user_edit_form");
        // //2、弹出模态框
        // $("#editUser").modal({
        //     backdrop:"static"
        // });
        window.location.href="${pageContext.request.contextPath}/animal/personal-info.jsp"

    });

    //点击更新按钮弹出模态框。
    $("#user_update_btn").click(function(){
        var file=document.getElementById("user_edit_form");
        var fd = new FormData(file);
        $.ajax({
            url:"${pageContext.request.contextPath}/user/update.action",
            type:"POST",
            processData: false,  // 告诉jQuery不要去处理发送的数据
            contentType: false, // 告诉jQuery不要去设置Content-Type请求头
            data:fd,
            success:function (result) {
                alert("用户信息更新成功！");
            },
            error:function(result){
                alert("用户信息更新失败！");
            }
        });

    });

    $("#logout").click(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/user/logout.action",
            type:"GET",
            success:function (result) {
                window.location.href="${pageContext.request.contextPath}/animal/index.jsp";
                alert("退出成功");
            },
            error:function (result) {
               alert("退出失败");
            }
        })
    })
    $("#user_register_btn").click(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/user/create.action",
            type:"POST",
            data:$("#user_register_form").serialize(),
            success:function (result) {
                alert("注册成功，请去登录！");
            },
            error:function (result) {
                alert("注册失败");
            }
        });
    });


</script>
</body>
</html>
