package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//




import java.sql.Statement;

public class ConnessioneMain {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/azienda?servetTimezone=UTC&useSSL=false";
		
		try(Connection connection= DriverManager.getConnection(url,"root","root");
			Statement statement =connection.createStatement();	
			) {
			System.out.println("Connesso!!!");
			
			
			if(statement.execute("SELECT VERSION()")) { //la query mi crea una tabella
				ResultSet result=statement.getResultSet();
				if(result.next()) {  // mi punta a una riga della tabella
					System.out.println(result.getString(1));
				}else {
					System.out.println("Non ho risultati");
				}

			}
			
			
			if(statement.execute("SELECT * FROM dipendenti ")) { 
				ResultSet result=statement.getResultSet();
				while(result.next()) {  // ogni volta che faccio next scende alla riga successiva
					int id =result.getInt(1); //il numero corrisponde alla colonna
					String nome= result.getString("nome");//o nome colonna stessa
					String cognome= result.getString(3);
					System.out.println(id+" "+nome+" "+cognome+" " );
					
				}
					
				

			}

			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

	
	

		
		
		
	
//		PrepareStatement prepara la query in maniera dinamica
//		da finire di scrivere
		String query="INSERT INTO dipendenti(nome,cognome) VALUES (?,?)";
		try(Connection connection= DriverManager.getConnection(url,"root","root");
			PreparedStatement statement =connection.prepareStatement(query);
				) {
				System.out.println("Connesso!!!");
				statement.setString(1, "Ermenegildo");
				statement.setString(2, "Zegna");
				statement.execute();
				System.out.println("Finito!!!");
				
				
			

				}catch(SQLException e) {
				e.printStackTrace();
			}
		
		
		
		
		
		String quegny="select * from dipendenti where id=?";
		try(Connection connection= DriverManager.getConnection(url,"root","root");
			PreparedStatement statement =connection.prepareStatement(quegny);
				) {
				System.out.println("Connesso!!!");
				statement.setInt(1, 10);// il primo dove metto index,secondo quello volutos
				ResultSet result =statement.executeQuery();
				while(result.next()) {   
					int id =result.getInt(1); 
					String nome= result.getString("nome");
					String cognome= result.getString(3);
					System.out.println(id+" "+nome+" "+cognome+" " );
					
				}
				System.out.println("Finito!!!");
				
				
			

				}catch(SQLException e) {
				e.printStackTrace();
			}
		
		
	}
	
	
}

