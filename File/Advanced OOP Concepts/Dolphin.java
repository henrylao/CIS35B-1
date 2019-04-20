package mypackage;

public class Dolphin extends Animal implements Swimming {

	public Dolphin(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println(getName() + " says: splish splash...");
	}

	@Override
	public void swim() {
		System.out.println(getName() + ": I can swim!");
	}

}
