package main.dao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Dao<T>  {
	
	default Connection getConnection() throws SQLException {
	String url="jdbc:mysql://localhost:3306/azienda?servetTimezone=UTC&useSSL=false";
	return  DriverManager.getConnection(url,"root","root");
	
	}	
	
	
}



