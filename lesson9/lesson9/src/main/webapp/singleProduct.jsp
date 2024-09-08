<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cabinet</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <section>
        <div class="cabinet">

            <div class="uk-container uk-container-expand single-product" style="margin-top: 8%; margin-bottom: 8%;">
                <div class="uk-grid-small" uk-grid>
                    <div class="uk-width-1-1">
                        <div class="uk-card uk-card-default">
                            <div class="uk-card-body">
                                <h5 class="uk-card-title">${product.name}</h5>
                                <h6 class="uk-text-muted">${product.price}</h6>
                                <p class="uk-text">${product.description}</p>

                                <button type="button" class="uk-button uk-button-primary" uk-toggle="target: #buyProductModal">Buy Product</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div id="buyProductModal" class="uk-flex-top" uk-modal>
                <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">
                    <button class="uk-modal-close-default" type="button" uk-close></button>
                    <h5 class="uk-modal-title">Confirmation</h5>
                    <p>Are you sure that you want to buy this product?</p>
                    <div class="uk-modal-footer">
                        <button type="button" class="uk-button uk-button-default uk-modal-close">Cancel</button>
                        <button type="button" product-id="${product.id}" class="uk-button uk-button-primary buy-product">Buy</button>
                    </div>
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
	<script src="js/bucketCalls.js"></script>
    <script src="js/cabinet.js"></script>
    <script src="js/login.js"></script>
</body>
</html>