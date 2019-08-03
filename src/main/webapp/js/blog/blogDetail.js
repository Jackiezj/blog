$(function () {
    //根据URL中aid获取数据库中数据
    let url = window.location.href;
    let indexNum = url.indexOf("?");
    aid = window.location.href.substring(indexNum+5);
    // 展示文章
    var testEditormdView;
    $.get("/assay/assayDetail", {"aid": aid}, function (data) {
        let markdown = data.content;
        testEditormdView = editormd.markdownToHTML("test-editormd-view", {
            markdown: markdown,//+ "\r\n" + $("#append-test").text(),
            //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            toc: true,
            tocm: true,    // Using [TOCM]
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
            theme: (localStorage.theme) ? localStorage.theme : "dark",
            tocContainer : "#custom-toc-container",
            tocDropdown   : false
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
});
