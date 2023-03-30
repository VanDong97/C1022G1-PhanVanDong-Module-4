<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/24/2023
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<form action="/dictionary">
    <input type="text" name="dictionary">
    <input type="submit" value="Tìm kiếm">
</form>
<p>${result}</p>
</body>
</html>
