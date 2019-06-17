
package client;

import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;


public class SelectCarOptions {

	////////// PROPERTIES //////////
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static ObjectOutputStream out;
	@SuppressWarnings("unused")
	private Automobile a1;

	////////// CONSTRUCTORS //////////
	public SelectCarOptions() {
		
	}
	public SelectCarOptions(ObjectOutputStream o) {
		out = o;
	}

	////////// INSTANCE METHODS //////////

	public void configureAuto(Object obj ) {
  		Automobile a = (Automobile) obj;
		boolean next = false;
		for(int i = 0; i < a.getOptionSetSize(); i++) {
			do {
				System.out.println(("Choice one option:\n"+a.printOneSet(i)));
				try {
					int temp = Integer.parseInt(in.readLine()) - 1;
					if(a.setOptionChoice(i, temp)) {
						next = true;
					}else {
						System.out.println("Invalid input!\nTry again!");
					}
				}catch(Exception e) {
					System.out.println("Invalid input!");
				}
				System.out.println();
			}while(next == false);
			next = false;
		}
		System.out.println(a.printChoices());
		
		System.out.println(a.getTotalPrice());
	}
	
	public void sendOut(Object obj) {
		try {
			out.writeObject(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isAutomobile(Object obj) {
		boolean isAutomobile = false;

		try {
			a1 = (Automobile) obj;
			isAutomobile = true;
		}
		catch (ClassCastException e) {
			isAutomobile = false;
		}

		return isAutomobile;
	}

}
