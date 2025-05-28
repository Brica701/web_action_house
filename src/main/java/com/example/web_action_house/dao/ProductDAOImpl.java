package com.example.web_action_house.dao;

import com.example.web_action_house.model.Category;
import com.example.web_action_house.model.Product;
import com.example.web_action_house.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private final Connection con;

    public ProductDAOImpl() {
        this.con = con;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = """
            SELECT p.*, c.id as cat_id, c.name as cat_name, u.id as u_id, u.username, u.surname
            FROM product p
            JOIN category c ON p.category_id = c.id
            JOIN user u ON p.user_id = u.id
        """;
        try (PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setImageUrl(rs.getString("image_url"));
                p.setStartBid(rs.getDouble("start_bid"));
                p.setCurrentBid(rs.getDouble("current_bid"));
                p.setEndDate(rs.getDate("end_date").toLocalDate());

                Category c = new Category();
                c.setId(rs.getInt("cat_id"));
                c.setName(rs.getString("cat_name"));
                p.setCategory(c);

                User u = new User();
                u.setId(rs.getInt("u_id"));
                u.setUsername(rs.getString("username"));
                u.setSurname(rs.getString("surname"));
                p.setUser(u);

                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void save(Product p) {
        String sql = "INSERT INTO product (name, description, image_url, start_bid, current_bid, end_date, category_id, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, p.getName());
            st.setString(2, p.getDescription());
            st.setString(3, p.getImageUrl());
            st.setDouble(4, p.getStartBid());
            st.setDouble(5, p.getStartBid()); // current_bid = start_bid al inicio
            st.setDate(6, Date.valueOf(p.getEndDate()));
            st.setInt(7, p.getCategory().getId());
            st.setInt(8, p.getUser().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findByUsername(String username) {
        List<Product> products = new ArrayList<>();
        String sql = """
            SELECT p.*, c.id as cat_id, c.name as cat_name, u.id as u_id, u.username, u.surname
            FROM product p
            JOIN category c ON p.category_id = c.id
            JOIN user u ON p.user_id = u.id
            WHERE u.username LIKE ?
        """;
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, "%" + username + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setImageUrl(rs.getString("image_url"));
                p.setStartBid(rs.getDouble("start_bid"));
                p.setCurrentBid(rs.getDouble("current_bid"));
                p.setEndDate(rs.getDate("end_date").toLocalDate());

                Category c = new Category();
                c.setId(rs.getInt("cat_id"));
                c.setName(rs.getString("cat_name"));
                p.setCategory(c);

                User u = new User();
                u.setId(rs.getInt("u_id"));
                u.setUsername(rs.getString("username"));
                u.setSurname(rs.getString("surname"));
                p.setUser(u);

                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Object[]> countProductsByCategory() {
        List<Object[]> resumen = new ArrayList<>();
        String sql = """
            SELECT c.name, COUNT(*) as total
            FROM product p
            JOIN category c ON p.category_id = c.id
            GROUP BY c.name
        """;
        try (PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                resumen.add(new Object[]{ rs.getString("name"), rs.getInt("total") });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumen;
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


