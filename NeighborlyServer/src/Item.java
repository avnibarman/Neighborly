
public class Item {
	
	boolean availibility;
	private String imageURL;
	private String description;
	private String address;
	private User owner;
	private User borrower;
	private String itemName;
	
	Item(boolean availibility, String imageURL, String  description, String address, User owner, User borrower,String itemName)
	{
		this.availibility = availibility;
		this.imageURL = imageURL;
		this.description = description;
		this.address = address;
		this.owner = owner;
		this.borrower = borrower;
		this.itemName = itemName;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public boolean isAvailibility() {
		return availibility;
	}
	public void setAvailibility(boolean availibility) {
		this.availibility = availibility;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public User getBorrower() {
		return borrower;
	}
	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
