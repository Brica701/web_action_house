package com.example.web_action_house.dao;

import java.sql.*;
import java.time.LocalDate;

import com.example.web_action_house.model.Auction;
import com.example.web_action_house.model.Category;
import com.example.web_action_house.model.Product;
import com.example.web_action_house.model.User;

public class AuctionDAOImpl implements AuctionDAO {
    private final Connection con;

    public AuctionDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public Auction findById(int id) {
        String sql = """
            SELECT a.*, u.id as uid, u.username, u.surname
            FROM auction a
            JOIN user u ON a.user_id = u.id
            WHERE a.id = ?
        """;
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Auction a = new Auction();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setDescription(rs.getString("description"));
                a.setStartDate(rs.getDate("start_date").toLocalDate());
                a.setEndDate(rs.getDate("end_date").toLocalDate());
                a.setStatus(rs.getInt("status"));

                User u = new User();
                u.setId(rs.getInt("uid"));
                u.setUsername(rs.getString("username"));
                u.setSurname(rs.getString("surname"));
                a.setUser(u);

                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void update(Auction a) {
        String sql = "UPDATE auction SET name = ?, description = ?, start_date = ?, end_date = ?, status = ?, user_id = ? WHERE id = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, a.getName());
            st.setString(2, a.getDescription());
            st.setDate(3, Date.valueOf(a.getStartDate()));
            st.setDate(4, Date.valueOf(a.getEndDate()));
            st.setInt(5, a.getStatus());
            st.setInt(6, a.getUser().getId());
            st.setInt(7, a.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
