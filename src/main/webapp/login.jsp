<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
  <div class="main">
    <main>
    <div class="imageWrap">
        <img class="image" src="./assets/images/seassist_logo.png" alt="ロゴ">
    </div>
    <div class="error">
      <% if (request.getAttribute("loginMessage") != null) { %>
        <%= request.getAttribute("loginMessage") %>
        <% } %>
    </div>
    <div class="loginWrapper">
      <h2>従業員管理システム</h2>
      <form action="login" action="logout" method="post">
        <input type="text" name="id" placeholder="userId"><br>
        <input type="password" name="password" placeholder="password"><br>
        <br>
        <input type="submit" value="ログイン">
      </form>
    </div>
    </main>
  </div>
</body>
</html>