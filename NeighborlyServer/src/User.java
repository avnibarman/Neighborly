import java.util.ArrayList;

public class User {
	
	private String username;
	private String email;
	private String imageURL;
	private ArrayList<Item> myItems;
	
	User(String username,String email,String imageURL)
	{
		this.username = username;
		this.email = email;
		this.imageURL = imageURL;
		this.myItems = new ArrayList<Item>(); // add an empty class
	}
	
	void addItem(Item toAdd)
	{
		myItems.add(toAdd);
	}
	
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
