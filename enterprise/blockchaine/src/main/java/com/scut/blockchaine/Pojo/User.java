package com.scut.blockchain.Pojo;

import javax.annotation.concurrent.Immutable;

public class User {
    public User(int uid, String name, String password, String tel_number, String card_number, String address) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.tel_number = tel_number;
        this.card_number = card_number;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int uid;
    private String name;
    private String password;
    private String tel_number;
    private String card_number;
    private String address;
}
