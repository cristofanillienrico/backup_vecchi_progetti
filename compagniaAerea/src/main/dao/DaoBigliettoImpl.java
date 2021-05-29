package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import main.model.Biglietto;
import main.model.Volo;

public class DaoBigliettoImpl implements DaoBiglietto{

	@Override
	public Biglietto get(Integer id) {
		String query="SELECT * FROM biglietto WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,id);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Biglietto biglietto= new Biglietto();
					biglietto.setId(id);
					biglietto.setPrezzo(result.getInt(2));
					biglietto.setIdPasseggero(result.getInt(3));
					biglietto.setIdVolo(result.getInt(4));
					
					return biglietto;
					
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public ArrayList<Biglietto> getAll() {
		String query="SELECT * FROM biglietto ";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			   
				ResultSet result=statement.executeQuery();
				ArrayList<Biglietto> listaBiglietti=new ArrayList<Biglietto>();
				
				while(result.next()) {
					
					Biglietto biglietto= new Biglietto();
					biglietto.setId(result.getInt(1));
					biglietto.setPrezzo(result.getInt(2));
					biglietto.setIdPasseggero(result.getInt(3));
					biglietto.setIdVolo(result.getInt(4));
					listaBiglietti.add(biglietto);
					
					
					
					
				}
				
				return listaBiglietti;
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void insert(Biglietto biglietto) {
		String query="INSERT INTO biglietto(prezzo,id_passeggero,id_volo) VALUES(?,?,?)";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1, biglietto.getPrezzo());
			    statement.setInt(2, biglietto.getIdPasseggero());
			    statement.setInt(3, biglietto.getIdVolo());
				statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void update(Biglietto biglietto) {
		String query="UPDATE biglietto SET prezzo=?,id_passeggero=?,id_volo=? WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				statement.setInt(1, biglietto.getPrezzo());
			    statement.setInt(2, biglietto.getIdPasseggero());
			    statement.setInt(3, biglietto.getIdVolo());
			    statement.setInt(4, biglietto.getId());
			    
				statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void delete(Integer id) {
		String query="DELETE FROM biglietto WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				statement.setInt(1, id);
			    statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void cancellaBigliettiVolo(Volo volo) {
		String query="DELETE \r\n"
				+ "FROM biglietto\r\n"
				+ "WHERE id_volo=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				statement.setInt(1,volo.getId());
			    statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

}
