var getMenuInfo = {
    userId: session.userId,
    sessionId: session.sessionId
};

var setting = {
    body: getMenuInfo,
    callBlack: function (msg) {
        console.log(msg)
    }
};

$(document).ready(function() {
    var post = common.post("user/getMenu", setting);
    console.log(post);
});

var vm = new Vue({
    el: 'menu',
    data:{}
});


