package vmarchuk.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vmarchuk.domain.Product;
import vmarchuk.service.ProductService;
import vmarchuk.service.impl.ProductServiceImpl;

@WebServlet(name = "product-create", urlPatterns = {"/product-create"})
public class ProductCreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ProductService productService = ProductServiceImpl.getProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        Product product = new Product(title, description, getValidatePrice(price));
        productService.create(product);
        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    private double getValidatePrice(String price) {
        if (price == null || price.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(price);
    }

}
