package com.example.foodhub.data.test_data;

public class CartItem {
    int image;
    String name;
    String descriotion;
    float price;


    public CartItem() {

    }

    public CartItem(int image, String name, String descriotion, float price) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.descriotion = descriotion;
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

    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }
}
