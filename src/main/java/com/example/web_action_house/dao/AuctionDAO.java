package com.example.web_action_house.dao;

import com.example.web_action_house.model.Auction;

import java.util.List;

public interface AuctionDAO {
    Auction findById(int id);
    List<Auction> findAll();
    void update(Auction auction);
}

