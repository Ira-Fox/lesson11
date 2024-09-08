$("button.createProduct").click(function() {
    console.log("Button clicked");
    var name = $("form.createProduct input.productName").val();
    var description = $("form.createProduct input.productDescription").val();
    var price = $("form.createProduct input.productPrice").val();
    
    var product = {
        name: name,
        description: description,
        price: price
    };

    $.post("product", product, function(data) {
        console.log("Response received: " + data);
        if (data === 'Success') {
            alert('Success');
        } else {
            alert('Failed to create product');
        }
    }).fail(function(jqXHR, textStatus, errorThrown) {
        alert('Request failed: ' + textStatus + ', ' + errorThrown);
    });
});