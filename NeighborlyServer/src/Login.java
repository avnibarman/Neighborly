import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
	String username;
	String password;
	static String loginQuery = "SELECT * FROM Userq WHERE username=? && password=?";
	
	Login(String password, String username){
		this.username = username;
		this.password = password;
	}
	
	User performLogin()
	{
		Connection conn = null;
		Statement st = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		ResultSet rsItems = null;
		ResultSet rsBorrowers = null;
		static String ownedItemsQuery = "SELECT * FROM items WHERE ownerID=?"; //need to install SQL may need to come back and change names later
		static String borrowerQuery = "SELECT * FROM users WHERE username=?";
		
		User owner;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Neighborly?user=root&password=root&useSSL=false"); 
			st = conn.createStatement(); 
			ps = conn.prepareStatement(loginQuery); //will get user class
			ps.setString(1, username); 
			ps.setString(2, password); 
			rs = ps.executeQuery(); 
			
			if(rs.next())
			{
				//validation was successful
				int ownerID = rs.getInt("ownerID");
				ps = conn.prepareStatement(ownedItemsQuery);
				ps.setInt(1, ownerID);
				rsItems = ps.executeQuery();
				//User(String username,String email,String imageURL) --> owner information
				String email = rs.getString("email");
				String imageURL = rs.getString("imageURL");
				owner = new User(username, email, imageURL);
				while(rsItems.next()) {
					//borrower information
					User borrower = null;
					String borrowerName = rsItems.getString("borrower");
					ps = conn.prepareStatement(borrowerQuery);
					ps.setString(1, borrowerName);
					rsBorrowers = ps.executeQuery();
					if(rsBorrowers.next()) {
						email = rsBorrowers.getString("email");
						imageURL = rsBorrowers.getString("imageURL");
						borrower = new User(borrowerName, email, imageURL);
					}
					
					bool available = false;
					if(borrower != null) {
						available = true;
					}
					
					String imageURL = rsItems.getString("imageURL");
					String description = rsItems.getString("description");
					String address = rsItems.getString("address");					
					String itemName = rsItems.getString("itemName");
					
					//Item(boolean availibility, String imageURL, String  description, String address, User owner, User borrower,String itemName)
					Item item = new Item(available, imageURL, description, address, owner, borrower, itemName);
					
					owner.addItem(item);
				}
				
				
				
				return user;
			}
			else //validation was not successful
			{
				return null;
			}
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
	

}
