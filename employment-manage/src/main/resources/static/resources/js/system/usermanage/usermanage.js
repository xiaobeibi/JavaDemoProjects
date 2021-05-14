layui.use(['table', 'form', 'layer', 'jquery'],function(){
    var table = layui.table,
        $ = layui.$,
        form = layui.form;
    tableIns = table.render({
        elem : '#userList',
        page : true,//开启分页
        url : '/employment/getallusers',
        cellMinWidth : 95,
        height : 'full-25',
        limit : 20,//每页条数
        limits : [10, 15, 20, 25],//可切换的每页条数
        autoSort : false,
        id : 'userList',
        toolbar: '#usersToolBar',
        method: "post",
        cols : [[
            {field:'userId', title:'id', hide:true},
            {field:'userAccount', title:'用户帐号', align:'center'},
            {field:'userName', title:'用户姓名', align:'center', sort:true},
            {field:'userType', title:'用户身份', align:'center', templet: function (item){
                if(item.userType == '0')
                    return '管理员';
                return '普通用户';
            }},
            {title:'操作', align:'center', fixed:'right', toolbar:'#userListOpt'}
        ]]
    });

    form.on("submit(doSearch)", function(data){
        tableIns.reload({
            where: data.field,
            page: {
                curr: 1
            }
        });
        return false;
    });

    //监控表格工具条事件
    table.on("toolbar(userList)", function (obj) {
        switch (obj.event) {
            case 'userAdd':
                openAddLayer(0);
                break;
            case 'userBatchDel':
                batchDelete();
                break;
        };
    });

    //监控行工具条事件
    table.on("tool(userList)", function (obj) {
        //获取当前行数据
        var data = obj.data;
        switch (obj.event) {
            case 'userEdit':
                userEdit(data);
                break;
            case 'userDel':
                userDel(data.userId);
                break;
        };
    });

    //添加用户
    form.on("submit(userSubmitBtn)", function(data){
        var url = "/employment/adduser";
        if(data.field.userId != ""){
            url = "/employment/updateuser";
        }
        $.post(url, data.field, function(result){
            if (result.code == 0) {
                tableIns.reload();
            }
            layer.msg(result.msg);
            layer.close(mainIndex);
        });
    });

    var mainIndex;
    //弹出添加页面
    function openAddLayer(userType){
        mainIndex = layer.open({
            type: 1,
            content: $("#addOrUpdateUser"),
            area: ['800px', '550px'],
            title: '添加用户',
            success: function () {
                $("#addOrUpdateForm")[0].reset();
                //设置下拉树中父节点的值为空
                $("[name='id']").val("");
            }
        });
    }

    function userEdit(data){
        mainIndex = layer.open({
            type: 1,
            content: $("#addOrUpdateUser"),
            area: ['800px', '550px'],
            title: '编辑用户信息',
            success: function () {
                $("#addOrUpdateForm")[0].reset();
                //装载新的数据
                form.val("addOrUpdateForm",data);
            }
        });
    }

    function userDel(userId){
        layer.confirm('确定删除吗？', {icon: 3, title: '提示'}, function (index) {
            $.post('/employment/deluser/' + userId, function(result){
                if (result.code == 0) {
                    tableIns.reload();
                }
                layer.msg(result.msg);
            });
        });
    }
});