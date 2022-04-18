package dao;


import java.util.ArrayList;
import java.sql.*;
import tables.num;


public class getNumday  {
	
	
	public static ArrayList<num> getNum(String string) throws ClassNotFoundException, SQLException
	{
		ArrayList<num> list = new ArrayList<num>();		
	    Connection conn = databasecon.initializeDatabase();
	    String id = string;
	    
	    if (conn != null) 
	    {
	    try
	    {
	    	Connection con = databasecon.initializeDatabase(); 
	        String query = "SELECT DATEDIFF(dateto, datefrom) AS day FROM leaveapp.leave WHERE id= ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
			
	        while(rs.next())	
	        {
	        	num user = new num();
	        	user.setNumday(rs.getString("day"));
	            list.add(user);
	        }
	    }
	    
	    catch (SQLException e) {
			e.printStackTrace();
		}
	
	    		}
		return list;

}

}
