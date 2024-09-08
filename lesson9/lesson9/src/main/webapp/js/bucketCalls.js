$("button.buy-product").click(function () {
  console.log("Buy button clicked");

  var productId = $(this).attr("product-id");
  console.log("Product ID: " + productId);

  $.post("bucket", { productId: productId })
    .done(function (data) {
      console.log("Response from server: " + data);
      if (data === "Success") {
        UIkit.modal("#buyProductModal").hide();
        alert("Success");
      }
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
      console.error("Error: " + errorThrown);
      console.error("Status: " + textStatus);
      console.error("Response Text: " + jqXHR.responseText);
    });
});
