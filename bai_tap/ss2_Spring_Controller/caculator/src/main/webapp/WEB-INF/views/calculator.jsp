<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/27/2023
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1 style="color: blueviolet">Calculator</h1>
<form action="/calculator" method="post">
    <input type="number" name="fistNumber">
    <input type="number" name="secondNumber">
    <br>
    <input type="submit" name="calculation" value="Addition">
    <input type="submit" name="calculation" value="Subtraction">
    <input type="submit" name="calculation" value="Multiplication">
    <input type="submit" name="calculation" value="Division">
</form>
<p>Result ${calculationMessege} : ${result}</p>
</body>
</html>
