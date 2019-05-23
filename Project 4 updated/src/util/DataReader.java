package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Automobile;

public class DataReader {
    
    public Automobile buildAutomobile(String filename) {
        Automobile automotive = new Automobile();
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("=");
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
                    String[] rawOptionData = parts[1].split(",");
                    String optionName = parts[0];
                    if(rawOptionData.length == 0)
                        throw new AutoException(CodeError.MISSING_OPTION);
                    automotive.setOptionSet(optionName, rawOptionData.length);
                    for(int i = 0; i < rawOptionData.length; i++) {
                        String[] optionData = rawOptionData[i].split(":");
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
}
