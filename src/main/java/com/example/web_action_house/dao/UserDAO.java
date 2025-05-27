package com.example.web_action_house.dao;

import com.example.web_action_house.model.User;

import java.util.List;

public interface UserDAO {
    User findById(int id);
    List<User> findAll();
}

