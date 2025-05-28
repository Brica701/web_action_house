package com.example.web_action_house.dao;


import com.example.web_action_house.model.Auction;
import util.DBUtil;

import java.sql.*;

public class AuctionDAOImpl implements AuctionDAO {

    @Override
    public Auction findById(int id) {
        Auction auction = null;
        String sql = "SELECT * FROM auction WHERE auction_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    auction = new Auction();
                    auction.setAuctionId(rs.getInt("auction_id"));
                    auction.setUserid(rs.getInt("user_id"));
                    auction.setTitle(rs.getString("title"));
                    auction.setStatus(rs.getInt("status"));
                    auction.setDescription(rs.getString("description"));
                    auction.setStartDate(rs.getDate("start_date"));
                    auction.setEndDate(rs.getDate("end_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auction;
    }

    @Override
    public boolean update(Auction auction) {
        String sql = "UPDATE auction SET user_id=?, title=?, status=?, description=?, start_date=?, end_date=? WHERE auction_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, auction.getUserId());
            stmt.setString(2, auction.getTitle());
            stmt.setInt(3, auction.getStatus());
            stmt.setString(4, auction.getDescription());
            stmt.setDate(5, auction.getStartDate());
            stmt.setDate(6, auction.getEndDate());
            stmt.setInt(7, auction.getAuctionId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

