package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import main.model.Aereo;
import main.model.Aereoporto;

public class DaoAereoportoImpl implements DaoAereoporto {

	@Override
	public Aereoporto get(Integer id) {
		String query="SELECT * FROM aereoporto WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setInt(1,id);
				ResultSet result=statement.executeQuery();
				if(result.next()) {
					
					Aereoporto aereoporto= new Aereoporto();
					aereoporto.setId(id);
					aereoporto.setCitta(result.getString(2));
					
					return aereoporto;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public ArrayList<Aereoporto> getAll() {
		String query="SELECT * FROM aereoporto";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    
				ResultSet result=statement.executeQuery();
				ArrayList<Aereoporto> listaAereoporti = new ArrayList<>(); 
				while(result.next()) {
					
					Aereoporto aereoporto= new Aereoporto();
					aereoporto.setId(result.getInt(1));
					aereoporto.setCitta(result.getString(2));
					
					
					listaAereoporti.add(aereoporto);
					
				}
				 return listaAereoporti;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void insert(Aereoporto aereoporto) {
		String query="INSERT INTO aereoporto(citta) VALUES(?)";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			    statement.setString(1,aereoporto.getCitta());
			    statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}

	}

	@Override
	public void update(Aereoporto aereoporto) {
		String query="UPDATE aereoporto SET citta=? WHERE id=?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			   	statement.setString(1, aereoporto.getCitta());
			   	statement.setInt(2, aereoporto.getId());
			    statement.execute();
				
				}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Aereoporto> aereoportiAereoXgiorni(Aereo aereo, int xGiorni) {
		String query="SELECT aereo.id AS areo_id,aereo.modello,aereoporto.id AS aereporto_id,aereoporto.citta,v.giorno_volo\r\n"
				+ "FROM aereo \r\n"
				+ "INNER JOIN volo AS v ON v.aereo_id=aereo.id\r\n"
				+ "INNER JOIN aereoporto ON v.aereoporto_arrivo_id=aereoporto.id\r\n"
				+ "WHERE aereo.id=? AND v.giorno_volo BETWEEN ? AND ?";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
				Date oggi = new Date();
				
			    Calendar cal = Calendar.getInstance();
				cal.setTime(oggi);
				cal.add(Calendar.DATE, -xGiorni);
				Date dateBeforeXDays = cal.getTime();
				
				java.sql.Date oggiSQL = new java.sql.Date(oggi.getTime());
				java.sql.Date dateBeforeXDaysSQL = new java.sql.Date(dateBeforeXDays.getTime());
				
				
				statement.setInt(1, aereo.getId());
				statement.setDate(2, dateBeforeXDaysSQL);
				statement.setDate(3, oggiSQL);
				ResultSet result=statement.executeQuery();
				ArrayList<Aereoporto> listaAereoporti = new ArrayList<>(); 
				while(result.next()) {
					
					Aereoporto aereoporto= new Aereoporto();
					aereoporto.setId(result.getInt(1));
					aereoporto.setCitta(result.getString(2));
					
					
					listaAereoporti.add(aereoporto);
					
				}
				 return listaAereoporti;
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Aereoporto piuAereiGiornoX(Date giorno) {
		String query="SELECT  tab.id,tab.citta,numero_voli\r\n"
				+ "FROM(\r\n"
				+ "		SELECT COUNT(volo.id) AS numero_voli,aereoporto.id,aereoporto.citta\r\n"
				+ "		FROM aereoporto\r\n"
				+ "		INNER JOIN volo ON volo.aereporto_partenza_id=aereoporto.id\r\n"
				+ "		WHERE volo.giorno_volo=? \r\n"
				+ "		GROUP BY aereoporto.id\r\n"
				+ "		ORDER BY numero_voli DESC) AS tab\r\n"
				+ "LIMIT 1;";
		
		try(Connection conn=this.getConnection();
			PreparedStatement statement= conn.prepareStatement(query);
			){	
			
				java.sql.Date giornoSql = new java.sql.Date(giorno.getTime());
			    statement.setDate(1,giornoSql);
				ResultSet result=statement.executeQuery();
				DaoAereoportoImpl impl= new DaoAereoportoImpl();
				
				if(result.next()) {
					
					Aereoporto aereoporto=impl.get(result.getInt(1));
					
					return aereoporto;
				}
				
			
					
			
		}catch(SQLException e) {
			System.out.println("qui");
			e.printStackTrace();
			
		}
		return null;
	}

}
