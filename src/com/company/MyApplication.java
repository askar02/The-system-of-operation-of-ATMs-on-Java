package com.company;

import com.company.controllers.DebtsController;
import com.company.controllers.TransController;
import com.company.entities.Trans;

import java.util.Scanner;

public class MyApplication {
    private final DebtsController debtsController;
    private final TransController transController;
    private final Scanner scanner;

    public MyApplication(DebtsController debtsController, TransController transController) {
        this.debtsController = debtsController;
        this.transController = transController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Hi there!");
            System.out.println("1. Log in");
            System.out.println("2. Create an account");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int userOption = scanner.nextInt();
            if(userOption == 1) {

            }
            else if(userOption == 2) {

            }
            else {
                break;
            }
        }
        System.out.println("***************");
    }
}
