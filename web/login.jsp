<%--
  Created by IntelliJ IDEA.
  User: CRS
  Date: 11/17
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="Login"  method="post"  style="padding-top:-700px;">
    用户名：<input type="text" name="name" value=""><br><br>
    密--码：  <input type="password" name="pwd" value=""><br><br>
    <input type="submit" value="登录" name="login"><input type="reset" value="重置"><br>
</form>
<form action="register.jsp">
    <input type="submit" value="新用户注册">
</form>

</body>
</html>
