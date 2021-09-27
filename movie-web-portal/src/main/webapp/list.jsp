<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>黑马影视首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<div>
    <!--头部-->
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 列表 -->
    <div id="list">
        <table class="table table-hover text-center" style="width:70%;" align="center">
            <tr v-for="(movie,index) in movieList" @click="jump2detail(movie.id)">
                <td><img :src="movie.image" width="140" height="100"/></td>
                <td>{{movie.name}}</td>
                <td>{{movie.director}}</td>
                <td>{{movie.actor}}</td>
            </tr>
        </table>
    </div>

    <!--尾部-->
    <jsp:include page="footer.jsp"></jsp:include>
</div>

<script>
    new Vue({
        el: "#list",
        data: {
            movieList: []
        },
        methods: {
            //根据cid查询影视列表
            findMovieListByCid(cid) {
                axios.get('/movie/findByCid?cid=' + cid).then(resp => {
                    this.movieList = resp.data;
                })
            },

            //跳转详情页
            jump2detail(id){
                location.href = 'detail.jsp?id='+id;
            }

        },
        created() {
            //根据cid查询影视列表
            let cid = location.search.split("=")[1];
            if (cid) {
                this.findMovieListByCid(cid);
            }
        }
    })
</script>

</body>
</html>