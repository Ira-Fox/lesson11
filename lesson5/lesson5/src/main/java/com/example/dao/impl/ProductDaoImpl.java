package com.example.dao.impl;

import com.example.dao.ProductDao;
import com.example.domain.Product;
import com.example.utils.ConnectionUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private static String READ_ALL = "SELECT * FROM product";
    private static String CREATE = "INSERT INTO product(name, description, price) VALUES(?, ?, ?)";
    private static String READ_BY_ID = "SELECT * FROM product WHERE id = ?";
    private static String UPDATE_BY_ID = "UPDATE product SET name = ?, description = ?, price = ? WHERE id = ?";
    private static String DELETE_BY_ID = "DELETE FROM product WHERE id = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public ProductDaoImpl() throws ClassNotFoundException, SQLException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public Product create(Product product){
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                product.setId(rs.getInt(1));
            }
            System.out.println(product.toString());
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product read(Integer id){
        Product product = null;

        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            int productId = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            float price = result.getFloat("price");

            product = new Product(productId, name, description, price);
            System.out.println(product.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product product){
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(Integer id){
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> readAll(){
        List<Product> list = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            
            System.out.println("---------- Product ----------");
            while (result.next()) { 
                int productId = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                float price = result.getFloat("price");

                Product product = new Product(productId, name, description, price);
                list.add(product);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
}
