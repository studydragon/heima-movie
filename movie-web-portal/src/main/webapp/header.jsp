<script type="text/javascript" src="js/axios-0.18.0.js"></script>
<script type="text/javascript" src="js/vuejs-2.5.16.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <!-- header -->
    <div class="header">
        <div class="container">
            <div class="w3layouts_logo">
                <a href="/"><h1>黑马<span>影视</span></h1></a>
            </div>
            <div class="w3l_sign_in_register" style="width: 10%">
                <ul>
                    <li v-if="memberName == ''"><a href="#" data-toggle="modal" data-target="#myModal">登录</a></li>
                    <li v-if="memberName != ''">欢迎回来,{{memberName}}</li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

    <!-- 这里是登录的窗口-->
    <div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    登录 & 注册
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <section>
                    <div class="modal-body">
                        <div class="w3_login_module">
                            <div class="module form-module">
                                <div></div>
                                <div class="form">
                                    <h3>账户登录</h3>
                                    <input type="text" placeholder="用户名" v-model="username">
                                    <input type="password" placeholder="密码" v-model="password">
                                    <input type="button" @click="login()" value="登录">
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>

    <!--nav-->
    <div class="movies_nav">
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                    <nav>
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="/">首页</a></li>
                            <li v-for="(category,index) in categoryList"><a :href="'list.jsp?cid='+category.id">{{category.name}}</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </nav>
        </div>
    </div>
</div>
<script>
    let header = new Vue({
        el: "#header",
        data: {
            memberName: "",
            username: "",
            password: "",
            categoryList: [],
        },
        methods: {
            //用户登录
            login() {
                axios.get('/member/login', {
                    params: {
                        "username": this.username,
                        "password": this.password
                    }
                }).then(resp => {
                    if (resp.data.code == "0") {
                        alert("用户名或者密码错误");
                    } else {
                        //将token保存
                        localStorage.setItem("token", resp.data.token);
                        localStorage.setItem("username", resp.data.username);
                        //页面刷新
                        location.reload();
                    }
                })
            },

            findCategoryList() {
                axios.get('/category/findAll').then(resp => {
                    this.categoryList = resp.data;
                })
            }
        },
        created() {
            this.findCategoryList();

            //判断是否要展示用户名
            if (localStorage.getItem("username")) {
                this.memberName = localStorage.getItem("username");
            }

        }
    })
</script>
