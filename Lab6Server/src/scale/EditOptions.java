//============================================================================
//Project     : Lab5
//Name        : EditOption.java
//Author      : Tianqi Yang
//Time        : 5/29/2019
//IDE         : Eclipse
//Description : it implements Runnable which edit the option of Automobile
//============================================================================
package scale;

import adapter.ProxyAutomobile;
import model.AutoLHM;
import model.Automobile;

public class EditOptions extends ProxyAutomobile implements Runnable{
	int x;
	int threadno;
	private String model;
    private String optionSetName;
    private String newOptionSetName;
    private String optionName;
    private String newOptionName;
    private float newPrice;
    private Thread t;
	private AutoLHM<Automobile> auto;

	public EditOptions(int x, String m, String name, String newName) {
		this.x = x;
		threadno = x;
    	model = m;
    	optionSetName = name;
        newOptionSetName = newName;
        optionName = null;
        newOptionName = null;
        newPrice = -1;
        t = new Thread(this);
        auto = getAutoLHM(); 
    }

	public EditOptions(int x, String m, String osn, String on, String non) {
    	this.x = x;
		threadno = x;
		model = m;
        optionSetName = osn;
        newOptionSetName = null;
        optionName = on;
        newOptionName = non;
        newPrice = -1;
        t = new Thread(this);
        auto = getAutoLHM();
    }
    
    public EditOptions(int x, String m, String osn, String on, float nv) {
    	this.x = x;
		threadno = x;
		model = m;
        optionSetName = osn;
        newOptionSetName = null;
        optionName = on;
        newOptionName = null;
        newPrice = nv;
        t = new Thread(this);
        auto = getAutoLHM();
    }
    
    public void run() {
    	System.out.println("Start thread " + threadno );
		ops();
		System.out.println("\nStopping thread " + threadno);
	}
    
	public void ops() {
		//System.out.println(Thread.currentThread().getName() + " started ");
		switch (x) {
		//synchronized
		case 0://newOptionSetName
			 HelperEdit h0 = new HelperEdit();
			 h0.helpEditOptionSetName(auto, model, optionSetName, newOptionSetName);
	         break;
		case 1://newOptionName
			 HelperEdit h1 = new HelperEdit();
			 h1.helpEditOptionName(auto, model, optionSetName, optionName, newOptionName);
			 break;
		case 2://newPrice
			HelperEdit h2 = new HelperEdit();
			h2.helpEditOptionPrice(auto, model, optionSetName, optionName, newPrice);
			break;
		//non synchronized 
		case 3://newOptionName
			HelperEdit h3 = new HelperEdit();
			h3.nosyn_helpEditOptionName(auto, model, optionSetName, optionName, newOptionName);
			break;
		case 4://newPrice
			HelperEdit h4 = new HelperEdit();
			h4.nosyn_helpEditOptionPrice(auto,model, optionSetName, optionName, newPrice);
			break;
		}
//		System.out.println(Thread.currentThread().getName() + " completed.\nPrint result:");
//		this.printAuto(model);
//		System.out.println("");
	}

	public void start() {
		t.start();		
	}
}
