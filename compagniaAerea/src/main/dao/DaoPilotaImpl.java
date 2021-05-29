package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import main.model.Pilota;

public class DaoPilotaImpl implements DaoPilota {

	@Override
	public Pilota get(Integer id) {
		
		String query="SELECT * FROM pilota WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,id);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Pilota pilota= new Pilota();
					pilota.setId(id);
					pilota.setNome(result.getString(2));
					pilota.setCognome(result.getString(3));
					pilota.setStipendio(result.getInt(4));
					pilota.setIdStatoPilota(result.getInt(5));
					
					return pilota;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	
	
	
	
	
	
	
	@Override
	public ArrayList<Pilota> getAll() {
		
		String query="SELECT * FROM pilota";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				ArrayList<Pilota> listaPiloti = new ArrayList<>(); 
				while(result.next()) {
					
					Pilota pilota= new Pilota();
					pilota.setId(result.getInt(1));
					pilota.setNome(result.getString(2));
					pilota.setCognome(result.getString(3));
					pilota.setStipendio(result.getInt(4));
					pilota.setIdStatoPilota(result.getInt(5));
					
					listaPiloti.add(pilota);
					
				}
				 return listaPiloti;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void insert(Pilota pilota) {
		
		String query="INSERT INTO pilota(nome,cognome,stipendio,id_stato_pilota) VALUES(?,?,?,?)";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1,pilota.getNome());
			    statement.setString(2,pilota.getCognome());
			    statement.setInt(3, pilota.getStipendio());
			    statement.setInt(4, pilota.getIdStatoPilota());
			    statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

		
	
	
	@Override
	public void update(Pilota pilota) {
		
		String query="UPDATE pilota SET nome=?,cognome=?,stipendio=?,id_stato_pilota=? WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			   	statement.setString(1, pilota.getNome());
			   	statement.setString(2, pilota.getCognome());
			   	statement.setInt(3, pilota.getStipendio());
			   	statement.setInt(4, pilota.getIdStatoPilota());
			   	statement.setInt(5, pilota.getId());
				statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void delete(Integer id) {
		DaoPilotaImpl impl= new DaoPilotaImpl();
		Pilota pilota=impl.get(id);
		pilota.setIdStatoPilota(3);
		impl.update(pilota);
		
		
	}








	@Override
	public int pilotiInAttivita() {
		String query="SELECT COUNT(id)"
				+ "		FROM pilota"
				+ "		WHERE pilota.id_stato_pilota=1;";
		
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					return result.getInt(1);
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return 0;
	}







//in assoluto
	@Override
	public Pilota pilotaVolatoDiPiu() {
		String query="SELECT nome,cognome,stipendio,id_stato_pilota\r\n"
				+ "FROM(\r\n"
				+ "		SELECT COUNT(v.id)AS c,p.id,p.nome,p.cognome,p.stipendio,p.id_stato_pilota\r\n"
				+ "		FROM pilota AS p\r\n"
				+ "		INNER JOIN volo AS v ON v.pilota_id=p.id\r\n"
				+ "		GROUP BY p.id\r\n"
				+ "		ORDER BY c DESC\r\n"
				+ "		) AS tab\r\n"
				+ "LIMIT 1;	";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Pilota pilota= new Pilota();
					
					pilota.setNome(result.getString(1));
					pilota.setCognome(result.getString(2));
					pilota.setStipendio(result.getInt(3));
					pilota.setIdStatoPilota(result.getInt(4));
					
					return pilota;
					}
				}catch(SQLException e) {
					System.out.println("qui");
					e.printStackTrace();
					
				}
				return null;

		}





//tra due date
	@Override
	public Pilota pilotaVolatoDiPiu(Date inizio, Date fine) {
		String query="SELECT nome,cognome,stipendio,id_stato_pilota\r\n"
				+ "FROM(\r\n"
				+ "		SELECT COUNT(v.id)AS c,p.id,p.nome,p.cognome,p.stipendio,p.id_stato_pilota\r\n"
				+ "		FROM pilota AS p\r\n"
				+ "		INNER JOIN volo AS v ON v.pilota_id=p.id\r\n"
				+ "		WHERE (?<=v.orario_partenza) AND (v.orario_arrivo<=?)\r\n"
				+ "		GROUP BY p.id\r\n"
				+ "		ORDER BY c DESC\r\n"
				+ "		\r\n"
				+ "		) AS tab\r\n"
				+ "LIMIT 1;";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				Timestamp inizioTst= new Timestamp(inizio.getTime());
			    statement.setTimestamp(1, inizioTst);
			    Timestamp fineTst= new Timestamp(fine.getTime());
			    statement.setTimestamp(2, fineTst);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Pilota pilota= new Pilota();
					
					pilota.setNome(result.getString(1));
					pilota.setCognome(result.getString(2));
					pilota.setStipendio(result.getInt(3));
					pilota.setIdStatoPilota(result.getInt(4));
					
					return pilota;
					}
				}catch(SQLException e) {
					System.out.println("qui");
					e.printStackTrace();
					
				}
				return null;
	}








	@Override
	public int guadagnoCompagnia() {
		String query="SELECT SUM(b.prezzo)-sum(pilota.stipendio)\r\n"
				+ "FROM biglietto AS b\r\n"
				+ "INNER JOIN volo AS v ON b.id_volo=v.id\r\n"
				+ "INNER JOIN pilota ON v.pilota_id=pilota.id";
		
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					return result.getInt(1);
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return 0;
	}








	@Override
	public int guadagnoCompagnia(Date inizio, Date fine) {
		String query="SELECT SUM(b.prezzo)-sum(pilota.stipendio)\r\n"
				+ "FROM biglietto AS b\r\n"
				+ "INNER JOIN volo AS v ON b.id_volo=v.id\r\n"
				+ "INNER JOIN pilota ON v.pilota_id=pilota.id\r\n"
				+ "WHERE ? <= v.orario_partenza AND v.orario_arrivo <= ?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				Timestamp inizioTst= new Timestamp(inizio.getTime());
			    statement.setTimestamp(1, inizioTst);
			    Timestamp fineTst= new Timestamp(fine.getTime());
			    statement.setTimestamp(2, fineTst);
				ResultSet result=statement.executeQuery();
				
				if(result.next()) {
					
					return result.getInt(1);
							
					}
				}catch(SQLException e) {
					System.out.println("qui");
					e.printStackTrace();
					
				}
				return 0;
	}








	@Override
	public int numeroVoli(Pilota pilota) {
		String query="SELECT COUNT(v.id)\r\n"
				+ "FROM pilota AS p\r\n"
				+ "INNER JOIN volo AS v ON v.pilota_id=p.id\r\n"
				+ "WHERE p.id=?";
		
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1, pilota.getId());
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					return result.getInt(1);
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return 0;
	}
	
	
	
	
	

	

}


