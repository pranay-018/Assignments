package com.nov_26.nov26;

final class Person {
	private final String name;
	private final int pid;

	public String getName() {
		return name;
	}

	public int getPid() {
		return pid;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", pid=" + pid + "]";
	}

	/**
	 * @param name
	 * @param pid
	 */
	public Person(String name, int pid) {
		this.name = name;
		this.pid = pid;
	}

}

public class ImmutableClass {
	public static void main(String[] args) {
		Person p1 = new Person("pranay", 101);
		System.out.println(p1);
	}
}
