package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getid {
	
	public static String id(String username, String password) {
		String id = null;
		try {        			
     
	        Connection con = databasecon.initializeDatabase(); 
	        String query = "select * from users where username = ? AND password= ?";
	        PreparedStatement ps = con.prepareStatement(query); 
			ps.setString(1, username);
			ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	id = rs.getString("id");
	        }
	        
		    
		    
	        ps.close(); 
	        con.close(); 
	} 
	catch (Exception e) { 
	  e.printStackTrace(); 
	} 
		return id;
      
    }
}
