package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils{
    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "09062005i";
    private static String URL = "jdbc:mysql://localhost:3306/shop";

    public static Connection openConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
    }
}