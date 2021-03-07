package com.company.entities;

public class Trans {
    private int card_number, sum;
    private String date, type;

    public Trans(String date, String type, int sum){
        setDate(date);
        setType(type);
        setSum(sum);
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    @Override
    public String toString() {
        return "Trans{" +
                ", sum=" + sum +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

