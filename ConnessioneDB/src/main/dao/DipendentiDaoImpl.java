package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import main.model.Dipendenti;

public class DipendentiDaoImpl extends DipendentiDao {
	
	@Override
	public Dipendenti get(int id) {
		
		String query = "SELECT * FROM DIPENDENTI WHERE id = ?";
		
		//ottenere connessione
		try (
			Connection connection= getConnection();
			PreparedStatement statement= connection.prepareStatement(query);
			){
			
			//eseguo query
			statement.setInt(1,id);
			ResultSet result= statement.executeQuery();
			
			
			//ricostruisco il risultato
			Dipendenti dipendenti= new Dipendenti();
			if(result.next()) {  //no while è campo unico
				dipendenti.setId(result.getInt("id"));
				dipendenti.setNome(result.getString("nome"));
				dipendenti.setCognome(result.getString("cognome"));
				return dipendenti;
				
			
			
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			
		}
		
		return null;
			
		}

	

	
	
	
	@Override
	public ArrayList<Dipendenti> getAll() {
		
		String query = "SELECT * FROM dipendenti";
		
		//ottenere connessione
		try (
			Connection connection= getConnection();
			Statement statement =connection.createStatement();
			){
			
			//eseguo query e ricostruisco il risultato
			if(statement.execute(query)) { 
				
				ResultSet result=statement.getResultSet();
				ArrayList<Dipendenti> listaDipendenti=new ArrayList<>();
				
				
				while(result.next()) {
					Dipendenti dipendente= new Dipendenti();
					dipendente.setId(result.getInt(1));
					dipendente.setNome(result.getString(2));
					dipendente.setCognome(result.getString(3));
					
					listaDipendenti.add(dipendente);
				
					
				}
				
				return listaDipendenti;
				
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		
	}
		return null;    
		
	}






	@Override
	public void insert(Dipendenti dipendente) {
		String query = "INSERT INTO dipendenti(nome,cognome) VALUES (?,?)";
		
		//ottenere connessione
		try (
			Connection connection= getConnection();
			PreparedStatement statement= connection.prepareStatement(query);
			){
			
			
			//dal dipendente alla statement
			statement.setString(1,dipendente.getNome());
			statement.setString(2,dipendente.getCognome());
			
			//eseguo query
			statement.execute();
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			
		}
		
	}






	@Override
	public void delete(int id) {
		String query = "DELETE FROM azienda.dipendenti WHERE  id=?";
		
		//ottenere connessione
		try (
			Connection connection= getConnection();
			PreparedStatement statement= connection.prepareStatement(query);
			){
			
			//eseguo query
			statement.setInt(1,id);
			statement.execute();
			
			
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			
		}
		
	}






	@Override
	public void update(Dipendenti dipendente) {
		
		String query = "UPDATE dipendenti SET nome=?, cognome=? WHERE id=?";
		
		//ottenere connessione
		try (
			Connection connection= getConnection();
			PreparedStatement statement= connection.prepareStatement(query);
			){
			
			//eseguo query
			
			statement.setInt(3,dipendente.getId());
			statement.execute();
			
			
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			
		}
		
	}

	
	
	
	
	
}


