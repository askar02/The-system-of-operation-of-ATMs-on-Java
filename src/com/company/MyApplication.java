package com.company;

import com.company.controllers.CardsController;
import com.company.controllers.DebtsController;
import com.company.controllers.TransController;
import com.company.controllers.UserController;
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
            try {
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
            catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
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
        System.out.print("Enter your login: ");
        int userLogin = scanner.nextInt();
        System.out.println(userController.registration(userLogin, fname, lname, birth_date));
    }
    public void userLogInMenu() {
        System.out.print("Enter your login: ");
        int login = scanner.nextInt();
        boolean loggedIn = userController.logIn(login);
        if (loggedIn) {
            cardApplication(login);
        }
        else {
            System.out.println("Access denied. Try again");
        }
    }
    public void cardApplication(int userLogin) {
        while (true) {
            System.out.println();
            System.out.println("1. View all cards.");
            System.out.println("2. Add new card.");
            System.out.println("3. Pick card by id.");
            System.out.println("0. Return to the main menu.");
            try {
                System.out.print("Choose an option 0-3: ");
                int cardOption = scanner.nextInt();
                if (cardOption == 1) {
                    viewAllCardsMenu(userLogin);
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
            catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
        }
    }
    public void viewAllCardsMenu(int login) {
        System.out.println(cardsController.viewAllCards(login));
    }
    public void createNewCardMenu(int userLogin) {
        System.out.print("Enter the card number: ");
        int cardNumber = scanner.nextInt();
        System.out.print("Enter card password: ");
        String password = scanner.next();
        System.out.print("Enter cvv: ");
        String cvv = scanner.next();
        System.out.print("Enter card balance: ");
        String balance = scanner.next();
        String response = cardsController.createNewCard(cardNumber, password, balance, cvv, userLogin);
        System.out.println(response);
    }
    public void getCardMenu(int userLogin) {
        System.out.print("Enter card number: ");
        int cardNumber = scanner.nextInt();
        boolean response = cardsController.getCard(cardNumber, userLogin);
        if (response) {
            transApplication(cardNumber);
        }
    }

    public void transApplication(int cardNumber) {
        while (true) {
            System.out.println();
            System.out.println("1. View history of transactions");
            System.out.println("2. Make new transaction");
            System.out.println("3. View debts");
            System.out.println("4. Take new loan");
            System.out.println("0. Return to card menu");
            System.out.print("Select the option 0-4: ");
            int transOption = scanner.nextInt();
            if (transOption == 1) {
                viewAllTransInfoMenu(cardNumber);
            }
            else if (transOption == 2) {
                newTransMenu(cardNumber);
            }
            else if(transOption == 3) {
                viewAllLoansMenu(cardNumber);
            }
            else if (transOption == 4) {
                newLoanMenu(cardNumber);
            }
            else {
                break;
            }
        }
    }
    public void viewAllTransInfoMenu(int card_number) {
        String response = transController.getAllTransInfo(card_number);
        System.out.println(response);
    }
    public void viewAllLoansMenu(int cardNumber) {
        String response = debtsController.getAllLoans(cardNumber);
        System.out.println(response);
    }
    public void newTransMenu(int card_number) {
        System.out.print("Set date of transaction: ");
        String date = scanner.next();
        System.out.print("Set the type of transaction: ");
        String type = scanner.next();
        System.out.print("Set the sum of transaction: ");
        int sum = scanner.nextInt();
        String response = transController.createTransaction(sum, date, type, card_number);
        System.out.println(response);
    }
    public void newLoanMenu(int card_number) {
        System.out.print("Set the sum of your loan: ");
        int loan_sum = scanner.nextInt();
        System.out.print("Set the plan of your loan, how long are you going to pay for it? ");
        int loan_plan = scanner.nextInt();
        String response = debtsController.takeLoan(loan_sum, loan_plan, card_number);
        System.out.println(response);
    }
 }
