package com.nov_27.nov27;

class MyCircularQueue {
	private static int front = -1;
	private static int rear = -1;
	private static int[] cq = new int[10];

	public MyCircularQueue() {
	}

	public static boolean isEmpty() {
		return (front == -1 || front > rear);
	}

	public static boolean isFull() {
		return rear == cq.length - 1;
	}
}

public class CircularQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
