package main;
import files.*;

public class Driver {
	public static void main(String [] args) {
		Phone obj = new SmartPhone();
		obj.show();
		
		Phone p = new Phone() 
		{	// this class is called anonymous inner class!!!!!
			public void show() {
				System.out.println("Call, sms,...");
			}
		};
		p.show();
		
		
		// this is interesting 
		PhoneInterface thePhone = ()-> System.out.println("wow wtf");
			
		
	}
}
