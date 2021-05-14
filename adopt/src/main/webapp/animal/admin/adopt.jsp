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
    <!-- 领养表列表查询部分  start-->
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">猫狗领养申请的审核</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="panel panel-default">
            <!-- 搜索部分 -->
            <div class="panel-body">
                <form class="form-inline" method="get" action="">
                    <div class="form-group">
                        <label for="findByAdoptTime">领养的时间</label>
                        <input type="date" class="form-control" id="findByAdoptTime" value="" name="adoptTime">
                    </div>
                    <button type="button" class="btn btn-primary" id="adopt_find_modal_btn">查询</button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">申请信息列表</div>
                    <!-- /.panel-heading -->
                    <table class="table table-bordered table-striped" id="adopt_table">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" id="check_all"/>
                            </th>
                            <th>编号</th>
                            <th>用户名称</th>
                            <th>流浪猫狗名字</th>
                            <th>申请时间</th>
                            <th>状态</th>
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

<!-- 引入js文件 -->
<!-- jQuery -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/JQuery/jquery-3.4.1.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<!-- 编写js代码 -->
<script type="text/javascript">

    //总的数据 当前的页面

    var totalRecord,currentPage,currentSize,currentPageSize;

    $(function(){
        to_page(1);
    });
    function to_page(pn){
        $.ajax({
            url:"${pageContext.request.contextPath}/adopt/adopts.action",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                resolving(result);
            }
        });
    }

    function resolving(result){
        //1、解析并显示员工数据
        build_adopts_table(result);
        //2、解析并显示分页信息
        build_page_info(result);
        //3、解析显示分页条数据
        build_page_nav(result);
    }
    function build_adopts_table(result){
        //清空table表格
        $("#adopt_table tbody").empty();
        //index：下标 user：单个对象
        var adopts=result.extend.pageInfo.list;
        $.each(adopts,function(index,adopt){
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var adoptIdTd = $("<td></td>").append(adopt.id);
            var userNameTd = $("<td></td>").append(adopt.user.userName);
            var petNameTd = $("<td></td>").append(adopt.pet.petName);
            var adoptTimeTd=$("<td></td>").append(adopt.adoptTime);
            var stateTd=$("<td></td>").append("还在审核");

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm agree_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("同意");
            //为编辑按钮添加一个自定义的属性，来表示当前员工id
            editBtn.attr("agree-id",adopt.id);
            var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm disagree_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("不同意");
            //为删除按钮添加一个自定义的属性来表示当前删除的员工id
            delBtn.attr("disagree-id",adopt.id);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            //var delBtn =
            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(checkBoxTd)
                .append(adoptIdTd)
                .append(userNameTd)
                .append(petNameTd)
                .append(adoptTimeTd)
                .append(stateTd)
                .append(btnTd)
                .appendTo("#adopt_table tbody");
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

    $(document).on("click",".agree_btn",function(){
        var id=$(this).attr("agree-id");
        if(confirm("确认同意吗？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/adopt/agree.action?id="+id,
                type:"GET",
                success:function (result) {
                    alert("审核成功");
                    to_page(currentPage);
                },
                error:function (result) {
                    alert("审核失败");
                    to_page(currentPage);
                }
            })
        }

    });
    $(document).on("click",".disagree_btn",function(){
        var id=$(this).attr("disagree-id");
        console.log(id);
        if(confirm("确认不同意吗？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/adopt/disAgree.action?id="+id,
                type:"GET",
                success:function (result) {
                    alert("审核成功");
                    to_page(currentPage);
                },
                error:function (result) {
                    alert("审核失败");
                    to_page(currentPage);
                }
            })
        }

    })


    $("#adopt_find_modal_btn").click(function () {
        $("#adopt_table tbody").empty();
        var adoptTime=$("#findByAdoptTime").val();
        $.ajax({
            url:"${pageContext.request.contextPath}/adopt/findByAdoptTime.action?adoptTime="+adoptTime,
            type:"Get",
            async:"true",
            success:function (result) {
                resolving(result);
            },
            error:function (result) {
                alert("查询错误")
            }
        });
    });
</script>

</body></html>