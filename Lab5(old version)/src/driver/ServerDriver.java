//============================================================================
// Project     : Lab5
// Name        : ServerDriver.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : it starts the Server
//============================================================================
package driver;

import adapter.BuildAuto;
import server.AutoServer;

public class ServerDriver {
	public static void main(String[] args) {
		int port = 6666;
		AutoServer serve = new BuildAuto();
		serve.serve(port);
	}
}
