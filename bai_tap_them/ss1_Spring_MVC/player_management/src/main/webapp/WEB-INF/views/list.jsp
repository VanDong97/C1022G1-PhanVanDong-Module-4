<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Danh Sách Các Cầu Thủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        img{
            height: 100px;
            width: 100px;
        }
    </style>
</head>
<body>
<h2>Danh Sách Các Cầu Thủ</h2>
<table>
    <tr>
        <th>Mã Cầu Thủ</th>
        <th>Tên Cầu Thủ</th>
        <th>Ngày Sinh</th>
        <th>Kinh Nghiệm</th>
        <th>Vị Trí Chơi</th>
        <th>Ảnh</th>
        <th></th>
    </tr>
    <c:forEach var="playerSoccer" items="${playerSoccerList}">
        <tr>
            <td>${playerSoccer.id}</td>
            <td>${playerSoccer.name}</td>
            <td>${playerSoccer.dateOfBirth}</td>
            <td>${playerSoccer.experience}</td>
            <td>${playerSoccer.location}</td>
            <td><img src="${playerSoccer.img}" alt=""></td>
            <td><a href="/player/detail/${playerSoccer.id}">Thông Tin Chi Tiết</a></td>
            <td>
                <button type="button" class="btn btn-danger" onclick="deleteplayer(${playerSoccer.id}),'${playerSoccer.name}'"
                        data-toggle="modal" data-targer="#exampleModal"> Xóa
                </button></td>
        </tr>
    </c:forEach>
</table>
<%--Modal Xóa--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xóa Cầu Thủ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/player/delete">
                <div class="modal-body">
                    <input hidden type="text" id="idDelete" name="idDelete">
                    <span>Bạn Có Muốn Xóa Cầu Thủ </span><span style="color: red" class="fw-bolder"
                                                              id="nameDelete"> Không</span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                    <button type="submit" class="btn btn-primary">Có</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
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
