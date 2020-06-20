package com.scut.blockchain.Pojo;

public class Trans {
    public Trans(int transid, String user_name, String time, String detail, String score_change) {
        this.transid = transid;
        this.user_name = user_name;
        this.time = time;
        this.detail = detail;
        this.score_change = score_change;
    }

    private int transid;

    public int getTransid() {
        return transid;
    }

    public void setTransid(int transid) {
        this.transid = transid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getScore_change() {
        return score_change;
    }

    public void setScore_change(String score_change) {
        this.score_change = score_change;
    }

    private String user_name;
    private String time;
    private String detail;
    private String score_change;
}
