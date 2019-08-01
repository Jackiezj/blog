var vm = new Vue({
    el: '#app',
    data: {
        user_id: ''
    },
    // 加载js即执行
    mounted: function () {
        this.get_user_id();
    },
    // 函数定义
    methods: {
        get_user_id: function () {
            axios({
                method: 'get',
                url: host + '/users/get_user_id',
            }).then(response => {
                console.log(response);
                this.user_id = this.response.errmsg;
            }).catch(error => {
                console.log(error);
            })
        },


    },

});
