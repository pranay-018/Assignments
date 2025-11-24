package com.nov25.NOV25;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.nov25.NOV25.StaticMethodReferenceDemo.NumberUtil;
import com.nov25.NOV25.StaticMethodReferenceDemo.StringUtil;

public class MethodReferencesDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "pranay", 12000);
		Employee e2 = new Employee(102, "Raj", 10000);
		Employee e3 = new Employee(103, "Rahul", 24000);
		Employee e4 = new Employee(105, "Rakesh", 19000);
		Employee e5 = new Employee(100, "Abhi", 14000);
		Employee[] employess = { e1, e2, e3, e4, e5 };
		// static method references
		// ClassName::methodName
		Function<Integer, Integer> squareFunctionUsingLambda = (num) -> {
			return NumberUtil.squareNum(num);
		};

		Function<Integer, Integer> squareFunctionUsingMR = NumberUtil::squareNum;

		System.out.println(squareFunctionUsingLambda.apply(10));
		System.out.println(squareFunctionUsingMR.apply(8));

		Function<Integer, Double> getLogByLambda = (num) -> StaticMethodReferenceDemo.getLog(num);

		Function<Integer, Double> getLogByMR = StaticMethodReferenceDemo::getLog;

		System.out.println(getLogByLambda.apply(20));
		System.out.println(getLogByMR.apply(20));

		Predicate<Integer> isEvenByLambda = (num) -> StaticMethodReferenceDemo.isEven(num);
		Predicate<Integer> isEvenByMR = StaticMethodReferenceDemo::isEven;

		System.out.println(isEvenByLambda.test(90));
		System.out.println(isEvenByMR.test(31));

		Supplier<Integer> findlengthLambda = () -> {
			String name = "pranay reddy";
			return StringUtil.findLength(name);
		};

		System.out.println(findlengthLambda.get());

//		Supplier<Integer> findlengthMR= StringUtil::findLength // not working doubt

		// object method references
		// objName::methodName
		String myName = "Pranay ";
		Supplier<Integer> lengthUsingLambda = () -> myName.length();

		System.out.println(lengthUsingLambda.get());

		Supplier<Integer> lengthUsingMR = myName::length;

		System.out.println(lengthUsingMR.get());

		ObjectMethodReferencesDemo hello = new ObjectMethodReferencesDemo();
		Supplier<String> sayHelloLambda = () -> {
			return hello.sayHello();
		};
		Supplier<String> sayHelloMR = hello::sayHello;
		System.out.println(sayHelloLambda.get());
		System.out.println(sayHelloMR.get());

		int[] arr = { 5, 6, 9, 2, 4, 0 };
		Consumer<int[]> printMR = hello::printNum;
		System.out.println(Arrays.toString(arr));
		
		
		

	}

}
