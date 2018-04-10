import java.util.ArrayList;

public class User {
	
	String username;
	String email;
	String imageURL;
	ArrayList<Item> myItems;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public ArrayList<Item> getMyItems() {
		return myItems;
	}
	public void setMyItems(ArrayList<Item> myItems) {
		this.myItems = myItems;
	}
	

}
