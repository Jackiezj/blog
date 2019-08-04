$(function () {
    // 获取路径中的uid
    let url = window.location.href;
    let indexNum = url.indexOf("?");
    let uid = window.location.href.substring(indexNum + 5);

    // 根据uid获取二级联动加载field和category
    $.get("/field/findAll", {}, function (data) {
        for(var i = 0; i < data.length; i++) {
            let el = '<option value="'+data[i]["id"]+'">'+data[i]["fname"]+'</option>';
            $("#field").append(el);
        }
    });
    $("#field").change(function () {
        //自动循环删除之前的数据
        $("#category option:gt(0)").remove();
        // 获取选中的filed的val
        if($(this).val()>0){
            $.get("/category/findAll", {"fid": $(this).val()}, function(data){
                $(data).each(function(index,e) {
                    $("#category").append("<option value='"+data[index].id+"'>"+data[index].cname+"</option>");
                });
            });
        }
    });

    // 发布文章按钮点击事件
    $("#addAssay").click(function () {
        addAssay(uid);
    });


    //编辑器
    var testEditormdView = editormd("test-editormd-view", {
        width   : "100%",
        height  : 1270,
        syncScrolling : "single",
        path    : "/lib/editor/lib/",
        markdown: "# hello",//+ "\r\n" + $("#append-test").text(),
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

function addAssay(uid) {
    data = {
        "aname": $("#aname").val(),
        "digest": $("#digest").val(),
        "content": $("#content").val(),
        "cid": $("#category").val(),
        "uid": uid,
        "logo": $("#logo").val(),
    };
    let flag = true;
    $.each(data, function (key, value) {
        if (data[key] == "" || data[key] == "-1" || data[key] == undefined) {
            switch (key) {
                case "aname":
                    alert("文章标题不能为空")
                    break;
                case "digest":
                    alert("文章摘要不能为空")
                    break;
                case "cid":
                    alert("分类不能为空")
                    break;
                case "logo":
                    alert("文章logo不能为空")
                    break;
                case "content":
                    alert("文章内容不能为空")
                    break;
            }
            flag = false;
            return false;
        }
    });
    if (flag) {
        $.post("/assay/addAssay", data, function () {
            location.href = "/"
        });
    }
}