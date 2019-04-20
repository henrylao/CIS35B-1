/* Anonymous inner class */

package mypackage;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Employees {
	
	private String[] employees;
	
	public Employees(String[] employees){
		this.employees = employees;
	}
	
	Enumeration<String> getEnumeration() {
		return new Enumeration<String>() {
			int element = 0;

			public boolean hasMoreElements() {
				return element < employees.length;
			}

			public String nextElement() {
				if (hasMoreElements())
					return employees[element++];
				else
					throw new NoSuchElementException();
			}
		};
	}
}
