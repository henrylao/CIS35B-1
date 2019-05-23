package adapter;

import java.util.LinkedHashMap;

import scale.EditOptions;
import util.AutoException;
import util.CodeError;
import util.DataReader;
import model.Automobile;
import model.OptionSet;

public abstract class ProxyAutomobile {
    private static LinkedHashMap<String, Automobile> automobiles = new LinkedHashMap<>();
    
    public void buildAuto(String fileName) {
        DataReader io = new DataReader();
        Automobile automobile = io.buildAutomobile(fileName);
        if(automobile == null)
            return;
        automobiles.put(automobile.getModel(), automobile);
        try {
            if(Double.compare(automobile.getBaseprice(), 0.0d) == 0)
                throw new AutoException(CodeError.MISSING_PRICE);
            if(automobile.getBaseprice() < 0)
                throw new AutoException(CodeError.NEGATIVE_BASEPRICE);
            if(automobile.getOpset().size() == 0)
                throw new AutoException(CodeError.MISSING_OPTIONSET);
        } catch (AutoException e) {
            e.print();
            io.log(e.toString());
            e.fix(e, automobile);
        }
    }
    
    public void printAuto(String modelName) {
        if(automobiles.containsKey(modelName))
            automobiles.get(modelName).print();
    }
    
    public void updateOptionSetName(String modelName, String optionSetName, String newName) {
        if(automobiles.containsKey(modelName)) {
            Automobile automobile = automobiles.get(modelName);
            OptionSet optionSet = automobile.findOptionSet(optionSetName);
            if(optionSet != null)
                automobile.updateOptionSet(optionSetName, newName);
        }
    }

    public void updateOptionName(String modelName, String optionSetName, String optionName, String newName) {
        if(automobiles.containsKey(modelName)) {
            Automobile automobile = automobiles.get(modelName);
            OptionSet optionSet = automobile.findOption(optionName);
            if(optionSet != null)
                automobile.updateOptionName(optionSetName, optionName, newName);
        }
    }
    
    public void updateOptionPrice(String modelName, String optionSetName, String optionName, double newPrice) {
        if(automobiles.containsKey(modelName)) {
            Automobile automobile = automobiles.get(modelName);
            OptionSet optionSet = automobile.findOption(optionName);
            if(optionSet != null)
                automobile.updateOptionValue(optionSetName, optionName, optionName, newPrice);
        }    
    }
    
    public void fix(AutoException e) {
        Automobile last = null;
        for(Automobile automobile: automobiles.values())
            last = automobile;
        e.fix(e, last);
    }
    
    public Automobile getInstace(String modelName) {
        return automobiles.get(modelName);
    }
    
    public void editOptionSetName(String model, String name, String newName) {
        EditOptions editOptions = new EditOptions(model, name, newName);
        Thread thread = new Thread(editOptions);
        thread.start();
    }
    
    public void editOptionName(String model, String optionSetName, String optionName, String newOptionName) {
        EditOptions editOptions = new EditOptions(model, optionSetName, optionName, newOptionName);
        Thread thread = new Thread(editOptions);
        thread.start();
    }
    
    public void editOptionValue(String model, String optionSetName, String optionName, double newValue) {
        EditOptions editOptions = new EditOptions(model, optionSetName, optionName, newValue);
        Thread thread = new Thread(editOptions);
        thread.start();
    }

}
