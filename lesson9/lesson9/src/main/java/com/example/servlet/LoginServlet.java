package com.example.servlet;

import java.io.IOException;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.domain.*;
import com.example.dto.UserLogin;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
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
    
    if (user != null && user.getPassword().equals(password)) {
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());

        UserLogin userLogin = new UserLogin();
        userLogin.destinationUrl = "cabinet.jsp";
        userLogin.userEmail = user.getEmail();
        String json = new Gson().toJson(userLogin);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
}
