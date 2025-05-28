package com.example.web_action_house.dao;


import com.example.web_action_house.model.Auction;
import java.util.List;

public interface AuctionDAO {
    Auction findById(int id);
    boolean update(Auction auction);
}



