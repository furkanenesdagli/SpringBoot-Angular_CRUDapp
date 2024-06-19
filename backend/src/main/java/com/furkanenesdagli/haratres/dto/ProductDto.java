package com.furkanenesdagli.haratres.dto;


public class ProductDto {
    private Long id;
    private String name;
    private int price;
    private int stock;
    private int reviewpoint;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getReviewpoint() {
        return reviewpoint;
    }

    public void setReviewpoint(int reviewpoint) {
        this.reviewpoint = reviewpoint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}