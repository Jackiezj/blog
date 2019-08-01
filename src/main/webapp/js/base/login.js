$(function () {
    $("#loginForm").submit(function () {
        $.post("/user/login", this.serialize(), function (data) {
            if (data.flag) {
                // 登录成功
                location.href="/index.html";
            } else {
                // 登录失败
                $("#errorPasswordMsg").html(data.errorMsg)
            }
        })
    })
});