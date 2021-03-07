package com.company.repositories.interfaces;

import com.company.entities.Trans;

import java.util.List;

public interface ITransRepo {
    List<Trans> getAllTransInfo(int card_number);
    boolean createTransaction(Trans trans, int card_number);
}
