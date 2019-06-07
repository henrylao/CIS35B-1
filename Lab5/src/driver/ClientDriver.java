//============================================================================
// Project     : Lab5
// Name        : ClientDriver.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : it starts the client
//============================================================================
package driver;

import adapter.BuildAuto;
import client.AutoClient;

public class ClientDriver {
	public static void main(String[] args) {
		int port = 6666;
		String host = "127.0.0.1";
		AutoClient client = new BuildAuto();
		client.client(host, port);
	}
}