<%--
  Created by IntelliJ IDEA.
  User: Gatsby
  Date: 2020/7/7
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件: <input type="file" name="upload"/> <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
