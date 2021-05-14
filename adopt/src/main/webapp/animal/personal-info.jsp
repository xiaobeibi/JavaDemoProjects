<%--
  Created by IntelliJ IDEA.
  User: 24255
  Date: 2019/9/3
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="multipart/form-data; charset=utf-8" />

    <title>个人信息修改</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- bootstrap -->
    <!-- bootstrap -->
    <link  href="${pageContext.request.contextPath}/bootstrap/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/bootstrap/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/bootstrap/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />


    <!-- global styles -->
    <link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />



    <!-- this page specific styles 游泳-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal-info.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<!-- end navbar -->

<!-- main container .wide-content is used for this layout without sidebar :)  -->
<div class="content wide-content">
    <div class="container-fluid">
        <div class="settings-wrapper" id="pad-wrapper">


            <!-- avatar column -->
            <div class="span3 avatar-box">
                <div class="personal-image">
                    <img src="/images/${user.pic}" alt="" class="avatar img-circle"  id="user_pic_modal_btn"/>
                    <form id="update_file" style="display: none"  enctype="multipart/form-data">
                        <input type="file"  name="file" id="myFile" />
                    </form>
                </div>
            </div>

            <!-- edit form column -->
            <div class="span7 personal-info">
                <h5 class="personal-title">个人信息修改</h5>
                <form id="user_edit_form">
                    <input type="hidden" id="edit_id" name="id" value="${user.id}">
                <div class="field-box">
                    <label>用户名:</label>
                    <input type="text" class="span5 inline-input" id="edit_userName" placeholder="用户名称" name="userName" value="${user.userName}" />
                </div>
                <div class="field-box">
                    <label>密码:</label>
                    <input type="password" class="span5 inline-input" id="edit_password" placeholder="用户密码" name="password" value="${user.password}"/>
                </div>
                <div class="field-box">
                    <label>年龄:</label>
                    <input type="text" class="span5 inline-input" id="edit_age" placeholder="年龄" name="age" value="${user.age}"/>
                </div>
                <div class="field-box">
                    <label>性别:</label>
                    <div class="ui-select">
                        <select id="edit_sex" name="sex" value="${user.sex}">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>

                <div class="field-box">
                    <label>电话密码:</label>
                    <input type="text" class="span5 inline-input" id="edit_telephone" placeholder="电话" name="telephone" value="${user.telephone}" />
                </div>
                <div class="field-box">
                    <label>Email:</label>
                    <input type="text" class="span5 inline-input" id="edit_Email" placeholder="Email"  name="Email" value="${user.email}"/>
                </div>

                <div class="field-box">
                    <label>地址:</label>
                    <input type="text" class="span5 inline-input" id="edit_address" placeholder="地址" name="address" value="${user.address}"/>
                </div>
                <div class="field-box">
                    <label>有无领养经历:</label>
                    <div class="ui-select">
                        <select id="edit_state" name="state" value="${user.state}">
                            <option value="0">有领养经历</option>
                            <option value="1">无领养经历</option>
                        </select>
                    </div>
                </div>
                <div class="span6 field-box actions">
                    <input type="button" class="btn-glow primary" value="提交修改" id="user_update_btn" />
                    <input type="button" class="btn-glow primary" value="返回主页" id="return_btn" />
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

    //点击更新按钮弹出模态框。
    $("#user_update_btn").click(function(){
        $.ajax({
            url:"${pageContext.request.contextPath}/user/update.action",
            type:"POST",
            async:"false",
            data:$("#user_edit_form").serialize(),
            success:function (result) {
                alert("用户信息更新成功！");
            },
            error:function(result){
                alert("用户信息更新失败！");
            }
        });
    });

    $("#return_btn").click(function () {
        window.location.href="${pageContext.request.contextPath}/animal/index.jsp";
    });
    
    
    $("#user_pic_modal_btn").click(function () {
        var file= $("#myFile");
        file.click();
        file.change(function () {
            var form=new FormData(document.getElementById("update_file"));
            console.log(form);
            $.ajax({
                url:"${pageContext.request.contextPath}/user/updatePic.action",
                type: "POST",
                data: form,
                async: false,
                processData: false, // 使数据不做处理
                contentType: false, // 不要设置Content-Type请求头
                success:function (result) {
                    alert("修改成功");
                    window.location.reload();
                },
                error:function (result) {
                    alert("修改失败");
                }
            });
        });
    })
</script>
</body>
</html>
