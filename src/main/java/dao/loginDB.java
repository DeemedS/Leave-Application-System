package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class loginDB {
	public static boolean check(String username,String password) {
	
	boolean st = false;
	try {        			
        Connection con = databasecon.initializeDatabase(); 
        String query = "select * from users where username = ? AND password= ?";
        PreparedStatement ps = con.prepareStatement(query); 
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        st = rs.next();
        
	    
	    
        ps.close(); 
        con.close(); 
} 
catch (Exception e) { 
  e.printStackTrace(); 
} 

	return st;
			}

}
