layui.use(['table', 'form', 'layer', 'laydate', 'jquery'],function(){
    var table = layui.table,
        laydate = layui.laydate,
        $ = layui.$,
        form = layui.form;

    var tableCols = [
        {field:'informationId', title:'id', hide:true},
        {field:'companyName', title:'就业单位', align:'center'},
        {field:'companyAddress', title:'就业单位地址', align:'center'},
        {field:'employmentStation', title:'就业岗位', align:'center'},
        {field:'treatment', title:'待遇', align:'center'},
        {field:'abilityRequirement', title:'能力要求', align:'center'},
        {field:'studentName', title:'学生姓名', align:'center'},
        {field:'studentMajor', title:'学生专业', align:'center'},
        {field:'studentGender', title:'学生性别', align:'center'},
        {field:'studentClass', title:'学生班级', align:'center'},
        {field:'studentMobile', title:'学生电话', align:'center'},
        {field:'employmentTime', title:'就业时间', align:'center'},
        {field:'companyContactName', title:'单位联系人', align:'center'},
        {field:'companyContactMobile', title:'单位联系人电话', align:'center'}
    ];
    var userType = window.sessionStorage.getItem("userType");
    if(0 == userType){
        tableCols.push({title:'操作', align:'center', fixed:'right', toolbar:'#infoListOpt'});
    }

    tableIns = table.render({
        elem : '#infoList',
        page : true,//开启分页
        url : '/employment/getallinfo',
        cellMinWidth : 95,
        height : 'full-25',
        limit : 20,//每页条数
        limits : [10, 15, 20, 25],//可切换的每页条数
        autoSort : false,
        id : 'infoListTable',
        toolbar: '#infoToolBar',
        method: "post",
        cols : [tableCols]
    });

    //监控表格工具条事件
    table.on("toolbar(infoList)", function (obj) {
        switch (obj.event) {
            case 'infoAdd':
                openAddLayer(0);
                break;
            case 'infoBatchDel':
                batchDelete();
                break;
        };
    });

    //监控行工具条事件
    table.on("tool(infoList)", function (obj) {
        //获取当前行数据
        var data = obj.data;
        switch (obj.event) {
            case 'infoEdit':
                infoEdit(data);
                break;
            case 'infoDel':
                infoDel(data.informationId);
                break;
        };
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

    //添加
    form.on("submit(infoSubmitBtn)", function(data){
        var url = "/employment/addinfo";
        if(data.field.informationId != ""){
            url = "/employment/updateinfo";
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
    function openAddLayer(){
        laydate.render({
            elem: '[name="employmentTime"]',
            trigger: 'click'
        });
        mainIndex = layer.open({
            type: 1,
            content: $("#addOrUpdateinfo"),
            area: ['900px', '600px'],
            title: '添加就业信息',
            success: function () {
                $("#addOrUpdateForm")[0].reset();
                //设置下拉树中父节点的值为空
                $("[name='informationId']").val("");
            }
        });
    }

    function infoEdit(data){
        laydate.render({
            elem: '[name="employmentTime"]',
            trigger: 'click'
        });
        mainIndex = layer.open({
            type: 1,
            content: $("#addOrUpdateinfo"),
            area: ['900px', '600px'],
            title: '编辑就业信息',
            success: function () {
                $("#addOrUpdateForm")[0].reset();
                //装载新的数据
                form.val("addOrUpdateForm",data);
            }
        });
    }

    function infoDel(infoId){
        layer.confirm('确定删除吗？', {icon: 3, title: '提示'}, function (index) {
            $.post('/employment/delinfo/' + infoId, function(result){
                if (result.code == 0) {
                    tableIns.reload();
                }
                layer.msg(result.msg);
            });
        });
    }
});