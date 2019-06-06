//============================================================================
// Project     : Lab5
// Name        : Server.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : it starts the Server
//============================================================================
package server;

public class Server {
	public static void main(String[] args) {
		System.out.println("Start server.");
		int port = 4501;
	    try {
	    	while(true) {
	    		DefaultServerSocket socket = new DefaultServerSocket(port);
	    		Thread thread = new Thread(socket);
	    		thread.run();
	    		System.out.println("Accept a client.");
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
