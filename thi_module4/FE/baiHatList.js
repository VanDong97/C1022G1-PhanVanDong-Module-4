// FIND ALL LIST SERVICE
function baiHat( append) {
    // let search = document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/baiHat?page=${page ? page : "0"}&name=` + search,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderService(data.content, append);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

function renderService(products, append) {
    let element = "";
    for (let product of products) {
        element += `
            <tr class = "fs-4">
                <td scope="row">${product.maBaiHat}</td>
                <td>${product.tenBaiHat}</td>
                <td>${product.tenTacGia}</td>
                <td>${product.ngayPhatHanh}</td>
                <td>${product.moTaThem}</td>
                <td>${product.theLoaiDTO.name}</td>
            </tr>
        `;
    }
    if (append) {
        $("#baiHat").append(element);
    } else {
        $("#baiHat").html(element);
    }
}