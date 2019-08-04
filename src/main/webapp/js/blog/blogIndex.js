$(function () {
    // 获取登录用户信息
    var user;
    $.get("/user/getLoginUser", {}, function (data) {
        if (data == "" || data == undefined) {
            alert("请先登录")
        } else {
            user = data;
        }
    });

    // 发送请求请求领域名称
    $.get("/field/findAll", {}, function (data) {
        var btns = '';
        for (var i = 0; i < data.length; i++) {
            var btn = '<button type="button" class="btn btn-secondary bg-success fbtn" id="f' + data[i].id + '">' + data[i].fname + '</button>'
            btns += btn;
        }
        btns += '<button type="button" class="btn btn-secondary bg-success" id="addField"><img src="../../images/icon_img/plus-2x.png"></button>';

        $("#fieldList").html(btns);
    });

    // 默认请求id为1的field的category发送请求请求分类名称
    findAllCategory(0);
    // 点击filed时加载对应category的name
    let currentFid;
    $(document).on("click", ".fbtn", function() {
        var fbtnId = $(this).attr("id");
        fbtnId = fbtnId.substring(1);
        currentFid = fbtnId;
        findAllCategory(fbtnId);
    });

    // 页面加载时加载文章列表
    findAllAssayListByUser();
    // 点击category时,加载文章列表
    $(document).on("click", ".cbtn", function() {
        var cbtnId = $(this).attr("id");
        cbtnId = cbtnId.substring(1);
        findAllAssayByCategory(cbtnId);
    })
    // 点击最新分类, 加载最新更新数据
    $(document).on("click", "#lasterCategoryBtn", function() {
        findAllAssayListByUser();
    });

    // 点击文章列表某个文章, 打开详情页面
    $(document).on("click", ".assaya", function () {
        // 跳转对应页面并回显数据
        var abtnId = $(this).attr("id");
        abtnId = abtnId.substring(1);
        location.href="/html/blog/blogDetail.html?aid="+abtnId;
    })

    // 点击新增文章, 添加文章
    var uid;
    $(document).on("click", "#addAssay", function () {
        $.get("/user/getLoginUser", {}, function (data) {
            if (data == "" || data == undefined) {
                alert("请先登录")
            } else {
                uid = data.id;
                location.href="/html/blog/blogAdd.html?uid="+uid;
            }
        });
    });

    // 增加领域 点击事件
    let fieldFlag = true;
    $(document).on("click", "#addField", function () {
        if (fieldFlag) {
            $("#addFieldForm").css("display", "block");
            fieldFlag = false;
        } else {
            $("#addFieldForm").css("display", "none");
            fieldFlag = true;
        }
    })
    $("#AddFieldCancel").click(function () {
        $("#addFieldForm").css("display", "none");
        fieldFlag = true;
    })
    // 增加领域 提交事件
    $("#addFieldForm").submit(function () {
        $.post("/field/addField", {"fname": $("#addFieldInput").val()}, function (data) {
            window.location.href="/"
        })
    });
    // 增加分类 点击事件
    let categoryFlag = true;
    $(document).on("click", "#addCategory", function () {
        if (categoryFlag) {
            $("#addCategoryForm").css("display", "block");
            categoryFlag = false;
        } else {
            $("#addCategoryForm").css("display", "none");
            categoryFlag = true;
        }
    })
    $("#AddCategoryCancel").click(function () {
        $("#addCategoryForm").css("display", "none");
        categoryFlag = true;
    })
    // 增加分类 提交事件
    $("#addCategoryForm").submit(function () {
        let data = {
            "cname": $("#addCategoryInput").val(),
            "fid": currentFid,
        };
        if (data.fid == "" || data.fid == undefined) {
            alert("请先点击要增加分类的领域");
        } else {
            $.post("/category/addCategory", data, function (data) {
                window.location.href="/"
            });
        }
    });

});

function findAllCategory(fid) {
    // 根据fid查询所有的category
    $.get("/category/findAll", {"fid": fid}, function (data) {
        var btns = '<button type="button" class="btn btn-secondary" id="lasterCategoryBtn">New</button>';
        for (var i = 0; i < data.length; i++) {
            var btn = '<button type="button" class="btn btn-secondary cbtn" id="c' + data[i].id + '">'+data[i].cname+'</button>';
            btns += btn;
        }
        btns += '<button type="button" class="btn btn-secondary" id="addCategory"><img src="../../images/icon_img/plus-2x.png"></button>';
        btns += '<button type="button" class="btn btn-secondary" id="addAssay">新增文章</button>';
        $("#categoryList").html(btns);
    })

}

function findAllAssayByCategory(cid) {
    $.get("/assay/findAssayListByCategory", {"cid": cid}, function (data) {
        assayListHtml(data);
    })
}

function findAllAssayListByUser() {
    $.get("/assay/findAllAssayListByUser", {}, function (data) {
        assayListHtml(data);
    });
}

function assayListHtml(data) {
    var assayList = "";
    for (var i = 0; i < data.length; i++) {
        var assay =
            '<a class="assaya" href="javascript:void(0)" style="text-decoration: none; color: #000;" id="a'+data[i].id+'">' +
            '            <br>\n' +
            '            <div class="media shadow-sm p-3 bg-white rounded">\n' +
            '                <img class="mr-3 assayListLogo" src="'+data[i].logo+'" alt="image">\n' +
            '                <div class="media-body">\n' +
            '                    <h5 class="mt-0">'+data[i].aname+'</h5>\n' +
            '                    <p>'+data[i].digest+'</p>\n' +
            '                </div>\n' +
            '            </div>' +
            '</a>';
        assayList += assay;
    }
    $("#assayList").html(assayList);
}