var eventUrl = "http://localhost:8080/lunchEvents";
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
                console.log(data.lunch.name);
            }, false);
        }
    }
});