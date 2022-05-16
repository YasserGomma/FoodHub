package com.example.foodhub.data.source.remote;

public class User {
    private String id;
    private String email;
    private String pass;
    private String name;
    private String mobile;
    private String pic;
    private String blocked;


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPic() {
        return pic;
    }

    public String getBlocked() {
        return blocked;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }
}
