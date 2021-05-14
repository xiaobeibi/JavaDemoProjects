<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>投标-<%=application.getAttribute("projectName")%>
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


        <form id="form" class="form-horizontal" method="post" action="<%=basePath%>bid/createBid"
              enctype="multipart/form-data" target="upLoadCustomizationCandyFrame"
        >

            <div class="form-group">
                <label for="tenderId" class="col-sm-2 control-label">项目编号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tenderId" readonly=true name="tenderId"
                           value="${tender.tenderId}">
                </div>
            </div>
            <div class="form-group">
                <label for="createTime" class="col-sm-2 control-label">创建时间</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="createTime" readonly=true name="createTime"
                           value="${tender.createTime}">
                </div>
            </div>
            <div class="form-group">
                <label for="tenderName" class="col-sm-2 control-label">招标名称</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tenderName" readonly=true name="tenderName"
                           placeholder="招标名称"
                           value="${tender.tenderName}">
                </div>
            </div>
            <div class="form-group">
                <label for="explainContent" class="col-sm-2 control-label">招标说明</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tenderExplainContent" readonly=true
                           name="explainContent"
                           placeholder="招标说明" value="${tender.explainContent}">
                </div>
            </div>

            <!--投标设置-->

            <div class="form-group">
                <label for="explainContent" class="col-sm-2 control-label">投标说明</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="explainContent" name="explainContent"
                           placeholder="招标说明">
                </div>
            </div>
            <div class="form-group">
                <label for="pdf" class="col-sm-2 control-label">详细文件</label>

                <div class="col-sm-10">
                    <input type="file" class="form-control" id="pdf" name="pdf" placeholder="详细文件">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-warning" id="create">进行投标</button>
                </div>
            </div>
        </form>
    </div>
</div>
<iframe id="upLoadCustomizationCandyFrame" name="upLoadCustomizationCandyFrame" style="display:none;">
</iframe>
</body>

<script>


    //提交按钮,所有验证通过方可提交

    $('#create').click(function () {

        var pdf = $("#pdf").val();
        if ($("#tenderName").val() && $("#explainContent").val() && pdf) {
            if (pdf.substring(pdf.lastIndexOf(".") + 1, pdf.length).toLocaleUpperCase() === "PDF") {
                $('#form').submit();
            } else {
                MSG.showErrorMsg("仅支持PDF格式");
            }
        } else {
            MSG.showErrorMsg("信息输入不完整");
        }

    });

    var $upLoadCustomizationCandyFrame = $("#upLoadCustomizationCandyFrame");
    //表单提交后成功与否判断
    $upLoadCustomizationCandyFrame.load(function () {
        var result = "允许上传的最大文件大小为 10M";
        try {
            result = $upLoadCustomizationCandyFrame.contents().find("body").text();
        } catch (e) {
            console.log(e);
        }
        if (result.indexOf('true-') != -1) {
            MSG.showSucceedMsg("操作成功");
            window.location.href = '<%=basePath%>bid/showOneBid?bidId=' + result.split("-")[1];
        } else {
            MSG.showErrorMsg("操作失败: " + result);
        }

    });

</script>

