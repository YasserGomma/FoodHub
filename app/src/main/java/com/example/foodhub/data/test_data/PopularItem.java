package com.example.foodhub.data.test_data;

public class PopularItem {
    String name;
    String Description;
    float price;
    float rate;
    int nummberOfPeople;
    int image;

    public PopularItem(String name, String description, int image, float price, float rate, int nummberOfPeople) {
        this.name = name;
        Description = description;
        this.price = price;
        this.rate = rate;
        this.nummberOfPeople = nummberOfPeople;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNummberOfPeople() {
        return nummberOfPeople;
    }

    public void setNummberOfPeople(int nummberOfPeople) {
        this.nummberOfPeople = nummberOfPeople;
    }
}
