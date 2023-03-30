<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/30/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Chỉnh Sửa Thông Tin Cầu Thủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form:form modelAttribute="playerSoccer" action="/player/edit" method="post">
    <form:input path="id" readonly="true"/>
    <table>
        <div class="form-group text-center" style="width: 400px">
            <label for="name">Tên Cầu Thủ</label>
            <form:input type="text" class="form-control" path="name" id="name"/>
        </div>
        <div class="form-group text-center" style="width: 400px">
            <label for="dateOfBirth">Ngày Sinh</label>
            <form:input type="date" class="form-control" path="dateOfBirth" id="dateOfBirth"/>
        </div>
        <div class="form-group text-center" style="width: 400px">
            <label for="experience">Kinh Nghiệm</label>
            <form:input type="text" class="form-control" path="experience" id="experience"/>
        </div>
        <div class="form-group text-center" style="width: 400px">
            <label for="location">Vị Trí</label>
            <form:input type="text" class="form-control" path="location" id="location"/>
        </div>
        <div class="form-group text-center" style="width: 400px">
            <label for="img">Ảnh Cầu Thủ</label>
            <form:input type="text" class="form-control" path="img" id="img"/>
        </div>
        <button type="button" class="btn btn-secondary" onclick="location.href = '/player'">Trở Lại</button>
        <button type="submit" class="btn btn-primary">Xác Nhận</button>
    </table>
</form:form>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
