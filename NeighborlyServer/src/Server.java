import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.util.Set;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.Extension;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class Server {
	
	ServerSocket ss = null;
	
	Server(int port){
		try {
			ss = new ServerSocket(port);
			while(true)
			{
				System.out.println("Waiting for connection...");
				//Session session = new
			}
		}
		catch(IOException ioe)
		{
			System.out.println("ioe in Server constructor: " + ioe.getMessage());
		}
	}
}
