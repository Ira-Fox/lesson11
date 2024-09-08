<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <header style="display: flex; justify-content: center; align-items: center;">
        <nav class="uk-navbar-container uk-navbar-transparent uk-navbar" uk-navbar style="width: 80%; display: flex; justify-content: center;">
        <div class="uk-navbar-left">
            <a class="uk-navbar-item uk-logo" href="#" style="color: white;">MAGAZINESTORE</a>
        </div>

        <div class="uk-navbar-right">
            <a class="uk-navbar-toggle" uk-navbar-toggle-icon href="#" uk-toggle="target: #offcanvas-nav" style="color: white;"></a>
        </div>
    </nav>

<div id="offcanvas-nav" uk-offcanvas="flip: true; overlay: true">
    <div class="uk-offcanvas-bar" style="background-color: #886c6c;">

        <button class="uk-offcanvas-close" type="button" uk-close></button>

        <h3 class="uk-heading-bullet">MAGAZINESTORE</h3>

        <ul class="uk-nav uk-nav-default">
            <li class="uk-active">
                <a href="${pageContext.request.contextPath}/cabinet.jsp">Home</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/createProduct.jsp">Add Periodical</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
            </li>
        </ul>

        <ul class="uk-navbar-nav uk-margin-auto-left">
            <li>
                <button class="uk-button uk-button-link product-logout">LogOut</button>
            </li>
        </ul>
    </div>
</div>
    </header>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>