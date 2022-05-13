package com.example.foodhub.data.models;

public class AddsItem {
    int image;
    String name;
    float price;

    public AddsItem() {

    }

    public AddsItem(int image, String name, float price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
