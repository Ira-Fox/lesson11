package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.domain.Product;
import com.example.service.ProductService;
import com.example.service.impl.ProductServiceImpl;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class Products extends HttpServlet{
    private ProductService productService = ProductServiceImpl.getProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> products = productService.readAll();
        String json = new Gson().toJson(products);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}
