//============================================================================
//Project     : Lab4
//Name        : EditOption.java
//Author      : Tianqi Yang
//Time        : 5/6/2019
//IDE         : Eclipse
//Description : it implements Runnable which edit the option of Automobile
//============================================================================
package scale;

import adapter.ProxyAutomobile;
import model.Automobile;

public class EditOptions extends ProxyAutomobile implements Runnable{
	int x;
	Automobile a1;
	private String model;
    private String optionSetName;
    private String newOptionSetName;
    private String optionName;
    private String newOptionName;
    private float newPrice;
	public EditOptions(int x, String m, String name, String newName) {
		this.x = x;
    	model = m;
    	optionSetName = name;
        newOptionSetName = newName;
        optionName = null;
        newOptionName = null;
        newPrice = -1;
    }
    
    public EditOptions(int x, String m, String osn, String on, String non) {
    	this.x = x;
		model = m;
        optionSetName = osn;
        newOptionSetName = null;
        optionName = on;
        newOptionName = non;
        newPrice = -1;
    }
    
    public EditOptions(int x, String m, String osn, String on, float nv) {
    	this.x = x;
		model = m;
        optionSetName = osn;
        newOptionSetName = null;
        optionName = on;
        newOptionName = null;
        newPrice = nv;
    }
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started ");
		switch (x) {
		case 0://newOptionSetName
			 updateOptionSetName(model, optionSetName, newOptionSetName);
	         break;
		case 1://newOptionName
			 updateOptionName(model, optionSetName, optionName, newOptionName);
			 break;
		case 2://newPrice
			updateOptionPrice(model, optionSetName, optionName, newPrice);
			break;
		}
		System.out.println(Thread.currentThread().getName() + " completed.\nPrint result:");
		this.printAuto(model);
		System.out.println("");
	}
	
	public void randomWait() {
		try {
			Thread.sleep((long)(1000*Math.random()));
		} catch(InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}
}
