package client;
import java.io.*;
import java.net.*;

public class KnockKnockClient {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

       
        socket = new Socket("153.18.26.137", 4444);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
            if (fromServer.equals("Bye."))
                break;
		    
            fromUser = stdIn.readLine();
	    if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
	    }
        }

        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}
