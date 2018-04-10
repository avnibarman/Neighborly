import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {
	String name;
	String password;
	String email;
	
	SignUp(String email, String password,String name){
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public boolean performSignUp()
	{
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Neighborly?user=root&password=root&useSSL=false"); 
			st = conn.createStatement();
			ps = conn.prepareStatement("INSERT INTO Users (email, name, password)\r\n" + 
					"VALUES (\" " + this.email + "\",\"" + this.name + "\",\""+ this.password +"\");");
			int x = ps.executeUpdate();
			
			System.out.println(x);
			return true;
			
		}
		catch(SQLException sqle){
			System.out.println("sqle: " + sqle.getMessage());
			return false;
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("cnfe: " + cnfe.getMessage());
		}
		finally {
			try {
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
