import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Item {
	
	private String itemName;
	private int itemID;
	private int availibility;
	private String imageURL;
	private String description;
	private double latitude;
	private double longitude;
	private int ownerID;
	private int borrowerID;

	Item(int itemID,String itemName, String description, int availibility, String imageURL, int ownerID, int borrowerID, double latitude, double longitude)
	{
		this.itemID = itemID;
		this.availibility = availibility;
		this.imageURL = imageURL;
		this.description = description;
		this.ownerID = ownerID;
		this.borrowerID = borrowerID;
		this.itemName = itemName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int isAvailibility() {
		return availibility;
	}
	public void setAvailibility(int availibility) {
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
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getBorrowerID() {
		return borrowerID;
	}

	public void setBorrowerID(int borrowerID) {
		this.borrowerID = borrowerID;
	}
	
	public void printItem() {
		
		System.out.println("----------------------------------------");
		System.out.println("ItemName: " + itemName);
		System.out.println("ItemID: " + itemID);
		System.out.println("Avaliliblity: " + availibility);
		System.out.println("description: "+ description);
		System.out.println("ownerID: " + ownerID);
		System.out.println("Latitude: " + latitude);
		System.out.println("Longitude: " + longitude);
	}
	
	public boolean addToDatabase()
	{
		Connection conn = null;
		Statement st = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		int ownerID = -1;
		int borrowerID = -1;
		String query = "INSERT INTO items (itemName, ownerID, borrowerID, availibility,"
				+ "image, description, latitude, longitude) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Neighborly?user=root&password=root&useSSL=false"); 
			st = conn.createStatement(); 
			ps = conn.prepareStatement(query); //will get user class
			
			if(borrowerID != 0) {
				availibility = 1;
			}
			
			else {
				availibility = 0;
			}
			
			ps = conn.prepareStatement(query);
			ps.setString(1, itemName);
			ps.setInt(2, ownerID);
			ps.setInt(3, borrowerID);
			ps.setInt(4, availibility);
			ps.setString(5, imageURL);
			ps.setString(6, description);
			ps.setDouble(7, latitude);
			ps.setDouble(8, longitude);
			
			ps.executeQuery();
			return true;
			
		}	

		catch(SQLException sqle){
			System.out.println("sqle: " + sqle.getMessage());
		}
		
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("cnfe: " + cnfe.getMessage());
		}
		
		finally {
			try {
				if(rs!= null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				if(conn != null)
				{
					conn.close();
				}
			}
			catch(SQLException sqle)
			{
				System.out.println("sqle closing streams: " + sqle.getMessage());
			}
			
		}

			return false;
		}
	
	
	public static void main(String [] args) {
		//Item(int itemID,String itemName, String description, int availibility, String imageURL, int ownerID, int borrowerID, double latitude, double longitude)
		Item item = new Item(1, "name", "description", 1, "imageURL", 1, 2, 1, 1);
		item.addToDatabase();
	}
	
}
