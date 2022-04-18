package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import tables.leave;

public class editDB {
	
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
		
		System.out.println(fdatefrom);
		System.out.println(fdateto);
	
	try {        			
        Connection con = databasecon.initializeDatabase(); 
        PreparedStatement st = con 
        .prepareStatement("UPDATE `leaveapp`.`leave` SET `datefrom` = ?, `dateto` = ?, `bckoffice` = ?, "
        		+ "`offleave` = ?, `reason` = ?, `remark` = ? WHERE (`num` = ?); "); 
      
        st.setString(1, fdatefrom); 
        st.setString(2, fdateto);
        st.setString(3, bckoffice);
        st.setString(4, offleave);
        st.setString(5, reason);
        st.setString(6, remark);
        st.setString(7, id);
        st.executeUpdate(); 
        con.close(); 
} 
catch (Exception e) { 
  e.printStackTrace(); 
} 

	return 0;
			} 
} 
