<%--
  Created by IntelliJ IDEA.
  User: 24255
  Date: 2019/8/22
  Time: 23:49
  To change this template use /images | Settings | /images Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html><head>
    <meta content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>流浪猫狗领养管理后台</title>
    <!-- 引入css样式文件 -->
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/js/houtai/css/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="${pageContext.request.contextPath}/js/houtai/css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/js/houtai/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/js/houtai/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/js/houtai/css/boot-crm.css" rel="stylesheet" type="text/css">
    <style>
        .panel-heading{background-color: #337ab7;border-color: #2e6da4;font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
        .panel-heading span{position:absolute;right:10px;top:12px;}
        .mySize{width: 55px;height: 65px;}
    </style>
</head>
<body>
<div id="wrapper">
    <!-- 导航栏部分 -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-brand" href="">流浪猫狗管理系统</a>
        </div>
        <!-- 导航栏右侧图标部分 -->
        <!-- 导航栏右侧图标部分 -->
        <ul class="nav navbar-top-links navbar-right">
            <!-- 消息通知 end -->
            <!-- 用户信息和系统设置 start -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="crmclass/list.action#">
                    <i class="fa fa-user fa-fw"></i>
                    <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="crmclass/list.action#"><i class="fa fa-user fa-fw"></i>
                        用户：</a>
                    </li>
                    <li><a href="crmclass/list.action#"><i class="fa fa-gear fa-fw"></i> 系统设置</a></li>
                    <li class="divider"></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/logout.action">
                            <i class="fa fa-sign-out fa-fw"></i>退出登录
                        </a>
                    </li>
                </ul>
            </li>
            <!-- 用户信息和系统设置结束 -->
        </ul> <!-- 左侧显示列表部分 start-->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <!-- 教学管理  折叠的分组列表 -->
                <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab">
                    <h4 class="panel-title">
                        后台管理 <span class="fa fa-chevron-up right"></span>
                    </h4>
                </div>
                <div id="collapseListGroup3" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                    <ul class="list-group">
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/users.jsp">
                                <i class="fa fa-flash fa-fw"></i> 用户信息
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/admin.jsp">
                                <i class="fa fa-flash fa-fw"></i> 管理员信息
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/pet.jsp">
                                <i class="fa fa-sitemap fa-fw"></i> 流浪猫狗管理
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/adopt.jsp">
                                <i class="fa fa-sitemap fa-fw"></i> 领养管理
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/comment.jsp">
                                <i class="fa fa-sitemap fa-fw"></i> 评论管理
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/blog.jsp">
                                <i class="fa fa-sitemap fa-fw"></i> 团队活动管理
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/apply.jsp">
                                <i class="fa fa-sitemap fa-fw"></i> 志愿者的申请
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/agree.jsp">
                                <i class="fa fa-sitemap fa-fw"></i> 同意领养列表
                            </a>
                        </li>
                        <li class="list-group-item my_font">
                            <a href="${pageContext.request.contextPath}/animal/admin/disAgree.jsp">
                                <i class="fa fa-sitemap fa-fw"></i> 不同意领养列表
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div><!-- 左侧显示列表部分 end-->

    </nav>
    <!-- pet信息查询部分  start-->
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">流浪猫狗信息管理</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="panel panel-default">
            <!-- 搜索部分 -->
            <div class="panel-body">
                <form class="form-inline" method="get" action="#">
                    <div class="form-group">
                        <label for="findByPetType">流浪猫狗类型</label>
                        <input type="text" class="form-control" id="findByPetType" value="" name="petName">
                    </div>
                    <button type="button" class="btn btn-primary" id="pet_find_modal_btn">查询</button>
                </form>
            </div>
        </div>
        <button class="btn btn-primary" id="pet_add_modal_btn">新增</button>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">用户评论列表</div>
                    <!-- /.panel-heading -->
                    <table class="table table-bordered table-striped" id="pet_table">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" id="check_all"/>
                            </th>
                            <th>流浪猫狗编号</th>
                            <th>流浪猫狗名</th>
                            <th>种类</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>照片</th>
                            <th>领养状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                    <div class="row">
                        <!--分页文字信息  -->
                        <div class="col-md-8" id="page_info_area"></div>
                        <!-- 分页条信息 -->
                        <div class="col-md-4" id="page_nav_area"></div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
    <!-- 班级列表查询部分  end-->
</div>
<!-- 创建流浪猫狗模态框 -->
<div class="modal fade" id="newPet" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新建流浪猫狗信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_pet_form" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="new_petName" class="col-sm-2 control-label">
                            流浪猫狗名
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="new_petName" placeholder="流浪猫狗名"
                                   name="petName">
                        </div>
                        <label for="new_petType" class="col-sm-2 control-label">
                            流浪猫狗类型
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="new_petType" placeholder="流浪猫狗类型"
                                   name="petType">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_sex" class="col-sm-2 control-label">
                            性别
                        </label>
                        <div class="col-sm-4">
                            <select class="form-control" id="new_sex" name="sex">
                                <option value="雄性">雄性</option>
                                <option value="雌性">雌性</option>
                            </select>
                        </div>
                        <label for="new_birthday" class="col-sm-2 control-label">
                            生日
                        </label>
                        <div class="col-sm-4">
                            <input type="date" class="form-control" id="new_birthday" placeholder="生日"
                                   name="birthday">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_state" class="col-sm-2 control-label">
                            领养状态
                        </label>
                        <div class="col-sm-4">
                            <select class="form-control" id="new_state" name="state">
                                <option value="0">还未被申请领养</option>
                                <option value="2">被领养</option>
                                <option value="1">被申请领养</option>
                            </select>
                        </div>
                        <label for="new_pic" class="col-sm-2 control-label">
                            照片
                        </label>
                        <div class="col-sm-1">
                            <input type="file" value="上传照片" id="new_pic" name="file">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_remark" class="col-sm-2 control-label">
                            备注
                        </label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="new_remark" placeholder="备注"
                                      name="remark"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="pet_saveDown_btn">关闭</button>
                <button type="button" class="btn btn-primary" id="pet_save_btn">提交流浪猫狗信息</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改流浪猫狗模态框 -->
<div class="modal fade" id="editPet" tabindex="-1" role="dialog" aria-labelledby="myModalLabe">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabe">修改流浪猫狗信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_pet_from" enctype="multipart/form-data">
                    <input type="hidden" id="edit_id" name="id">
                    <div class="form-group">
                        <label for="edit_petName" class="col-sm-2 control-label">
                            流浪猫狗名
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_petName" placeholder="流浪猫狗名" value="${pet.petName}"
                                   name="petName">
                        </div>
                        <label for="edit_petType" class="col-sm-2 control-label">
                            流浪猫狗类型
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="edit_petType" placeholder="流浪猫狗类型" value="${pet.petType}"
                                   name="petType">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_sex" class="col-sm-2 control-label">
                            性别
                        </label>
                        <div class="col-sm-4">
                            <select class="form-control" id="edit_sex" name="sex" value="${pet.sex}">
                                <option value="雄性">雄性</option>
                                <option value="雌性">雌性</option>
                            </select>
                        </div>
                        <label for="edit_birthday" class="col-sm-2 control-label">
                            生日
                        </label>
                        <div class="col-sm-4">
                            <input type="date" class="form-control" id="edit_birthday" placeholder="生日" value="${pet.birthday}"
                                   name="birthday">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_pic" class="col-sm-2 control-label">
                            照片
                        </label>
                        <div class="col-sm-4">
                            <input type="file" id="edit_pic" value="${pet.pic}" name="file">
                        </div>
                        <label for="edit_state" class="col-sm-2 control-label">
                            领养状态
                        </label>
                        <div class="col-sm-4">
                            <select class="form-control" id="edit_state" value="${pet.state}" name="state">
                                <option value="0">还未被申请领养</option>
                                <option value="1">正在被申请领养</option>
                                <option value="2">已经被人领养</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_remark" class="col-sm-2 control-label">
                            备注
                        </label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="edit_remark" placeholder="备注" value="${pet.remark}"
                                      name="remark"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="pet_updateDown_btn">关闭</button>
                <button type="button" class="btn btn-primary" id="pet_update_btn">保存修改</button>
            </div>
        </div>
    </div>
</div>
<!-- 引入js文件 -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/JQuery/jquery-3.4.1.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/js/houtai/js/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script src="${pageContext.request.contextPath}/js/houtai/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/houtai/js/dataTables.bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/js/houtai/js/sb-admin-2.js"></script>
<!-- 编写js代码 -->
<script type="text/javascript">


    //总的数据 当前的页面
    var totalRecord,currentPage,currentSize,currentPageSize,currentPages;

    $(function(){
        to_page(1);
    });
    function to_page(pn){
        $.ajax({
            url:"${pageContext.request.contextPath}/pet/pets.action",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                resolving(result);
            }
        });
    }
    function resolving(result){
        //1、解析并显示员工数据
        build_pets_table(result);
        //2、解析并显示分页信息
        build_page_info(result);
        //3、解析显示分页条数据
        build_page_nav(result);
    }

    //解析并显示员工数据
    function build_pets_table(result){
        //清空table表格
        $("#pet_table tbody").empty();
        //index：下标 user：单个对象
        var pets=result.extend.pageInfo.list;
        $.each(pets,function(index,pet){
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var petIdTd = $("<td></td>").append(pet.id);
            var petNameTd = $("<td></td>").append(pet.petName);
            var petTypeTd = $("<td></td>").append(pet.petType);
            var sexTd=$("<td></td>").append(pet.sex);
            var birthdayTd=$("<td></td>").append(pet.birthday);
            var picTd=$("<td></td>").append($("<img/>").addClass("mySize").attr("src","/images/"+spilt(pet.pic)));
            var stateTd=null;
            if(pet.state==0){
                stateTd=$("<td></td>").append("还未被申请领养");
            }else if(pet.state==1){
                stateTd=$("<td></td>").append("正在被申请领养");
            }else{
                stateTd=$("<td></td>").append("已经被领养");
            }

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("修改");
            //为编辑按钮添加一个自定义的属性，来表示当前员工id
            editBtn.attr("edit-id",pet.id);
            var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            //为删除按钮添加一个自定义的属性来表示当前删除的员工id
            delBtn.attr("del-id",pet.id);
            var btnTd = $("<td></td>").append(editBtn).append("").append(delBtn);
            //var delBtn =
            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(checkBoxTd)
                .append(petIdTd)
                .append(petNameTd)
                .append(petTypeTd)
                .append(sexTd)
                .append(birthdayTd)
                .append(picTd)
                .append(stateTd)
                .append(btnTd)
                .appendTo("#pet_table tbody");
        });
    }
    //解析显示分页信息
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
            result.extend.pageInfo.pages+"页,总"+
            result.extend.pageInfo.total+"条记录");
        totalRecord = result.extend.pageInfo.total;//最后的数据
        currentPage = result.extend.pageInfo.pageNum;//当前页
        var currentPages=result.extend.pageInfo.pages;//总的页数
        currentSize=result.extend.pageInfo.size;//当前页面的尺寸
        currentPageSize=result.extend.pageInfo.pageSize;//每页的尺寸
    }
    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result){
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加点击翻页的事件
            firstPageLi.click(function(){
                to_page(1);
            });
            prePageLi.click(function(){
                to_page(result.extend.pageInfo.pageNum -1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                to_page(result.extend.pageInfo.pageNum +1);
            });
            lastPageLi.click(function(){
                to_page(result.extend.pageInfo.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums,function(index,item){

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }


    //清空表单样式及内容
    function reset_form(ele){
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮弹出模态框。
    $("#pet_add_modal_btn").click(function(){
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#newPet form");
        //弹出模态框
        $("#newPet").modal({
            backdrop:"static"
        });
    });
    //点击保存，保存流浪猫狗。
    $("#pet_save_btn").click(function(){
        var pet=document.getElementById("new_pet_form");
        var petTd=new FormData(pet);
        $.ajax({
            url:"${pageContext.request.contextPath}/pet/create.action",
            type:"POST",
            processData: false,  // 告诉jQuery不要去处理发送的数据
            contentType: false, // 告诉jQuery不要去设置Content-Type请求头
            data:petTd,
            success:function (result) {
                alert("流浪猫狗创建成功");
                $("#pet_saveDown_btn").click();
                if(currentSize=currentPageSize){
                    to_page(currentPages+1);
                } else {
                    to_page(currentPages)
                }
            },
            error:function (result) {
                $("#pet_saveDown_btn").click();
                alert("流浪猫狗创建失败");
            }
        });
    });


    //点击编辑按钮弹出模态框。
    $(document).on("click",".edit_btn",function(){
        //1、发送ajax,根据id获取用户信息
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#editPet form");
        var id = $(this).attr("edit-id");
        $.ajax({
            url:"${pageContext.request.contextPath}/pet/findById.action?id="+id,
            type:"GET",
            success:function(result){
                //填充用户信息
                $("#edit_id").val(result.extend.pet.id);
                $("#edit_petName").val(result.extend.pet.petName);
                $("#edit_petType").val(result.extend.pet.petType);
                $("#edit_sex").val(result.extend.pet.sex);
                $("#edit_birthday").val(result.extend.pet.birthday);
                $("#edit_state").val(result.extend.pet.state);
                $("#edit_remark").val(result.extend.pet.remark);
            },
            error:function (result) {
                alert("通过id查询用户失败")
           }
        });
        //2、弹出模态框
        $("#editPet").modal({
            backdrop:"static"
        });

    });

    //点击更新按钮弹出模态框。
    $("#pet_update_btn").click(function(){
        var pet=document.getElementById("edit_pet_from");
        var petTd=new FormData(pet);
        $.ajax({
            url:"${pageContext.request.contextPath}/pet/update.action",
            type:"POST",
            processData: false,  // 告诉jQuery不要去处理发送的数据
            contentType: false, // 告诉jQuery不要去设置Content-Type请求头
            data:petTd,
            success:function (result) {
                to_page(currentPage);
                $("#pet_updateDown_btn").click();
                alert("流浪猫狗信息更新成功！");
            },
            error:function(result){
                alert("流浪猫狗信息更新失败！");
                $("#pet_saveDown_btn").click();
                to_page(currentPage);
            }
        });

    });

    //单个删除
    $(document).on("click",".delete_btn",function(){
        //1、弹出是否确认删除对话框
        var petName = $(this).parents("tr").find("td:eq(2)").text();
        var petId = $(this).attr("del-id");
        if(confirm("确认删除【"+petName+"】吗？")){
            //确认，发送ajax请求删除即可
            $.ajax({
                url:"${pageContext.request.contextPath}/pet/delete.action?id="+petId,
                type:"GET",
                success:function (result) {
                    if(result.code==100){
                        alert("流浪猫狗删除成功！");
                        if(currentSize==1){
                            to_page(currentPage-1);
                        } else {
                            to_page(currentPage);
                        }
                    }else{
                        alert("流浪猫狗删除失败！");
                        to_page(currentPage);
                    }
                }
            });
        }
    });

    function spilt(pics) {
        var pis=pics;
        var pt=pis.toString().split(",");
        return pt[0];
    }

    $("#pet_find_modal_btn").click(function () {
        $("#pet_table tbody").empty();
        var petType=$("#findByPetType").val();
        to_findByPetType(1,petType);
    });

    function to_findByPetType(pn,petType) {
        $.ajax({
            url:"${pageContext.request.contextPath}/pet/findByPetType.action?",
            type:"POST",
            dataType:"json",
            data:{"pn":pn,"petType":petType},
            async:"true",
            success:function (result) {
                build_pets_table(result);
                build_page_info(result);
                build_page_findByPetType(result,petType);
            },
            error:function (result) {
                alert("查询错误")
            }
        });
    }


    //解析显示分页条，点击分页要能去下一页....
    function build_page_findByPetType(result,petType){
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加点击翻页的事件
            firstPageLi.click(function(){
                to_findByPetType(1,petType);
            });
            prePageLi.click(function(){
                to_findByPetType(result.extend.pageInfo.pageNum -1,petType);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                to_findByPetType(result.extend.pageInfo.pageNum +1,petType);
            });
            lastPageLi.click(function(){
                to_findByPetType(result.extend.pageInfo.pages,petType);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums,function(index,item){

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                to_findByPetType(item,petType);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }
</script>

</body>
</html>
