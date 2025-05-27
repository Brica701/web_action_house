package com.example.web_action_house.dao;

import com.example.web_action_house.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    void save(Product product);
}
