package com.company.repositories.interfaces;

import com.company.entities.Cards;
import java.util.List;

public interface ICardRepo {// interface of Card repository List in java provides the facility to maintain the ordered collection
    List<Cards> viewAllCards(int login); // viewAllCards is the menu by which user can see all the cards if user have any with access in face of login
    boolean createNewCard(Cards cards, int login); //createNewCard is the menu by which user can create new card or cards by parameters cards and login
    Cards getCard(int cardNumber, int login); //getCard is the menu by which user can choose card by card's number and login
}
