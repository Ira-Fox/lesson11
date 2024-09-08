package com.example.servlet;

import java.io.IOException;

import com.example.domain.Product;
import com.example.service.ProductService;
import com.example.service.impl.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductController extends HttpServlet {

	ProductService productService = ProductServiceImpl.getProductService();

	@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    String price = request.getParameter("price");
    
    try {
        Product product = new Product(name, description, getValidatedPrice(price));
        productService.create(product);
        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    } catch (Exception e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to create product");
    }
}
	
	private float getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Float.parseFloat(price);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}
}
