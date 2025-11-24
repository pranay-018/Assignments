
import java.util.Arrays;

class Employee {
	private int empid;
	private String empname;
	private double Salary;

	/**
	 * @param empid
	 * @param empname
	 * @param salary
	 */
	public Employee(int empid, String empname, double salary) {
		this.empid = empid;
		this.empname = empname;
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", Salary=" + Salary + "]";
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
}
