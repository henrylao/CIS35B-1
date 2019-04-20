package mypackage;

public class Parrot extends Animal implements Flying {
	
	public Parrot(String name){
		super(name);
	}

	@Override
	public void sound() {
		System.out.println(getName() + " says: tweet tweet...");
	}

	@Override
	public void fly() {
		System.out.println(getName() + ": I can fly!");
	}
}