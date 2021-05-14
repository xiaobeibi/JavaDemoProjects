<%--
  Created by IntelliJ IDEA.
  User: 24255
  Date: 2019/8/22
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>具体动物信息的展示</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content=""/>
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!--// Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" type="text/css" media="all">
    <!-- Owl-Carousel-CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />

</head>
<body>
<jsp:include page="navigation.jsp"></jsp:include>
<!-- services -->

<div class="services" id="services">
    <div class="container">
        <h3 class="agile-title">领养中心</h3>
        <div class="w3_agile_services_grids">

        </div>
    </div>

    <div class="w3l-img-side">
        <img src="/images/cat11.png" alt="" />
    </div>
    <div class="w3l-img-side w3l-img-side2">
        <img src="/images/cat1.png" alt="" />
    </div>
</div>
<div class="row">
    <!-- 分页条信息 -->
    <div class="col-md-5" id="page_info_area"></div>
    <div class="col-md-4 myPage" id="page_nav_area"></div>
</div>


<!-- //services -->
<!-- js -->
<script src="${pageContext.request.contextPath}/JQuery/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<!-- Necessary-JavaScript-File-For-Bootstrap -->
<!-- //js -->

<!-- start-smooth-scrolling 上去-->
<script src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script src="${pageContext.request.contextPath}/js/easing.js"></script>
<script>
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();

            $('html,body').animate({
                scrollTop: $(this.hash).offset().top
            }, 1000);
        });
    });
</script>
<!-- //end-smooth-scrolling -->

<!-- smooth-scrolling-of-move-up 这是service.html页面反到底层上去的功能 -->
<script>
    $(document).ready(function () {
        $().UItoTop({
            easingType: 'easeOutQuart'
        });

    });
</script>
<!-- //smooth-scrolling-of-move-up -->
<script type="text/javascript">
    //总的数据 当前的页面

    var totalRecord,currentPage;

    $(function(){
        to_page(1);
    });
    function to_page(pn){
        $.ajax({
            url:"${pageContext.request.contextPath}/pet/petState.action",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                console.log(result);
                //1、解析并显示员工数据
                build_pets_table(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }

    function build_pets_table(result){
        //清空table表格
        $(".w3_agile_services_grids").empty();
        //index：下标 user：单个对象
        var pets=result.extend.pageInfo.list;
        $.each(pets,function(index,pet){
            var divTd=$("<div></div>").addClass("ih-item circle effect1 agile_services_grid");
            var headTd=$("<div></div>").addClass("spinner");
            var imgTd=$("<div></div>").addClass("img").append($("<img/>").addClass("img-responsive").attr("src","/images/"+spilt(pet.pic)).attr("pet-id",pet.id));
            // imgTd.attr("pet-id",pet.id);
            /*$(".img-responsive").attr("pet-id",pet.id);*/
            divTd.append(headTd);
            divTd.append(imgTd);
            var fileTd=$("<fieldset></fieldset>");
            var animalTd=$("<legend></legend>").append(pet.petName);
            fileTd.append(animalTd).append(pet.remark);

            $("<div></div>").addClass("col-md-4 col-sm-4 col-xs-4 w3_agile_services_grid").attr("data-aos","zoom-in")
                .append(divTd)
                .append(fileTd)
                .appendTo(".w3_agile_services_grids");
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

    $(document).on("click",".img-responsive",function(){
        var id = $(this).attr("pet-id");
        console.log($(this));
        console.log(id);
        $.ajax({
            url:"${pageContext.request.contextPath}/pet/findByPet.action?id="+id,
            type:"GET",
            success:function (result) {
                window.location.href="${pageContext.request.contextPath}/animal/show.jsp";
            },
            error:function (result) {
                alert("跳转查询失败")
            }

        })
    })

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
                to_page(1);
            },
            error:function (result) {
                console.log(result);
                alert("流浪猫狗创建失败");
            }
        });
    });

    function spilt(pics) {
        var pis=pics;
        var pt=pis.toString().split(",");
        return pt[0];
    }
</script>

</body>

</html>