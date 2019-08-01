$(function () {
    // 发送请求请求领域名称
    $.get("/field/findAll", {}, function (data) {
        var btns = '';
        for (var i = 0; i < data.length; i++) {
            var btn = '<button type="button" class="btn btn-secondary bg-success ">'+data[i].fname+'</button>'
            btns += btn;
        }
        btns += '<button type="button" class="btn btn-secondary bg-success"><img src="../../images/icon_img/plus-2x.png"></button>';

        $("#fieldList").html(btns)
    })

});