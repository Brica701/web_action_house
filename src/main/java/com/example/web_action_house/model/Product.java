package com.example.web_action_house.model;

public class Product {
    private int productId;
    private String title;
    private String description;
    private String imgUrl;
    private double startingBid;
    private double currentBid;
    private double closingBid;
    private Category category;
    private Auction auction;

    // Constructor vacío
    public Product() {}

    // Constructor para crear producto desde el servlet (sin ID)
    public Product(String title, String description, String imgUrl,
                   double startingBid, double currentBid, double closingBid,
                   Category category, Auction auction) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.startingBid = startingBid;
        this.currentBid = currentBid;
        this.closingBid = closingBid;
        this.category = category;
        this.auction = auction;
    }

    // Constructor completo con objetos (incluye ID)
    public Product(int productId, String title, String description, String imgUrl,
                   double startingBid, double currentBid, double closingBid,
                   Category category, Auction auction) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.startingBid = startingBid;
        this.currentBid = currentBid;
        this.closingBid = closingBid;
        this.category = category;
        this.auction = auction;
    }

    // Constructor alternativo con auctionId como int (usado en DAOImpl)
    public Product(int productId, String title, String description, String imgUrl,
                   double startingBid, double currentBid, double closingBid,
                   Category category, int auctionId) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.startingBid = startingBid;
        this.currentBid = currentBid;
        this.closingBid = closingBid;
        this.category = category;
        this.auction = new Auction();
        this.auction.setAuctionId(auctionId);
    }

    // Getters y Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public double getClosingBid() {
        return closingBid;
    }

    public void setClosingBid(double closingBid) {
        this.closingBid = closingBid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    // Acceso indirecto al ID de la subasta
    public int getAuctionId() {
        return auction != null ? auction.getAuctionId() : 0;
    }

    public void setAuctionId(int auctionId) {
        if (this.auction == null) {
            this.auction = new Auction();
        }
        this.auction.setAuctionId(auctionId);
    }
}
