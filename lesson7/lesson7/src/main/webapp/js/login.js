function toggleToLoginForm() {
    $('.registration').animate({
        height: "toggle",
        opacity: "toggle"
    }).fadeOut("slow", function() {
        $('.login').animate({
            height: "toggle",
            opacity: "toggle"
        }).fadeIn("slow");
    });
}

$('.message a').click(function(event) {
    event.preventDefault();
    toggleToLoginForm();
});

$(".submit.register").click(function() {
    var firstName = $("input.firstName").val();
    var lastName = $("input.lastName").val();
    var email = $("input.email").val();
    var password = $("input.password").val();

    if (firstName == '' || lastName == '' || email == '' || password == '') {
        alert("Please fill all fields!");
    } else {

        var userRegistration = {
            firstName: firstName,
            lastName: lastName,
            email: email,
            password: password
        };

        $.post("registration", userRegistration, function(data) {
            if (data == 'Success') {

                $("form.register-form")[0].reset();
                $("form.login-form")[0].reset();

                toggleToLoginForm();
                showAlertAfterRegistration();
            }
        });
    }
});

function showAlertAfterRegistration() {
    $('#successAlert').fadeIn();
}

$("button.login").click(function() {
    var email = $("form.login-form input.email").val();
    var password = $("form.login-form input.password").val();

    if (email == '' || password == '') {
        alert("Please fill in the login form!");
    } else {
        var userLogin = {
            email: email,
            password: password
        };

        $.post("login", userLogin, function(data) {
            if (data.destinationUrl) {
                window.location.href = data.destinationUrl + "?email=" + encodeURIComponent(data.userEmail);
            } else {
                alert("Login failed. Please check your credentials.");
            }
        }, "json");
    }
});