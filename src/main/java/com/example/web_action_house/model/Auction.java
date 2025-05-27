package com.example.web_action_house.model;

import java.sql.Date;

public class Auction {
    private int auctionId;
    private int userId;
    private String title;
    private int status;
    private String description;
    private Date startDate;
    private Date endDate;

    public Auction() {}

    public Auction(int auctionId, int userId, String title, int status, String description, Date startDate, Date endDate) {
        this.auctionId = auctionId;
        this.userId = userId;
        this.title = title;
        this.status = status;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters y Setters
    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
