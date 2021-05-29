package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import main.model.Aereoporto;
import main.model.Passeggero;
import main.model.Volo;

public class DaoPasseggeroImpl implements DaoPasseggero {

	@Override
	public Passeggero get(Integer id) {
		
		String query="SELECT * FROM passeggero WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,id);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Passeggero passeggero= new Passeggero();
					passeggero.setId(id);
					passeggero.setNome(result.getString(2));
					passeggero.setCognome(result.getString(3));
					passeggero.setCodiceFiscale(result.getString(4));
					
					
					return passeggero;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	
	
	
	
	
	
	
	@Override
	public ArrayList<Passeggero> getAll() {
		
		String query="SELECT * FROM passeggero";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				ArrayList<Passeggero> listaPasseggeri = new ArrayList<>(); 
				while(result.next()) {
					
					Passeggero passeggero= new Passeggero();
					passeggero.setId(result.getInt(1));
					passeggero.setNome(result.getString(2));
					passeggero.setCognome(result.getString(3));
					passeggero.setCodiceFiscale(result.getString(4));
					
					
					listaPasseggeri.add(passeggero);
					
				}
				 return listaPasseggeri;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void insert(Passeggero passeggero) {
		
		String query="INSERT INTO passeggero(nome,cognome,codice_fiscale) VALUES(?,?,?)";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1,passeggero.getNome());
			    statement.setString(2,passeggero.getCognome());
			    statement.setString(3,passeggero.getCodiceFiscale());
			    
			    statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

		
	
	
	@Override
	public void update(Passeggero passeggero) {
		
		String query="UPDATE passeggero SET nome=?,cognome=?,codice_fiscale=? WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			   	statement.setString(1, passeggero.getNome());
			   	statement.setString(2, passeggero.getCognome());
			   	statement.setString(3, passeggero.getCodiceFiscale());
			   	statement.setInt(4, passeggero.getId());
				statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void delete(Integer id) {
		return ;
		
	}








	@Override
	public int inVolo(String localita) {
		String query="SELECT COUNT(p.id)\r\n"
				+ "FROM passeggero AS p\r\n"
				+ "INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "INNER JOIN volo AS v ON b.id_volo=v.id\r\n"
				+ "INNER JOIN aereoporto AS a ON v.aereporto_partenza_id=a.id\r\n"
				+ "WHERE a.citta=?;";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1,localita);
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
	public Passeggero volatoPiuSpesso() {
		String query="SELECT id,nome,cognome,codice_fiscale\r\n"
				+ "FROM (SELECT COUNT(b.id) AS c,p.id,p.nome,p.cognome,p.codice_fiscale\r\n"
				+ "		FROM passeggero AS p\r\n"
				+ "		INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "		GROUP BY p.id\r\n"
				+ "		ORDER BY c desc\r\n"
				+ "		) AS res\r\n"
				+ "LIMIT 1";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Passeggero passeggero= new Passeggero();
					passeggero.setId(result.getInt(1));
					passeggero.setNome(result.getString(2));
					passeggero.setCognome(result.getString(3));
					passeggero.setCodiceFiscale(result.getString(4));
					
					
					return passeggero;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}








	@Override
	public Passeggero spesoDiPiu() {
		String query="SELECT tab1.id,tab1.nome,tab1.cognome,tab1.codice_fiscale,tab1.somma AS spesa_totale\r\n"
				+ "FROM (SELECT sum(b.prezzo) AS somma,p.id,p.nome,p.cognome,p.codice_fiscale\r\n"
				+ "		FROM passeggero AS p\r\n"
				+ "		INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "		GROUP BY p.id) AS tab1\r\n"
				+ "		\r\n"
				+ "WHERE tab1.somma= (SELECT MAX(somma)\r\n"
				+ "						FROM (SELECT sum(b.prezzo) AS somma,p.id,p.nome,p.cognome\r\n"
				+ "								FROM passeggero AS p\r\n"
				+ "								INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "								GROUP BY p.id) AS tab2\r\n"
				+ "\r\n"
				+ "						)";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Passeggero passeggero= new Passeggero();
					passeggero.setId(result.getInt(1));
					passeggero.setNome(result.getString(2));
					passeggero.setCognome(result.getString(3));
					passeggero.setCodiceFiscale(result.getString(4));
					
					
					return passeggero;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}








	@Override
	public Passeggero mediaSpesoDiMeno() {
		String query="SELECT res1.id,res1.nome,res1.cognome,res1.codice_fiscale,res1.media\r\n"
				+ "FROM (SELECT avg(b.prezzo) AS media,p.id,p.nome,p.cognome,p.codice_fiscale\r\n"
				+ "		FROM passeggero AS p\r\n"
				+ "		INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "		GROUP BY p.id\r\n"
				+ "		) AS res1\r\n"
				+ "WHERE res1.media=(SELECT min(res2.media)\r\n"
				+ "						FROM (SELECT avg(b.prezzo) AS media,p.nome,p.cognome\r\n"
				+ "								FROM passeggero AS p\r\n"
				+ "								INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "								GROUP BY p.id\r\n"
				+ "								) AS res2)";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Passeggero passeggero= new Passeggero();
					passeggero.setId(result.getInt(1));
					passeggero.setNome(result.getString(2));
					passeggero.setCognome(result.getString(3));
					passeggero.setCodiceFiscale(result.getString(4));
					
					
					return passeggero;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}








	@Override
	public ArrayList<Passeggero> passeggeriVoloX(Volo VoloX) {
		String query="SELECT p.id,p.nome,p.cognome,p.codice_fiscale\r\n"
				+ "FROM passeggero AS p \r\n"
				+ "INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "INNER JOIN volo AS v ON b.id_volo=v.id\r\n"
				+ "WHERE v.id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1, VoloX.getId());
				ResultSet result=statement.executeQuery();
				ArrayList<Passeggero> listaPasseggeri = new ArrayList<>(); 
				while(result.next()) {
					
					Passeggero passeggero= new Passeggero();
					passeggero.setId(result.getInt(1));
					passeggero.setNome(result.getString(2));
					passeggero.setCognome(result.getString(3));
					passeggero.setCodiceFiscale(result.getString(4));
					
					
					listaPasseggeri.add(passeggero);
					
				}
				 return listaPasseggeri;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}








	@Override
	public int numPasseggeriGiornoAereoporto(Date giorno, Aereoporto aereoporto) {
		String query="SELECT COUNT(p.id)\r\n"
				+ "FROM passeggero AS p\r\n"
				+ "INNER JOIN biglietto AS b ON b.id_passeggero=p.id\r\n"
				+ "INNER JOIN volo AS v ON b.id_volo=v.id\r\n"
				+ "WHERE v.giorno_volo=? AND v.aereoporto_arrivo_id=? \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "";
		
		
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				java.sql.Date giornoSql =new java.sql.Date(giorno.getTime());
				statement.setDate(1,giornoSql);
				statement.setInt(2, aereoporto.getId());
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
	public boolean isInDatabase(Passeggero passeggero) {
		String query="SELECT *\r\n"
				+ "FROM passeggero AS p\r\n"
				+ "WHERE nome=? AND cognome=? AND codice_fiscale=? ";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1, passeggero.getNome());
			    statement.setString(2, passeggero.getCognome());
			    statement.setString(3, passeggero.getCodiceFiscale());
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					return true;
				}else {
					return false;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("Errore!!!");
			e.printStackTrace();
			
		}
		return false;
	}








	@Override
	public Passeggero get(String nome, String cognome, String codiceFiscale) {
		String query="SELECT *\r\n"
				+ "FROM passeggero AS p\r\n"
				+ "WHERE nome=? AND cognome=? AND codice_fiscale=? ";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1, nome);
			    statement.setString(2, cognome);
			    statement.setString(3, codiceFiscale);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					Passeggero passeggero= new Passeggero();
					passeggero.setId(result.getInt(1));
					passeggero.setNome(nome);
					passeggero.setCognome(cognome);
					passeggero.setCodiceFiscale(codiceFiscale);
					
					return passeggero;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("Errore!!!");
			e.printStackTrace();
			
		}
		return null;
	}
}
