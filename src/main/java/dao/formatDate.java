package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class formatDate {
	
	public static String fdate(String date) {
		String fdate = null;
		try {        			
     
	        Connection con = databasecon.initializeDatabase(); 
	        String query = "SELECT str_to_date( ? , '%d/%m/%Y') as date";
	        PreparedStatement ps = con.prepareStatement(query); 
			ps.setString(1, date);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	fdate = rs.getString("date");
	        }
	        
		    
		    
	        ps.close(); 
	        con.close(); 
	} 
	catch (Exception e) { 
	  e.printStackTrace(); 
	} 
		return fdate;
      
    }
}
