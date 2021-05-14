layui.use(['form', 'layer', 'jquery'], function(){
    var form = layui.form,
        $ = layui.$;

    //登录验证
    form.on("submit(formLogin)", function(data){
        $.post("/employment/login", data.field, function(result){
            if(result.code == 500){
                alert("用户名或密码错误");
            }else{
                window.sessionStorage.setItem("userId", result.data.userId);
                window.sessionStorage.setItem("userAccount", result.data.userAccount);
                window.sessionStorage.setItem("userName", result.data.userName);
                window.sessionStorage.setItem("userType", result.data.userType);
                location.href = "/employment/employmentinfo";
            }
        }, "json");
    });
});