/* Interfaces */

package mypackage;

public class Program5 {

	public static void main(String[] args) {
	
		Parrot parrot = new Parrot("Parrot01");
		Dolphin dolphin = new Dolphin("Dolphin01");
		Duck duck = new Duck("Duck01");
	
		parrot.fly(); /* Parrot implements Flying interface, so Parrot can (must implement) fly */
		parrot.sound();
		System.out.println();
		
		dolphin.swim(); /* Dolphin implements Swimming interface, so Dolphin can (must implement) swim */
		dolphin.sound();
		System.out.println();
		
		duck.fly(); /* Duck implements both Flying and Swimming interfaces, so Duck can (must implement) both fly and swim */
		duck.swim();
		duck.sound();
		
	}
}
