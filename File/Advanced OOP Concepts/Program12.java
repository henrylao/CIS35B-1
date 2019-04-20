/* Generics - Gen<T extends V> */

package mypackage;

public class Program12 {

	public static void main(String[] args) {
		//ExtendsParam<String> s = new ExtendsParam<String>("before setting value"); /* This does not compile because T value ExtendsParam class is bounded*/
		ExtendsParam<Number> e = new ExtendsParam<Number>(100);
		System.out.println(e.getValue());
		e.setValue(101);
		System.out.println(e.getValue());
	}
}
