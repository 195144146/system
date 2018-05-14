

// 全局变量

//取消所有日志警告
Vue.config.silent= false;

//配置是否允许Vue-devtools检查代码
// 开发版本默认为true
// 生产版本默认为false
Vue.config.devtools = true;

//设置为true，在浏览器开发工具中启用对组件初始化、渲染、和打补丁的性能追踪
Vue.config.performance = true;

//设置为false，以阻止Vue在启动时生成生产提示
Vue.config.productionTip = true;

//当主键渲染时遇到未处理的异常，会调用这个函数，默认会输出错误堆栈信息
//自定义错误
Vue.config.errorHandler = function (err, vm) {
    console.log(err);
    console.log(vm);
};

//自定义警告
Vue.config.warnHandler = function (msg, vm, trace) {
    // `trace` 是组件的继承关系追踪
};

//自定义键位名
Vue.config.keyCodes = {
    enter: 13,
    space: 32
};

//使Vue忽略在Vue之外的自定义元素。
// 否则，它会假设你忘记注册全局组件或者拼错了组件名称，从而抛出一个关于Unknown custom element的警告
Vue.config.ignoredElements = [
    'my-custom-web-component', 'another-web-component','test'
]
/**
 * Vue定义的合并策略
 * 子实例不存在使用父实例
 * @param parentVal 父实例
 * @param childVal  子实例
 * @returns {*}
 */
var defaultStrat = function (parentVal, childVal) {
    return childVal === undefined
        ? parentVal
        : childVal
}

//自定义合并策略
Vue.config.optionMergeStrategies._my_option = function (parent,child,vm) {
    return child + 1
}
const profile = Vue.extend({
    _my_option: 1
})

//修改Watch的合并策略
Vue.config.optionMergeStrategies.watch = function (toVal, fromVal) {
    // return mergedVal;
}
<!--模板语法-->
<!--指令-->
new Vue({
    el: '#test',
    data: {
        message: 'hello word',
        world: 'world',
        ok: false,
        list: [1,2,3,4,5],
        list2: [
            {text: "content1"},
            {text: "content2"}
        ],
        list3: [
            {
                text: "content1",
                id: 1
            },
            {
                text: "content2",
                id: 2
            }
        ],
        notok: true,
        httest: '<span style="color: darkred"> 这是一个html内容</span>',
        url: "http://baidu.com",
        target: '_blank'
    },
    methods:{
        onchangmessage: function(event) {
            this.message = '虞嘉俊';
            console.log("message=虞嘉俊");
        },
        //可以检测到
        onchangelist3: function () {
            this.list3[1].text = "content3"
        },
        // 可以检测到
        onchangelist3as2: function () {
            Vue.set(this.list3,0,{text:"content4"})
        },
        //检测不到这样的变动
        onchangelist: function () {
            this.list[0] = 6
        },
        //可以检测到
        onchangelistas2: function () {
            Vue.set(this.list,1,7)
        },
        //可以检测到
        onchangelistas3: function () {
            this.list.splice(2,1,8)
        },
        methodnewdate: function () {
            return Date.now();
        }
    },
    //过滤器
    filters: {
        formatext: function (value) {
            value = value? falue.toString():""
            return value
        }
    },
    //计算属性
    computed: {
        reversedMessage: function () {
            return this.message.split("").reverse().join("")
        },
        newdate: function () {
            // cache: false
            return Date.now();
        }
    },
    //watchers
    watch: {
        //当message改变时这个方法会被触发
        message: function () {

        }
    }
});


Vue.component('button-counter',{
    ////点击button调用incrementCounter方法
    template: '<div>' +
                '<button v-on:click="incrementCounter">{{counter}}</button>' +
                '<input type="number" v-model.number="counter">' +
              '</div>',
    data: function () {
        return {counter:0}
    },
    methods: {
        incrementCounter: function () {
            console.log("component");
            this.counter += 1;
            //触发increment事件
            this.$emit('increment')
        }
    },
})

new Vue({
    el: '#counter-event-example',
    data: {
        total: 0
    },
    methods: {
        incrementTotal: function () {
            this.total += 1
            console.log("fsdfd");
        }
    }
})
