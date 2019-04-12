package main;
import files.PhoneInterface;
public class Driver2 {
	PhoneInterface phoneInterface = new PhoneInterface() {
		public void show() {
			System.out.println("printing from anoymous class of the interface!");
		}
	};
}
