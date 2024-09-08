package com.example.servlet;

import java.io.IOException;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.domain.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getUserByEmail(email);

        if (user == null) {
            request.setAttribute("errorMessage", "Invalid login or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (user.getPassword().equals(password)) {
            request.setAttribute("email", email);
            request.getRequestDispatcher("cabinet.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid login or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
