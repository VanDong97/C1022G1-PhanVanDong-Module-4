<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>
<h1>Email validate</h1>
<h3 style="color: rebeccapurple">${message}</h3>
<br/>
<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
</form>
</body>
</html>