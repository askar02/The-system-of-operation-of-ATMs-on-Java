package com.company.repositories.interfaces;

import com.company.entities.Cards;
import java.util.List;

public interface ICardRepo {
    List<Cards> viewAllCards(int login);
    boolean createNewCard(Cards cards, int login);
    Cards getCard(int cardNumber, int login);
    boolean checkPassword(String password, int cardNumber);
}
