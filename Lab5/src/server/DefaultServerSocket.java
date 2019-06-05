package server;

import adapter.*;
import java.io.*;
import java.net.*;

public class DefaultServerSocket extends Thread implements FixAuto {

	////////// PROPERTIES //////////

	private int port;
	private ServerSocket server;
	private boolean DEBUG = true;
	////////// CONSTRUCTORS //////////

	public DefaultServerSocket(int port) {
		this.port = port;
		try {
			this.server = new ServerSocket(port);
		}
		catch (IOException e) {
			System.err.println("Could not listen on port " + port + " ... ");
			System.exit(1);
		}
	}

	////////// INSTANCE METHODS //////////

	@Override
	public void run() {
		Socket clientSocket = null;

		while (true) {
			//Accept client
			try {
				clientSocket = server.accept();
			}
			catch (IOException e) {
				System.err.println("Error establishing client connection ... ");
				System.exit(1);
			}

			//Handle client-server interaction
			if (DEBUG)
				System.out.println(clientSocket.getLocalAddress());
			new DefaultSocketClient(clientSocket).start();

		}
	}

	@Override
	public String fix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fix(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
