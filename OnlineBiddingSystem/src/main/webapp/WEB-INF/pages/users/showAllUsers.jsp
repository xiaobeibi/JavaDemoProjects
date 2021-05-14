<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>服务商管理-${applicationScope.projectName}</title>
    <jsp:include page="../public/datatables-bootstrap-js-css.jsp"/>
</head>
<body>

<div>
    <%--<button style="float: right;margin-bottom: 10px;" type="button" class="btn btn-info"
            onclick="window.location.href='<%=basePath%>pages/users/goCreateUsersIndexPage'"
    >新建用户
    </button>--%>

    <table id="showTable" class="table table-striped" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>服务商名</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>地址</th>
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
            {"data": "userName"},
            {"data": "phone"},
            {"data": "email"},
            {"data": "userId"}
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
                    return "<button  type=\"button\" class=\"btn btn-warning btn-xs\" " +
                            "onclick=\"window.location.href ='<%=basePath%>users/goUpdateUsersIndexPage?usersId=" + data + "'\">修改</button>" +
                            "&nbsp;&nbsp;<button type=\"button\" class=\"btn btn-danger btn-xs js-del\" usersId=" + data + ">删除</button>";
                },
                "orderable": false,
                "targets": 3
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
                var usersId = $2.attr("usersId");
                $2.parent().parent().addClass("js-del-tr");
                $.ajax({
                    type: "POST",
                    url: "<%=basePath%>" + "users/deleteUser",
                    data: {
                        "usersId": usersId
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

        /**
         * 获取所有用户数据展示
         */
        $.ajax({
            type: "POST",
            url: "<%=basePath%>" + "users/searchUsers",
            data: {},
            dataType: "json",
            success: function (data) {
                console.log(data);
                dataTableSetting.data = data.data;
                table = $showTable.DataTable(dataTableSetting);
                delRegister();
            }
        });

    });

</script>
