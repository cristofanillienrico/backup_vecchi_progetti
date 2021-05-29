package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import main.model.Aereo;
import main.model.Aereoporto;

public class DaoAereoImpl implements DaoAereo{

	@Override
	public Aereo get(Integer id) {
		
		String query="SELECT * FROM aereo WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,id);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Aereo aereo= new Aereo();
					aereo.setId(id);
					aereo.setModello(result.getString("modello"));
					aereo.setIdStatoAereo(result.getInt(3));
					
					return aereo;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public ArrayList<Aereo> getAll() {
		
		String query="SELECT * FROM aereo";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				ArrayList<Aereo> listaAerei = new ArrayList<>(); 
				while(result.next()) {
					
					Aereo aereo= new Aereo();
					aereo.setId(result.getInt(1));
					aereo.setModello(result.getString("modello"));
					aereo.setIdStatoAereo(result.getInt(3));
					listaAerei.add(aereo);
					
				}
				 return listaAerei;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void insert(Aereo aereo) {
		
		String query="INSERT INTO aereo(modello,id_stato_aereo) VALUES(?,?);";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1,aereo.getModello());
			    statement.setInt(2,aereo.getIdStatoAereo());
				statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

		
	
	
	@Override
	public void update(Aereo aereo) {
		
		String query="UPDATE aereo SET modello=?, id_stato_aereo=? WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1,aereo.getModello());
			    statement.setInt(2,aereo.getIdStatoAereo());
			    statement.setInt(3,aereo.getId());
				statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void delete(Integer id) {
		DaoAereoImpl impl= new DaoAereoImpl();
		Aereo aereo= impl.get(id);
		aereo.setIdStatoAereo(3);
		impl.update(aereo);
		
		
	}

	@Override
	public ArrayList<Aereo> aereiInVoloDataOra(Date data) {
		String query="SELECT distinct a.id,a.modello\r\n"
				+ "FROM aereo AS a\r\n"
				+ "INNER JOIN volo v ON v.aereo_id=a.id\r\n"
				+ "WHERE ?> v.orario_partenza AND ?< v.orario_arrivo";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    Timestamp timestp = new Timestamp(data.getTime());
			    statement.setTimestamp(1, timestp);
			    statement.setTimestamp(2, timestp);
			    ResultSet result=statement.executeQuery();
				ArrayList<Aereo> listaAerei = new ArrayList<>();
				DaoAereoImpl impl= new DaoAereoImpl();
				
				while(result.next()) {
					
					
					Aereo aereo=impl.get(result.getInt(1));
					listaAerei.add(aereo);
					
					
				}
				 return listaAerei;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
		
	}

	@Override
	public Aereoporto aereoportoArrivoUltimoVolo(Aereo aereo) {
		String query="SELECT *\r\n"
				+ "FROM (\r\n"
				+ "		SELECT v.aereoporto_arrivo_id,v.giorno_volo\r\n"
				+ "		FROM volo AS v\r\n"
				+ "		WHERE v.aereo_id=? \r\n"
				+ "		ORDER BY v.giorno_volo DESC) AS tab\r\n"
				+ "LIMIT 1;";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,aereo.getId());
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					DaoAereoportoImpl impl= new DaoAereoportoImpl();
					Aereoporto aereoporto= new Aereoporto();
					aereoporto.setId(result.getInt(1));
					aereoporto.setCitta(impl.get(result.getInt(1)).getCitta());
					
					return aereoporto;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Date ultimoGiornoVolato(Aereo aereo) {
		String query="SELECT *\r\n"
				+ "FROM(\r\n"
				+ "		SELECT v.giorno_volo\r\n"
				+ "		FROM aereo AS a\r\n"
				+ "		INNER JOIN volo AS v ON v.aereo_id=a.id\r\n"
				+ "		WHERE a.id=? \r\n"
				+ "		ORDER BY v.giorno_volo DESC) AS tab\r\n"
				+ "LIMIT 1;	";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,aereo.getId());
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Date ultimoGiorno= new Date(result.getDate(1).getTime());
					return ultimoGiorno;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}
	
	
	
	
	

	

}
