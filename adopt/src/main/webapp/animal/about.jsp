<%--
  Created by IntelliJ IDEA.
  User: 24255
  Date: 2019/8/22
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content=""/>


    <!-- css files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" type="text/css" media="all">
    <!-- Owl-Carousel-CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
    <link href='${pageContext.request.contextPath}/css/simplelightbox.min.css' rel='stylesheet' type='text/css'>
</head>
<body>
<jsp:include page="navigation.jsp"></jsp:include>
<!-- welcome -->
<div class="about" id="about">
    <div class="container">
        <h3 class="agile-title">欢迎</h3>
        <div class="about-top w3ls-agile">
            <div class="col-md-6 red">
                <img class="img-responsive" src="/images/ab.jpg" alt="">
            </div>
            <div class="col-md-6 come">
                <div class="about-wel">
                    <h5>几句话关于我们的
                        <span>流浪猫狗救助</span>
                    </h5>
                    <p>面对这样可爱的猫和狗谁能不喜爱呢？
                        伤心时，它总是在我身边陪伴着我；
                        开心时，我总会和他一起分享，它成了和我不形影不离的好朋友。</p>
                    <ul>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的健康和关怀</li>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的美容</li>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的食物</li>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的行为</li>
                    </ul>
                </div>
                <div class="button-styles">
                    <a href="#cat" data-toggle="modal" data-target="#Catbtn">养狗注意的地方</a>
                    <a href="#dog" data-toggle="modal" data-target="#Dogbtn">养猫注意的地方</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Gallery -->
<div id="gallery" class="gallery">
    <div class="container">
        <h3 class="agile-title">Gallery</h3>
    </div>
    <div class="agileinfo-gallery-row">
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/m1.jpg" class="imghvr-hinge-right figure">
                <img src="/images/m1.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/g2.jpg" class="imghvr-hinge-right figure">
                <img src="/images/g2.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/g3.jpg" class="imghvr-hinge-right figure">
                <img src="/images/g3.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/m4.jpg" class="imghvr-hinge-right figure">
                <img src="/images/m4.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/m5.jpg" class="imghvr-hinge-right figure">
                <img src="/images/m5.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/m6.jpg" class="imghvr-hinge-right figure">
                <img src="/images/m6.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/m3.jpg" class="imghvr-hinge-right figure">
                <img src="/images/m3.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/images/m2.jpg" class="imghvr-hinge-right figure">
                <img src="/images/m2.jpg" alt="" title="Cat Life Image" />
            </a>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- Modal5 -->
<div class="modal fade" id="Catbtn" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="modal-info">
                    <h4>Dog Life</h4>
                    <img src="${pageContext.request.contextPath}/images/2.jpg" alt=" " class="img-responsive" />
                    <p class="para-agileits-w3layouts">
                        喂食的时间要准，尽量按照在原主人家的习惯喂养，不要喂它们过多的甜食、咸食和刺激性强的食品。
                        刚来的宝宝，主人要亲自喂食，时日积久，便能和爱犬建立起深厚的感情，加深相互信任的程度，
                        主人的另一个重要任务是要帮助小家伙克服离开母亲的痛苦，尽快适应新环境。
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal5 -->
<div class="modal fade" id="Dogbtn" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="modal-info">
                    <h4>Cat Life</h4>
                    <img src="${pageContext.request.contextPath}/images/1.jpg" alt=" " class="img-responsive" />
                    <p class="para-agileits-w3layouts">
                        我们不能一直将小猫放在家里面养，我们需要时不时的将小猫带出去溜溜,然后，我们在养小猫的时候，还需要多陪小猫玩耍。
                        我们在养小猫的时候，还需要多打理打理它的毛发。
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //Gallery -->
<!-- js -->
<script src="${pageContext.request.contextPath}/JQuery/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- Necessary-JavaScript-File-For-Bootstrap -->
<!-- //js -->

<!-- simple-lightbox -->
<script src="${pageContext.request.contextPath}/js/simple-lightbox.min.js"></script>
<script>
    $(function () {
        var gallery = $('.agileinfo-gallery-row a').simpleLightbox({
            navText: ['&lsaquo;', '&rsaquo;']
        });
    });
</script>


<!-- Light-box css -->
<!-- //simple-lightbox -->

</body>
</html>
