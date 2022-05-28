package com.example.foodhub.data.test_data;

public class CartItem {
    public String image;
    public String name;
    public String descriotion;
    public String price;


    public CartItem() {

    }

    public CartItem(String image, String name, String descriotion, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.descriotion = descriotion;
    }

}
