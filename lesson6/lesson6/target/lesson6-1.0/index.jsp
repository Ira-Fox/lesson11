<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <section>
        <div class="registration">
        <h2>Registration</h2>
            <form class="form" action="${pageContext.request.contextPath}/registration" method="post">
            <label for="firstName">Enter first name</label>
            <br>
            <input class="uk-input" name="firstName">
            <br>
            <label for="lastName">Enter last name</label>
            <br>
            <input class="uk-input" name="lastName">
            <br>
            <label for="emailField">Enter email</label>
            <br>
            <input class="uk-input" type="text" id="emailField" name="email">
            <br>
            <label for="passwordField">Enter password</label>
            <br>
            <input class="uk-input" type="password" id="passwordField" name="password" />
            <br>
            <input class="submit" type="submit" name="Submit">
        </form>
        </div>
    </section>

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>