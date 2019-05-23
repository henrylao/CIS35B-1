package client;

public class DriverClient {
    public static void main(String[] args) { 
        Client client = new Client("127.0.0.1", 4444);
        Thread thread = new Thread(client);
        thread.run();
    }
}
