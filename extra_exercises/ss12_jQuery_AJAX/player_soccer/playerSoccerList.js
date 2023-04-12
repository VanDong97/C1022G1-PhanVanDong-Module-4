function playerSoccerList(append) {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/api/player',
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderPlayer(data.content, append);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

function renderPlayer(products, append) {
    let element = "";
    for (let product of products) {
        element += `
        <tr class="fs-4">
            <td scope="row">${product.id}</td>
            <td>${product.name}</td>
            <td>${product.dateOfBirth}</td>
            <td>${product.experience}</td>
            <td>${product.location}</td>
            <td><img src="${product.img}" alt=""></td>
            <td>${product.team.name}</td>
        </tr>
        `
    }
    if (append) {
        $("#playerSoccer").append(element);
    } else {
        $("#playerSoccer").html(element);
    }
}

$(document).ready(function () {
    playerSoccerList();
})