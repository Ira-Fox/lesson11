package vmarchuk.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import vmarchuk.domain.Product;
import vmarchuk.service.ProductService;
import vmarchuk.service.impl.ProductServiceImpl;

@WebServlet(name = "products", urlPatterns = {"/products"})
public class ProductsController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductService productService = ProductServiceImpl.getProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        List<Product> products = productService.readAll();
        String json = new Gson().toJson(products);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
