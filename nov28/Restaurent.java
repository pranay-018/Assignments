package com.nov_28.nov_28;

class Chef extends Thread {
	private final String[] orders; // if not assigned in final initilization then we must pass the final values
									// through the constructors

	public Chef(String... orders) { // passing multi values
		this.orders = orders;
	}

	@Override
	public void run() {
		for (String item : orders) {
			System.out.println(this.getName() + " is preparing");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(this.getName() + " interuped ");
			}
			System.out.println(this.getName() + " served " + item);
		}
	}
}

public class Restaurent {
	public static void main(String[] args) {
		try {
			Chef c1 = new Chef("hyd biryani", "chicken");
			Chef c2 = new Chef("fried Rice", "fish Curry");
			Chef c3 = new Chef("mutton", "rice");
			Chef c4 = new Chef("biryani", "chicken curry", "curd rice");

			c1.setName("chef1");
			c1.setName("chef2");
			c1.setName("chef3");
			c1.setName("chef4");

			c1.start();
			c2.start();
			c3.start();
			c4.start();

			c1.join(); // throws InterupatedException checkedException
			c2.join();
			c3.join();
			c4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
