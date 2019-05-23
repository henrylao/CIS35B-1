package model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable {
    
    private static final long serialVersionUID = 4950072331096985781L;
    private ArrayList<Option> option;
    private String name;
    private Option choise;  

    protected OptionSet(ArrayList<Option> opt) {
        this.option = new ArrayList<Option>(opt);
    }
    
    protected OptionSet(String name, int size) {
        option = new ArrayList<Option>(size);
        this.name = name;
    }
    
    protected OptionSet(String name, ArrayList<Option> opt) {
        this.option = new ArrayList<Option>(opt);
        this.name = name;
    }
    
    protected ArrayList<Option> getOpt() {
        return option;
    }
    
    protected Option getOpt(int index) {
        if(index < option.size())
            return option.get(index);
        return null;
    }

    protected String getName() {
        return name;
    }
    
    protected Option getOptionChoice() {
        return choise;
    }
    
    protected void setOpt(ArrayList<Option> opt) {
        this.option = new ArrayList<Option>(opt);
    }

    protected void setName(String name) {
        this.name = name;
    }
    
    protected void setOptionChoice(String optionName) {
        choise = findOption(optionName);
    }
    
    protected Option findOption(String name) {
        for(int i = 0; i < option.size(); i++) {
            if(option.get(i).getName().equals(name))
                return option.get(i);
        }
        return null;
    }
    
    protected void addOpt(String name, double price) {
        option.add(new Option(name, price));
    }
    
    protected void deleteOption(String optionName) {
        Option toBeDelete = findOption(optionName);
        if(toBeDelete != null) {
            option.remove(toBeDelete);
        }
        return;
    }
    
    protected void updateOpt(String option, String name, double price) {
        Option opt = findOption(option);
        if(opt != null) {
            opt.setName(name);
            opt.setPrice(price);
        }
    }

    protected void updateOpt(String option, String name) {
        Option opt = findOption(option);
        if(opt != null) {
            opt.setName(name);
        }
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" ");
        builder.append(option.toString());
        return builder.toString();
    }
    
    protected void print() {
        System.out.println(this.toString());
    }
    
    protected class Option implements Serializable {
        private static final long serialVersionUID = 814096102005213381L;
        private String name;
        private double price;
        
        protected Option(String name, double price) {
            this.name = name;
            this.price = price;
        }
        
        protected String getName() {
            return name;
        }
        protected double getPrice() {
            return price;
        }
        protected void setName(String name) {
            this.name = name;
        }
        protected void setPrice(double price) {
            this.price = price;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("\n\t\t\t");
            builder.append(name);
            builder.append(": $");
            builder.append(price);
            return builder.toString();
        }
        protected void print() {
            System.out.println(this.toString());
        }  
    }
}
