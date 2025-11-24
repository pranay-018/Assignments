package com.nov25.NOV25;

public class StaticMethodReferenceDemo {

	static class NumberUtil {
		public static int squareNum(int num) {
			return num * num;
		}
	}

	public static Double getLog(int num) {
		return Math.log10(num);
	}

	public static boolean isEven(int num) {
		return num % 2 == 0;
	}

	static class StringUtil {
		public static int findLength(String str) {
			return str.length();
		}
	}

}
