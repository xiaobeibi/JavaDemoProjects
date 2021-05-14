<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<title>首页-${applicationScope.projectName}</title>
<div class="row row-offcanvas row-offcanvas-right">

    <div class="col-xs-12 col-sm-9">
        <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
        </p>
        <div class="jumbotron">
            <h1>${applicationScope.projectName}</h1>
            <p>.</p>
        </div>
        <div class="row" style="margin-bottom: 30px;">
            <div class="row placeholders">
                <c:forEach var="candy" items="${candies}">
                    <div class="col-xs-6 col-sm-3 placeholder">
                        <a href="<%=basePath%>candy/showOne?tenderId=${candy.tenderId}" class="thumbnail">
                            <img src="<%=basePath%>candy/downImage?downImageUrl=${candy.image}" class="img-rounded"
                                 alt="未知">
                        </a>
                        <div style="margin: 5px 0px 15px;">
                            <p>${candy.tenderName}</p>
                            <span class="text-muted">类别:${candy.candyCategory.candyCategoryName}&nbsp;|&nbsp;销量:${candy.salesVolume}</span>
                        </div>
                    </div>
                </c:forEach>
            </div><!--/row-->
        </div>
        <!--/.col-xs-12.col-sm-9-->
    </div>
    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
    </div>
    <!--/.sidebar-offcanvas-->

</div>
