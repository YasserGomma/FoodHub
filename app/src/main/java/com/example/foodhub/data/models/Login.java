package com.example.foodhub.data.models;

public class Login {
    private String id;
    private String pass;
    private String type;
    private String method;


    // Getter Methods

    public Login(String id, String pass, String type, String method) {
        this.id = id;
        this.pass = pass;
        this.type = type;
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    // Setter Methods

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
