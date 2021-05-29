package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao <T,E>{
	
	
	
	
	default Connection getConnection() throws SQLException {
		
		String URL="jdbc:mysql://localhost:3306/compagnia_aerea?servetTimezone=UTC&useSSL=false";
		return DriverManager.getConnection(URL, "root", "root");
	}
	
	
	public abstract T get(E id);
	public abstract ArrayList<T> getAll();
	public abstract void insert(T tipo);
	public abstract void update(T tipo);
	public abstract void delete(E id);
	
	
	
	
	
	
//	public static <T> T metodoGenerico(String query) {
//		
//				try(Connection conn=this.getConnection();
//				PreparedStatement statement= conn.prepareStatement(query);
//				){	
//				    return T;
//					}
//					
//				
//						
//				
//			}catch(SQLException e) {
//				System.out.println("qui");
//				e.printStackTrace();
//				
//			}
//			return T;
//		}
	
	
}
