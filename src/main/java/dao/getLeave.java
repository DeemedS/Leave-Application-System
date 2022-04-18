package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import tables.leave;

public class getLeave{

public static leave getUserData(String id) throws ClassNotFoundException, SQLException
	{	
		leave userBean = new leave();
		Connection conn = databasecon.initializeDatabase();	
		
        
	    if (conn != null) 
	    {
			try
			{
				PreparedStatement st = (PreparedStatement) conn
				.prepareStatement("SELECT *, DATE_FORMAT(datefrom,'%d/%m/%Y') AS fdatefrom, DATE_FORMAT(dateto,'%d/%m/%Y') AS fdateto FROM leaveapp.leave WHERE num= ?");  
				st.setString(1, id); 
				ResultSet rs =st.executeQuery(); 
				
				while(rs.next())
				{
					userBean.setId(rs.getString("num"));
					userBean.setDatefrom(rs.getString("fdatefrom"));
					userBean.setDateto(rs.getString("fdateto"));
					userBean.setBckoffice(rs.getString("bckoffice"));
					userBean.setReason(rs.getString("reason"));
					userBean.setOffleave(rs.getString("offleave"));
					userBean.setRemark(rs.getString("remark"));

									}				
			}
			catch(SQLException ex){ex.printStackTrace();}		
	    }
	    return userBean;
	}	
}