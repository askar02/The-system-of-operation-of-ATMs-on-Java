package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.CardRepository;
import com.company.repositories.DebtsRepo;
import com.company.repositories.TransRepo;
import com.company.repositories.UsersRepo;
import com.company.repositories.interfaces.ICardRepo;
import com.company.repositories.interfaces.IDebtsRepo;
import com.company.repositories.interfaces.ITransRepo;
import com.company.repositories.interfaces.IUsersRepo;


public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        ICardRepo cardsRepo = new CardRepository(db);
        IUsersRepo usersRepo = new UsersRepo(db);
        ITransRepo transRepo = new TransRepo(db);
        IDebtsRepo debtsRepo = new DebtsRepo(db);
        MyApplication app = new MyApplication(debtsRepo,transRepo,cardsRepo,usersRepo);
        app.start();

    }
}