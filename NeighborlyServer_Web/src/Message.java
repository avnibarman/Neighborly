import java.io.IOException;

import javax.websocket.Session;

public class Message {
	String message;
	int id;
	
	public String getMessage() {//corrected spelling for messsage
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void sendMessage(Session s) {
		try {
			s.getBasicRemote().sendText(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2 users connected to messaging system

}
