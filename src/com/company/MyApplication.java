package com.company;

import com.company.controllers.CardsController;
import com.company.controllers.DebtsController;
import com.company.controllers.TransController;
import com.company.controllers.UserController;
import com.company.entities.Trans;
import com.company.repositories.interfaces.ICardRepo;
import com.company.repositories.interfaces.IDebtsRepo;
import com.company.repositories.interfaces.ITransRepo;
import com.company.repositories.interfaces.IUsersRepo;

import java.util.Scanner;

public class MyApplication {
    private final DebtsController debtsController;
    private final TransController transController;
    private final UserController userController;
    private final CardsController cardsController;
    private final Scanner scanner;

    public MyApplication(IDebtsRepo debtsRepo, ITransRepo transRepo, ICardRepo cardRepo, IUsersRepo usersRepo) {
        cardsController = new CardsController(cardRepo);
        debtsController = new DebtsController(debtsRepo);
        transController = new TransController(transRepo);
        userController = new UserController(usersRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Hi there!");
            System.out.println("1. Log in");
            System.out.println("2. Create an account");
            System.out.println("0. Exit");
            System.out.print("Choose an option 0-2: ");
            int userOption = scanner.nextInt();
            if(userOption == 1) {
                userLogInMenu();
            }
            else if(userOption == 2) {
                userRegistrationMenu();
            }
            else {
                break;
            }
        }
        System.out.println("***************");
    }
    public void userRegistrationMenu() {
        System.out.print("Enter your first name: ");
        String fname = scanner.next();
        System.out.print("Enter your last name: ");
        String lname = scanner.next();
        System.out.print("Enter your birth date: ");
        String birth_date = scanner.next();
        System.out.print("Enter your IIN as login: ");
        int userLogin = scanner.nextInt();
        System.out.println(userController.registration(userLogin, fname, lname, birth_date));
    }
    public void userLogInMenu() {
        System.out.print("Enter your password: ");
        String password = scanner.next();
        System.out.print("Enter your login: ");
        int login = scanner.nextInt();
        boolean loggedIn = userController.logIn(login, password);
        System.out.println(loggedIn ? cardApplication(login) : "Access denied. Try again");
    }
    public void cardApplication(int userLogin) {
        while (true) {
            System.out.println();
            System.out.println("1. View all cards.");
            System.out.println("2. Add new card.");
            System.out.println("3. Pick card by id.");
            System.out.println("0. Return to the main menu.");
            System.out.print("Choose an option 0-3: ");
            int cardOption = scanner.nextInt();
            if (cardOption == 1) {
                viewAllCardsMenu();
            }
            else if(cardOption == 2) {
                createNewCardMenu(userLogin);
            }
            else if (cardOption == 3) {
                getCardMenu(userLogin);
            }
            else {
                break;
            }
        }
    }
    public void viewAllCardsMenu() {
        System.out.println(cardsController.viewAllCards());
    }
    public void createNewCardMenu(int userLogin) {
        System.out.print("Enter the card number: ");
        int cardNumber = scanner.nextInt();
        System.out.print("Enter card password: ");
        String password = scanner.next();
        System.out.print("Enter cvv: ");
        int cvv = scanner.nextInt();
        System.out.println("Enter card balance: ");
        String balance = scanner.next();
        String response = cardsController.createNewCard(cardNumber, password, balance, cvv, userLogin);
        System.out.println(response);
    }
    public void getCardMenu(int userLogin) {
        System.out.print("Enter card number: ");
        int cardNumber = scanner.nextInt();
        boolean response = cardsController.getCard(cardNumber);
        System.out.println(response?transApplication(userLogin, cardNumber):"");
    }

    public void transApplication(int userLogin, int cardNumber) {

    }
}
