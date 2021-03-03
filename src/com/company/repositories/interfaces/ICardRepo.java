package com.company.repositories.interfaces;

import com.company.entities.Cards;

import javax.smartcardio.Card;
import java.util.List;

public interface ICardRepo {
    List<Cards> viewAllCards();
    boolean createNewCard(Cards cards);


}
