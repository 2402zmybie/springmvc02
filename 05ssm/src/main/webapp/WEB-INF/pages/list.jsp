<%--
  Created by IntelliJ IDEA.
  User: Gatsby
  Date: 2020/7/8
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="aa" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width:300px;
            border: 1px solid red;
            border-collapse: collapse;
        }
        td{
            border: 1px solid red;
        }
        .a{
            background: gray;
        }
    </style>

</head>
<body>
    <h3>查询所有账户信息</h3>
    <!--※注意，这里核心库的前缀名改成"aa"只是用于讲语法，按编程规范，应该用"c" -->
    <table >
        <tr> <th>姓名</th> <th>money</th> </tr>

        <aa:forEach items="${accounts}" var="account" varStatus="idx">
            <aa:if test="${idx.count%2==0}" var="boo"><!-- 这个地方是如果这个if条件满足，那么那个boo就是true-->
                <tr class="a"><!--如果是偶数标签就设置为灰色 -->
            </aa:if>
            <aa:if test="${!boo}">
                <tr>
            </aa:if>

            <td>${account.name}</td> <td>${account.money}</td>
            </tr>
        </aa:forEach>

    </table>







</body>
</html>
