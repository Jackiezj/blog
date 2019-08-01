$(function () {
    $.get("/html/base/header.html",function (data) {
        $("#header").html(data);
    });
    $.get("/html/base/footer.html",function (data) {
        $("#footer").html(data);
    });
    $.get("/user/getLoginUser", function (data) {
        if (data) {
            $("#loginAndRegister").html(data.username);
            $("#loginAndRegister").attr("href", "");
        }
    })
});