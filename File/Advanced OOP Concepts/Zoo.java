package mypackage;

import java.util.List;

public class Zoo {
	public void hearAnimals(List<? extends Animal> animals){
		for (Animal a:animals)
		{
			a.sound();
		}
	}
}
