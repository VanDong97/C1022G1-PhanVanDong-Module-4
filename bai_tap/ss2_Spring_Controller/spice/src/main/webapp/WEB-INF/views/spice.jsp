<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/27/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../js/bootstrap.min.js">
<html>
<head>
    <title>Sandwich Spice</title>
</head>
<body>
<div>
    <h2 style="color: blueviolet">Sandwich Spice</h2>
    <form action="/save" method="post" style="color: #0b5ed7">
        <input type="checkbox" value="Lettuce" name="spice">Lettuce
        <input type="checkbox" value="Tomato" name="spice">Tomato
        <input type="checkbox" value="Mustard" name="spice">Mustard
        <input type="checkbox" value="Sprouts" name="spice">Sprouts <br>
        <hr>
        <input type="submit" value="Save">
    </form>
    <div style="color: #0a53be">${listSpice}</div>
</div>
</body>
</html>
