package com.example.web_action_house.dao;

import com.example.web_action_house.model.Category;
import com.example.web_action_house.model.Product;
import com.example.web_action_house.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private Connection conn;

    public ProductDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productos = new ArrayList<>();
        String sql = "SELECT p.*, c.title AS category_title, u.username AS username " +
                "FROM product p " +
                "JOIN category c ON p.category_id = c.category_id " +
                "JOIN auction a ON p.auction_id = a.auction_id " +
                "JOIN user u ON a.user_id = u.user_id";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category categoria = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_title"),
                        null
                );

                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));

                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("img_url"),
                        rs.getDouble("starting_bid"),
                        rs.getDouble("current_bid"),
                        rs.getDouble("closing_bid"),
                        categoria,
                        rs.getInt("auction_id")
                );
                productos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO product (title, description, img_url, starting_bid, current_bid, closing_bid, category_id, auction_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getTitle());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getImgUrl());
            ps.setDouble(4, product.getStartingBid());
            ps.setDouble(5, product.getCurrentBid());
            ps.setDouble(6, product.getClosingBid());
            ps.setInt(7, product.getCategory().getCategoryId());
            ps.setInt(8, product.getAuctionId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

