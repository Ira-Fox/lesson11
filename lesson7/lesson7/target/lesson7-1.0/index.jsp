<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <section>
    <div class="registration uk-cover-container">
        <form class="form register-form" action="${pageContext.request.contextPath}/registration" method="post">
            <h2>Registration</h2>

            <label for="firstName">Enter first name</label><br>
            <input class="uk-input firstName" name="firstName"><br>
            
            <label for="lastName">Enter last name</label><br>
            <input class="uk-input lastName" name="lastName"><br>
            
            <label for="emailField">Enter email</label><br>
            <input class="uk-input email" type="email" id="emailField" name="email"><br>
            
            <label for="passwordField">Enter password</label><br>
            <input class="uk-input password" type="password" id="passwordField" name="password"><br>
            
            <p class="message">Already registered? <a href="#login">Sign In</a></p>
            <button type="button" class="submit register uk-button uk-button-primary"  style="padding-left: 14px;">Create</button>
        </form>
    </div>
    
    <div class="login uk-cover-container" style="display:none;">
        <form class="form login-form" method="post" action="login">
            <h2>Login</h2>

            <label for="emailField">Email:</label><br>
            <input class="uk-input email" type="email" id="emailField" name="email"><br>
            
            <label for="passwordField">Password:</label><br>
            <input class="uk-input password" type="password" id="passwordField" name="password"><br>
            
            <div class="uk-flex uk-flex-center">
                <button type="button" class="submit login uk-button uk-button-primary" style="background-color: #8f6464; padding-left: 14px;">Login</button>
            </div>
        </form>
    </div>

    <div class="uk-alert-success" uk-alert style="display:none;" id="successAlert">
        <a class="uk-alert-close" uk-close></a>
        <strong>Success!</strong> You are registered.
    </div>
</section>

    <jsp:include page="footer.jsp"></jsp:include>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="js/login.js"></script>
</body>
</html>