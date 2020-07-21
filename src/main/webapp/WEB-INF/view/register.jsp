<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h1>注册</h1>
<form action="/user/register" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="注册">
</form>
<hr>
<p><a href="/">登录</a></p>
</body>
</html>