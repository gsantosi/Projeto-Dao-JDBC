package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
   
	public static Connection conn = null;
	
	public static Connection getConnection() {
		 
			if(conn == null) {
		
	try{
	      Properties proper = loadProperties();
		   String url = proper.getProperty("Conectorurl");
          conn =   DriverManager.getConnection(url,proper);	
	    }
	catch(SQLException e){
		throw new DbException(e.getMessage());
	}
			}
	return conn;
	}
	

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			
			}catch(SQLException e) {
				throw new DbException (e.getMessage());
			}
			
				
			}
	}

	
	public static Properties loadProperties(){
		try(FileInputStream fs = new FileInputStream("Conector")){
			Properties proper = new Properties();
			proper.load(fs);
			return proper;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
