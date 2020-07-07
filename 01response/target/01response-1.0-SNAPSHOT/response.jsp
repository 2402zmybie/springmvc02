<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/7
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery-3.4.1.js"></script>

    <script>
        //页面加载,绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //发送ajax请求
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data: "{'username':'老何','password':'123456','age': 27}",
                    dataType: "json",
                    type: 'post',
                    success: function (data) {
                        alert(data)
                    }
                })
            })
        })
    </script>
</head>
<body>

    <a href="user/testString">testString</a>

    <br>
    <br>
    <br>

    <a href="user/testVoid">testVoid</a>

    <br>
    <br>
    <br>

    <a href="user/testModelAndView">testModelAndView</a>


    <br>
    <br>
    <br>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

    <br>
    <br>
    <br>
    <button id="btn" >发送ajax的请求</button>
</body>
</html>
