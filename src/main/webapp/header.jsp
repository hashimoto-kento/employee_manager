<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ヘッダー</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
  <div class="header">
    <main>
      <img class="image" src="./assets/images/seassist_logo.png" alt="ロゴ">
        <a href="<%= request.getContextPath() %>/logout"><input type="submit" value="ログアウト"></a>
    </main>
  </div>
</body>
</html>