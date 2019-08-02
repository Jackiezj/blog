$(function () {
    // 发送请求请求领域名称
    $.get("/field/findAll", {}, function (data) {
        var btns = '';
        for (var i = 0; i < data.length; i++) {
            var btn = '<button type="button" class="btn btn-secondary bg-success fbtn" id=f"' + data[i].fid + '">' + data[i].fname + '</button>'
            btns += btn;
        }
        btns += '<button type="button" class="btn btn-secondary bg-success"><img src="../../images/icon_img/plus-2x.png"></button>';

        $("#fieldList").html(btns);
    })

    // 默认请求id为1的field的category发送请求请求分类名称
    findAllCategory(1);
    // 点击filed时加载对应category的name
    $(".fbtn").click(function () {
        var fbtnId = $(this).attr("id");
        fbtnId = fbtnId.substring(1);
        findAllCategory(fbtnId);
    })

});

function findAllCategory(fid) {
    // 根据fid查询所有的category
    $.get("/category/findAll", {"fid": fid}, function (data) {
        var btns = '<button type="button" class="btn btn-secondary">New</button>';
        for (var i = 0; i < data.length; i++) {
            var btn = '<button type="button" class="btn btn-secondary" cid="' + data[i].cid + '">data[i].cname</button>';
        }
        btns += btn;
        $("#categoryList").html(btns);
    })

}