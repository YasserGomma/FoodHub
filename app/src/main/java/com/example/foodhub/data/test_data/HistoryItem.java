package com.example.foodhub.data.test_data;

public class HistoryItem {
    String name;
    String date;
    String items;
    String statue;

    float price;
    int pic;

    public HistoryItem() {

    }

    public HistoryItem(String name, String date, String items, String statue, float price, int pic) {
        this.name = name;
        this.date = date;
        this.items = items;
        this.statue = statue;
        this.price = price;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
