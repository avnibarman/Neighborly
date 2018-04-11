package NeighborlyServer.src;


public class Item {
	
	boolean availibility;
	private String imageURL;
	private String description;
	private String address;
	private User owner;
	private User borrower;
	private String itemName;
	private int latitude;
	private int longitude;
	
	
	Item(boolean availibility, String imageURL, String  description, int latitude, int longitude, User owner, User borrower, String itemName) {
		this.availibility = availibility;
		this.imageURL = imageURL;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
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
	
	public void addToDatabase()
	{
		Connection conn = null;
		Statement st = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		int ownerID = -1;
		int borrowerID = -1;
		static String query = "INSERT INTO items (itemName, ownerID, borrowerID, availibility,"
				+ "image, description, latitude, longitude) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		static String queryOwner = "SELECT userID "
				+ "FROM Users "
				+ "WHERE email = '?'";
		
		static String queryBorrower = "SELECT userID "
				+ "FROM Users "
				+ "WHERE email = '?'";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Neighborly?user=root&password=root&useSSL=false"); 
			st = conn.createStatement(); 
			ps = conn.prepareStatement(queryOwner); //will get user class
			ps.setString(1, owner.getEmail()); 
			rs = ps.executeQuery(); 
			
			if(rs.next()) {	
				ownerID = rs.getInt("userID");
			}
			
			ps = conn.prepareStatement(queryBorrower);
			ps.setString(1, borrower.getEmail());
			rs = ps.executeQuery();			
			if(rs.next()) {
				borrowerID = rs.getInt("userID");
			}
			
			if(borrowerID != null) {
				availibility = true;
			}
			
			else {
				availibility = false;
			}
			
			ps = conn.prepareStatement(query);
			ps.set(1, itemName);
			ps.set(2, ownerID);
			ps.set(3, borrowerID);
			ps.set(4, availibility);
			ps.set(5, imageURL);
			ps.set(6, description);
			ps.set(7, latitude);
			ps.set(8, longitude);
			
			
			
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
		User owner = new User("owner", "ownerEmail" ,"imageURL");
		User borrower = new User("borrower", "borrowerEmail" ,"imageURL");
		Item item = new Item(true, "imageURL", "description", 1, 1, owner, borrower, "itemName");
		item.addToDatabase();
	}
	

	
}
