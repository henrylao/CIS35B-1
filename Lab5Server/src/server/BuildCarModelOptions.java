

package server;

import java.util.Properties;
import adapter.*;
import model.Automobile;
import util.FileIO;

public class BuildCarModelOptions extends ProxyAutomobile implements AutoServer{

	////////// PROPERTIES //////////

	private static final int WAITING = 0;
	private static final int REQUEST_BUILD_AUTO = 1;
	private static final int REQUEST_CONFIGURE_AUTO = 2;
	private int state = WAITING;
	private Automobile auto;
	////////// CONSTRUCTORS //////////

	public BuildCarModelOptions() {

	}

	////////// INSTANCE METHODS //////////

	
	public Object processRequest(Object obj) {
		Object toClient = null;
		
		if (state == REQUEST_BUILD_AUTO) {
			CreateAuto a = new BuildAuto();
			try {
	    		Properties props = (Properties) obj;
				a.buildAuto(obj,1);
	    	}
			catch (ClassCastException e) {
				a.buildAuto(obj,2);
			}
			toClient = "Automobile object successfully added to database\n"
					+ "Press any key to return to main menu";
			this.state = WAITING;
		}
		else if (state == REQUEST_CONFIGURE_AUTO) {
			Automobile a = new BuildAuto().getAuto( (String) (obj));
			toClient = a;
		}

		this.state = WAITING;

		return toClient;
	}

	public String setRequest(int i) {
		String output = null;
		if (i == 1) {
			this.state = REQUEST_BUILD_AUTO;
			output = "Upload a file to create an Automobile";
		}
		else if (i == 2) {
			this.state = REQUEST_CONFIGURE_AUTO;
			output = "Select an Automobile from the following list to configure: \n"+
					super.avaliableAuto();
		}
		else {
			output = "Invalid request";
		}
		return output;
	}



}
