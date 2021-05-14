layui.use('jquery', function(){
    var $ = layui.$;
    var userType = window.sessionStorage.getItem("userType");
    var userName = window.sessionStorage.getItem("userName");
    if(0 != userType){
        $('.user-manage-item').remove();
    }
    $('.user-name').text(userName);
    $('.logout-btn').on('click', function(){
        window.sessionStorage.clear();
        location.href="/employment";
    });
});