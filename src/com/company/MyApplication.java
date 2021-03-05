package com.company;

import com.company.controllers.CardsController;
import com.company.controllers.DebtsController;
import com.company.controllers.TransController;
import com.company.controllers.UserController;
import com.company.entities.Trans;

import java.util.Scanner;

public class MyApplication {
    private final DebtsController debtsController;
    private final TransController transController;
    private final UserController userController;
    private final CardsController cardsController;
    private final Scanner scanner;

    public MyApplication(DebtsController newDebtsController, TransController newTransController, CardsController newCardsController, UserController newUserController) {
        this.cardsController = newCardsController;
        this.userController = newUserController;
        this.debtsController = newDebtsController;
        this.transController = newTransController;
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
                userLogInMenu();
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
        int login = scanner.nextInt();
        System.out.println(userController.registration(login, fname, lname, birth_date));
    }
    public void userLogInMenu() {
        System.out.print("Enter your password: ");
        String password = scanner.next();
        System.out.print("Enter your login: ");
        int login = scanner.nextInt();
        boolean loggedIn = userController.logIn(login, password);
        System.out.println(loggedIn ? cardApplication(login) : "Access denied. Try again");
    }
    public void cardApplication(int login) {
        while (true) {
            System.out.println();
            System.out.println("1. View all cards.");
            System.out.println("2. Add new card.");
            System.out.println("0. Return to the main menu.");
            System.out.print("Choose an option 0-2: ");
            int cardOption = scanner.nextInt();
            if (cardOption == 1) {

            }
            else if(cardOption == 2) {

            }
            else {
                break;
            }
        }
    }
    public void viewAllCardsMenu() {

    }
}
