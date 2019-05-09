var eventUrl = "http://localhost:8080/lunches";
new Vue({
    el: '#app',
    data: {
        locat: null,
        error: null
    },
    created: function () {
        this.init();
    },
    methods: {
        init: function () {
            this.loadData();
        },
        loadData: function () {
            // this.$http.get(eventUrl).then(function (response) {
            //     if (!!response.body) {
            //         this.locat = response.body;
            //     }
            // }, function (response) {
            //     this.error = response;
            // });
        }
    }
});