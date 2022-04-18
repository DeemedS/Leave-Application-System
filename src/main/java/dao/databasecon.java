package dao;

import java.sql.*;  
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
public class databasecon { 
    public static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 

    	
    	String url = "jdbc:mysql://localhost:3306/";
    	String db = "leaveapp"; 
    	String driver = "com.mysql.cj.jdbc.Driver"; //connection driver 
    	String userName ="root";
    	String password="root";
  
        Class.forName(driver); 
        // initialize database connection
        Connection con = DriverManager.getConnection(url+db, userName, password); 
        return con; 
    } 
} 