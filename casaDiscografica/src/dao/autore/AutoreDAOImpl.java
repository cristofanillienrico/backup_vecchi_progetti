package dao.autore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractMySQLDAO;
import model.Autore;
import model.CasaDiscografica;
import model.Cd;


public class AutoreDAOImpl extends AbstractMySQLDAO implements AutoreDAO {

	@Override
	public List<Autore> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<Autore> result = new ArrayList<Autore>();
				Autore autoreTemp = null;
				
				String query="SELECT *\r\n"
						+ "FROM autore AS a\r\n"
						+ "INNER JOIN casa_discografica AS c ON a.id_casa_discografica=c.id";
				try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {

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

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public Autore get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		Autore autoreTemp = null;
		String query="SELECT *\r\n"
				+ "FROM autore AS a\r\n"
				+ "INNER JOIN casa_discografica AS c ON a.id_casa_discografica=c.id\r\n"
				+ "WHERE a.id=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					autoreTemp = new Autore();
					autoreTemp.setId(rs.getLong(1));
					autoreTemp.setNome(rs.getString(2));
					autoreTemp.setCognome(rs.getString(3));
					autoreTemp.setDataNascita(rs.getDate(4));
					autoreTemp.setNickname(rs.getString(5));
					autoreTemp.setCasaDiscografica(new CasaDiscografica(rs.getLong(7),rs.getString(8),rs.getString(9),rs.getDate(10)));
					return autoreTemp;
					
				} 
			}
			
		} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return null;
	}

	@Override
	public int update(Autore input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE autore SET nome=?,cognome=?,data_nascita=?,nickname=?,id_casa_discografica=? where id=?;")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setDate(3, new java.sql.Date(input.getDataNascita().getTime()));
			ps.setString(4, input.getNickname());
			ps.setLong(5, input.getCasaDiscografica().getId());
			ps.setLong(6, input.getId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(Autore input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO autore (nome,cognome,data_nascita,nickname,id_casa_discografica) VALUES (?, ?, ?,?,?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setDate(3, new java.sql.Date(input.getDataNascita().getTime()));
			ps.setString(4, input.getNickname());
			ps.setLong(5, input.getCasaDiscografica().getId());
			
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Autore input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM autore WHERE ID=?")) {
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Autore> findByExample(Autore example) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (example == null)
			throw new Exception("Valore di input non ammesso.");

		ArrayList<Autore> result = new ArrayList<Autore>();
		Autore autoreTemp = null;

		String query = "select * from autore "
				+ "inner join casa_discografica on casa_discografica.id=autore.id_casa_discografica"
				+ " where 1=1 ";
		
		if (example.getNome() != null && !example.getNome().equals("")) {
			query += " and nome='" + example.getNome() + "' ";
		}
		if (example.getCognome() != null && !example.getCognome().equals("")) {
			query += " and cognome='" + example.getCognome() + "' ";
		}

		if (example.getDataNascita() != null && !example.getDataNascita().equals("")) {
			query += " and data_nascita='" + example.getDataNascita() + "' ";
			
		if (example.getNickname() != null && !example.getNickname().equals("")) {
				query += " and nickname='" + example.getNickname() + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {

				autoreTemp = new Autore();
				autoreTemp.setId(rs.getLong(1));
				autoreTemp.setNome(rs.getString(2));
				autoreTemp.setCognome(rs.getString(3));
				autoreTemp.setDataNascita(rs.getDate(4));
				autoreTemp.setNickname(rs.getString(5));
				autoreTemp.setCasaDiscografica(
						new CasaDiscografica(rs.getLong(7), rs.getString(8), rs.getString(9), rs.getDate(10)));

				result.add(autoreTemp);

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
		this.connection = connection;
		
	}

	@Override
	public void populateCd(Autore input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<Cd> result = new ArrayList<Cd>();
				Cd cdTemp = null;
				
				String query="SELECT *\r\n"
						+ "from cd AS c\r\n"
						+ "INNER JOIN autore AS a ON c.id_autore=a.id\r\n"
						+ "WHERE c.id_autore=?";
				try (PreparedStatement ps = connection.prepareStatement(query)) {
					
					
					ps.setLong(1,input.getId());
					
					try( ResultSet rs = ps.executeQuery()){
						while (rs.next()) {
							
							cdTemp = new Cd();
							cdTemp.setId(rs.getLong(1));
							cdTemp.setTitolo(rs.getString(2));
							cdTemp.setGenere(rs.getString(3));
							cdTemp.setNumeroTracce(rs.getInt(4));
							cdTemp.setAutore(new Autore(rs.getLong(6),rs.getString(7),rs.getString(8),rs.getDate(9),rs.getString(10)));
							
							result.add(cdTemp);
						}
						
						input.setListaCd(result);
					}
					
					

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				
				
			}

			@Override
			public List<Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception {
				// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<Autore> result = new ArrayList<Autore>();
				Autore autoreTemp = null;

				String query = "SELECT *\r\n" + "FROM autore AS a\r\n"
						+ "INNER JOIN casa_discografica AS c ON a.id_casa_discografica=c.id\r\n" + "WHERE c.id=?";
				try (PreparedStatement ps = connection.prepareStatement(query);) {
					
					ps.setLong(1, input.getId());

					try (ResultSet rs = ps.executeQuery()) {
						while (rs.next()) {

							autoreTemp = new Autore();
							autoreTemp.setId(rs.getLong(1));
							autoreTemp.setNome(rs.getString(2));
							autoreTemp.setCognome(rs.getString(3));
							autoreTemp.setDataNascita(rs.getDate(4));
							autoreTemp.setNickname(rs.getString(5));
							autoreTemp.setCasaDiscografica(new CasaDiscografica(rs.getLong(7), rs.getString(8),
									rs.getString(9), rs.getDate(10)));

							result.add(autoreTemp);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
			}

			@Override
			public List<Autore> findByCdWhereNTracceGraterThen(int nTracce) throws Exception {
				// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<Autore> result = new ArrayList<Autore>();
				Autore autoreTemp = null;

				String query = "SELECT *\r\n"
						+ "FROM autore AS a\r\n"
						+ "INNER JOIN cd ON cd.id_autore=a.id\r\n"
						+ "WHERE cd.numero_tracce>?";
				try (PreparedStatement ps = connection.prepareStatement(query);) {
					
					ps.setLong(1, nTracce);

					try (ResultSet rs = ps.executeQuery()) {
						while (rs.next()) {

							autoreTemp = new Autore();
							autoreTemp.setId(rs.getLong(1));
							autoreTemp.setNome(rs.getString(2));
							autoreTemp.setCognome(rs.getString(3));
							autoreTemp.setDataNascita(rs.getDate(4));
							autoreTemp.setNickname(rs.getString(5));
							autoreTemp.setCasaDiscografica(new CasaDiscografica(rs.getLong(7), rs.getString(8),
									rs.getString(9), rs.getDate(10)));

							result.add(autoreTemp);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
			}

		}


