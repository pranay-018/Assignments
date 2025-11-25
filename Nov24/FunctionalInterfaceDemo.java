
interface StringInterface {
	public void startsWithA(String[] names);
}

interface EmployeeInterface {
	public Employee[] addBonus(Employee[] emp);
}

interface ValidatePassword {
	public boolean validatePassword(String password);
}

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		String[] names = { "anu", "raju", "arya", "gokul", "ramu" };
		StringInterface stringInterface = (String[] namess) -> {
			for (String s : namess) {
				if (s.startsWith("a")) {
					System.out.println(s);
				}
			}
		};
		stringInterface.startsWithA(names);
		Employee e1 = new Employee(101, "pranay", 12000);
		Employee e2 = new Employee(102, "Raj", 10000);
		Employee e3 = new Employee(103, "Rahul", 24000);
		Employee e4 = new Employee(105, "Rakesh", 19000);
		Employee e5 = new Employee(100, "Abhi", 14000);
		Employee[] employess = { e1, e2, e3, e4, e5 };
		EmployeeInterface employeeInterface = (Employee[] emps) -> {
			for (Employee e : emps) {
				e.setSalary(e.getSalary() + 2000);
			}
			return emps;
		};
		Employee[] addedBounusemps = employeeInterface.addBonus(employess);
		for (Employee ee : addedBounusemps) {
			System.out.println(ee);
		}
		String password = "Pranay@18";
		ValidatePassword validatePassword = (String pass) -> {
			String reqPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s]).{8,}$";
			if (pass.matches(reqPassword)) {
				return true;
			}
			return false;
		};
		System.out.println(validatePassword.validatePassword(password));

	}

}
