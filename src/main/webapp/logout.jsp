<%@page import="model.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>  
<%@ page import="java.io.*" %>
<%UserBean user = (UserBean)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>ログアウト画面</title>
</head>
<body>
<h1>
    <% String logoutMessage = (String)request.getAttribute("logoutMessage"); %>
    <%= logoutMessage %>
    </br></h1>
    <a href="login.jsp"><input type="submit" value="ログイン画面へ"></a>
</body>
</html>