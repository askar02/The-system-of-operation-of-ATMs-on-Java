package com.company.entities;

public class Debts {
    private int card_number;
    private int loan_plan, loan_sum;

    public Debts(int loan_sum, int loan_plan) { //instances of Debts
        setLoan_plan(loan_plan);
        setLoan_sum(loan_sum);
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public int getLoan_plan() {
        return loan_plan;
    }

    public void setLoan_plan(int loan_plan) {
        this.loan_plan = loan_plan;
    }

    public int getLoan_sum() {
        return loan_sum;
    }

    public void setLoan_sum(int loan_sum) {
        this.loan_sum = loan_sum;
    }

    @Override
    public String toString() {
        return "Debts{" +
                ", loan_plan=" + loan_plan +
                ", loan_sum=" + loan_sum +
                '}';
    }
}