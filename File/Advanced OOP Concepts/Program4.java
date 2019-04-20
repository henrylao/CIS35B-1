/* Abstract methods and classes */

package mypackage;

public class Program4 {
	public static void main(String[] args) {
		Shape s;
		
		//s = new Shape(); /* illegal declaration, Shape is an abstract class and cannot be instantiated */
		
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		
		s = circle;
		s.draw();
		
		s = rectangle;
		s.draw();
	}
}
