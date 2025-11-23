package com.simplebank.app;

public class SavingAccount extends Account {

    public SavingAccount(long accNo, String holderName, double balance, String bankName, String bankBranch) {
        super(accNo, holderName, balance, bankName, bankBranch);
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Saving Account: Withdrawal successful. New Balance: " + getBalance());
        } else {
            System.out.println("Saving Account: Insufficient Balance.");
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Saving Account: Deposit successful. New Balance: " + getBalance());
    }
}