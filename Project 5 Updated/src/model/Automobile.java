package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Automobile implements Serializable {

    private static final long serialVersionUID = 2181066470719363336L;
    private String make;
    private String model;
    private double basePrice;
    private List<OptionSet> optionSet;
    
    public Automobile(ArrayList<OptionSet> optionSet) {
        this.optionSet = new ArrayList<>(optionSet);
    }
    
    public Automobile() {
        this.optionSet = new ArrayList<OptionSet>();
    }
    
    public Automobile(String model, double basePrice) {
        this.optionSet = new ArrayList<OptionSet>();
        this.basePrice = basePrice;
        this.model = model;
    }
    
    public Automobile(String make, String model, double basePrice) {
		this.make = make;
		this.model = model;
		this.basePrice = basePrice;
		this.optionSet = new ArrayList<OptionSet>();
    }
    
    public Automobile(String model, double basePrice, ArrayList<OptionSet> optionSet) {
        this.optionSet = new ArrayList<OptionSet>(optionSet);
        this.basePrice = basePrice;
        this.model = model;
    }
    
    public synchronized String getMake() {
        return make;
    }

    public synchronized String getModel() {
        return model;
    }

    public synchronized double getBaseprice() {
        return basePrice;
    }
    
    public synchronized List<OptionSet> getOpset() {
        return optionSet;
    }
    
    public synchronized OptionSet getOpset(int index) {
        if(index < optionSet.size())
            return optionSet.get(index);
        return null;
    }
    public synchronized String getOptionChoice(String optionSetName) {
        if(findOptionSet(optionSetName).getOptionChoice() == null)
            return "None";
        return findOptionSet(optionSetName).getOptionChoice().getName();
    }
    public synchronized double getOptionChoicePrice(String optionSetName) {
        if(findOptionSet(optionSetName) == null || findOptionSet(optionSetName).getOptionChoice() == null)
            return 0d;
        return findOptionSet(optionSetName).getOptionChoice().getPrice(); 
    }
    public synchronized double getTotalPrice() {
        double totalPrice = basePrice;
        for(OptionSet optionSet: optionSet) {
            if(optionSet.getOptionChoice() != null)
                totalPrice += optionSet.getOptionChoice().getPrice();
        }
        return totalPrice;
    }
    
    public synchronized void setMake(String make) {
        this.make = make;
    }
    
    public synchronized void setModel(String model) {
        this.model = model;
    }

    public synchronized void setBaseprice(double basePrice) {
        this.basePrice = basePrice;
    }

    public synchronized void setOptionSet(String optionSetName, int size) {
        optionSet.add(new OptionSet(optionSetName, size));
    }
    
    public synchronized void setOption(String optionSet, String name, double price) {
        OptionSet optset = findOptionSet(optionSet);
        if(optset != null)
            optset.addOpt(name, price);
    }
    
    public synchronized void setOptionChoice(OptionSet optionSetName, String optionName) {
        optionSetName.setOptionChoice(optionName);
    }
    
    public synchronized OptionSet findOptionSet(String optionSetName) {
        for(int i = 0; i < optionSet.size(); i++) {
            if(optionSet.get(i).getName().equals(optionSetName))
                return optionSet.get(i);
        }
        return null;
    }
    
    public synchronized OptionSet findOption(String optionName) {
        for(int i = 0; i < optionSet.size(); i++) {
            if(optionSet.get(i).findOption(optionName) != null)
                return optionSet.get(i);
        }
        return null;
    }
    
    public synchronized void deleteOptionSet(String optionSetName) {
        OptionSet delete = findOptionSet(optionSetName);
        if(delete != null) {
            optionSet.remove(delete);
        }
        return;
    }
    
    public synchronized void deleteOption(String optionName) {
        OptionSet delete = findOption(optionName);
        if(delete != null) {
            delete.deleteOption(optionName);
        }
        return;
    }
    
    public synchronized void updateOptionSet(String optionSetName, String newOptionSetName) {
        OptionSet optionSet = findOptionSet(optionSetName);
        if(optionSet != null) {
            optionSet.setName(newOptionSetName);
        }
    }
   
    public synchronized void updateOptionValue(String optionSetName, String optionName, String newOptionName, double price) {
        OptionSet optionSet = findOptionSet(optionSetName);
        if(optionSet != null) {
            optionSet.updateOpt(optionName, newOptionName, price);
        }
    }
    
    public synchronized void updateOptionName(String optionSetName, String optionName, String newOptionName) {
        OptionSet optionSet = findOptionSet(optionSetName);
        if(optionSet != null) {
            optionSet.updateOpt(optionName, newOptionName);
        }
    }
    
    public String toString() {
        StringBuilder br = new StringBuilder();
        br.append("Automobile : \t");
        br.append(make);
        br.append("\nModel : \t");
        br.append(model);
        br.append("\nbaseprice : \t$");
        br.append(basePrice);
        br.append("\noptionset :");
        for(int i = 0; i < optionSet.size(); i++) {
            br.append("\t");
            br.append(optionSet.get(i).toString());
            br.append("\n\t");
        }
        br.append("\nCurrent Total Price = $");
        br.append(getTotalPrice());
        return br.toString();
    }
    
    public void print() {
        System.out.println(this.toString());
    }
}
