<%--
  Created by IntelliJ IDEA.
  User: 24255
  Date: 2019/8/22
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content=""/>
    <style type="text/css">
        #blog{
            background: url(/images/bg3.jpg)no-repeat center fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            -ms-background-size: cover;
            position: relative;
        }
        .myfont{
            font-size: 10px;
            color: red;
        }
    </style>
    <!--// Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" type="text/css" media="all">
    <!-- Owl-Carousel-CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />

</head>
<body>
<jsp:include page="navigation.jsp"></jsp:include>
<!-- blog -->
<div class="blog" id="blog" >
    <div class="container">
        <h3 class="agile-title">团队活动</h3>
        <div class="col-md-5 col-xs-6 blog-grids">


            <div class="clearfix"></div>
        </div>

    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <div class="col-md-4" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area"></div>
    </div>
    <div class="blog-grids mid-blog-agile">
        <img src="/images/cat2.png" class="img-responsive" alt="">
    </div>
</div>
<!-- Modal5 -->
<div class="modal fade" id="showTeam" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="modal-info">

                    <h4 id="edit_title"></h4>
                    <p id="edit_address"></p>
                    <p class="para-agileits-w3layouts" id="edit_event"></p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //Modal5 -->
<!-- //blog -->
<!-- js -->
<script src="${pageContext.request.contextPath}/JQuery/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- Necessary-JavaScript-File-For-Bootstrap -->
<!-- //js -->
<script type="text/javascript">
    var totalRecord,currentPage;

    $(function(){
        to_page(1);
    });
    function to_page(pn){
        $.ajax({
            url:"${pageContext.request.contextPath}/blog/blogs.action",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                //1、解析并显示员工数据
                build_blogs_table(result);

                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }


    function build_blogs_table(result){
        //清空table表格
        $(".col-md-5").empty();
        //index：下标 user：单个对象
        var blogs=result.extend.pageInfo.list;
        $.each(blogs,function(index,blog){

            var yearTd=$("<div></div>").addClass("blog-left-agileits").append($("<p></p>")).append(blog.actionTime);

            var blogTd=$("<div></div>").addClass("blog-right-agileits-w3layouts");

            var titleTd=$("<h4></h4>").append($("<a></a>")).addClass("myfont").append(blog.title);
            titleTd.attr("id","title_btn");
            titleTd.attr("title-id",blog.id);

            var peopelsTd=$("<p></p>").append($("<a></a>")).append(blog.peoples);

           blogTd.append(titleTd).append(peopelsTd);

           var clear=$("<div></div>").addClass("clearfix");
            //append方法执行完成以后还是返回原来的元素
                $("<div></div>").addClass("blog-full-wthree")
                    .append(yearTd)
                    .append(blogTd)
                    .append(clear)
                    .appendTo(".col-md-5");

        });
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

    //点击编辑按钮弹出模态框。

    $(document).on("click","#title_btn",function(){

        var id = $(this).attr("title-id");
        $.ajax({
            url:"${pageContext.request.contextPath}/blog/findById.action?id="+id,
            type:"GET",
            success:function(result){
                //填充用户信息
                $("#edit_title").text(result.extend.blog.title);
                $("#edit_address").text(result.extend.blog.address);
                $("#edit_event").text(result.extend.blog.event);

            }});
        //2、弹出模态框
        $("#showTeam").modal({
            backdrop:"static"
        });
    });
</script>
</body>
</html>
