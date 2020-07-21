<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

<h1>登录</h1>
<form action="/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
<hr>
<p><a href="/register">注册</a></p>
</body>
</html>