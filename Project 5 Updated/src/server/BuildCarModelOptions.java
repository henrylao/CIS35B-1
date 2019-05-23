package server;

import java.util.Properties;

import adapter.BuildAuto;
import model.Automobile;

public class BuildCarModelOptions {
	public Automobile buildAutoOptions(Properties props) {
		AutoServer server = new BuildAuto();
		return server.acceptPropertiesObject(props);
	}	
}
