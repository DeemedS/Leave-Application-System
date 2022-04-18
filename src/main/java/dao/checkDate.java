package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class checkDate {
	
	public static String cdate(String date, String id) {
		String cdate = null;
		try {        			
     
	        Connection con = databasecon.initializeDatabase(); 
	        String query = "SELECT * FROM leaveapp.leave WHERE ? between datefrom and dateto AND id = ?";
	        PreparedStatement ps = con.prepareStatement(query); 
			ps.setString(1, date);
			ps.setString(2, id);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	cdate = rs.getString("id");
	        }
	        
		    
		    
	        ps.close(); 
	        con.close(); 
	} 
	catch (Exception e) { 
	  e.printStackTrace(); 
	} 
		return cdate;
      
    }
}
