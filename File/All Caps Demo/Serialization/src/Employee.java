import java.io.*;

public class Employee implements Serializable {
	
	private String name;
	private double salary;
	private Day hireDay;
	
	public Employee(String n, double s, Day d) {
		this.name = n;
		this.salary = s; 
		this.hireDay = d;
	}
	
	public Employee() {}
	
	public void print() {
		System.out.println(name + " " + salary + " " + hireYear() );

	}
	public int hireYear() {
		return hireDay.getYear();
	}

}
