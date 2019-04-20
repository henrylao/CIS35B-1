package mypackage;

public class Duck extends Animal implements Flying, Swimming {

	public Duck(String name) {
		super(name);
	}

	@Override
	public void swim() {
		System.out.println(getName() + ": I can swim!");

	}

	@Override
	public void fly() {
		System.out.println(getName() + ": I can fly!");

	}

	@Override
	public void sound() {
		System.out.println(getName() + " says: Quack quack");

	}
}
