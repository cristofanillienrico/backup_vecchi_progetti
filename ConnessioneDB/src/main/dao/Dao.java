package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
	
	private String url="jdbc:mysql://localhost:3306/azienda?servetTimezone=UTC&useSSL=false";
	
	
	
	protected Connection getConnection() throws SQLException {
		
		return  DriverManager.getConnection(url,"root","root");
		
	}
	
	
	
	


}
