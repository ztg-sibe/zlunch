var eventUrl = "http://localhost:8080/lunchEvents";

Vue.component('lunch-participation-list', {
    props: ['lunch'],
    data: function () {
        return {message: []};
    },
    template: '<div><div v-for="item in message">{{item.user.name}}</div></div>',
    created: function () {
        this.$http.get("/lunches/" + this.lunch + "/participations")
            .then(function (data) {
                this.message = data.body;
            });
    }
})

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
            var es = new EventSource(eventUrl);
            es.addEventListener('message', function (event) {
                var data = JSON.parse(event.data);
                alert("New lunch arrived! Hungry? Then subscribe to:" + data.lunch.name);
            }, false);
        }
    }
});