package com.example.web_action_house.dao;

import com.example.web_action_house.model.Auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionDAOImpl implements AuctionDAO {
    private Connection conn;

    public AuctionDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Auction findById(int id) {
        String sql = "SELECT * FROM auction WHERE auction_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Auction auction = new Auction();
                    auction.setAuctionId(id);
                    auction.setUserId(rs.getInt("user_id"));
                    auction.setTitle(rs.getString("title"));
                    auction.setStatus(rs.getInt("status"));
                    auction.setDescription(rs.getString("description"));
                    auction.setStartDate(rs.getDate("start_date"));
                    auction.setEndDate(rs.getDate("end_date"));
                    return auction;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Auction> findAll() {
        List<Auction> auctions = new ArrayList<>();
        String sql = "SELECT * FROM auction";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Auction a = new Auction();
                a.setAuctionId(rs.getInt("auction_id"));
                a.setUserId(rs.getInt("user_id"));
                a.setTitle(rs.getString("title"));
                a.setStatus(rs.getInt("status"));
                a.setDescription(rs.getString("description"));
                a.setStartDate(rs.getDate("start_date"));
                a.setEndDate(rs.getDate("end_date"));
                auctions.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auctions;
    }

    @Override
    public void update(Auction auction) {
        String sql = "UPDATE auction SET user_id = ?, title = ?, status = ?, description = ?, start_date = ?, end_date = ? WHERE auction_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, auction.getUserId());
            ps.setString(2, auction.getTitle());
            ps.setInt(3, auction.getStatus());
            ps.setString(4, auction.getDescription());
            ps.setDate(5, auction.getStartDate());
            ps.setDate(6, auction.getEndDate());
            ps.setInt(7, auction.getAuctionId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
