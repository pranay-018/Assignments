package com.nov_27.nov27;

class Node {
	private int data;
	private Node next;

	Node() {
	}

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	Node(int data, Node node) {
		this.data = data;
		this.next = node;
	}

	public Node getNext() {
		return next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}

class MyStackLL {
	private static Node top;

	public static boolean isEmpty() {
		return top == null;
	}

	public static Node createNode(int data) {
		return new Node(data);
	}

	public static void push(int data) {
		Node newNode = createNode(data);
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
	}

	public static Node top() {
		if (isEmpty()) {
			System.out.println("stack underflow");
			return null;
		}
		return top;
	}

	public static void pop() {
		if (isEmpty()) {
			System.out.println("stack underflow");
			return;
		}
		System.out.println(top.getData());
		Node deletedNode = top; // if we don't create temp node then dangling pointer happens
		top = top.getNext();
		deletedNode.setNext(null);

	}

}

class MyStackArray {
	private static int top = -1;
	private static int[] arr = new int[10];

	/**
	 * @param top
	 */
	public MyStackArray() {
	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == arr.length;
	}

	public static void push(int num) {
		if (isFull()) {
			System.out.println("stack overflow");
		}
		arr[++top] = num;
	}

	public static void pop() {
		if (!isEmpty()) {
			System.out.println(arr[top--]);
			return;

		}
		System.out.println("stack underflow");
	}

	public static int peek() {
		if (isEmpty()) {
			System.out.println("stack overflow");
			return -1;
		}
		return arr[top];
	}

}

public class StackDemo {

	public static void main(String[] args) {
//		MyStackArray.push(23);
//		MyStackArray.push(40);
//		System.out.println(MyStackArray.peek());
//		MyStackArray.pop();
//		System.out.println(MyStackArray.peek());
//		MyStackArray.pop();
//		System.out.println(MyStackArray.peek());
		MyStackLL.push(10);
		MyStackLL.push(20);
		MyStackLL.push(40);
		System.out.println(MyStackLL.top().getData());
		MyStackLL.pop();
		System.out.println(MyStackLL.top().getData());
		MyStackLL.pop();
		System.out.println(MyStackLL.top().getData());
		MyStackLL.pop();
		try {
			System.out.println(MyStackLL.top().getData());
		} catch (Exception e) {
			System.out.println();
		}

	}

}
