$(function () {
    // 发送请求请求领域名称
    $.get("/field/findAll", {}, function (data) {
        var btns = '';
        for (var i = 0; i < data.length; i++) {
            var btn = '<button type="button" class="btn btn-secondary bg-success fbtn" id="f' + data[i].id + '">' + data[i].fname + '</button>'
            btns += btn;
        }
        btns += '<button type="button" class="btn btn-secondary bg-success"><img src="../../images/icon_img/plus-2x.png"></button>';

        $("#fieldList").html(btns);
    });

    // 默认请求id为1的field的category发送请求请求分类名称
    findAllCategory(0);
    // 点击filed时加载对应category的name
    $(document).on("click", ".fbtn", function() {
        var fbtnId = $(this).attr("id");
        fbtnId = fbtnId.substring(1);
        findAllCategory(fbtnId);
    });

    // 页面加载时加载文章列表
    $.get("/assay/findAssayListFirstVisit", {}, function (data) {
        var assayList = "";
        for (var i = 0; i < data.length; i++) {
            var assay =
                '            <br>\n' +
                '            <div class="media shadow-sm p-3 bg-white rounded">\n' +
                '                <img class="mr-3" src="../../images/icon_img/image-6x.png" alt="Generic placeholder image">\n' +
                '                <div class="media-body">\n' +
                '                    <h5 class="mt-0">'+data[i].aname+'</h5>\n' +
                '                    <p>'+data[i].digest+'</p>\n' +
                '                </div>\n' +
                '            </div>';
            assayList += assay;
        }
        $("#assayList").html(assayList);
    })
    // 点击category时,加载文章列表
    $(document).on("click", ".cbtn", function() {
        var cbtnId = $(this).attr("id");
        cbtnId = cbtnId.substring(1);
        findAllAssayByCategory(cbtnId);
    })

});

function findAllCategory(fid) {
    // 根据fid查询所有的category
    $.get("/category/findAll", {"fid": fid}, function (data) {
        var btns = '<button type="button" class="btn btn-secondary">New</button>';
        for (var i = 0; i < data.length; i++) {
            var btn = '<button type="button" class="btn btn-secondary cbtn" id="c' + data[i].id + '">'+data[i].cname+'</button>';
            btns += btn;
        }
        btns += '<button type="button" class="btn btn-secondary"><img src="../../images/icon_img/plus-2x.png"></button>';
        $("#categoryList").html(btns);
    })

}

function findAllAssayByCategory(cid) {
    $.get("/assay/findAssayListByCategory", {"cid": cid}, function (data) {
        var assayList = "";
        for (var i = 0; i < data.length; i++) {
            var assay =
                '            <br>\n' +
                '            <div class="media shadow-sm p-3 bg-white rounded">\n' +
                '                <img class="mr-3" src="../../images/icon_img/image-6x.png" alt="Generic placeholder image">\n' +
                '                <div class="media-body">\n' +
                '                    <h5 class="mt-0">'+data[i].aname+'</h5>\n' +
                '                    <p>'+data[i].digest+'</p>\n' +
                '                </div>\n' +
                '            </div>';
            assayList += assay;
        }
        $("#assayList").html(assayList);
    })

}