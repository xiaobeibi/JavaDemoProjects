layui.use(['element', 'table'], function(){
    var table = layui.table,
        $ = layui.$;

    table.render({
        elem : '#majorStaList',
        page : true,//开启分页
        url : '/employment/statistic/student_major',
        cellMinWidth : 95,
        height : 'full-25',
        limit : 20,//每页条数
        limits : [10, 15, 20, 25],//可切换的每页条数
        autoSort : false,
        id : 'majorStaList',
        method: "post",
        cols : [[
            {field:'student_major', title:'学生专业', align:'center'},
            {field:'studentCount', title:'就业人数', align:'center'},
            {title:'操作', align:'center', fixed:'right', toolbar:'#statisticListOpt'}
        ]]
    });

    table.render({
        elem : '#companyStaList',
        page : true,//开启分页
        url : '/employment/statistic/company_name',
        cellMinWidth : 95,
        height : 'full-25',
        limit : 20,//每页条数
        limits : [10, 15, 20, 25],//可切换的每页条数
        autoSort : false,
        id : 'companyStaList',
        method: "post",
        cols : [[
            {field:'company_name', title:'就业单位', align:'center'},
            {field:'studentCount', title:'就业人数', align:'center'},
            {title:'操作', align:'center', fixed:'right', toolbar:'#statisticListOpt'}
        ]]
    });

    table.render({
        elem : '#classStaList',
        page : true,//开启分页
        url : '/employment/statistic/student_class',
        cellMinWidth : 95,
        height : 'full-25',
        limit : 20,//每页条数
        limits : [10, 15, 20, 25],//可切换的每页条数
        autoSort : false,
        id : 'classStaList',
        method: "post",
        cols : [[
            {field:'student_class', title:'学生班级', align:'center'},
            {field:'studentCount', title:'就业人数', align:'center'},
            {title:'操作', align:'center', fixed:'right', toolbar:'#statisticListOpt'}
        ]]
    });

    table.render({
        elem : '#stationStaList',
        page : true,//开启分页
        url : '/employment/statistic/employment_station',
        cellMinWidth : 95,
        height : 'full-25',
        limit : 20,//每页条数
        limits : [10, 15, 20, 25],//可切换的每页条数
        autoSort : false,
        id : 'stationStaList',
        method: "post",
        cols : [[
            {field:'employment_station', title:'就业岗位', align:'center'},
            {field:'studentCount', title:'就业人数', align:'center'},
            {title:'操作', align:'center', fixed:'right', toolbar:'#statisticListOpt'}
        ]]
    });
});