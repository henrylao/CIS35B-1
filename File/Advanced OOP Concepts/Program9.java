/* Anonymous inner class */

package mypackage;

import java.util.Enumeration;

public class Program9 {
	public static void main (String[] args) {
		
		String[] listEmployees = {"John", "Bob", "Mike", "Susan", "Jason", "Sarah"};
		
		Employees e = new Employees(listEmployees);
		
		Enumeration<String> enumeration = e.getEnumeration();
		
		// Enumerating through list of employees
		while(enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
	}
}
