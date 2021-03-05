package com.company.entities;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    Scanner input = new Scanner(System.in);
    private int month;
    private int year;

    public static void checkPassword(String password) { // function which cheks the password if it is not matching with conditions outputs come message
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]3)[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            System.out.println("Your password does not match with requirements!\n Please be sure that your password\ncontains at least 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special symbol(@,$,!,^) and length more or equal to 8.");
        }
    }

    public static void idCheck(String ID) {
        char[] IDChar = ID.toCharArray();
        boolean firstPart = false;
        boolean secondPart = false;
        for (int i = 0; i < 7; ++i) {
            if ((IDChar[i] >= 48 && IDChar[i] <= 59)) {
                firstPart = true;
            }
        }
        for (int i = 0; i < 7; ++i) {
            if ((IDChar[i] >= 48 && IDChar[i] <= 59)) {
                secondPart = true;
            }
        }
        if (firstPart && secondPart && IDChar[6] == '-' && ID.length() == 12) {
            System.out.println("Your ID is correct");
        }
    }

    public static void CardNumberChecker(String[] CardNumber) {
        System.out.println("Input your card number");
        List<String> card_number = new ArrayList<String>();
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|\n" +
                "\t\t(?<mastercard>5[1-5][0-9]{14})|\n" +
                "\t\t(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|\n" +
                "\t\t(?<amex>3[47][0-9]{13})|\n" +
                "\t\t(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|\n" +
                "\t\t(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
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

    public boolean checkDate(String date) {
        String[] splitDate = date.split("/");
        int m = Integer.parseInt(splitDate[0]);
        int y = Integer.parseInt(splitDate[1]);
        if ((m > 0 && m < 13) && (y > 20 && y < 30)) {
            System.out.println("Your inspiration date is valid");
            return true;
        }
        else {
            System.out.println("Enter valid date of inspiration");
            return false;
        }
    }
}
