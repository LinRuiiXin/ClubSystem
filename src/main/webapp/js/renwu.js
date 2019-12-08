var app = new Vue({
    el: '#table',
    data: {
        addDetail: {},
        editlist: false,
        editDetail: {},
        newsList: [{
            title: '在移动设备开发',
            content: '阿里嘎多',
            user: '张若昀',
            dates: '2018-02-09',
            id: "45211546"
        }, {
            title: '图形及特效特性',
            user: '张若昀',
            dates: '2018-02-09',
            id: "61341341"
        }, {
            title: '设备兼容特性',
            user: '张若昀',
            dates: '2018-02-09',
            id: "62451431"
        }, {
            title: 'W3C将致力于开发用于实时通信',
            user: '张若昀',
            dates: '2018-02-09',
            id: "62345213"
        }, {
            title: '全新的表单输入对象',
            user: '张若昀',
            dates: '2018-02-09',
            id: "23322445"
        }],
        editid: ''
    },
    mounted() {

    },
    methods: {

        //新增
        adddetail() {
            //这里的思路应该是把this.addDetail传给服务端，然后加载列表this.newsList
            //this.newsList.push(this.addDetail)
            this.newsList.push({
                title: this.addDetail.title,
                user: this.addDetail.user,
                dates: this.addDetail.dates,
                id: Math.floor(Math.random() * 1000000 + 1)
            })

            //axios.post('url',this.addDetail).then((res) =>{
            //若返回正确结果，清空新增输入框的数据
            //this.addDetail.title = ""
            //this.addDetail.user = ""
            //this.addDetail.dates = ""
            //})

        },
        //删除
        deletelist(id, i) {
            this.newsList.splice(i, 1);
            //这边可以传id给服务端进行删除  ID = id
            //axios.get('url',{ID:id}).then((res) =>{
            //			加载列表				
            //})
        },
        //编辑
        edit(item) {
            console.log(item)
            this.editDetail = {
                title: item.title,
                user: item.user,
                dates: item.dates,
                id: item.id
            }
            this.editlist = true
            this.editid = item.id

        },
        //确认更新
        update() {
            //编辑的话，也是传id去服务端
            //axios.get('url',{ID:id}).then((res) =>{
            //			加载列表				
            //})
            let _this = this
            for (let i = 0; i < _this.newsList.length; i++) {
                if (_this.newsList[i].id == this.editid) {
                    _this.newsList[i] = {
                        title: _this.editDetail.title,
                        user: _this.editDetail.user,
                        dates: _this.editDetail.dates,
                        id: this.editid
                    }
                    this.editlist = false
                }
            }
        }
    }
})