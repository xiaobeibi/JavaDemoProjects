<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>招标公示-${applicationScope.projectName}</title>
    <jsp:include page="../public/datatables-bootstrap-js-css.jsp"/>
</head>
<body>
<select id="state" class="form-control" style="width: 300px;margin-bottom: 10px;">
    <option value="0">所有</option>
    <option value="WaitForAudit">等待审核</option>
    <option value="Bid">中标</option>
    <option value="NotWinning">未中标</option>
</select>
<div>
    <table id="showTable" class="table table-striped" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>项目编号</th>
            <th>招标名称</th>
            <th>投标服务商</th>
            <th>投标状态</th>
            <th>投标说明</th>
            <th>投标时间</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>

<script>

    var $showTable = $("#showTable");
    var table;

    var dataTableSetting = {

        "language": {
            "sProcessing": "处理中...",
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "查无数据",
            "info": "_PAGE_ / _PAGES_",
            "infoEmpty": "暂无数据",
            "infoFiltered": "(过滤总数 _MAX_ 条)",
            "search": "检索",
            "sLoadingRecords": "载入中...",
            "oPaginate": {
                "sNext": ">",
                "sPrevious": "<"
            }
        },
        "columns": [
            {"data": "bidId"},
            {"data": "tender.tenderName"},
            {"data": "users.userName"},
            {"data": "stateChina"},
            {"data": "explainContent"},
            {"data": "createTime"},
            {"data": "bidId"}
        ],
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 0
            },
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 1
            },
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 2
            },
            {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 3
            }, {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 4
            }, {
                "render": function (data, type, row) {
                    return data;
                },
                "targets": 5
            },
            {
                "render": function (data, type, row) {
                    return "<button  type=\"button\" class=\"btn btn-warning btn-xs\" " +
                            "onclick=\"window.open('<%=basePath%>bid/showOneBid?bidId=" + data + "')\">查看</button>&nbsp;&nbsp;"
                            <c:if test="${sessionScope.get('isAdmin') != null}">
                            + "<button  type=\"button\" class=\"btn btn-warning btn-xs\" " +
                            "onclick=\"window.open('<%=basePath%>bid/goUpdatePage?bidId=" + data + "')\">修改</button>" +
                            "&nbsp;&nbsp;<button type=\"button\" class=\"btn btn-danger btn-xs js-del\" bidId=" + data + ">删除</button>"
                            </c:if>
                            ;
                },
                "orderable": false,
                "targets": 6
            }
        ]
    };


    $(function () {

        /**
         * 注册删除事件
         */
        var delRegister = function () {
            $showTable.find(" tbody").on('click', 'tr .js-del', function () {
                var $2 = $(this);
                var tenderId = $2.attr("bidId");
                $2.parent().parent().addClass("js-del-tr");
                $.ajax({
                    type: "POST",
                    url: "<%=basePath%>" + "bid/delete",
                    data: {
                        "tenderId": tenderId
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.success) {
                            table.row(".js-del-tr").remove().draw(false);
                            alert("删除成功！")
                        } else {
                            MSG.showErrorMsg(data.data);
                        }
                    }
                });

            });
        };


        dataTableSetting.data = eval('${tenders}');
        table = $showTable.DataTable(dataTableSetting);
        delRegister();

        var settingState = '${state}';
        if (settingState) {
            $("#state").val(settingState);
        } else {
            $("#state").val("0");
        }
        $("#state").on("change", function () {
            var state = $(this).val();
            window.location.href = "<%=basePath%>" + "bid/goIndexPage?state=" + state;
        });
    });

</script>
