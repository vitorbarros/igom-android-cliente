package com.segurityapp.igom.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Client extends Entity{

    @SerializedName("_id")
    private String _id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("creditCard")
    private ArrayList creditCard;

    @SerializedName("address")
    private ArrayList address;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(ArrayList creditCard) {
        this.creditCard = creditCard;
    }

    public ArrayList getAddress() {
        return address;
    }

    public void setAddress(ArrayList address) {
        this.address = address;
    }
}
