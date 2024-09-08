var products = null;

$.get("products", function(data) {
    if (data !== '') {
        products = data;
    }
}).done(function() {
    var cardsContent = "";
    jQuery.each(products, function(i, value) {
        cardsContent += "<div class='uk-width-1-3@m uk-width-1-2@s'>" +
                        "<div class='uk-card uk-card-default uk-card-hover uk-margin'>" +
                        "<div class='uk-card-body'>" +
                        "<h5 class='uk-card-title'>" + value.name + "</h5>" +
                        "<h6 class='uk-text-muted'>" + value.price + "</h6>" +
                        "<p class='uk-text'>" + value.description + "</p>" +
                        "<a href='product?id=" + value.id + "' class='uk-link'>View Product</a>" +
                        "</div>" +
                        "</div>" +
                        "</div>";
    });
    $('#productCards').html(cardsContent);
});