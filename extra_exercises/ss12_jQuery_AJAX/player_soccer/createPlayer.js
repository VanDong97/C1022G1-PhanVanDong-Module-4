$("#addPlayer").click(function (event) {
    debugger
    event.preventDefault()
    let name = $("#name").val();
    let dateOfBirth = $("#dateOfBirth").val();
    let experience = $("#experience").val();
    let location = $("#location").val();
    let img = $("#img").val();
    let team = $("#selectTeam").val();
    createPlayer(name, dateOfBirth, experience, location, img, team);
})

function createPlayer(name, dateOfBirth, experience, location, img, team) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/player",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify({
            name: name,
            dateOfBirth: dateOfBirth,
            experience: experience,
            location: location,
            img: img,
            team: {team}
        }),
        success: function (data) {
            alert("Thêm mới thành công")
            $("#exampleModal").hide();
            $("body").removeClass("modal-open");
            $(".modal-backdrop").remove();
            $('#loadDelete').trigger('click');
            document.getElementById("name").value = "";
            document.getElementById("dateOfBirth").value = "";
            document.getElementById("experience").value = "";
            document.getElementById("location").value = "";
            document.getElementById("img").value = "";
            playerSoccerList();
        },
        error: function (data) {
            $("#addNameValid").html("")
            $("#addDateOfBirthValid").html("")
            $("#addExperienceValid").html("")
            $("#addLocationValid").html("")
            $("#addImgValid").html("")
            for (let key of Object.keys(data.responseJSON)) {
                const cusKey = `${key[0].toUpperCase()}${key.substring(1)}`;
                if (document.getElementById(`add${cusKey}Valid`)) {
                    document.getElementById(`add${cusKey}Valid`).innerText = data.responseJSON[key] ?? '';
                }
            }
        },
    })
}

function selectTeam() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/team`,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            console.log(data)
            teamOption(data);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

function teamOption(products) {
    let element = "";
    element += `<select class="form-control" id = "selectTeam">`
    for (let product of products) {
        element += `<option value="${product.id}">${product.name}</option>`
    }
    `</select>`
    $("#team").html(element);
}

$(document).ready(function () {
    selectTeam();
})