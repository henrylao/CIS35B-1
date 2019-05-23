package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import model.Automobile;

public class DataReader {
    
    public Automobile buildAutomobile(String filename) {
        Automobile automotive = new Automobile();
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(" = ");
                if(parts[0].equals("Make")) {
                    automotive.setMake(parts[1]);
                }
                else if(parts[0].equals("Model")) {
                    automotive.setModel(parts[1]);
                }
                else if(parts[0].equals("Base Price")) {
                    automotive.setBaseprice(Double.parseDouble(parts[1]));
                }
                else { 
                    if(parts.length < 2)
                        throw new AutoException(CodeError.MISSING_OPTION);
                    String[] rawOptionData = parts[1].split(", ");
                    String optionName = parts[0];
                    if(rawOptionData.length == 0)
                        throw new AutoException(CodeError.MISSING_OPTION);
                    automotive.setOptionSet(optionName, rawOptionData.length);
                    for(int i = 0; i < rawOptionData.length; i++) {
                        String[] optionData = rawOptionData[i].split(": ");
                        String name = optionData[0];
                        double price = Double.parseDouble(optionData[1]);
                        automotive.setOption(optionName, name, price);
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            try {
                throw new AutoException(CodeError.FILENAME_ERROR);
            } catch (AutoException e1) {
                e1.print();
                log(e1.toString());
                e1.setErrorInfo(filename);
                e1.fix(e1, automotive);
                return null;
            }
        } catch (IOException e) {
            log(e.toString());
            e.printStackTrace();
            System.exit(1);
        } catch (AutoException e) {
            e.print();
            log(e.toString());
            e.fix(e, automotive);
        } finally { 
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return automotive;
    }
    
    public void log(String message) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String timeStamp = dateFormat.format(date);
            bw.write("[" + timeStamp + "] " + message + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Properties readPropertiesFile(String filename) {
    	Properties props = new Properties();
    	
    	try {
	    	FileInputStream in = new FileInputStream(filename);
	    	props.load(in);
	    	in.close();
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.exit(1);
    	}
    	return props;
    } 
    
    public Automobile buildAutoProperties(Properties props) {
    	Automobile auto = new Automobile();
    	
    	String CarMake = props.getProperty("CarMake");
    	if(!CarMake.equals(null)) {
    		auto.setMake(CarMake);
    		auto.setModel(props.getProperty("CarModel"));
    		auto.setBaseprice(Double.parseDouble(props.getProperty("BasePrice")));
    		
            for(int i = 1; i <= 5; i++) {
                auto.setOptionSet(props.getProperty("Option"+i), 2);
                String name = props.getProperty("OptionValue"+i+"a");
                double price = Double.parseDouble(props.getProperty("OptionPrice"+i+"a"));
                auto.setOption(props.getProperty("Option"+i), name, price);
                name = props.getProperty("OptionValue"+i+"b");
                price = Double.parseDouble(props.getProperty("OptionPrice"+i+"b"));
                auto.setOption(props.getProperty("Option"+i), name, price);
            }
        }
    	return auto;
    }
}
