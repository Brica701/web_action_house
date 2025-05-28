package com.example.web_action_house.dao;

import com.example.web_action_house.model.Category;
import com.example.web_action_house.model.Product;
import com.example.web_action_house.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> findAllWithCategoryAndUser() {
        List<Product> list = new ArrayList<>();
        String sql = """
            SELECT p.*, c.title AS category_title, u.username, a.end_date 
            FROM product p
            JOIN category c ON p.category_id = c.category_id
            LEFT JOIN auction a ON p.auction_id = a.auction_id
            LEFT JOIN user u ON a.user_id = u.user_id
        """;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setImgUrl(rs.getString("img_url"));
                product.setStartingBid(rs.getBigDecimal("starting_bid"));
                product.setCurrentBid(rs.getBigDecimal("current_bid"));
                product.setClosingBid(rs.getBigDecimal("closing_bid"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setAuctionId(rs.getInt("auction_id"));
                product.setCategoryTitle(rs.getString("category_title"));
                product.setUsername(rs.getString("username"));
                product.setAuctionEndDate(rs.getDate("end_date"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insert(Product product) {
        String sql = "INSERT INTO product (title, description, img_url, starting_bid, category_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getTitle());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getImgUrl());
            stmt.setBigDecimal(4, product.getStartingBid());
            stmt.setInt(5, product.getCategoryId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object[]> countProductsByCategory() {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT c.title, COUNT(*) AS count FROM product p JOIN category c ON p.category_id = c.category_id GROUP BY c.title";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = new Object[2];
                row[0] = rs.getString("title");
                row[1] = rs.getInt("count");
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> searchByUsername(String username) {
        List<Product> list = new ArrayList<>();
        String sql = """
            SELECT p.*, c.title AS category_title, u.username, a.end_date 
            FROM product p
            JOIN category c ON p.category_id = c.category_id
            LEFT JOIN auction a ON p.auction_id = a.auction_id
            LEFT JOIN user u ON a.user_id = u.user_id
            WHERE u.username LIKE ?
        """;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + username + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("product_id"));
                    product.setTitle(rs.getString("title"));
                    product.setDescription(rs.getString("description"));
                    product.setImgUrl(rs.getString("img_url"));
                    product.setStartingBid(rs.getBigDecimal("starting_bid"));
                    product.setCurrentBid(rs.getBigDecimal("current_bid"));
                    product.setClosingBid(rs.getBigDecimal("closing_bid"));
                    product.setCategoryId(rs.getInt("category_id"));
                    product.setAuctionId(rs.getInt("auction_id"));
                    product.setCategoryTitle(rs.getString("category_title"));
                    product.setUsername(rs.getString("username"));
                    product.setAuctionEndDate(rs.getDate("end_date"));
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}



