package com.example.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(){
        try {
            userDao = new UserDaoImpl();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public User create(User t) {
        return userDao.create(t);
    }

    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public User update(User t) {
        return userDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

}
