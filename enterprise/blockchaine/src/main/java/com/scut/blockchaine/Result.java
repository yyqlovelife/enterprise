package com.scut.blockchaine;

public class Result {
    public Result(int statecode) {
        this.statecode = statecode;
    }

    private int statecode;

    public int getStatecode() {
        return statecode;
    }

    public void setStatecode(int statecode) {
        this.statecode = statecode;
    }

    public String getScore_number() {
        return score_number;
    }

    public void setScore_number(String score_number) {
        this.score_number = score_number;
    }

    private String score_number;
}
