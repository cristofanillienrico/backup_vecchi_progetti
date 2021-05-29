package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import main.model.Volo;

public class DaoVoloImpl implements DaoVolo {

	@Override
	public Volo get(Integer id) {
		String query="SELECT * FROM volo WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,id);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Volo volo= new Volo();
					
					volo.setId(id);
					
					Timestamp partenza=result.getTimestamp(2);
					Date partenzaDate= new Date(partenza.getTime());
					volo.setOrarioPartenza(partenzaDate);
					
					Timestamp arrivo=result.getTimestamp(3);
					Date arrivoDate= new Date(arrivo.getTime());
					volo.setOrarioArrivo(arrivoDate);
					
					Date giorno=result.getDate(4);
					volo.setGiornoVolo(giorno);
					
					volo.setAereoId(result.getInt(5));
					volo.setPilotaId(result.getInt(6));
					volo.setAereoportoPartenzaId(result.getInt(7));
					volo.setAereoportoArrivoId(result.getInt(8));
					volo.setAnnullato(result.getBoolean(9));
					
					return volo;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public ArrayList<Volo> getAll() {
		String query="SELECT * FROM volo";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				ArrayList<Volo> listaVoli = new ArrayList<>(); 
				while(result.next()) {
					
					Volo volo= new Volo();
					
					volo.setId(result.getInt(1));
					
					Timestamp partenza=result.getTimestamp(2);
					Date partenzaDate= new Date(partenza.getTime());
					volo.setOrarioPartenza(partenzaDate);
					
					Timestamp arrivo=result.getTimestamp(3);
					Date arrivoDate= new Date(arrivo.getTime());
					volo.setOrarioArrivo(arrivoDate);
					
					Date giorno=result.getDate(4);
					volo.setGiornoVolo(giorno);
					
					volo.setAereoId(result.getInt(5));
					volo.setPilotaId(result.getInt(6));
					volo.setAereoportoPartenzaId(result.getInt(7));
					volo.setAereoportoArrivoId(result.getInt(8));
					volo.setAnnullato(result.getBoolean(9));

					
					listaVoli.add(volo);
					
				}
				 return listaVoli;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void insert(Volo volo) {
		String query="INSERT INTO volo(orario_partenza,orario_arrivo,giorno_volo,aereo_id,pilota_id,aereporto_partenza_id,aereoporto_arrivo_id) VALUES(?,?,?,?,?,?,?)";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    Timestamp partenza= new Timestamp(volo.getOrarioPartenza().getTime());
			    statement.setTimestamp(1, partenza);
			    
			    Timestamp arrivo = new Timestamp(volo.getOrarioArrivo().getTime());
			    statement.setTimestamp(2, arrivo);
			    
			    java.sql.Date giorno=new java.sql.Date(volo.getGiornoVolo().getTime());
			    statement.setDate(3,giorno);
			    
			    statement.setInt(4, volo.getAereoId());
			    statement.setInt(5, volo.getPilotaId());
			    statement.setInt(6, volo.getAereoportoPartenzaId());
			    statement.setInt(7, volo.getAereoportoArrivoId());
			    
			    statement.execute();
			    
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}

	}

	@Override
	public void update(Volo volo) {
		String query="UPDATE volo SET aereo_id=?,pilota_id=?,aereporto_partenza_id=?,aereoporto_arrivo_id=?,flag_annullato=? WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			   	statement.setInt(1, volo.getAereoId());
			   	statement.setInt(2, volo.getPilotaId());
			   	statement.setInt(3, volo.getAereoportoPartenzaId());
			   	statement.setInt(4, volo.getAereoportoArrivoId());
			   	statement.setBoolean(5,volo.isAnnullato());
			   	statement.setInt(6, volo.getId());
			
			    statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
				}
	}

	@Override
	public void delete(Integer id) {
		DaoVoloImpl impl= new DaoVoloImpl();
		Volo volo= impl.get(id);
		volo.setAnnullato(true);
		impl.update(volo);
		


}

	@Override
	public Volo incassatoDiPiu() {
		String query="SELECT *\r\n"
				+ "FROM(\r\n"
				+ "	SELECT v.id,SUM(b.prezzo)\r\n"
				+ "	FROM biglietto AS b\r\n"
				+ "	INNER JOIN volo AS v ON b.id_volo=v.id\r\n"
				+ "	GROUP BY v.id\r\n"
				+ "	ORDER BY b.prezzo DESC	\r\n"
				+ ") AS tab\r\n"
				+ "LIMIT 1;";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			   
				ResultSet result=statement.executeQuery();
				DaoVoloImpl impl= new DaoVoloImpl();
				
				if(result.next()) {
					
					int id=result.getInt(1);
					Volo volo=impl.get(id);
					
					return volo;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	
	
	
	
	
	@Override
	public Volo incassatoDiPiu(Date inizio, Date fine) {
		String query="SELECT *\r\n"
				+ "FROM(\r\n"
				+ "	SELECT v.id,SUM(b.prezzo)\r\n"
				+ "	FROM biglietto AS b\r\n"
				+ "	INNER JOIN volo AS v ON b.id_volo=v.id\r\n"
				+ "	WHERE ?<= v.orario_partenza AND v.orario_arrivo<=? \r\n"
				+ "	GROUP BY v.id\r\n"
				+ "	ORDER BY b.prezzo DESC	\r\n"
				+ ") AS tab\r\n"
				+ "LIMIT 1;";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				Timestamp inizioTst= new Timestamp(inizio.getTime());
				statement.setTimestamp(1, inizioTst);
		    
				Timestamp fineTst = new Timestamp(fine.getTime());
				statement.setTimestamp(2, fineTst);
				
				ResultSet result=statement.executeQuery();
				DaoVoloImpl impl= new DaoVoloImpl();
				
				if(result.next()) {
					
					int id=result.getInt(1);
					Volo volo=impl.get(id);
					
					return volo;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public ArrayList<Volo> voliInNegativo(Date giorno) {
		String query="SELECT v.id AS id_volo,(sum(b.prezzo)-p.stipendio) AS ricavo\r\n"
				+ "FROM volo AS v\r\n"
				+ "INNER JOIN biglietto AS b ON b.id_volo=v.id\r\n"
				+ "INNER JOIN pilota AS p ON v.pilota_id=p.id\r\n"
				+ "WHERE v.giorno_volo=? \r\n"
				+ "GROUP BY v.id\r\n"
				+ "HAVING ricavo<0";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				java.sql.Date giornoSql= new java.sql.Date(giorno.getTime());
			    statement.setDate(1, giornoSql);
				ResultSet result=statement.executeQuery();
				ArrayList<Volo> listaVoli = new ArrayList<>();
				DaoVoloImpl impl =new DaoVoloImpl();
				
				while(result.next()) {
					Volo volo=impl.get(result.getInt(1));
					listaVoli.add(volo);
					
				}
				 return listaVoli;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
		
	}
	
}
