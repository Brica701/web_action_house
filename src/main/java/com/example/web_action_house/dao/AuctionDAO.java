package com.example.web_action_house.dao;


import com.example.web_action_house.model.Auction;

public interface AuctionDAO {
    Auction findById(int id);
    void update(Auction auction);
}


