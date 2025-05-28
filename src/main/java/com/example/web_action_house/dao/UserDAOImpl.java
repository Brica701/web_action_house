package com.example.web_action_house.dao;



import com.example.web_action_house.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final Connection con;

    public UserDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement("SELECT * FROM user");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setSurname(rs.getString("surname"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

