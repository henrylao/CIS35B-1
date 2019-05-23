package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import model.Automobile;

public class Client implements Runnable {
    private String serverIPAddress;
    private int serverPort;
    
    public Client(String ipAddress, int port) {
        serverIPAddress = ipAddress;
        serverPort = port;   
    }
    
    public void run() {
        Socket serverSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            serverSocket = new Socket(serverIPAddress, serverPort);
            out = new PrintWriter(serverSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        BufferedReader commandReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Please input command: send, list, config, quit");
            String userInput;
            try {
                userInput = commandReader.readLine();
                switch(userInput) {
                    case "quit":
                        out.println("quit");
                        System.out.println(in.readLine());
                        serverSocket.close();
                        return;
                    case "send":
                        System.out.print("File name: ");
                        String fileName = commandReader.readLine();
                        out.println("send");                  
                        CarModelOptionsIO carModelOptionsIO = new CarModelOptionsIO();
                        Properties properties = carModelOptionsIO.readPropertiesFile(fileName);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverSocket.getOutputStream());
                        objectOutputStream.writeObject(properties);
                        System.out.println("Server: " + in.readLine());
                        break;
                    case "list":
                        out.println("list");
                        String line;
                        while((line = in.readLine()) != null) {
                            if(line.length() <= 0)
                                break;
                            System.out.println(line);
                        }
                        break;
                    case "config":
                        System.out.println("Model name: ");
                        String modelName = commandReader.readLine();
                        out.println("config");
                        out.println(modelName);
                        ObjectInputStream objectIS = new ObjectInputStream(serverSocket.getInputStream());
                        Automobile automobile = null;
                        try {
                            automobile = (Automobile) objectIS.readObject();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        SelectCarOption selectCarOption = new SelectCarOption();
                        selectCarOption.configure(automobile);
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
