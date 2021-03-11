package com.company.entities;

public class Trans {
    private int card_number, sum; //variable
    private String date, type; //variable

    public Trans(String date, String type, int sum){ //trans method
        setDate(date);
        setType(type);
        setSum(sum);
    }


    public int getSum() {
        return sum;
    } //Method, which returns sum of transaction

    public void setSum(int sum) {
        this.sum = sum;
    } //Method, which changes the sum of transaction


    public String getDate() {
        return date;
    } //Method, which returns date of transaction

    public void setDate(String date) {
        this.date = date;
    } //Method, which changes the date of transaction

    public String getType() {
        return type;
    } //Method, which returns type of transaction

    public void setType(String type) {
        this.type = type;
    } //Method, which changes the type of transaction

    public int getCard_number() {
        return card_number;
    } //Method, which returns card_number of transaction

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    } //Method, which changes the card_number of transaction

    @Override
    public String toString() {
        return "Trans{" +
                ", sum=" + sum +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

