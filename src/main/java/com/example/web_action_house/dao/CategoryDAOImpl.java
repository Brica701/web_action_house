package com.example.web_action_house.dao;


import com.example.web_action_house.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private final Connection con;

    public CategoryDAOImpl() {
        this.con = con;
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement("SELECT * FROM category");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
