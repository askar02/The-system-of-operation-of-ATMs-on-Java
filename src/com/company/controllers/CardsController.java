package com.company.controllers;

import com.company.entities.Cards;
import com.company.repositories.interfaces.ICardRepo;

import java.util.List;

public class CardsController {
    private final ICardRepo repo;

    public CardsController(ICardRepo repo) {
        this.repo = repo;
    }

    public String viewAllCards(int login) {
        List<Cards> cardsList = repo.viewAllCards(login);
        return (cardsList == null ? "No cards found" : cardsList.toString());
    }
    public String createNewCard(int card_number, String password, String  balance, String cvv, int login ) {
        Cards cards = new Cards(card_number, password, balance, cvv, login);
        boolean created = repo.createNewCard(cards, login);
        return (created ? "Creation is failed try again" : "Your card is created");
    }
    public boolean getCard(int card_number, int login, String password) {
        boolean access = repo.checkPassword(password, card_number);
        Cards cards = repo.getCard(card_number, login);
        if (cards == null) {
            System.out.println("No card with given id is found.");
            return false;
        }
        else {
            if (access) {
                System.out.println(cards.toString());
                return true;
            }
            else {
                System.out.println("Wrong password");
                return false;
            }
        }
    }
}

