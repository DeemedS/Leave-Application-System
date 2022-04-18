package dao;


import java.util.ArrayList;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import tables.leave;



/**
 * Servlet implementation class UserBean
 */
@WebServlet("/UserBean")
public class listDB  {
	
	
	public static ArrayList<leave> getUsersList(String string) throws ClassNotFoundException, SQLException
	{
		ArrayList<leave> list = new ArrayList<leave>();		
	    Connection conn = databasecon.initializeDatabase();
	    String id = string;
	    
	    if (conn != null) 
	    {
	    try
	    {
	    	Connection con = databasecon.initializeDatabase(); 
	        String query = "SELECT *, DATE_FORMAT(datefrom,'%d/%m/%Y') AS fdatefrom,DATEDIFF(dateto,datefrom) AS DAY, DATE_FORMAT(dateto,'%d/%m/%Y') AS fdateto \r\n"
	        		+ "FROM leaveapp.leave WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        
	        
	        while(rs.next())	
	        {
	        	leave user = new leave();
	        	user.setId(rs.getString("num"));
	            user.setDatefrom(rs.getString("fdatefrom"));
	            user.setDateto(rs.getString("fdateto"));
	            user.setBckoffice(rs.getString("bckoffice"));
	            user.setReason(rs.getString("reason"));
	            user.setRemark(rs.getString("remark")); 
	            user.setDay(rs.getString("day"));
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
