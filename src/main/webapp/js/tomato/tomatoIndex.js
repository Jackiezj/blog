let work_i = null;
let rest_i = null;

var vm = new Vue({
    el: '#app',
    data: {
        tomato_num: 0,
        // p1: document.getElementById('start_music'),
        remainder_time: 'ff',

    },
    mounted: function(){
        // this.firstStart()
    },
    methods: {
        startTomato: function () {
            let p1 = document.getElementById('start_music');
            let p2 = document.getElementById('stop_music');
            let tomato_num = this.tomato_num;
            let to_pi = this.tomatoTips;
            let re_pi = this.restTips;
            if (work_i != null) {
                clearInterval(work_i);
            }
            if (rest_i != null) {
                clearInterval(rest_i);
            }
            $('#startTomato').attr('disabled', true);
            $('#stopTomato').attr('disabled', false);
            if (tomato_num == 0) {
                p1.play();
                to_pi('番茄时间', 24, 59);
            }
            setInterval(function () {
                p1.play();
                to_pi('番茄时间', 24, 59);
            }, 1800000);
            setTimeout(function () {
                p2.play();
                re_pi('休息时间', 4, 59);
                tomato_num += 1;
                $('#finish_tomato_num').html(tomato_num);
                setInterval(function () {
                    p2.play();
                    re_pi('休息时间', 4, 59);
                    tomato_num += 1;
                    $('#finish_tomato_num').html(tomato_num);
                }, 1800000);
            }, 1500000)

        },

        stopTomato: function () {
            $('#startTomato').attr('disabled', false);
            $('#stopTomato').attr('disabled', true);
            if (work_i != null) {
                clearInterval(work_i);
            }
            if (rest_i != null) {
                clearInterval(rest_i);
            }
            this.longRestTips('休息一会,马上回来吧!', 0, 0);

        },

        tomatoTips: function (introduce, min, sec) {
            work_i = setInterval(function () {
                $('#tomato-tips').html(introduce+': '+min+'分'+sec+'秒')
                if (sec == 0) {
                    if (min == 0) {
                        $('#tomato-tips').html('')
                        clearInterval(work_i);
                    } else {
                        min -= 1;
                        sec = 60;
                    }
                }
                sec -= 1;
            }, 1000);
        },

        restTips: function (introduce, min, sec) {
            rest_i = setInterval(function () {
                $('#tomato-tips').html(introduce+': '+min+'分'+sec+'秒')
                if (sec == 0) {
                    if (min == 0) {
                        $('#tomato-tips').html('')
                        clearInterval(rest_i);
                    } else {
                        min -= 1;
                        sec = 60;
                    }
                }
                sec -= 1;
            }, 1000);
        },

        longRestTips: function (introduce, min, sec) {
            let hour = 0;
            rest_i = setInterval(function () {
                if (hour == 0) {
                    $('#tomato-tips').html(introduce+' '+min+':'+sec);
                } else {
                    $('#tomato-tips').html(introduce+' '+hour+':'+min+':'+sec);
                }
                if (sec == 60) {
                    if (min == 60) {
                        if (hour == 2) {
                            $('#tomato-tips').html('已经休息2小时以上了,马上开始工作吧!');
                            clearInterval(rest_i);
                        }
                        hour += 1;
                        min = 0;
                    } else {
                        min += 1;
                        sec = 0;
                    }
                }
                sec += 1;
            }, 1000);
        },



    },



    filter: {

    },

});