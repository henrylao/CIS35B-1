package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

import adapter.BuildAuto;
import model.Automobile;

public class Server implements Runnable{
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    
    public Server(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String message = in.readLine();
                if(message == null) {
                    continue;
                }
                
                out = new PrintWriter(socket.getOutputStream(), true);
                switch(message){
	                case "send":
	                    ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
	                    Properties properties = (Properties)objectIS.readObject();
	                    BuildCarModelOptions bulidCarModelOptions = new BuildCarModelOptions();
	                    Automobile auto = bulidCarModelOptions.buildAutoOptions(properties);
	                    System.out.println("Receive Automobile " + auto.getModel());
	                    out.println("Automobile created successfully.");
	                    break;
	                case "list":         
                        AutoServer autoServer = new BuildAuto();
                        out.println(autoServer.listAutomobile());
                        out.println("");
                        System.out.println("Return list of Automobiles:\n" + autoServer.listAutomobile());
                        break;
                    case "config":
                        String modelName = in.readLine();
                        BuildAuto buildAuto = new BuildAuto();
                        Automobile automobile = buildAuto.getInstace(modelName);
                        ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
                        objectOS.writeObject(automobile);
                        System.out.println("Return Automobile " + automobile.getModel());
                        break;
                	case "quit": 
                        out.println("Bye!");
                        System.out.println("Quit");
                        socket.close();
                        return;                           
                }
            }            
        } catch (IOException e){
            System.err.println("Could not listen on port: " + socket.getPort());
            System.exit(1);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }
     }
}

