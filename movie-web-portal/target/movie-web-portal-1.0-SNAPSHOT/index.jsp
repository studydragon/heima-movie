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

    <!--焦点图-->
    <div class="ad">
        <ul class="slider">
            <li><img src="/images/6.jpg"/></li>
            <li><img src="/images/5.jpg"/></li>
            <li><img src="/images/4.jpg"/></li>
            <li><img src="/images/3.jpg"/></li>
            <li><img src="/images/2.jpg"/></li>
        </ul>
        <ul class="num">
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
            <li>5</li>
        </ul>
    </div>

    <!--尾部-->
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/pic.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/token.js"></script>
<!--Vue的代码写到这里-->
<%--<script type="text/javascript">--%>
<%--    const app = new Vue({--%>
<%--        el: '#app',--%>
<%--        data: {--%>
<%--            bannerList: [],//轮播列表--%>
<%--            moviesListMap: {},//影视map--%>
<%--        },--%>
<%--        methods: {--%>
<%--            findBannerList() {--%>
<%--                axios.get('/index/findBannerList').then(resp => {--%>
<%--                    this.bannerList = resp.data;--%>
<%--                    //console.log(this.bannerList);--%>
<%--                })--%>
<%--            },--%>

<%--            findMoviesListMap() {--%>
<%--                axios.get('/index/findMoviesListMap').then(resp => {--%>
<%--                    this.moviesListMap = resp.data;--%>
<%--                    console.log(this.moviesListMap);--%>
<%--                })--%>
<%--            }--%>
<%--        },--%>
<%--        watch: {},--%>
<%--        created() {--%>

<%--        }--%>
<%--    })--%>
<%--</script>--%>
</html>


