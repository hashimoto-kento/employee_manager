<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>従業員登録</title>
</head>
<body>
  <%@ include file="header.jsp"%>
  <main>
    <h1>従業員登録フォーム</h1>
      <div class="main_registration">
        <form action="EmployeeRegistrationServlet" method="post">
          <label for="firstName">氏名（姓）</label>
          <input type="text" name="firstName" id="firstName" placeholder="例：山田" required><br>
    
          <label for="lastName">氏名（名）</label>
          <input type="text" name="lastName" id="lastName" placeholder="例：太郎" required><br>
    
          <label>性別</label>
          <input type="radio" name="gender" value="男" id="male">男
          <input type="radio" name="gender" value="女" id="female">女<br>
    
          <label for="birthday">生年月日</label>
          <input type="text" name="birthday" id="birthday" placeholder="例：19910105" required><br>
    
          <label for="phoneNumber">電話番号</label>
          <input type="text" name="phoneNumber" id="phoneNumber" placeholder="例：08012345678" required><br>
    
           <label for="section">部署</label>
          <select name="section" id="section">
            <% List<String> sectionNames = (List<String>) request.getAttribute("sectionNames");
               if (sectionNames != null) {
               for (String sectionName : sectionNames) { %>
              <option value="<%= sectionName %>"><%= sectionName %></option>
            <% }
              }
               %>
          </select><br>
    
           <label for="language">経験言語</label>
          <select name="language" id="language">
            <% List<String> languages = (List<String>) request.getAttribute("languages");
              if (languages != null) {
               for (String language : languages) { %>
            <option value="<%= language %>"><%= language %></option>
            <% } 
              }
            %>
          </select><br>
    
    
          <label for="hiringDate">入社日</label>
          <input type="text" name="hireDate" id="hiringDate" placeholder="例：20220401" required><br>
          <input type="submit" value="従業員登録確定">
          <input type="reset" value="クリア">
        </form>
      </div>
    <div class="main_move">
      <form action="<%= request.getContextPath() %>/menu.jsp" method="get">
        <input type="submit" value="メニュー画面へ">    
    </form>
  </div>
  </main>
</body>
</html>