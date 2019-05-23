package scale;

import adapter.ProxyAutomobile;

public class EditOptions extends ProxyAutomobile implements Runnable {
    private String model;
    private String optionSetName;
    private String newOptionSetName;
    private String optionName;
    private String newOptionName;
    private Double newValue;
    
    public EditOptions(String model, String name, String newName) {
        this.model = model;
        this.optionSetName = name;
        this.newOptionSetName = newName;
        this.optionName = null;
        this.newOptionName = null;
        this.newValue = null;
    }
    
    public EditOptions(String model, String optionSetName, String optionName, String newOptionName) {
        this.model = model;
        this.optionSetName = optionSetName;
        this.newOptionSetName = null;
        this.optionName = optionName;
        this.newOptionName = newOptionName;
        this.newValue = null;
    }
    
   public EditOptions(String model, String optionSetName, String optionName, double newValue) {
        this.model = model;
        this.optionSetName = optionSetName;
        this.newOptionSetName = null;
        this.optionName = optionName;
        this.newOptionName = null;
        this.newValue = newValue;
    }
    
    public void run() {
        
        if(newOptionSetName != null) {
            updateOptionSetName(model, optionSetName, newOptionSetName);
            newOptionSetName = null;
        } else if(newOptionName != null) {
            updateOptionName(model, optionSetName, optionName, newOptionName);
            newOptionName = null;
        } else if(newValue != null) {
            updateOptionPrice(model, optionSetName, optionName, newValue);
            newValue = null;
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
