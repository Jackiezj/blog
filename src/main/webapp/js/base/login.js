var vm = new Vue({
    el: '#app',
    data: {
        host: host,

        error_name: false,
        error_password: false,

        error_name_message: '',
        error_password_message: '',

        username: '',
        password: '',
    },
    mounted: function(){
    },
    methods: {

        // 检查用户名
        check_username: function (){
            // 检查重名
            // if (this.error_name == false) {
            //     axios.get(this.host + '/usernames/' + this.username + '/count/', {
            //         responseType: 'json'
            //     })
            //         .then(response => {
            //             if (response.data.count > 0) {
            //                 this.error_name_message = '用户名已存在';
            //                 this.error_name = true;
            //             } else {
            //                 this.error_name = false;
            //             }
            //         })
            //         .catch(error => {
            //             console.log(error.response.data);
            //         })
            // }
        },
        check_pwd: function (){
            // var len = this.password.length;
            // if(len<8||len>20){
            //     this.error_password_message = '请输入8-20个字符的密码';
            //     this.error_password = true;
            // } else {
            //     this.error_password = false;
            // }
        },
        // 登录
        on_submit: function(){
            this.check_username();
            this.check_pwd();

            if(this.error_name == false && this.error_password == false && this.error_check_password == false
                && this.error_phone == false && this.error_sms_code == false && this.error_allow == false) {

                axios.post(this.host + '/users/', {
                    username: this.username,
                    password: this.password,
                    password2: this.password2,
                    mobile: this.mobile,
                    sms_code: this.sms_code,
                    allow: this.allow.toString()
                }, {
                    responseType: 'json'
                })
                    .then(response => {
                        // 记录用户的登录状态
                        sessionStorage.clear();
                        localStorage.clear();

                        localStorage.token = response.data.token;
                        localStorage.username = response.data.username;
                        localStorage.user_id = response.data.id;

                        location.href = '/index.html';
                    })
                    .catch(error=> {
                        if (error.response.status == 400) {
                            if ('non_field_errors' in error.response.data) {
                                this.error_sms_code_message = error.response.data.non_field_errors[0];
                            } else {
                                this.error_sms_code_message = '数据有误';
                            }
                            this.error_sms_code = true;
                        } else {
                            console.log(error.response.data);
                        }
                    })
            }
        }
    }
});
