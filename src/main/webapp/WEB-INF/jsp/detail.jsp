<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/tag.jsp"></jsp:include>
<html lang="zh-CN">
<head>
    <jsp:include page="common/head.jsp"></jsp:include>
    <title>商品详情页面</title>
</head>
<body>
<%--秒杀详情begin--%>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>${seckill.name}</h1>
        </div>
        <div class="panel-body">
            <%--秒杀状态提示Begin--%>
            <div>
                <h2 class="text-danger" id="seckill-box">
                </h2>
            </div>
            <%--秒杀状态提示End--%>
        </div>
    </div>
</div>

<%--用户登陆成功友好提示Begin--%>
<div id="tipInfoBox" class="alert alert-success col-md-4 col-md-push-4"></div>
<%--用户登陆成功友好提示End--%>

<%--秒杀详情end--%>

<!--登录弹出层，输入电话 begin-->
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>秒杀电话：
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey" placeholder="填写手机号^o^"
                               class="form-control">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <!-- 验证信息-->
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    登录
                </button>
            </div>

        </div>
    </div>
</div>
<!--登录弹出层，输入电话 end-->






</body>




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<%--引入倒计时js--%>
<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="/resource/script/seckill.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        //使用El表达式传入参数
        seckill.detail.init({
            seckillId:${seckill.seckillId},
            startTime:${seckill.startTime.time},
            endTime:${seckill.endTime.time}
        })
    });
</script>
</html>