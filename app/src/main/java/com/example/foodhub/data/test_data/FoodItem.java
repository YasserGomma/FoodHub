package com.example.foodhub.data.test_data;

public class FoodItem {
    int image;
    String name;

    public FoodItem(String name, int image) {
        this.image = image;
        this.name = name;
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
}
