$(function () {
    //当表单提交时，调用所有的校验方法
    $("#registerForm").submit(function () {
        //1.发送数据到服务器
        if (checkUsername() && checkPassword() && checkEmail()) {
            //校验通过,发送ajax请求，提交表单的数据   username=zhangsan&password=123
            $.post("/user/register", $(this).serialize(), function (data) {
                //处理服务器响应的数据  data  {flag:true,errorMsg:"注册失败"}

                if (data.flag) {
                    //注册成功，跳转成功页面
                    location.href = "index.html";
                } else {
                    //注册失败,给errorMsg添加提示信息
                    $("#errorMsg").html(data.errorMsg);

                }
            });
        }
        //2.不让页面跳转
        return false;
        //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
    });
    //当某一个组件失去焦点是，调用对应的校验方法
    $("#username").blur(checkUsername);
    $("#password").blur(checkPassword);
    $("#password2").blur(checkPassword2);
    $("#email").blur(checkEmail);
    $("#getEmailCode").click(getEmailCode);
});

function checkUsername() {
    //1.获取用户名值
    var username = $("#username").val();
    //2.定义正则
    var reg_username = /^\w{4,20}$/;

    //3.判断，给出提示信息
    var flag = reg_username.test(username);
    if (flag) {
        //用户名合法
        $("#usernameArrorMsg").html("");
    } else {
        //用户名非法,加一个红色边框
        $("#usernameArrorMsg").html("用户名不合法, 请输入4-20位用户名");
    }

    return flag;
}

//校验密码
function checkPassword() {
    //1.获取密码值
    var password = $("#password").val();
    //2.定义正则
    var reg_password = /^\w{6,20}$/;

    //3.判断，给出提示信息
    var flag = reg_password.test(password);
    if (flag) {
        //密码合法
        $("#passwordArrorMsg").html("");
    } else {
        //密码非法,加一个红色边框
        $("#passwordArrorMsg").html("密码不合法");
    }

    return flag;
}

//校验密码
function checkPassword2() {
    //1.获取密码值
    var password = $("#password").val();
    var password2 = $("#password2").val();

    //3.判断，给出提示信息
    var flag = password == password2;
    if (flag) {
        //密码合法
        $("#passwordArrorMsg2").html("");
    } else {
        //密码非法,加一个红色边框
        $("#passwordArrorMsg2").html("两次密码不一致");
    }

    return flag;
}

//校验邮箱
function checkEmail() {
    //1.获取邮箱
    var email = $("#email").val();
    //2.定义正则		itcast@163.com
    var reg_email = /^\w+@\w+\.\w+$/;

    //3.判断
    var flag = reg_email.test(email);
    if (flag) {
        $("#emailArrorMsg").html("");
    } else {
        $("#emailArrorMsg").html("邮箱格式不正确");
    }

    return flag;
}

function getEmailCode() {
    var email = $("#email").val();
    var d = {
        "email": email
    };
    $.post("/user/sendEmailCode", d, function (data) {
        if (data.flag) {
            initTime = 60;
            setInterval(function () {
                initTime = initTime - 1;
                if (initTime > 0) {
                    $("#getEmailCode").html(initTime + "秒后重试");
                    $("#getEmailCode").attr("disabled", "true");
                } else {
                    $("#getEmailCode").html("获取验证码");
                }
            }, 1000);
        } else {
            alert(data.errorMsg)
        }
    })

}
