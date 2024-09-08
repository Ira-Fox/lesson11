package com.example.dao.impl;

import com.example.dao.BucketDao;
import com.example.domain.Bucket;
import com.example.utils.ConnectionUtils;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class BucketDaoImpl implements BucketDao{

    private static String READ_ALL = "SELECT * FROM bucket";
    private static String CREATE = "INSERT INTO bucket(user_id, product_id, purchase_date) VALUES (?, ?, ?)";
    private static String READ_BY_ID = "SELECT * FROM bucket WHERE id = ?";
    private static String DELETE_BY_ID = "DELETE FROM bucket WHERE id = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketDaoImpl() throws ClassNotFoundException, SQLException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public Bucket create(Bucket bucket){
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                bucket.setId(rs.getInt(1));
            }
            System.out.println(bucket.toString());
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bucket;
    }

    @Override
    public Bucket read(Integer id){
        Bucket bucket = null;

        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            int bucketId = result.getInt("id");
            int userId = result.getInt("user_id");
            int productId = result.getInt("product_id");
            java.util.Date purchaseDate = result.getDate("purchase_date");

            bucket = new Bucket(bucketId, userId, productId, purchaseDate);
            System.out.println(bucket.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bucket;
    }

    @Override
    public Bucket update(Bucket t){
        throw new IllegalStateException("there is no update for bucket");
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
    public List<Bucket> readAll(){
        List<Bucket> list = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            
            System.out.println("---------- Bucket ----------");
            while (result.next()) { 
                int bucketId = result.getInt("id");
                int userId = result.getInt("user_id");
                int productId = result.getInt("product_id");
                java.util.Date purchaseDate = result.getDate("purchase_date");
    
                Bucket bucket = new Bucket(bucketId, userId, productId, purchaseDate);
                list.add(bucket);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
}
