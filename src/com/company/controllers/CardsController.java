package com.company.controllers;

import com.company.entities.Cards;
import com.company.repositories.interfaces.ICardRepo;

import java.util.List;

public class CardsController {
    private final ICardRepo repo;

    public CardsController(ICardRepo repo) {
        this.repo = repo;
    }

    public String viewAllCards() {
        List<Cards> CardsList = repo.viewAllCards();
        return (CardsList == null ? "No cards found" : CardsList.toString());
    }
    public String createNewCard(int card_number, String password, String  balance, int cvv, int login ) {
        Cards cards = new Cards(card_number, password, balance, cvv, login);
        boolean created = repo.createNewCard(cards);
        return (created ? "Your card is created" : "Creation is failed try again");
    }
    public boolean getCard(int card_number) {
        Cards cards = repo.getCard(card_number);
        if (cards == null) {
            System.out.println("No card with given id is found.");
            return false;
        }
        else {
            System.out.println(cards.toString());
            return true;
        }
    }
}

