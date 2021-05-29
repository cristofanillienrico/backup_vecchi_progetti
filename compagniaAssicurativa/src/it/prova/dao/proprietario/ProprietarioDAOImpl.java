package it.prova.dao.proprietario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.Automobile;
import it.prova.model.Proprietario;

public class ProprietarioDAOImpl extends AbstractMySQLDAO implements IProprietarioDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection=connection;
		
	}

	@Override
	public List<Proprietario> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<Proprietario> result = new ArrayList<Proprietario>();
				Proprietario proprietarioTemp = null;
				
				String query="select * from proprietario; ";
				try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {

					while (rs.next()) {
						proprietarioTemp=new Proprietario();
						proprietarioTemp.setId(rs.getLong("id"));
						proprietarioTemp.setNome(rs.getString("nome"));
						proprietarioTemp.setCognome(rs.getString("cognome"));
						proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));
						
						result.add(proprietarioTemp);
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public Proprietario get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		Proprietario proprietarioTemp = null;
		String query="SELECT *\r\n"
				+ "FROM proprietario AS c\r\n"
				+ "WHERE c.id=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, idInput);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					
					proprietarioTemp=new Proprietario();
					proprietarioTemp.setId(idInput);
					proprietarioTemp.setNome(rs.getString("nome"));
					proprietarioTemp.setCognome(rs.getString("cognome"));
					proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));
					return proprietarioTemp;
					
					
				} 
			}
			
		} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return null;
	}

	@Override
	public int update(Proprietario input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE proprietario SET nome=?,cognome=?,data_nascita=? where id=?;")) {
			
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setDate(3, new java.sql.Date(input.getDataNascita().getTime()));
			ps.setLong(4, input.getId());
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(Proprietario input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO proprietario (nome,cognome,data_nascita) VALUES (?, ?, ?);")) {
			
			ps.setString(1,input.getNome());
			ps.setString(2,input.getCognome());
			ps.setDate(3,new java.sql.Date(input.getDataNascita().getTime()));
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Proprietario input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (input == null || input.getId() == null || input.getId() <1)
					throw new Exception("Valore di input non ammesso.");
				
				

				int result = 0;
				try (PreparedStatement ps = connection.prepareStatement("DELETE FROM proprietario WHERE ID=?")) {
					ps.setLong(1, input.getId());
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public List<Proprietario> findByExample(Proprietario example) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (example == null)
					throw new Exception("Valore di input non ammesso.");

				ArrayList<Proprietario> result = new ArrayList<Proprietario>();
				Proprietario proprietarioTemp = null;

				String query = "select * from proprietario "
						+ " where 1=1 ";
				
				if (example.getNome() != null && !example.getNome().equals("")) {
					query += " and nome='" + example.getNome() + "' ";
				}
				if (example.getCognome() != null && !example.getCognome().equals("")) {
					query += " and cognome='" + example.getCognome() + "' ";
				}

				if (example.getDataNascita() != null && !example.getDataNascita().equals("")) {
					query += " and data_nascita='" + example.getDataNascita() + "' ";
					
				}

				try (Statement ps = connection.createStatement()) {
					ResultSet rs = ps.executeQuery(query);

					while (rs.next()) {
						
						proprietarioTemp=new Proprietario();
						proprietarioTemp.setId(rs.getLong("id"));
						proprietarioTemp.setNome(rs.getString("nome"));
						proprietarioTemp.setCognome(rs.getString("cognome"));
						proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));
						
						result.add(proprietarioTemp);
					}

						

					
					return result;

				} catch (Exception e) {
					e.printStackTrace();
					throw e;

				}
	}

	@Override
	public void populateAutomobili(Proprietario input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Automobile> result = new ArrayList<Automobile>();
		Automobile automobileTemp = null;
		
		String query="SELECT *\r\n"
				+ "FROM automobile AS a\r\n"
				+ "WHERE a.id_proprietario=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			
			
			ps.setLong(1,input.getId());
			
			try( ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					
					automobileTemp=new Automobile();
					automobileTemp.setId(rs.getLong("id"));
					automobileTemp.setMarca(rs.getString("marca"));
					automobileTemp.setModello(rs.getString("modello"));
					automobileTemp.setCilindrata(rs.getInt("cilindrata"));
					automobileTemp.setDataImmatricolazione(rs.getDate("data_immatricolazione"));
					result.add(automobileTemp);
					
					
				}
				
				input.setListaAutomobili(result);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public List<Proprietario> ownersCarsWithInsuranceCompanyInMilan() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Proprietario> result = new ArrayList<Proprietario>();
		Proprietario proprietarioTemp = null;
		
		String query="SELECT p.*\r\n"
				+ "FROM proprietario AS p\r\n"
				+ "INNER JOIN automobile AS a ON a.id_proprietario=p.id\r\n"
				+ "INNER JOIN compagnia_assicurativa AS c ON a.id_compagnia_assicurativa=c.id\r\n"
				+ "WHERE c.indirizzo LIKE '%,Milano'";
		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {

			while (rs.next()) {
				proprietarioTemp=new Proprietario();
				proprietarioTemp.setId(rs.getLong("id"));
				proprietarioTemp.setNome(rs.getString("nome"));
				proprietarioTemp.setCognome(rs.getString("cognome"));
				proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));
				
				result.add(proprietarioTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Proprietario> ownersCarsInsuredWithCompanyThatHasLessTwentyCars() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Proprietario> result = new ArrayList<Proprietario>();
		Proprietario proprietarioTemp = null;
		
		String query="SELECT DISTINCT  p.*\r\n"
				+ "FROM proprietario AS p\r\n"
				+ "INNER JOIN automobile AS a ON a.id_proprietario=p.id\r\n"
				+ "INNER JOIN compagnia_assicurativa AS c ON a.id_compagnia_assicurativa=c.id\r\n"
				+ "WHERE c.id IN(SELECT c.id \r\n"
				+ "		FROM compagnia_assicurativa AS c\r\n"
				+ "		INNER JOIN automobile AS a ON a.id_compagnia_assicurativa=c.id\r\n"
				+ "		INNER JOIN proprietario AS p ON a.id_proprietario=p.id\r\n"
				+ "		GROUP BY c.id\r\n"
				+ "		having COUNT(a.id)<20) ;";
		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {

			while (rs.next()) {
				proprietarioTemp=new Proprietario();
				proprietarioTemp.setId(rs.getLong("id"));
				proprietarioTemp.setNome(rs.getString("nome"));
				proprietarioTemp.setCognome(rs.getString("cognome"));
				proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));
				
				result.add(proprietarioTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
