Vue.config.silent=true; //取消所有日志警告
Vue.config.productionTip = false; //阻止Vue在启动时生成生产提示。

var path = "http://127.0.0.1:8080/";

var headers = {
    Accept: "application/json; charset=utf-8"
};

var session= {
    userId : 1,
    sessionId: "vjfklvajkl_213"
};

common = {
    post:function(url,setting){
        $.ajax(path+url,{
            async: false, //同步
            type: "POST", //post请求
            headers: headers, //httpHeader
            data: setting.body,
            success: setting.callBlack,
            datatype: "json"

        })
    },
    asyncPost:function(url,setting){
        $.ajax(path+url,{
            async: true, //异步
            type: "POST", //post请求
            headers: headers, //httpHeader
            data: setting.body,
            success: setting.callBlack,
            datatype: "json"
        })
    }
};