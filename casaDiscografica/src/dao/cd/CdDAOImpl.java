package dao.cd;

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

public class CdDAOImpl extends AbstractMySQLDAO implements CdDAO {

	@Override
	public List<Cd> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Cd> result = new ArrayList<Cd>();
		Cd cdTemp = null;

		String query = "SELECT * FROM cd AS c INNER JOIN autore AS a ON c.id_autore=a.id";
		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {

			while (rs.next()) {

				cdTemp = new Cd();
				cdTemp.setId(rs.getLong(1));
				cdTemp.setTitolo(rs.getString(2));
				cdTemp.setGenere(rs.getString(3));
				cdTemp.setNumeroTracce(rs.getInt(4));
				cdTemp.setAutore(
						new Autore(rs.getLong(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10)));

				result.add(cdTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Cd get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		String query = "SELECT *\r\n" + "FROM cd AS c\r\n" + "INNER JOIN autore AS a ON c.id_autore=a.id\r\n"
				+ "WHERE c.id=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Cd cdTemp;
					cdTemp = new Cd();
					cdTemp.setId(rs.getLong(1));
					cdTemp.setTitolo(rs.getString(2));
					cdTemp.setGenere(rs.getString(3));
					cdTemp.setNumeroTracce(rs.getInt(4));
					cdTemp.setAutore(new Autore(rs.getLong(6), rs.getString(7), rs.getString(8), rs.getDate(9),
							rs.getString(10)));
					return cdTemp;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public int update(Cd input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection
				.prepareStatement("UPDATE cd SET titolo=?,genere=?,numero_tracce=?,id_autore=? where id=?;")) {

			ps.setString(1, input.getTitolo());
			ps.setString(2, input.getGenere());
			ps.setInt(3, input.getNumeroTracce());
			ps.setLong(4, input.getAutore().getId());
			ps.setLong(5, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(Cd input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO cd (titolo,genere,numero_tracce,id_autore) VALUES (?, ?, ?,?);")) {
			ps.setString(1, input.getTitolo());
			ps.setString(2, input.getGenere());
			ps.setInt(3, input.getNumeroTracce());
			ps.setLong(4, input.getAutore().getId());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Cd input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM cd WHERE ID=?")) {
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> findByExample(Cd example) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				if (example == null)
					throw new Exception("Valore di input non ammesso.");

				ArrayList<Cd> result = new ArrayList<Cd>();
				Cd cdTemp = null;

				String query = "select * from cd "
						+ "inner join autore on cd.id_autore=autore.id"
						+ " where 1=1 ";
				
				if (example.getTitolo() != null && !example.getTitolo().equals("")) {
					query += " and titolo='" + example.getTitolo() + "' ";
				}
				if (example.getGenere() != null && !example.getGenere().equals("")) {
					query += " and genere='" + example.getGenere() + "' ";
				}

				if (example.getNumeroTracce() != 0 ) {
					query += " and numero_tracce='" + example.getNumeroTracce() + "' ";
					
				}

				try (Statement ps = connection.createStatement()) {
					ResultSet rs = ps.executeQuery(query);

					while (rs.next()) {

						cdTemp = new Cd();
						cdTemp.setId(rs.getLong(1));
						cdTemp.setTitolo(rs.getString(2));
						cdTemp.setGenere(rs.getString(3));
						cdTemp.setNumeroTracce(rs.getInt(4));
						cdTemp.setAutore(
								new Autore(rs.getLong(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10)));

						result.add(cdTemp);

					}
					return result;

				} catch (Exception e) {
					e.printStackTrace();
					throw e;

				}
				
			}
				




	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Cd> findAllByGenere(String genere) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
				if (isNotActive())
					throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

				ArrayList<Cd> result = new ArrayList<Cd>();
				Cd cdTemp = null;

				String query = "SELECT *\r\n"
						+ "FROM cd\r\n"
						+ "INNER JOIN autore AS a ON cd.id_autore=a.id\r\n"
						+ "WHERE cd.genere=?";
				try (PreparedStatement ps = connection.prepareStatement(query); ) {
					
					ps.setString(1, genere);
					try(ResultSet rs = ps.executeQuery()){
						while (rs.next()) {

							cdTemp = new Cd();
							cdTemp.setId(rs.getLong(1));
							cdTemp.setTitolo(rs.getString(2));
							cdTemp.setGenere(rs.getString(3));
							cdTemp.setNumeroTracce(rs.getInt(4));
							cdTemp.setAutore(
									new Autore(rs.getLong(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10)));

							result.add(cdTemp);
					}

					
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				return result;
	}

	@Override
	public List<Cd> findAllByAutoreWhereTitolStartsWith(Autore autoreInput, String iniziale) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Cd> result = new ArrayList<Cd>();
		Cd cdTemp = null;

		String query = "SELECT *\r\n"
				+ "FROM cd\r\n"
				+ "INNER JOIN autore AS a ON cd.id_autore=a.id\r\n"
				+ "WHERE a.id=? AND cd.titolo LIKE ?";
		try (PreparedStatement ps = connection.prepareStatement(query); ) {
			
			ps.setLong(1, autoreInput.getId());
			ps.setString(2, iniziale+"%");
			try(ResultSet rs = ps.executeQuery()){
				while (rs.next()) {

					cdTemp = new Cd();
					cdTemp.setId(rs.getLong(1));
					cdTemp.setTitolo(rs.getString(2));
					cdTemp.setGenere(rs.getString(3));
					cdTemp.setNumeroTracce(rs.getInt(4));
					cdTemp.setAutore(
							new Autore(rs.getLong(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10)));

					result.add(cdTemp);
			}

			
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
