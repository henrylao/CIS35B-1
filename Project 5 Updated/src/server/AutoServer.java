package server;

import java.util.Properties;

import model.Automobile;

public interface AutoServer {

	public Automobile acceptPropertiesObject(Properties props);
	public String listAutomobile();
}
