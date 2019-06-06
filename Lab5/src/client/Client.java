//============================================================================
// Project     : Lab5
// Name        : Client.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : it starts the client
//============================================================================
package client;

import server.DefaultServerSocket;

public class Client {
	public static void main(String[] args) {
		DefaultSocketClient client = new DefaultSocketClient("127.0.0.1", 4501);//
        Thread thread = new Thread(client);
        thread.run();
	}
}
