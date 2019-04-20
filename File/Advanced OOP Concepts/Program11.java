/* Generics - Gen<T, V> */

package mypackage;

public class Program11 {
	
	public static void main(String[] args) {
		DoubleParam<String, Integer> s = new DoubleParam<String, Integer>("before setting value", 100);
		System.out.println(s.getFirst() + " " + s.getSecond());
		s.setFirst("after setting value");
		s.setSecond(101);
		System.out.println(s.getFirst() + " " + s.getSecond());
	}
}

