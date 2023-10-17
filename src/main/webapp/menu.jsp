<%@page import="model.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%UserBean user = (UserBean)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
  <%@ include file="header.jsp"%>
  <div class="main">
    <main>
    <%=user.getUserId() %>さん、こんにちは
      <h2>従業員管理システム</h2>
        <a href="<%= request.getContextPath() %>/menu?action=employeeList">
        <input type="submit" name="button" value="従業員一覧"></a><br>
        <a href="<%= request.getContextPath() %>/menu?action=employeeRegistration">
        <input type="submit" name="button" value="従業員登録画面へ"></a><br>
        <a href="<%= request.getContextPath() %>/menu?action=languageRegistration>">
        <input type="submit" name="button" value="経験言語登録画面へ"></a>
      </form>
    </main>
  </div>
</body>
</html>