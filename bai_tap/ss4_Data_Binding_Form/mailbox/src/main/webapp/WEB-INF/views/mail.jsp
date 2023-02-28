<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/28/2023
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Hòm Thư Điện Tử</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>Setting</h1>
<table>
    <form:form action="mailBox" modelAttribute="mailBox" method="post">
        <tr>
            <div>
                <th>
                    <lable for="languages">Languages</lable>
                    <form:radiobuttons path="languages" items="${languageList}"/>
                </th>
            </div>
        </tr>
        <tr>
            <div>
                <th>
                    <lable for="pageSize">Page Size</lable>
                    <form:radiobuttons path="pageSize" items="${pageSizeList}"/>
                </th>
            </div>
        </tr>
        <tr>
            <div>
                <th>
                    <lable for="spamsFilter">Spams Filter</lable>
                    <form:checkbox path="spamsFilter" id="spamsFilter"/>
                    <span>Enable spams filter</span>
                </th>
            </div>
        </tr>
        <tr>
            <div>
                <th>
                    <lable for="signature">Signature</lable>
                    <form:textarea path="signature" id="signature"/>
                </th>
            </div>
        </tr>
        <tr>
            <div>
                <td>
                    <button type="submit" class="btn btn-primary">Update</button>
                    <button type="button" class="btn btn-primary" onclick="window.location.href='/mailBox'">Cancel
                    </button>
                </td>
            </div>
        </tr>
    </form:form>
</table>
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
