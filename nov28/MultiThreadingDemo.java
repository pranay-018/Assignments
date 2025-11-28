package com.nov_28.nov_28;

class MyThreadRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Mythread Runnable  " + Thread.currentThread().getName() + " is running");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " Runnable value : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { // checked Exception
				e.printStackTrace();
			}
		}

	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Mythread " + this.getName() + " is running");
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " value : " + i);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) { // checked Exception
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreadingDemo {

	public static void main(String[] args) {
		// about main thread
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState());
		System.out.println(Thread.currentThread().isAlive());
		System.out.println(Thread.currentThread().isDaemon());
		System.out.println(Thread.currentThread().isInterrupted());
		// using extending thread
//		MyThread t2 = new MyThread();
//		MyThread t1 = new MyThread();
//		t1.run();
//		t2.run();
		// using runnable
		Thread t3 = new Thread(new MyThreadRunnable());
		Thread t4 = new Thread(new MyThreadRunnable());
		t3.run();
		t4.run();

	}
}
