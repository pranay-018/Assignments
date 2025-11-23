package com.simplebank.app;

import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavingAccount saving = new SavingAccount(1111, "Rohit", 5000, "Simple Bank", "Hyderabad");
        CurrentAccount current = new CurrentAccount(2222, "Anita", 8000, 2000, "Simple Bank", "Chennai");

        while (true) {
            System.out.println("\n===== Simple Banking App =====");
            System.out.println("1. Saving Account");
            System.out.println("2. Current Account");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> accountMenu(saving, sc);
                case 2 -> accountMenu(current, sc);
                case 3 -> { System.out.println("Thank You!"); return; }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    public static void accountMenu(Account acc, Scanner sc) {
        while (true) {
            System.out.println("\n--- Account Menu for: " + acc.getHolderName() + " ---");
            System.out.println(acc);
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Reset PIN");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> System.out.println("Balance: " + acc.getBalance());

                case 2 -> {
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                }

                case 3 -> {
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                }

                case 4 -> {
                    System.out.print("Enter old PIN: ");
                    int oldPin = sc.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();
                    acc.resetPin(oldPin, newPin);
                }

                case 5 -> { return; }
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}