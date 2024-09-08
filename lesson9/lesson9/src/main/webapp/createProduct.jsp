<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%
     String email = (String) session.getAttribute("email");
    if (email == null) {
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cabinet</title>
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

    <section>
        <div class="cabinet" style="height: 89.7%;">
            <h1>Welcome to the cabinet, <%= email %>!</h1>
            <div class="container-fluid" style="width: 70%;">
                <div class="row">
			        <form class="createProduct" style="margin-top: 170px; margin-bottom: 50px;">
                        <label>Name:</label><br>
                        <div class="form-group">
                            <input type="text" name="name" class="form-control uk-input productName">
                        </div>
                        <label>Description:</label><br>
                        <div class="form-group">
                            <input type="text" name="description" class="form-control uk-input productDescription">
                        </div>
                        <label>Price:</label><br>
                        <div class="form-group">
                            <input type="number" name="price" class="form-control uk-input productPrice">
                        </div>
                        <button type="button" class="submit createProduct uk-button uk-button-primary">Submit</button>
                    </form>
                </div>
            </div>
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
    <script src="js/header.js"></script>
	<script src="js/serverCalls.js"></script>
    <script src="js/cabinet.js"></script>
    <script src="js/login.js"></script>
</body>
</html>