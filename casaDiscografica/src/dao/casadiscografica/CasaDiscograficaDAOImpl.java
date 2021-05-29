package dao.casadiscografica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractMySQLDAO;
import model.Autore;
import model.CasaDiscografica;

public class CasaDiscograficaDAOImpl extends AbstractMySQLDAO implements CasaDiscograficaDAO{

	@Override
	public List<CasaDiscografica> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
				CasaDiscografica casaDiscograficaTemp = null;

				try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from casa_discografica")) {

					while (rs.next()) {
						casaDiscograficaTemp = new CasaDiscografica();
						casaDiscograficaTemp.setId(rs.getLong(1));
						casaDiscograficaTemp.setRagioneSociale(rs.getString(2));
						casaDiscograficaTemp.setIndirizzo(rs.getString(3));
						casaDiscograficaTemp.setDataFondazione(rs.getDate(4));
						result.add(casaDiscograficaTemp);
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public CasaDiscografica get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (idInput == null || idInput < 1)
					throw new Exception("Valore di input non ammesso.");

				CasaDiscografica result = null;
				try (PreparedStatement ps = connection.prepareStatement("select * from casa_discografica where id=?")) {

					ps.setLong(1, idInput);
					try (ResultSet rs = ps.executeQuery()) {
						if (rs.next()) {
							CasaDiscografica casaDiscograficaTemp = null;
							casaDiscograficaTemp = new CasaDiscografica();
							casaDiscograficaTemp.setId(idInput);
							casaDiscograficaTemp.setRagioneSociale(rs.getString(2));
							casaDiscograficaTemp.setIndirizzo(rs.getString(3));
							casaDiscograficaTemp.setDataFondazione(rs.getDate(4));
							return casaDiscograficaTemp;
						} 
					}
					
				} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
					return result;
	}

	@Override
	public int update(CasaDiscografica input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (input == null || input.getId() == null || input.getId() <1)
					throw new Exception("Valore di input non ammesso.");

				int result = 0;
				try (PreparedStatement ps = connection.prepareStatement(
						"UPDATE casa_discografica SET ragione_sociale=?, indirizzo=?, data_fondazione=? where id=?;")) {
					ps.setString(1, input.getRagioneSociale());
					ps.setString(2, input.getIndirizzo());
					ps.setDate(3, new java.sql.Date(input.getDataFondazione().getTime()));
					ps.setLong(4, input.getId());
					
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public int insert(CasaDiscografica input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (input == null)
					throw new Exception("Valore di input non ammesso.");

				int result = 0;
				try (PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO casa_discografica (ragione_sociale,indirizzo,data_fondazione) VALUES (?, ?, ?);")) {
					ps.setString(1, input.getRagioneSociale());
					ps.setString(2, input.getIndirizzo());
					ps.setDate(3, new java.sql.Date(input.getDataFondazione().getTime()));
					
					
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public int delete(CasaDiscografica input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (input == null || input.getId() == null || input.getId() <1)
					throw new Exception("Valore di input non ammesso.");
				
				

				int result = 0;
				try (PreparedStatement ps = connection.prepareStatement("DELETE FROM casa_discografica WHERE ID=?")) {
					ps.setLong(1, input.getId());
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public List<CasaDiscografica> findByExample(CasaDiscografica example) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (example == null)
					throw new Exception("Valore di input non ammesso.");

				ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
				CasaDiscografica casaDiscograficaTemp = null;

				String query = "select * from casa_discografica where 1=1 ";
				if (example.getRagioneSociale() != null && !example.getRagioneSociale().equals("")) {
					query += " and ragione_sociale='" + example.getRagioneSociale() + "' ";
				}
				if (example.getIndirizzo() != null && !example.getIndirizzo().equals("")) {
					query += " and indirizzo='" + example.getIndirizzo() + "' ";
				}

				if (example.getDataFondazione() != null && !example.getDataFondazione().equals("")) {
					query += " and data_fondazione='" + example.getDataFondazione() + "' ";
				

				try (Statement ps = connection.createStatement()) {
					ResultSet rs = ps.executeQuery(query);

					while (rs.next()) {

						casaDiscograficaTemp = new CasaDiscografica();
						casaDiscograficaTemp.setId(rs.getLong(1));
						casaDiscograficaTemp.setRagioneSociale(rs.getString(2));
						casaDiscograficaTemp.setIndirizzo(rs.getString(3));
						casaDiscograficaTemp.setDataFondazione(rs.getDate(4));
						result.add(casaDiscograficaTemp);

					}
						return result;

				} catch (Exception e) {
					e.printStackTrace();
					throw e;

				}
				
			}
				return null;
				
		}

	@Override
	public void setConnection(Connection connection) {
		this.connection=connection;
		
	}

	@Override
	public void populateAuthors(CasaDiscografica input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Autore> result = new ArrayList<Autore>();
		Autore autoreTemp = null;
		
		String query="SELECT *\r\n"
				+ "FROM autore AS a\r\n"
				+ "INNER JOIN casa_discografica AS c ON a.id_casa_discografica=c.id\r\n"
				+ "WHERE a.id_casa_discografica=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			
			
			ps.setLong(1,input.getId());
			
			try( ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					
					autoreTemp = new Autore();
					autoreTemp.setId(rs.getLong(1));
					autoreTemp.setNome(rs.getString(2));
					autoreTemp.setCognome(rs.getString(3));
					autoreTemp.setDataNascita(rs.getDate(4));
					autoreTemp.setNickname(rs.getString(5));
					autoreTemp.setCasaDiscografica(new CasaDiscografica(rs.getLong(7),rs.getString(8),rs.getString(9),rs.getDate(10)));
					
					result.add(autoreTemp);
				}
				
				input.setListaAutori(result);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}

	@Override
	public CasaDiscografica casaDiscograficaFindByAutore(Autore input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() < 1 )
			throw new Exception("Valore di input non ammesso.");

		CasaDiscografica result = null;
		
		String query="SELECT *\r\n"
				+ "FROM casa_discografica AS c\r\n"
				+ "INNER JOIN autore AS a ON a.id_casa_discografica=c.id\r\n"
				+ "WHERE a.id=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, input.getId());
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					CasaDiscografica casaDiscograficaTemp = null;
					casaDiscograficaTemp = new CasaDiscografica();
					casaDiscograficaTemp.setId(rs.getLong("id_casa_discografica"));
					casaDiscograficaTemp.setRagioneSociale(rs.getString(2));
					casaDiscograficaTemp.setIndirizzo(rs.getString(3));
					casaDiscograficaTemp.setDataFondazione(rs.getDate(4));
					return casaDiscograficaTemp;
				} 
			}
			
		} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return result;
	}

	@Override
	public List<CasaDiscografica> findAllByAutoreWhereSurnameStartsWith(String iniziale) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;
		
		String query="SELECT *\r\n"
				+ "FROM casa_discografica AS c\r\n"
				+ "INNER JOIN autore AS a ON a.id_casa_discografica=c.id\r\n"
				+ "WHERE a.cognome LIKE ?";
		try (PreparedStatement ps = connection.prepareStatement(query);) {
			
			ps.setString(1, iniziale+"%");
			
			try( ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					casaDiscograficaTemp = new CasaDiscografica();
					casaDiscograficaTemp.setId(rs.getLong(1));
					casaDiscograficaTemp.setRagioneSociale(rs.getString(2));
					casaDiscograficaTemp.setIndirizzo(rs.getString(3));
					casaDiscograficaTemp.setDataFondazione(rs.getDate(4));
					result.add(casaDiscograficaTemp);
			}

			
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
				CasaDiscografica casaDiscograficaTemp = null;
				
				String query="SELECT *\r\n"
						+ "FROM casa_discografica AS c\r\n"
						+ "INNER JOIN autore AS a ON a.id_casa_discografica=c.id\r\n"
						+ "INNER JOIN cd ON cd.id_autore=a.id\r\n"
						+ "WHERE cd.genere=? ";
				try (PreparedStatement ps = connection.prepareStatement(query);) {
					
					ps.setString(1, genere);
					
					try( ResultSet rs = ps.executeQuery()){
						while (rs.next()) {
							casaDiscograficaTemp = new CasaDiscografica();
							casaDiscograficaTemp.setId(rs.getLong(1));
							casaDiscograficaTemp.setRagioneSociale(rs.getString(2));
							casaDiscograficaTemp.setIndirizzo(rs.getString(3));
							casaDiscograficaTemp.setDataFondazione(rs.getDate(4));
							result.add(casaDiscograficaTemp);
					}

					
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

}
