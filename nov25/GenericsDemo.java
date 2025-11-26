package com.nov_25.nov_25;

import java.util.Arrays;

class Container<T> {
	private T item;

	/**
	 * @param item
	 */
	public Container(T item) {
		this.item = item;
	}

	public Container() {
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

}

class Student {
	private int id;
	private String studname;

	/**
	 * @param id
	 * @param studname
	 */
	public Student(int id, String studname) {
		this.id = id;
		this.studname = studname;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studname=" + studname + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudname() {
		return studname;
	}

	public void setStudname(String studname) {
		this.studname = studname;
	}

}

class UserPair<K, V> {
	private K first;
	private V second;

	public UserPair() {

	}

	public UserPair(K first, V second) {
		this.first = first;
		this.second = second;
	}

	public K getFirst() {
		return first;
	}

	@Override
	public String toString() {
		return "UserPair [first=" + first + ", second=" + second + "]";
	}

	public V getSecond() {
		return second;
	}

}

class Order<T> {
	private T orderId;

	/**
	 * @param orderId
	 */
	public Order(T orderId) {
		this.orderId = orderId;
	}

	public Order() {

	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + "]";
	}

	public T getOrderId() {
		return orderId;
	}

	public void setOrderId(T orderId) {
		this.orderId = orderId;
	}

}

class OrderItems<ID, T> {
	private ID orderItemId;
	private T ItemName;

	/**
	 * @param orderItemId
	 * @param itemName
	 */
	public OrderItems(ID orderItemId, T itemName) {
		this.orderItemId = orderItemId;
		ItemName = itemName;
	}

	public ID getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(ID orderItemId) {
		this.orderItemId = orderItemId;
	}

	public T getItemName() {
		return ItemName;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", ItemName=" + ItemName + "]";
	}

	public void setItemName(T itemName) {
		ItemName = itemName;
	}

	public OrderItems() {
	}

}

class ArrayPrinter<T> {
	private T[] arr;

	public ArrayPrinter(T[] arr) {
		this.arr = arr;
		printArray();
	}

	public void printArray() {
		for (T n : this.arr) {
			System.out.println(n);
		}
	}
}

public class GenericsDemo {

	public static void main(String[] args) {
		Container<String> fruit = new Container<String>(); // for this you must have default constructor or else you
															// get error
		fruit.setItem("Apple");
		System.out.println(fruit.getItem());

		Container<Integer> number = new Container();
		number.setItem(25);
		System.out.println(number.getItem());

		Container<Student> studentContainer = new Container();
		Student s = new Student(101, "pranay");
		studentContainer.setItem(s);
		System.out.println(studentContainer.getItem());

		int[] arr = { 5, 6, 9, 2, 0 };
		Container<int[]> arrayContainer = new Container();
		arrayContainer.setItem(arr);
		System.out.println(Arrays.toString(arrayContainer.getItem()));

		UserPair<Integer, Integer>[] cordinates = new UserPair[5];
		for (int i = 0; i < 5; i++) {
			cordinates[i] = new UserPair(i, i * 5);
		}
		for (UserPair pair : cordinates) {
			System.out.println(pair.getFirst() + "--->" + pair.getSecond());

		}

		UserPair<Order<Integer>, OrderItems<Integer, String>[]>[] myOrders = new UserPair[5];
		for (int i = 0; i < 5; i++) {
			Order o = new Order(101 + i);
			OrderItems<Integer, String>[] myOrderItems = new OrderItems[i + 1];
			for (int j = 0; j <= i; j++) {
				String orderName = "orderItem  " + i + " " + j;
				myOrderItems[j] = new OrderItems(201 + i + j, orderName);
			}
			myOrders[i] = new UserPair(o, myOrderItems);
		}

		for (UserPair myorder : myOrders) {
			System.out.println(myorder.getFirst() + "-->");
			for (OrderItems orderItems : (OrderItems<Integer, String>[]) myorder.getSecond()) {
				System.out.println(orderItems.getOrderItemId());
				System.out.println(orderItems.getItemName());

			}
			System.out.println();
		}
		Integer[] nums = { 1, 2, 3, 6, 4 };
		String[] strs = { "raju", "ramu", "anu", "abhi" };
		ArrayPrinter<Integer> arrayPrinter = new ArrayPrinter(nums);

		ArrayPrinter<String> stringPrinter = new ArrayPrinter(strs);
		int[] nums2 = { 1, 2, 3 };
//		ArrayPrinter<int> numsPrinter = new ArrayPrinter(nums); --> error because Primitive arrays cannot be used as T[] (T[] is in ArrayPrinter Class).
//		how to call primitive arrays 
//		class ArrayPrinter {
//		    public static void print(int[] arr) {
//		        for (int n : arr) System.out.println(n);
//		    }
//
//		    public static <T> void print(T[] arr) {
//		        for (T n : arr) System.out.println(n);
//		    }
//		}
//		Arrayprinter.print(nums2); // using funtion overloading

		display("hello");
		add(4, 5);

	}

	public static <T> void display(T data) {
		System.out.println(data);
	}

//	public static <,U> void add(T t,U u){
//		System.out.println(t+u); // error --> since + operation not works for the  objects when we pass so we need to use lower bound and upper bound
//	}
	public static <T extends Number, U extends Number> void add(T t, U u) {
		System.out.println(t.intValue() + u.intValue());
	}

}
