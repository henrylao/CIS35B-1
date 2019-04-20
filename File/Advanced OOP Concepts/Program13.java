package mypackage;

import java.util.ArrayList;
import java.util.List;

public class Program13 {
	public static void main(String[] args) {
		Zoo z = new Zoo();
		
		Parrot parrot = new Parrot("Parrot01");
		Dolphin dolphin = new Dolphin("Dolphin01");
		Duck duck = new Duck("Duck01");
		
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(parrot);
		animals.add(dolphin);
		animals.add(duck);
		
		System.out.println("Hearing sounds from a list of Animals");
		z.hearAnimals(animals);
		
		System.out.println();
		
		Duck duck2 = new Duck("Duck02");
		Duck duck3 = new Duck("Duck03");
		
		List<Duck> ducks = new ArrayList<Duck>();
		ducks.add(duck);
		ducks.add(duck2);
		ducks.add(duck3);
		
		System.out.println("Hearing sounds from a list of Ducks");
		z.hearAnimals(ducks); /* Using the wildcard in Zoo now allows method hearAnimals to take a List of any class that extends Animal) */ 
	}
}
