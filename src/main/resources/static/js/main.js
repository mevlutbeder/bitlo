$(document).ready(function () {

    $("#loginForm").submit(function (event) {

      // event.preventDefault();

        var loginForm = {}
        loginForm["username"] = $("#username").val();
        loginForm["password"] = $("#password").val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/login",
            data: JSON.stringify(loginForm),
            dataType: 'json',
            success: function (data) {
                console.log(data);

            },
            error: function (e) {
                console.log("hata : "+e);

            }
        });

    });

});