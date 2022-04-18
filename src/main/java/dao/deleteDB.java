package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class deleteDB{

public static void deleteUser(String id) throws ClassNotFoundException, SQLException
	{	
		Connection conn = databasecon.initializeDatabase();	
	    if (conn != null) 
	    {
			try
			{
				PreparedStatement st = (PreparedStatement) conn
				.prepareStatement("DELETE FROM leaveapp.leave WHERE num = ? ");  
				st.setString(1, id); 
				System.out.println(id);
				st.executeUpdate(); 
				
			}
			catch(SQLException ex){ex.printStackTrace();}		
	    }
	    
	}	
}