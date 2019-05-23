package client;

import java.util.Properties;

import util.DataReader;

public class CarModelOptionsIO {
    public Properties readPropertiesFile(String filename) {
        DataReader io = new DataReader();
        Properties properties = io.readPropertiesFile(filename);
        return properties;    
    }
}
