package com.nov_28.nov_28;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChefES extends Thread {
	private String order;

	public ChefES(String order) {
		this.order = order;
	}

	@Override
	public void run() {
		System.out.println(getName() + "  is preparing " + order);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(this.getName() + " interuped ");
		}
		System.out.println(" item is served " + order);
	}

	public static void main(String[] args) {
		ExecutorService manager = Executors.newFixedThreadPool(4);

		String[] menu = { "hyd biryani", "chicken", "fried Rice", "fish Curry", "mutton", "rice" };
		for (String item : menu) {
			ChefES chefThread = new ChefES(item);
			manager.submit(chefThread);
		}
		manager.shutdown();
	}

}
