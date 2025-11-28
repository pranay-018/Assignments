package com.nov_27.nov27;

class MyQueueArr {
	private static int front = -1;
	private static int rear = -1;
	private static int[] queue = new int[10];
	private static int counter = 0;

	MyQueueArr() {
	}

	public static boolean isEmpty() {
		if (front > rear)
			return true;
		return front == -1;

	}

	public static void push(int num) {
		if (rear == queue.length) {
			System.out.println("queue is full");
			return;
		}
		queue[++rear] = num;

		if (front == -1) {
			front = 0;
		}
	}

	public static void front() {
		if (!isEmpty()) {
			System.out.println(queue[front]);
		} else {
			System.out.println("queue is Empty");
		}
	}

	public static void rear() {
		if (!isEmpty()) {
			System.out.println(queue[rear]);
		} else {
			System.out.println("queue is Empty");
		}
	}

	public static void pop() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return;
		}
		System.out.println(queue[front]);
		counter--;
		front++;
		if (front > rear) {
			front = -1;
			rear = -1;
		}
	}

	public static void display() {
		for (int i = front; i <= rear; i++) {
			System.out.println(queue[i]);
		}
	}

}

public class QueueDemo {
	public static void main(String[] args) {
		MyQueueArr.push(10);
		MyQueueArr.push(20);
		MyQueueArr.push(30);
		MyQueueArr.push(40);
		MyQueueArr.display();
		MyQueueArr.pop();
		System.out.println();
		MyQueueArr.display();
		MyQueueArr.pop();
		MyQueueArr.pop();
		System.out.println();
		MyQueueArr.display();
		MyQueueArr.pop();
		MyQueueArr.display();
		MyQueueArr.pop();

	}
}
