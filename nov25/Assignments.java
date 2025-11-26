package com.nov_25.nov_25;

class Logger {
	private static Logger instance;

	private Logger() {
	};

	public static Logger getIntance() {
		if (instance == null) {
			return instance = new Logger();
		}
		return instance;
	}

	public void log() {
		System.out.println("logged");
	}
}

public class Assignments {

	public static void main(String[] args) {
		Logger log1 = Logger.getIntance();
		System.out.println(log1.hashCode());
		log1.log();
		Logger log2 = Logger.getIntance();
		System.out.println(log2.hashCode());
		log2.log();
	}

}
