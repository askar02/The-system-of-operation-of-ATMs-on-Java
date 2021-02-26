package com.company.entities;

public class Trans {
    private int cards_card_number;
    private String operation;
    public Trans(){

    }

    public Trans(String operation){
        setOperation(operation);
        setCards_card_number(cards_card_number);
    }

    public Trans(int cards_card_number, String operation){
        setCards_card_number(cards_card_number);
        setOperation(operation);
    }

    public int getCards_card_number() {
        return cards_card_number;
    }

    public void setCards_card_number(int cards_card_number) {
        this.cards_card_number = cards_card_number;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}

