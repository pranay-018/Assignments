package com.simplebank.app;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(long accNo, String holderName, double balance, double overdraftLimit, String bankName, String bankBranch) {
        super(accNo, holderName, balance, bankName, bankBranch);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Current Account: Withdrawal successful. New Balance: " + getBalance());
        } else {
            System.out.println("Current Account: Overdraft Limit Exceeded.");
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Current Account: Deposit successful. New Balance: " + getBalance());
    }
}