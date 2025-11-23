package com.simplebank.app;

public abstract class Account {
    private long accNo;
    private String holderName;
    private double balance;
    private int pin;
    private String bankName;
    private String bankBranch;

    public Account(long accNo, String holderName, double balance, String bankName, String bankBranch) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.pin = generatePin();
    }

    private int generatePin() {
        return (int)(Math.random() * 9000) + 1000;
    }

    public int getPin() { return pin; }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void resetPin(int oldPin, int newPin) {
        if (verifyPin(oldPin)) {
            this.pin = newPin;
            System.out.println("PIN reset successful!");
        } else {
            System.out.println("Incorrect old PIN. PIN reset failed.");
        }
    }

    public long getAccNo() { return accNo; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    protected void setBalance(double bal) { this.balance = bal; }
    public String getBankName() { return bankName; }
    public String getBankBranch() { return bankBranch; }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    @Override
    public String toString() {
        return "Account No: " + accNo +
               ", Name: " + holderName +
               ", Bank: " + bankName +
               ", Branch: " + bankBranch +
               ", Balance: " + balance +
               ", PIN: " + pin;
    }
}
