import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
	String username;
	String password;
	static String loginQuery = "SELECT * FROM users WHERE username=? && password=?";
	
	Login(String password, String username){
		this.username = username;
		this.password = password;
	}
	
	boolean performLogin()
	{
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Neighborly?user=root&password=root&useSSL=false"); 
			st = conn.createStatement();
			ps = conn.prepareStatement(loginQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				//validation was successful
				return true;
			}
			else //validation was not successful
			{
				return false;
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
