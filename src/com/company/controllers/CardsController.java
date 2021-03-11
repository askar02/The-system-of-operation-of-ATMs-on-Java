package com.company.controllers;

import com.company.entities.Cards;
import com.company.repositories.interfaces.ICardRepo;

import java.util.List;

public class CardsController {
    private final ICardRepo repo;

    public CardsController(ICardRepo repo) {
        this.repo = repo;
    }

    public String viewAllCards(int login) {//method to get all cards by login of users
        List<Cards> cardsList = repo.viewAllCards(login);
        return (cardsList == null ? "No cards found" : cardsList.toString());//return string depending on result of method in repo
    }
    public String createNewCard(int card_number, String password, String  balance, String cvv, int login ) { //method of creation new card through repo
        Cards cards = new Cards(card_number, password, balance, cvv, login);
        boolean created = repo.createNewCard(cards, login);
        return (created ? "Creation is failed try again" : "Your card is created");//return string depending on result of method in repo
    }
    public boolean getCard(int card_number, int login) {//method of getting access to a certain card through repo method
        Cards cards = repo.getCard(card_number, login);
        if (cards == null) { //return string depending on result of method in repo
            System.out.println("No card with given id is found.");
            return false;
        }
        else {
            System.out.println(cards.toString());
            return true;
        }
    }
}

