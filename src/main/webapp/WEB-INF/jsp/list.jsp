<!DOCTYPE html>

<%@include file="common/tag.jsp"%>
<html lang="zh-CN">
<head>


    <title>秒杀列表</title>
    <%@include file="common/head.jsp"%>
    
</head>
<body>
    <!--页面显示部分-->

    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                    <h2>秒杀列表</h2>
                <div>
                    <button id="defaultBtn" class="btn btn-default">默认列表<span class="glyphicon glyphicon-align-justify"></span></button>
                    <button id="willBeginBtn" class="btn btn-default">即将开始<span class="glyphicon glyphicon-circle-arrow-down"></span></button>
                    <button id="hotIngBtn" class="btn btn-default">火热进行<span><img src="/imges/0x1f4a5.png"/></span></button>
                    <button id="willEndBtn" class="btn btn-default">即将结束<span class="glyphicon glyphicon-circle-arrow-down"></span></button>
                    <button id="userBtn" class="btn btn-default">我的秒杀<span class="glyphicon glyphicon-cloud"></span></button>
                    <button id="loginOutBtn" class="btn btn-default">登陆<span class="glyphicon glyphicon-log-in"></span></button>
                </div>
            </div>
            <div class="panel-body">
                <table class="table table-hover" id="listTable">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>库存</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>创建时间</th>
                        <th>详情页</th>
                    </tr>
                    </thead>
                    <tbody id="seckListBody">
                    <c:forEach var="seckill" items="${list}" varStatus="status">
                        <tr>
                            <td>${seckill.name}</td>
                            <td>${seckill.number}</td>
                            <td>
                                <fmt:formatDate value="${seckill.startTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                            </td>
                            <td>
                                <fmt:formatDate value="${seckill.endTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                            </td>
                            <td style="color: red">
                                <fmt:formatDate value="${seckill.createTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                            </td>
                            <td><a href="/seckill/${seckill.seckillId}/detail" class="btn btn-info" target="_blank">详情</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>



        </div>

    </div>




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>