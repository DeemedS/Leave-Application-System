package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import tables.name;

public class getname{

public static name getUserData(String id) throws ClassNotFoundException, SQLException
	{	
		name userBean = new name();
		Connection conn = databasecon.initializeDatabase();	
		
        
	    if (conn != null) 
	    {
			try
			{
				PreparedStatement st = (PreparedStatement) conn
				.prepareStatement("SELECT * FROM leaveapp.users WHERE id= ?");  
				st.setString(1, id); 
				ResultSet rs =st.executeQuery(); 
				
				while(rs.next())
				{
					userBean.setLname(rs.getString("lname"));
					userBean.setFname(rs.getString("fname"));
					userBean.setMname(rs.getString("mname"));
					userBean.setUid(rs.getString("id"));

									}				
			}
			catch(SQLException ex){ex.printStackTrace();}		
	    }
	    return userBean;
	}	
}