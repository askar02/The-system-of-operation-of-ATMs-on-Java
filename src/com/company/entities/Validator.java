package com.company.entities;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    Scanner input = new Scanner(System.in);
    private int month;
    private int year;

    public boolean checkPassword(String password) { // function which cheks the password if it is not matching with conditions outputs come message
        String regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$";
        if (password.matches(regexp)) {
            return true;

        } else {
            return false;
        }
    }

    public static void idCheck(String ID) { //id checker to check is id has valid input type
        char[] IDChar = ID.toCharArray(); // array IDChar
        boolean firstPart = false; // id is divided into 2 parts and checks it separately initially it is assigned to false
        boolean secondPart = false;
        for (int i = 0; i < 7; ++i) { // loop checks first part of id
            if ((IDChar[i] >= 48 && IDChar[i] <= 59)) {
                firstPart = true;
            }
        }
        for (int i = 0; i < 7; ++i) { // loop checks second part of id
            if ((IDChar[i] >= 48 && IDChar[i] <= 59)) {
                secondPart = true;
            }
        }
        if (firstPart && secondPart && IDChar[6] == '-' && ID.length() == 12) { // if first part and second part of inputted id is valid then checker outputs following message
            System.out.println("Your ID is correct");
        }
    }

    public static void CardNumberChecker(String[] CardNumber) { // checks number of the card
        System.out.println("Input your card number");
        List<String> card_number = new ArrayList<String>(); //array list of string which checks type of card number
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|\n" +
                "\t\t(?<mastercard>5[1-5][0-9]{14})|\n" +
                "\t\t(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|\n" +
                "\t\t(?<amex>3[47][0-9]{13})|\n" +
                "\t\t(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|\n" +
                "\t\t(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$"; // regex
        Pattern pattern = Pattern.compile(regex);
        for (String card : card_number) {
            card = card.replaceAll("-", "");
            Matcher matcher = pattern.matcher(card);
            System.out.println(matcher.matches());
            if (matcher.matches()) {
                System.out.println(matcher.group());
            }
        }
    }
}
