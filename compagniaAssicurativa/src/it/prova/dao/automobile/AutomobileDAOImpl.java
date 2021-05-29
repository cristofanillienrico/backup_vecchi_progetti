package it.prova.dao.automobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.Automobile;
import it.prova.model.CompagniaAssicurativa;
import it.prova.model.Proprietario;

public class AutomobileDAOImpl extends AbstractMySQLDAO implements IAutomobileDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@Override
	public List<Automobile> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Automobile> result = new ArrayList<Automobile>();
		Proprietario proprietarioTemp = null;
		Automobile automobileTemp = null;
		CompagniaAssicurativa compagniaAssicurativaTemp = null;

		String query = "SELECT *\r\n" + "FROM automobile AS a\r\n"
				+ "INNER JOIN proprietario AS p ON a.id_proprietario=p.id\r\n"
				+ "INNER JOIN compagnia_assicurativa AS c ON a.id_compagnia_assicurativa=c.id";
		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {

			while (rs.next()) {
				proprietarioTemp = new Proprietario();
				proprietarioTemp.setId(rs.getLong("id_proprietario"));
				proprietarioTemp.setNome("nome");
				proprietarioTemp.setCognome(rs.getString("cognome"));
				proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));

				compagniaAssicurativaTemp = new CompagniaAssicurativa();
				compagniaAssicurativaTemp.setId(rs.getLong("id_compagnia_assicurativa"));
				compagniaAssicurativaTemp.setRagioneSociale("ragione_sociale");
				compagniaAssicurativaTemp.setIndirizzo(rs.getString("indirizzo"));
				compagniaAssicurativaTemp.setDataFondazione(rs.getDate("data_fondazione"));

				automobileTemp = new Automobile();
				automobileTemp.setId(rs.getLong("id"));
				automobileTemp.setMarca(rs.getString("marca"));
				automobileTemp.setModello(rs.getString("modello"));
				automobileTemp.setDataImmatricolazione(rs.getDate("data_immatricolazione"));
				automobileTemp.setCilindrata(rs.getInt("cilindrata"));
				automobileTemp.setProprietario(proprietarioTemp);
				automobileTemp.setCompagniaAssicurativa(compagniaAssicurativaTemp);

				result.add(automobileTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Automobile get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		Proprietario proprietarioTemp = null;
		Automobile automobileTemp = null;
		CompagniaAssicurativa compagniaAssicurativaTemp = null;

		String query = "SELECT *\r\n" + "FROM automobile AS a\r\n"
				+ "INNER JOIN proprietario AS p ON a.id_proprietario=p.id\r\n"
				+ "INNER JOIN compagnia_assicurativa AS c ON a.id_compagnia_assicurativa=c.id\r\n" + "WHERE a.id=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, idInput);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {

					proprietarioTemp = new Proprietario();
					proprietarioTemp.setId(rs.getLong("id_proprietario"));
					proprietarioTemp.setNome("nome");
					proprietarioTemp.setCognome(rs.getString("cognome"));
					proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));

					compagniaAssicurativaTemp = new CompagniaAssicurativa();
					compagniaAssicurativaTemp.setId(rs.getLong("id_compagnia_assicurativa"));
					compagniaAssicurativaTemp.setRagioneSociale("ragione_sociale");
					compagniaAssicurativaTemp.setIndirizzo(rs.getString("indirizzo"));
					compagniaAssicurativaTemp.setDataFondazione(rs.getDate("data_fondazione"));

					automobileTemp = new Automobile();
					automobileTemp.setId(idInput);
					automobileTemp.setMarca(rs.getString("marca"));
					automobileTemp.setModello(rs.getString("modello"));
					automobileTemp.setDataImmatricolazione(rs.getDate("data_immatricolazione"));
					automobileTemp.setCilindrata(rs.getInt("cilindrata"));
					automobileTemp.setProprietario(proprietarioTemp);
					automobileTemp.setCompagniaAssicurativa(compagniaAssicurativaTemp);

					return automobileTemp;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public int update(Automobile input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE automobile SET marca=?,modello=?,cilindrata=?,data_immatricolazione=?,id_compagnia_assicurativa=?,id_proprietario=? where id=?;")) {

			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getCilindrata());
			ps.setDate(4, new java.sql.Date(input.getDataImmatricolazione().getTime()));
			ps.setLong(5, input.getCompagniaAssicurativa().getId());
			ps.setLong(6, input.getProprietario().getId());
			ps.setLong(7, input.getId());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(Automobile input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO automobile (marca,modello,cilindrata,data_immatricolazione,id_compagnia_assicurativa,id_proprietario) VALUES (?, ?, ?,?,?,?);")) {

			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getCilindrata());
			ps.setDate(4, new java.sql.Date(input.getDataImmatricolazione().getTime()));
			ps.setLong(5, input.getCompagniaAssicurativa().getId());
			ps.setLong(6, input.getProprietario().getId());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Automobile input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM automobile WHERE ID=?")) {
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Automobile> findByExample(Automobile example) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (example == null)
			throw new Exception("Valore di input non ammesso.");

		ArrayList<Automobile> result = new ArrayList<Automobile>();
		Automobile automobileTemp = null;
		Proprietario proprietarioTemp = null;
		CompagniaAssicurativa compagniaAssicurativaTemp = null;

		String query = "SELECT *\r\n" + "FROM automobile AS a\r\n"
				+ "INNER JOIN proprietario AS p ON a.id_proprietario=p.id\r\n"
				+ "INNER JOIN compagnia_assicurativa AS c ON a.id_compagnia_assicurativa=c.id\r\n" + "WHERE 1=1 ";

		if (example.getMarca() != null && !example.getMarca().equals("")) {
			query += " and marca='" + example.getMarca() + "' ";
		}
		if (example.getModello() != null && !example.getModello().equals("")) {
			query += " and modello='" + example.getModello() + "' ";
		}

		if (example.getCilindrata() != 0) {
			query += " and cilindrata='" + example.getCilindrata() + "' ";

		}
		if (example.getDataImmatricolazione() != null) {
			query += " and data_immatricolazione='" + example.getDataImmatricolazione() + "' ";

		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {

				proprietarioTemp = new Proprietario();
				proprietarioTemp.setId(rs.getLong("id_proprietario"));
				proprietarioTemp.setNome("nome");
				proprietarioTemp.setCognome(rs.getString("cognome"));
				proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));

				compagniaAssicurativaTemp = new CompagniaAssicurativa();
				compagniaAssicurativaTemp.setId(rs.getLong("id_compagnia_assicurativa"));
				compagniaAssicurativaTemp.setRagioneSociale("ragione_sociale");
				compagniaAssicurativaTemp.setIndirizzo(rs.getString("indirizzo"));
				compagniaAssicurativaTemp.setDataFondazione(rs.getDate("data_fondazione"));

				automobileTemp = new Automobile();
				automobileTemp.setId(rs.getLong("id"));
				automobileTemp.setMarca(rs.getString("marca"));
				automobileTemp.setModello(rs.getString("modello"));
				automobileTemp.setDataImmatricolazione(rs.getDate("data_immatricolazione"));
				automobileTemp.setCilindrata(rs.getInt("cilindrata"));
				automobileTemp.setProprietario(proprietarioTemp);
				automobileTemp.setCompagniaAssicurativa(compagniaAssicurativaTemp);

				System.out.println(automobileTemp);

				result.add(automobileTemp);

			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	@Override
	public List<Automobile> carsWithOwnerHasMoreThanFortyYears() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Automobile> result = new ArrayList<Automobile>();
		Proprietario proprietarioTemp = null;
		Automobile automobileTemp = null;
		CompagniaAssicurativa compagniaAssicurativaTemp = null;

		String query = "SELECT *\r\n" + "FROM automobile AS a\r\n"
				+ "INNER JOIN proprietario AS p ON a.id_proprietario=p.id\r\n"
				+ "INNER JOIN compagnia_assicurativa AS c ON a.id_compagnia_assicurativa=c.id\r\n"
				+ "WHERE(SELECT DATEDIFF(?,p.data_nascita )/365 AS DATEDIFF)>40";
		try (PreparedStatement ps = connection.prepareStatement(query);) {

			ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					proprietarioTemp = new Proprietario();
					proprietarioTemp.setId(rs.getLong("id_proprietario"));
					proprietarioTemp.setNome("nome");
					proprietarioTemp.setCognome(rs.getString("cognome"));
					proprietarioTemp.setDataNascita(rs.getDate("data_nascita"));

					compagniaAssicurativaTemp = new CompagniaAssicurativa();
					compagniaAssicurativaTemp.setId(rs.getLong("id_compagnia_assicurativa"));
					compagniaAssicurativaTemp.setRagioneSociale("ragione_sociale");
					compagniaAssicurativaTemp.setIndirizzo(rs.getString("indirizzo"));
					compagniaAssicurativaTemp.setDataFondazione(rs.getDate("data_fondazione"));

					automobileTemp = new Automobile();
					automobileTemp.setId(rs.getLong("id"));
					automobileTemp.setMarca(rs.getString("marca"));
					automobileTemp.setModello(rs.getString("modello"));
					automobileTemp.setDataImmatricolazione(rs.getDate("data_immatricolazione"));
					automobileTemp.setCilindrata(rs.getInt("cilindrata"));
					automobileTemp.setProprietario(proprietarioTemp);
					automobileTemp.setCompagniaAssicurativa(compagniaAssicurativaTemp);

					result.add(automobileTemp);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
