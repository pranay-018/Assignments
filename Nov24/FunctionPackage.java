package com.nov25.NOV25;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionPackage {
	public static void main(String[] args) {

		int a = 89;
		int b = 600;
		Supplier<Integer> maxNumber = () -> {
			return a > b ? a : b;
		};
		System.out.println(maxNumber.get());

		Consumer<Integer> squareConsumer = (num1) -> { // note consumer takes only one arguments
			System.out.println(num1 * num1);
		};
		squareConsumer.accept(8);

		Consumer<int[]> sortNumbers = (arr) -> { // must pass generic as int[] since we are passing array
			Arrays.sort(arr);
		};
		int[] arr = { 1, 2, 7, 9, 3, 4 };
		sortNumbers.accept(arr);
		System.out.println(Arrays.toString(arr));

		Employee e1 = new Employee(101, "pranay", 12000);
		Employee e2 = new Employee(102, "Raj", 10000);
		Employee e3 = new Employee(103, "Rahul", 24000);
		Employee e4 = new Employee(105, "Rakesh", 19000);
		Employee e5 = new Employee(100, "Abhi", 14000);

		Employee[] employees = { e1, e2, e3, e4, e5 };
		Consumer<Employee[]> printName = (employeess) -> { // argument name should be different from original array name
			for (Employee e : employeess) {
				System.out.println(e.getEmpname());
			}
		};
		printName.accept(employees);

		Predicate<Integer> isEven = (n) -> n % 2 == 0;
		System.out.println(isEven.test(90));

		Predicate<String> isLengthGreaterThan7 = (name) -> name.length() > 7;
		System.out.println(isLengthGreaterThan7.test("pranay reddy"));

		Predicate<Employee[]> checkSal = (employee_array) -> {
			for (Employee e : employee_array) {
				if (e.getSalary() > 20000)
					return true;
			}
			return false;
		};
		System.out.println(checkSal.test(employees) ? "has greater than 20000" : "No");

		Function<Employee[], Double> getSumSalary = (employee_array) -> {
			Double sum = 0.0;
			for (Employee e : employee_array) {
				sum += e.getSalary();
			}
			return sum;
		};

		System.out.println(getSumSalary.apply(employees));
		
		 
	}
}
