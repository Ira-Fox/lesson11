<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <section>
        <div class="login">
        <h2>Login</h2>
            <form class="form" method="post" action="login">
                <label for="emailField">Email:</label>
                <br>
                <input class="uk-input" type="text" id="emailField" name="email" />
                <br>
                <label for="passwordField">Password:</label>
                <br>
                <input class="uk-input" type="password" id="passwordField" name="password" />
                <br>
                <input class="submit" type="submit" value="Login" />
            </form>
        </div>
    </section>

    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>