package com.example.dao;

import com.example.domain.User;
import com.example.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User>{
    User getUserByEmail(String email);
}