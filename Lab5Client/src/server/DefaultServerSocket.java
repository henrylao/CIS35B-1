package server;

import adapter.*;
import java.io.*;
import java.net.*;

public class DefaultServerSocket extends Thread implements Debuggable, Runnable {

	////////// PROPERTIES //////////

	private int port;
	private static ServerSocket server;

	////////// CONSTRUCTORS //////////

	public DefaultServerSocket(int port) {
		this.port = port;

	}

	////////// INSTANCE METHODS //////////

	@Override
	public void run() {
		Socket clientSocket = null;
		try {
			this.server = new ServerSocket(port); 
		}
		catch (IOException e) {
			System.out.println("Could not listen on port " + port + " ... ");
			System.exit(1);
		}
		while (DEBUG) {
			//Accept client
			try {
				clientSocket = server.accept();
			}
			catch (IOException e) {
				System.out.println("Error establishing client connection ... ");
				System.exit(1);
			}

			//Handle client-server interaction
			if (DEBUG)
				System.out.println(clientSocket.getLocalAddress());
			new DefaultSocketClient(clientSocket).start();
		}
	}

}
