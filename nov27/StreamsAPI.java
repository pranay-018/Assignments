package com.nov_27.nov27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
	private int sid;
	private String sname;
	private int marks;
	private int age;

	public Student() {
	}

	/**
	 * @param sid
	 * @param sname
	 */
	public Student(int sid, String sname, int marks, int age) {
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.marks = marks;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", age=" + age + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}

public class StreamsAPI {

	public static void main(String[] args) {
		Integer[] arr1 = { 34, 67, 90, 23, 58, 12, 59, 23, 30, 82 };
		Arrays.stream(arr1).forEach(System.out::println);
		List<Integer> iList = Arrays.stream(arr1).collect(Collectors.toList());
		System.out.println(iList);
		Integer mini = Arrays.stream(arr1).min((a, b) -> a - b).get();
		System.out.println(mini);
		// we can also find minimum
		mini = Arrays.stream(arr1).min(Integer::compare).get();
		System.out.println(mini);

		long count = Arrays.stream(arr1).count();
		System.out.println(count);

		// sum of array reduce
		int sum = Arrays.stream(arr1).reduce(0, (a, b) -> a - b);
		System.out.println(sum);
		System.out.println(Arrays.stream(arr1).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b));
		System.out.println(Arrays.stream(arr1).reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b));

		// intermediate operation
		System.out.println("intermediate");
		Stream.of(arr1).filter(num -> num % 2 == 0).forEach(System.out::println); // must pass predicate in filter
		System.out.println("map");
		Stream.of(arr1).map(num -> num + 10).forEach(System.out::println);
		// limit
		Stream.of(arr1).limit(5).forEach(System.out::println);
		// distinct
		Stream.of(arr1).distinct().forEach(System.out::println);

		System.out.println("distinct and count");
		System.out.println(Stream.of(arr1).distinct().count());

		// skip
		Stream.of(arr1).skip(2).forEach(System.out::println);

		System.out.println("Any match");
		System.out.println(Stream.of(arr1).anyMatch(num -> num == 91));
		System.out.println(Stream.of(arr1).allMatch(num -> num < 100));
		System.out.println(Stream.of(arr1).noneMatch(num -> num > 100)); // nothing is greater than 100 then return
																			// true;
		// find first
		System.out.println(Stream.of(arr1).filter(num -> num > 40).findFirst().get()); // first number that is greater
																						// than 40

		Integer[] nums = { 23, 45, 23, 1, 3, 8, 56, 3, 421, 546, 34, 3, 27 };
		List<Integer> numList = Arrays.asList(nums);
		numList.stream().filter(num -> num % 3 == 0).distinct().skip(2).limit(2).forEach(System.out::println);
//		Stream.of(nums).filter(num -> num%3 == 0).distinct().forEach(System.out::println));
//		Stream.of(numList).filter(num -> num % 3 == 0).distinct().forEach(System.out::println); // error since num in stream is List not Integer so we can't perform % operation or arthimetic operation
		numList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		String[] names = { "pranay", "raju", "anu", "padmalatha", "arjun" };
		Stream.of(names).filter(s -> s.length() >= 5).forEach(System.out::println);
//		names.streams().filter().forEach() -->error since we can't have streams function for String function
		Arrays.stream(names).filter(s -> s.length() > 5).forEach(System.out::println);
		Arrays.stream(names).filter(s -> s.length() > 5).filter(s -> s.endsWith("a")).forEach(System.out::println);

		// user defined streams
		List<Student> stuList = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			stuList.add(new Student(100 + i, "raju" + i, i % 2 == 0 ? 70 + i : 60 - i,
					i % 3 == 0 ? 20 + i + 3 : 25 - i - 3));
		}
		stuList.add(new Student(123, "pranay", 56, 27));
		stuList.forEach(System.out::println);
		System.out.println();
		stuList.stream().filter(student -> student.getAge() > 20).forEach(System.out::println);
		System.out.println();
		stuList.stream().filter(student -> student.getMarks() % 2 == 0)
				.sorted((emp1, emp2) -> emp1.getSname().compareTo(emp2.getSname())).forEach(System.out::println);

	}

}
