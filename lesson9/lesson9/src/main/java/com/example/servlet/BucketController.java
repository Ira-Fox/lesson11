package com.example.servlet;

import java.io.IOException;
import java.util.Date;

import com.example.domain.Bucket;
import com.example.service.BucketService;
import com.example.service.impl.BucketServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
    private BucketService bucketService = BucketServiceImpl.getBucketService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("NotAuthenticated");
            return;
        }

        String productId = request.getParameter("productId");
        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
        bucketService.create(bucket);

        response.getWriter().write("Success");
    }
}
