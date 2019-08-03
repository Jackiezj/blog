$(function () {

    // 关闭和打开目录
    let times = 0;
    $('#show-table').click(function (e) {
        e.preventDefault();
        if (times === 0) {
            $(this).css('left', '260px');
            $('#sidebar').css('display', 'block');
            $('#show-table p').html('关闭目录');
            times = 1;
        } else {
            $(this).css('left', '0');
            $('#sidebar').css('display', 'none');
            $('#show-table p').html('打开目录');
            times = 0;
        }
    });
});
