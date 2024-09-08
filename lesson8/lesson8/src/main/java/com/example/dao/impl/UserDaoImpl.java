package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao{
    private static String READ_ALL = "SELECT * FROM user";
    private static String CREATE = "INSERT INTO user(email, firstName, lastName, role, password) VALUES(?, ?, ?, ?, ?)";
    private static String READ_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static String UPDATE_BY_ID = "UPDATE user SET email = ?, firstName = ?, lastName = ?, role = ?, password = ? WHERE id = ?";
    private static String DELETE_BY_ID = "DELETE FROM user WHERE id = ?";
    private static String READ_BY_EMAIL = "SELECT * FROM user WHERE email = ?";

    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws ClassNotFoundException, SQLException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public User create(User user){
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            System.out.println(user.toString());
            rs.close();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User read(Integer id){
        User user = null;

        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            int userId = result.getInt("id");
            String email = result.getString("email");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String role = result.getString("role");
            String password = result.getString("password");

            user = new User(userId, email, firstName, lastName, role, password);
            System.out.println(user.toString());

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User update(User user){
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public void delete(Integer id){
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<User> readAll(){
        List<User> list = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            
            System.out.println("---------- User ----------");
            while (result.next()) { 
                int userId = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String role = result.getString("role");
                String password = result.getString("password");

                User user = new User(userId, email, firstName, lastName, role, password);
                list.add(user);
            }
        } catch (SQLException e) {
            
            LOGGER.error(e);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer userId = result.getInt("id");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String role = result.getString("role");
			String password = result.getString("password");
			user = new User(userId, email, firstName, lastName, role, password);

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;
    }
}
