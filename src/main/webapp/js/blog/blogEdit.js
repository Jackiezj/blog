$(function () {
    // 点击编辑按钮编辑该文章
    let url = window.location.href;
    let indexNum = url.indexOf("?");
    aid = window.location.href.substring(indexNum + 5);
    $("#edit-assay").click(function () {
        location.href = "/html/blog/blogEdit.html?aid=" + aid;
    });

    //根据URL中aid获取数据库中数据, 展示文章
    var testEditormdView;
    var assayData;  // assay的所有信息
    $.get("/assay/assayDetail", {"aid": aid}, function (data) {
        assayData = data;
        $("#aname").attr("value", data.aname);
        $("#digest").attr("value", data.digest);
        let markdown = data.content;
        testEditormdView = editormd("test-editormd-view", {
            width   : "100%",
            height  : 1270,
            syncScrolling : "single",
            path    : "/lib/editor/lib/",

            markdown: markdown,//+ "\r\n" + $("#append-test").text(),
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            toc: true,
            tocm: true,    // Using [TOCM]
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
            theme: (localStorage.theme) ? localStorage.theme : "dark",
            tocContainer: "#custom-toc-container",
            tocDropdown: false
        });
    });

    // 关闭和打开目录
    let times = 0;
    $('#show-table').click(function (e) {
        e.preventDefault();
        if (times === 0) {
            $(this).css('left', '260px');
            $("#edit-assay").css('left', '260px');
            $('#sidebar').css('display', 'block');
            $('#show-table p').html('关闭目录');
            times = 1;
        } else {
            $(this).css('left', '0');
            $("#edit-assay").css('left', '0');
            $('#sidebar').css('display', 'none');
            $('#show-table p').html('打开目录');
            times = 0;
        }
    });

    // 对Assay所有信息"assayData"修改后定时保存
    let date = new Date();
    let saveInterval = setInterval(function () {
        assayData.updateTime = date.getTime();
        assayData.aname = $("#aname").val();
        assayData.digest = $("#digest").val();
        assayData.content = $("#content").val();

        $.post("/assay/assaySave", assayData, function () {
        })
    }, 3000);

    // edit页面关闭后取消定时保存
    window.onunload = function (event) {
        saveInterval.clearInterval();
    }
});