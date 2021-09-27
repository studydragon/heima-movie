<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>黑马影视首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/medile.css" rel='stylesheet' type='text/css'/>
    <link href="css/single.css" rel="stylesheet" type="text/css"/>
    <link href="aliplayer/aliplayer-min.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .vip-join {
            color: #00c1de;
        }

        .vip_limit_content {
            display: flex;
            width: 100%;
            height: 100%;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
        }

        .vip_limit_content .title {
            font-size: 18px;
            line-height: 36px;
            color: #fff;
            text-align: center;
            width: 100%;
        }

        .vip_limit_button_box {
            text-align: center;
            white-space: nowrap;
            overflow: hidden;
            width: 100%;
        }

        .vip_limit_btn {
            display: inline-block;
            min-width: 100px;
            position: relative;
            background: #f60;
            padding: 0 35px;
            margin: 0px 5px 20px 5px;
            border-radius: 38px;
            font-size: 18px;
            line-height: 38px;
            color: #623A0C;
            text-align: center;
            background-image: linear-gradient(-135deg, #FBE8A8 0%, #F8E7AC 15%, #E2C078 100%);
            cursor: pointer;
        }

        .vip_limit_close {
            text-align: center;
        }

        .vip_limit_close span {
            display: inline-block;
            width: 40px;
            height: 40px;
            line-height: 36px;
            background: rgba(165, 165, 165, 0.54);
            border-radius: 50%;
            font-size: 24px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div>
    <!--头部-->
    <jsp:include page="header.jsp"></jsp:include>

    <!-- single -->
    <div class="single-page-agile-main" id="detail">
        <div class="container">
            <div class="agileits-single-top">
                <ol class="breadcrumb">
                    <li><a href="/">首页</a></li>
                    <li class="active">影视详情</li>
                </ol>
            </div>
            <div class="single-page-agile-info">
                <div class="show-top-grids-w3lagile">
                    <div class="single-left">
                        <div class="song">
                            <div class="song-info">
                                <h3>{{movie.name}}</h3>
                            </div>
                            <div class="video-grid-single-page-agileits">
                                <div class="prism-player" id="J_prismPlayer"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>

    <!--尾部-->
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="aliplayer/aliplayer-min.js"></script>
<script type="text/javascript" src="aliplayer/aliplayercomponents-1.0.5.min.js"></script>
<script type="text/javascript" src="js/axios-0.18.0.js"></script>
<script type="text/javascript" src="js/vuejs-2.5.16.js"></script>
<script type="text/javascript" src="js/token.js"></script>

<!--Vue的代码写到这里-->
<script>

    const saveTime = function (memoryVideo, currentTime) {
        localStorage.setItem(memoryVideo, currentTime);
    };
    const getTime = function (memoryVideo) {
        return localStorage.getItem(memoryVideo)
    };

    const app = new Vue({
        el: '#detail',
        data: {
            movie: {},//接收影视详情
        },
        methods: {
            //查询影视详情
            findMovieDetailById(movieId) {
                axios.get('/movie/findById?id=' + movieId).then(resp => {
                    // if (resp.data == []) {
                    //     alert("登录之后才能观看视频");
                    //     localStorage.removeItem("token");
                    //     localStorage.removeItem("username");
                    // } else {
                    if (resp) {
                        this.movie = resp.data;
                        let player = new Aliplayer({
                            id: 'J_prismPlayer',
                            width: '100%',
                            height: '500px',
                            autoplay: false,
                            controlBarVisibility: 'hover',
                            isLive: false,
                            components: [{
                                name: 'MemoryPlayComponent',
                                type: AliPlayerComponent.MemoryPlayComponent,
                                args: [false, getTime, saveTime]
                            }],
                            cover: this.movie.image,//图片
                            vid: this.movie.playId,//视频id
                            playauth: this.movie.playAuth,//视频播放秘钥
                            encryptType: 1, //是否加密播放
                        }, function (player) {
                            console.log('播放器创建好了。')
                        });
                    }
                    //}
                })
            },
        },
        watch: {},
        created() {
            //1. 获取到出入的movieId
            let movieId = location.search.split("=")[1];

            //2. 调用查询影视详情的方法
            this.findMovieDetailById(movieId);
        }
    })
</script>


</html>