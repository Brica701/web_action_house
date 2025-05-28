package com.example.web_action_house.model;

public class Category {
    private int categoryid;
    private String title;
    private String description;

    public int getId() {
        return categoryid;
    }

    public void setCategoryId(int id) {
        this.categoryid = id;
    }

    public String getCategoryId() {
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
}
