package server;

import adapter.*;
import client.*;
import java.io.*;
import java.net.*;

public class DefaultServerSocket extends Thread implements FixAuto, Runnable {

	////////// PROPERTIES //////////

	private int port;
	private ServerSocket server;
	private boolean DEBUG = true;
	////////// CONSTRUCTORS //////////

	public DefaultServerSocket(int port) {
		this.port = port;

		try {
			this.server = new ServerSocket(port);
			Socket clientSocket = server.accept();
			System.out.println(5);
		}
		catch (IOException e) {
			System.out.println("Could not listen on port " + port + " ... ");
			System.exit(1);
		}
	}

	////////// INSTANCE METHODS //////////

	public void run() {
		Socket clientSocket = null;

		while (true) {
			//Accept client
			System.out.println(3);
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
	
	public String fix() {
		return null;
	}

	
	public String fix(int i) {
		return null;
	}

}
