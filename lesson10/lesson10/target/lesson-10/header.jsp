<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/header.css">

<header class="d-flex justify-content-center align-items-center" style="background-color: #8f6464; height: 60px;">
    <nav class="navbar navbar-expand-lg navbar-dark w-75" style="background-color: #8f6464;">
        <div class="container-fluid">
            <a class="navbar-brand" href="#" style="color: white;">MAGAZINESTORE</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNav" aria-controls="offcanvasNav">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="offcanvas offcanvas-end bg-dark" tabindex="-1" id="offcanvasNav" aria-labelledby="offcanvasNavLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasNavLabel" style="color: white;">MAGAZINESTORE</h5>
                    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">

                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/cabinet.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/createProduct.jsp">Add Periodical</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
                        </li>
                    </ul>

                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <button class="btn btn-link text-white product-logout">LogOut</button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>
<div class="offcanvas offcanvas-start" tabindex="-1"
	id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
	<div class="offcanvas-header">
		<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
			aria-label="Close"></button>
	</div>
	<div class="offcanvas-body">
		<div class="d-flex flex-column container">
			<a type="button" class="btn btn-dark m-1"
				href="${pageContext.request.contextPath}/createProduct.jsp">Add
				new product</a> <a type="button" class="btn btn-dark m-1">Another
				action</a>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="js/header.js"></script>