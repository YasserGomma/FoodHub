package com.example.foodhub.data.models;

import java.util.ArrayList;

public class RestaurantItem {
    int image;
    float rate;
    int numberOfPeople;
    int deliveryPrice;
    String  deliverytime;
    ArrayList<String> popularItems;
    String name;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public ArrayList<String> getPopularItems() {
        return popularItems;
    }

    public void setPopularItems(ArrayList<String> popularItems) {
        this.popularItems = popularItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

    public RestaurantItem(int image, float rate, int numberOfPeople, int deliveryPrice, ArrayList<String> popularItems, String name, String  deliverytime) {
        this.image = image;
        this.rate = rate;
        this.numberOfPeople = numberOfPeople;
        this.deliveryPrice = deliveryPrice;
        this.popularItems = popularItems;
        this.name = name;
        this.deliverytime=deliverytime;
    }
}
