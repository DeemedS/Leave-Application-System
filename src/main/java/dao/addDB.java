package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import tables.leave;

public class addDB {
	
	public static long insert(leave u) {
		
		String id = u.getId();
		String datefrom = u.getDatefrom();
		String dateto = u.getDateto();
		String bckoffice = u.getBckoffice();
		String reason = u.getReason();
		String offleave = u.getOffleave();
		String remark = u.getRemark();		
		String fdatefrom = formatDate.fdate(datefrom);
		String fdateto = formatDate.fdate(dateto);	
		
	
	try {        			
        Connection con = databasecon.initializeDatabase(); 
        PreparedStatement st = con 
        .prepareStatement("INSERT INTO `leaveapp`.`leave` (`id`, `datefrom`, `dateto`, `bckoffice`, `offleave`, `reason`, `remark`) "
        		+ "VALUES ( ?, ?, ?, ?, ?, ?, ?);"); 
      
        st.setString(1, id); 
        st.setString(2, fdatefrom);
        st.setString(3, fdateto);
        st.setString(4, bckoffice);
        st.setString(5, offleave);
        st.setString(6, reason);
        st.setString(7, remark);
        st.executeUpdate(); 
        con.close(); 
} 
catch (Exception e) { 
  e.printStackTrace(); 
} 

	return 0;
			} 
} 
