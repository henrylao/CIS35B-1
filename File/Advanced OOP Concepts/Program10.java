/* Generics - Gen<T> */

package mypackage;

public class Program10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleParam<String> s = new SingleParam<String>("before setting value");
		System.out.println(s.getValue());
		s.setValue("after setting value");
		System.out.println(s.getValue());
	}

}
