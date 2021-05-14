<%--
  Created by IntelliJ IDEA.
  User: 24255
  Date: 2019/8/22
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <!-- 班级列表查询部分  start-->
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">用户活动管理</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="panel panel-default">
            <!-- 搜索部分 -->
            <div class="panel-body">
                <form class="form-inline" method="get" action="">
                    <div class="form-group">
                        <label for="findByTime">活动事件</label>
                        <input type="date" class="form-control" id="findByTime" value="" name="actionTime">
                    </div>
                    <button type="button" class="btn btn-primary" id="blog_find_modal_btn">查询</button>
                </form>
            </div>
        </div>
        <button class="btn btn-primary" id="blog_add_modal_btn">新增</button>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">活动列表</div>
                    <!-- /.panel-heading -->
                    <table class="table table-bordered table-striped" id="blog_table">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" id="check_all"/>
                            </th>
                            <th>编号</th>
                            <th>活动事件</th>
                            <th>活动地点</th>
                            <th>活动人物</th>
                            <th>活动描述</th>
                            <th>标题</th>
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
                            <div class="col-md-4" id="page_nav_area">

                            </div>
                        </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
    <!-- 用户查询  end-->
</div>
<!-- 创建用户模态框 id newUser form users-->
<div class="modal fade" id="newBlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新建团队活动信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_blog_form">
                    <div class="form-group">
                        <label for="new_title" class="col-sm-2 control-label">
                            活动标题
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_title" placeholder="标题" name="title">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="new_actionTime" class="col-sm-2 control-label">
                            活动时间
                        </label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="new_actionTime" placeholder="活动时间" name="actionTime">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_address" class="col-sm-2 control-label">
                            活动地点
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_address" placeholder="活动地点" name="address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_peoples" class="col-sm-2 control-label">
                            活动人物
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_peoples" placeholder="活动人物" name="peoples">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_event" class="col-sm-2 control-label">
                            活动介绍
                        </label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="new_event" placeholder="活动介绍"  name="event"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="blog_saveDown_btn">关闭</button>
                <button type="button" class="btn btn-primary" id="blog_save_btn">提交</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改班级模态框 -->
<div class="modal fade" id="editBlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabe">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabe">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_blog_form">
                    <input type="hidden" id="edit_id" name="id">
                    <div class="form-group">
                        <label for="edit_title" class="col-sm-2 control-label">
                            活动标题
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_title" placeholder="标题" value="${blog.title}" name="title">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit_actionTime" class="col-sm-2 control-label">
                            活动时间
                        </label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="edit_actionTime" placeholder="用户名称" value="${blog.actionTime}" name="actionTime">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_address" class="col-sm-2 control-label">
                            活动地点
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_address" placeholder="活动地点" value="${blog.address}" name="address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_peoples" class="col-sm-2 control-label">
                            活动人物
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_peoples" placeholder="活动人物" value="${blog.peoples}" name="peoples">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_event" class="col-sm-2 control-label">
                            活动介绍
                        </label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="edit_event" placeholder="活动介绍" value="${blog.event}"  name="event"></textarea>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="blog_updateDown_btn">关闭</button>
                <button type="button" class="btn btn-primary" id="blog_edit_btn">保存修改</button>
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
            url:"${pageContext.request.contextPath}/blog/blogs.action",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                resolving(result);
            }
        });
    }

    function resolving(result){
        //1、解析并显示员工数据
        build_blogs_table(result);
        //2、解析并显示分页信息
        build_page_info(result);
        //3、解析显示分页条数据
        build_page_nav(result);
    }
    function build_blogs_table(result){
        //清空table表格
        $("#blog_table tbody").empty();
        //index：下标 user：单个对象
        var blogs=result.extend.pageInfo.list;
        $.each(blogs,function(index,blog){
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");

            var blogIdTd = $("<td></td>").append(blog.id);
            var titleTd=$("<td></td>").append(blog.title);
            var actionTimed = $("<td></td>").append(blog.actionTime);
            var addressTd = $("<td></td>").append(blog.address);
            var peoplesTd=$("<td></td>").append(blog.peoples);
            var eventTd=$("<td></td>").append(blog.event);

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("修改");
            //为编辑按钮添加一个自定义的属性，来表示当前员工id
            editBtn.attr("edit-id",blog.id);
            var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            //为删除按钮添加一个自定义的属性来表示当前删除的员工id
            delBtn.attr("del-id",blog.id);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            //var delBtn =
            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(checkBoxTd)
                .append(blogIdTd)
                .append(titleTd)
                .append(actionTimed)
                .append(addressTd)
                .append(peoplesTd)
                .append(eventTd)

                .append(btnTd)
                .appendTo("#blog_table tbody");
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
    $("#blog_add_modal_btn").click(function(){
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#newBlog form");
        //弹出模态框
        $("#newBlog").modal({
            backdrop:"static"
        });
    });
    //点击保存，保存员工。
    $("#blog_save_btn").click(function(){
        //2、发送ajax请求保存员工
        $.ajax({
            url:"${pageContext.request.contextPath}/blog/create.action",
            type:"POST",
            data:$("#newBlog form").serialize(),
            success:function (result) {
                alert("活动添加成功");
                $("#blog_saveDown_btn").click();
                if(currentSize=currentPageSize){
                    to_page(currentPages+1);
                } else {
                    to_page(currentPages)
                }
            },
            error:function (result) {
                console.log(result);
                alert("活动添加失败");

            }
        });
    });


    //点击编辑按钮弹出模态框。
    $(document).on("click",".edit_btn",function(){
        //1、发送ajax,根据id获取用户信息
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#editBlog form");
        var id = $(this).attr("edit-id");
        $.ajax({
            url:"${pageContext.request.contextPath}/blog/findById.action?id="+id,
            type:"GET",
            success:function(result){
                //填充用户信息
                console.log(result);

                $("#edit_id").val(result.extend.blog.id);
                $("#edit_actionTime").val(result.extend.blog.actionTime);
                $("#edit_address").val(result.extend.blog.address);
                $("#edit_peoples").val(result.extend.blog.peoples)
                $("#edit_event").val(result.extend.blog.event);
                $("#edit_title").val(result.extend.blog.title);

            }});
        //2、弹出模态框
        $("#editBlog").modal({
            backdrop:"static"
        });

    });

    //点击更新按钮弹出模态框。
    $("#blog_edit_btn").click(function(){
        $.ajax({
            url:"${pageContext.request.contextPath}/blog/update.action",
            type:"POST",
            data:$("#edit_blog_form").serialize(),
            success:function (result) {
                alert("活动信息更新成功！");
                $("#blog_updateDown_btn").click();
                to_page(currentPage);
            },
            error:function(result){
                alert("活动信息更新失败！");
                to_page(currentPage);
            }
        });

    });

    //单个删除
    $(document).on("click",".delete_btn",function(){
        //1、弹出是否确认删除对话框
        var  title= $(this).parents("tr").find("td:eq(1)").text();
        var id = $(this).attr("del-id");

        if(confirm("确认删除【"+title+"】吗？")){
            //确认，发送ajax请求删除即可
            $.ajax({
                url:"${pageContext.request.contextPath}/blog/delete.action?id="+id,
                type:"GET",
                success:function (result) {
                        alert("活动删除成功！");
                    if(currentSize==1){
                        to_page(currentPage-1);
                    } else {
                        to_page(currentPage);
                    }
                },
                error:function (result) {
                    alert("活动删除失败");
                    to_page(currentPage);
                }
            });
        }
    });


    $("#blog_find_modal_btn").click(function () {
        $("#blog_table tbody").empty();
        var actionTime=$("#findByTime").val();
        to_findByTime(1,actionTime);

    });

    function to_findByTime(pn,actionTime) {
        $.ajax({
            url:"${pageContext.request.contextPath}/blog/findByTime.action?",
            type:"POST",
            dataType:"json",
            data:{"pn":pn,"actionTime":actionTime},
            async:"true",
            success:function (result) {
                build_blogs_table(result);
                build_page_info(result);
                build_page_findByTime(result,actionTime);
            },
            error:function (result) {
                alert("查询错误")
            }
        });
    }

    //解析显示分页条，点击分页要能去下一页....
    function build_page_findByTime(result,actionTime){
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
                to_findByTime(1,actionTime);
            });
            prePageLi.click(function(){
                to_findByTime(result.extend.pageInfo.pageNum -1,actionTime);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                to_findByTime(result.extend.pageInfo.pageNum +1,actionTime);
            });
            lastPageLi.click(function(){
                to_findByTime(result.extend.pageInfo.pages,actionTime);
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
                to_findByTime(item,actionTime);
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

</body></html>
