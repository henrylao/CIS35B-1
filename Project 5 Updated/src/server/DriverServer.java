package server;

import java.net.ServerSocket;
import java.net.Socket;

public class DriverServer {
    public static void main(String[] args) {
        System.out.println("Start server.");
        try {
            @SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(4444);
            while(true) {
                Socket socket = serverSocket.accept();
                Server server = new Server(socket);
                Thread thread = new Thread(server);
                thread.start();
                System.out.println("Accept a client.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
