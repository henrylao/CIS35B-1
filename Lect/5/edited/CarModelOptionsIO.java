package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;

import server.BuildCarModelOptions;

public class CarModelOptionsIO extends Thread{
	////////// PROPERTIES //////////

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket clientSocket;
	private BuildCarModelOptions protocol;
	private boolean DEBUG = true;
	////////// CONSTRUCTORS //////////

	public CarModelOptionsIO(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	////////// INSTANCE METHODS //////////

	public void handleConnection() {
		if (DEBUG)
			System.out.println("Creating server object streams ... ");
		try {
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			PrintWriter out1 = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}
		catch (IOException e) {
			System.err.println("Error creating server object streams ... ");
			System.exit(1);
		}

		protocol = new BuildCarModelOptions();//protocol
		
		String menu = "\nEnter 1 to upload a new Automobile\n"
				+ "Enter 2 to configure an Automobile\n"
				+ "Enter 0 to terminate connection\n";

		try {
			do {
				if (DEBUG)
					System.out.println("Sending client interaction choices ... ");
				sendOutput(menu);
				if (DEBUG)
					System.out.println("Reading client request ... ");
				int request = Integer.parseInt(in.readObject().toString());
				if (DEBUG)
					System.out.println(request);
				if (request == 0)
					break;
				if (DEBUG)
					System.out.println("Sending client request follow-up ... ");
				sendOutput(protocol.setRequest(request));
				if (request >= 1 && request <= 2)
					handleInput(request);
			} while (in.readObject() != null);

			if (DEBUG)
				System.out.println("Closing server input stream for client " + clientSocket.getInetAddress() + " ... ");
			in.close();
		}
		catch (IOException e) {
			System.err.println("Error handling client connection ... ");
			System.exit(1);
		}
		catch (ClassNotFoundException e) {
			System.err.println("Error in uploaded object, object may be corrupted ... ");
			System.exit(1);
		}
	}

	public void sendOutput(Object obj) {
		try {
			out.writeObject(obj);
		}
		catch (IOException e) {
			System.err.println("Error returning output to client ... ");
			System.exit(1);
		}
	}

	public void handleInput(int request) {
		Object fromClient = null;
		Object toClient = null;

		try {
			switch (request) {
				case 1: //Client request to build Automobile
					if (DEBUG)
						System.out.println("Waiting for client to upload file ... ");
					fromClient = in.readObject();//Properties
					String fileType = checkFileType(fromClient.toString());
					
					if (DEBUG) {
						System.out.println(fromClient);
						System.out.println("Adding new Automobile to database ... ");
					}
					System.out.println(fileType);
					toClient = protocol.processRequest(fromClient);
					sendOutput(toClient);
					break;

				case 2: //Client request to configure Automobile
					if (DEBUG)
						System.out.println("Waiting for client to select Automobile ... ");
					fromClient = Integer.parseInt(in.readObject().toString());
					if (DEBUG)
						System.out.println("Sending Automobile object to client ... ");
					toClient = protocol.processRequest(fromClient);
					sendOutput(toClient);
					break;

				default: //Invalid requests
					;
			}
		}
		catch (ClassNotFoundException e) {
			System.err.println("Error in uploaded object, file may be corrupted ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error in retrieving object from client ... ");
			System.exit(1);
		}
	}

	private String checkFileType(String fileName) {
		String fileType = "";
		File file = new File(fileName);
		try
		   {
		      fileType = Files.probeContentType(file.toPath());
		      
		   }
		   catch (IOException ioException)
		   {
		      System.err.println(
		           "ERROR: Unable to determine file type for " + fileName
		              + " due to exception " + ioException);
		   }
		   return fileType;
		
	}

	@Override
	public void run() {
		handleConnection();

		//Close client output stream
		if (DEBUG)
			System.out.println("Closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		try {
			out.close();
		}
		catch (IOException e) {
			System.err.println("Error closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		}

		//Close client socket
		if (DEBUG)
			System.out.println("Closing client socket " + clientSocket.getInetAddress() + " ... ");
		try {
			clientSocket.close();
		}
		catch (IOException e) {
			System.err.println("Error closing client socket " + clientSocket.getInetAddress() + " ... ");
		}
	}

}