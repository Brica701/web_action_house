package com.example.web_action_house.dao;


import com.example.web_action_house.model.Product;

import java.util.List;
import java.util.List;

public interface ProductDAO {
    List<Product> findAllWithCategoryAndUser();
    boolean insert(Product product);
    List<Object[]> countProductsByCategory();
    List<Product> searchByUsername(String username);
}

