package com.nov_28.nov_28;

public class BankAccount {
	private double balance = 15000;

	public void withDraw(double amount) {
		System.out.println(Thread.currentThread().getName() + "  is running ");
		synchronized (this) {

			if (amount > balance)
				System.out.println("insufficient Funds");
			else {

				System.out.println(Thread.currentThread().getName() + " is doing withdraw operation ");
				balance -= amount;
				System.out.println("remainig balance : " + balance);

			}
		}
	}

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		Runnable r = () -> {
			account.withDraw(1000);
		};
		Thread t1 = new Thread(r, "user1");
		Thread t2 = new Thread(r, "user2");
		t2.start();
		t1.start();

		

	}
}
