package com.nov_25.nov_25;

// singleton

class DBConnection {
	private static DBConnection instance;

	private DBConnection() {
		System.out.println("instance created");
	}

	public static DBConnection getInstance() {
		if (instance != null) {
			return instance;
		}
		instance = new DBConnection();
		return instance;
	}
}

// factory Pattern 
interface Shape {
	public void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("circle is drawn");

	}

}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("rectangle is drawn");

	}

}

class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("triangle is drawn");

	}

}

class ShapesFactory {
	public static Shape getShape(String type) {
		if (type.equals("circle"))
			return new Circle();
		if (type.equals("rectangle"))
			return new Rectangle();
		if (type.equals("triangle"))
			return new Triangle();
		return null;

	}
}

// abstract factory
interface Button {
	public void click();
}

interface CheckBox {
	public void check();
}

class WinButton implements Button {

	@Override
	public void click() {
		System.out.println("windows button");

	}

}

class WinCheck implements CheckBox {

	@Override
	public void check() {
		System.out.println("windows check");

	}

}

class MacButton implements Button {
	@Override
	public void click() {
		System.out.println("mac button");

	}
}

class MacCheck implements CheckBox {

	@Override
	public void check() {
		System.out.println("Mac check");

	}

}

interface GUIFactory {
	Button createButton();

	CheckBox createCheckBox();
}

class WinFactory implements GUIFactory {

	@Override
	public Button createButton() {
		return new WinButton();
	}

	@Override
	public CheckBox createCheckBox() {
		return new WinCheck();
	}

}

class MacFactory implements GUIFactory {

	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public CheckBox createCheckBox() {
		return new MacCheck();
	}

}

// builder pattern
class Pizza {
	private String size;
	private boolean cheese;
	private boolean olives;

	private Pizza(Builder builder) {
		this.size = builder.size;
		this.cheese = builder.cheese;
		this.olives = builder.olives;
	}

	public static class Builder {

		private String size;
		private boolean cheese;
		private boolean olives;

		public Builder(String size) {
			this.size = size;
		}

		public Builder cheese(boolean cheese) {
			this.cheese = cheese;
			return this;

		}

		public Builder olives(boolean olives) {
			this.olives = olives;
			return this;
		}

		public Pizza build() {
			return new Pizza(this);
		}

	}

	@Override
	public String toString() {
		return "Builder [size=" + size + ", cheese=" + cheese + ", olives=" + olives + "]";
	}
}

abstract class DrinkMaker {
	// skeleton code . it should be same for subclasses who are extending this class
	// must be final we cannot change the prepareDrink
	public final void prepareDrink() {
		boilWater();
		makeDrink();
		addExtras();
		serve();
	}

	public void boilWater() {
		System.out.println("water boiled");
	}

	public void serve() {
		System.out.println("drink served");
	}

	abstract void makeDrink();

	abstract void addExtras();
}

class TeaMaker extends DrinkMaker {

	@Override
	void makeDrink() {
		System.out.println("making tea");
	}

	@Override
	void addExtras() {
		System.out.println("adding ginger");
	}

}

class CoffeMaker extends DrinkMaker {
	@Override
	void makeDrink() {
		System.out.println("making coffee");
	}

	@Override
	void addExtras() {
		System.out.println("adding sugar , and Ginger");
	}
}

//  bridge Pattern
abstract class VideoPlatform {
	protected ProcessingQuality quality;

	VideoPlatform(ProcessingQuality quality) {
		this.quality = quality;
	}

	abstract void playVideo();
}

interface ProcessingQuality {
	public void processQuality();
}

class HDQuality implements ProcessingQuality {

	@Override
	public void processQuality() {
		System.out.println("playing in HD mode");

	}

}

class K8Quality implements ProcessingQuality {

	@Override
	public void processQuality() {
		System.out.println("playing in 8k mode");

	}

}

class K4Quality implements ProcessingQuality {

	@Override
	public void processQuality() {
		System.out.println("playing in 4K mode");

	}

}

class PrimeVideo extends VideoPlatform {

	PrimeVideo(ProcessingQuality quality) {
		super(quality);

	}

	@Override
	public void playVideo() {
		System.out.println("playing in Prime Video");
		quality.processQuality();
	}

}

class NetflixVideo extends VideoPlatform {

	NetflixVideo(ProcessingQuality quality) {
		super(quality);

	}

	@Override
	public void playVideo() {
		System.out.println("playing in netflix Video");
		quality.processQuality();
	}

}

class YouTubeVideo extends VideoPlatform {

	YouTubeVideo(ProcessingQuality quality) {
		super(quality);

	}

	@Override
	public void playVideo() {
		System.out.println("playing in youtube Video");
		quality.processQuality();
	}

}

// proxy pattern

interface Payment {
	public void pay(double amount);
}

class CashPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("payment is done for amount : " + amount);

	}

}

class UPIPayment implements Payment {
	private CashPayment cashPayment = new CashPayment();

	@Override
	public void pay(double amount) {
		System.out.println("user is valiadated");
		System.out.println("otp entered successfully");
		System.out.println("Payment Successfull");
		cashPayment.pay(amount);
	}

}

class NetBankPayment implements Payment {
	private CashPayment cashPayment = new CashPayment();

	@Override
	public void pay(double amount) {
		System.out.println("enter the credentials");
		System.out.println("user is authenticated and login successfull");
		System.out.println("Payment Successfull");
		cashPayment.pay(amount);
	}

}

public class DesignPatternsDemo {
	public static void main(String[] args) {
		// singleton pattern
		// database connection similar for creating log files
		DBConnection dbconnection = DBConnection.getInstance();
		System.out.println(dbconnection.hashCode());
		DBConnection dbconnection2 = DBConnection.getInstance();
		System.out.println(dbconnection2.hashCode());

		// factory pattern
		Shape shape = ShapesFactory.getShape("circle");
		shape.draw();

		Shape shape2 = ShapesFactory.getShape("rectangle");
		shape2.draw();

		// abstract factory Container
		GUIFactory gUIFactory = new WinFactory();
		Button winButton = gUIFactory.createButton();
		winButton.click();
		CheckBox winCheck = gUIFactory.createCheckBox();
		winCheck.check();

		GUIFactory gUIFactory2 = new MacFactory();
		Button macButton = gUIFactory2.createButton();
		macButton.click();
		CheckBox macCheck = gUIFactory2.createCheckBox();
		macCheck.check();

		// Builder pattern
		Pizza pizza = new Pizza.Builder("medium").cheese(true).olives(false).build();
		System.out.println(pizza);

		// template pattern

		DrinkMaker tea = new TeaMaker();
		tea.prepareDrink();
		DrinkMaker coffee = new CoffeMaker();
		coffee.prepareDrink();

		// bridge Patttern
		VideoPlatform primeHD = new PrimeVideo(new HDQuality());
		primeHD.playVideo();

		VideoPlatform prime4K = new PrimeVideo(new K4Quality());
		primeHD.playVideo();

		VideoPlatform netflix8K = new NetflixVideo(new K8Quality());
		primeHD.playVideo();
		
		// proxy pattern
		Payment upi = new UPIPayment();
		upi.pay(2000);
		
		Payment netBank = new NetBankPayment();
		netBank.pay(210000);

	}

}
