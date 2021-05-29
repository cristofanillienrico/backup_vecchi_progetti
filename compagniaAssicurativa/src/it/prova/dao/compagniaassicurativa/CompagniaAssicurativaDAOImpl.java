package it.prova.dao.compagniaassicurativa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.Automobile;
import it.prova.model.CompagniaAssicurativa;

public class CompagniaAssicurativaDAOImpl extends AbstractMySQLDAO implements ICompagniaAssicurativaDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@Override
	public List<CompagniaAssicurativa> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<CompagniaAssicurativa> result = new ArrayList<CompagniaAssicurativa>();
		CompagniaAssicurativa compagniaAssicurativaTemp = null;

		String query = "select * from compagnia_assicurativa; ";
		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery(query)) {

			while (rs.next()) {
				compagniaAssicurativaTemp = new CompagniaAssicurativa();
				compagniaAssicurativaTemp.setId(rs.getLong("id"));
				compagniaAssicurativaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				compagniaAssicurativaTemp.setIndirizzo(rs.getString("indirizzo"));
				compagniaAssicurativaTemp.setDataFondazione(rs.getDate("data_fondazione"));

				result.add(compagniaAssicurativaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public CompagniaAssicurativa get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		CompagniaAssicurativa compagniaAssicurativaTemp = null;
		String query = "SELECT *\r\n" + "FROM compagnia_assicurativa AS c\r\n" + "WHERE c.id=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					compagniaAssicurativaTemp = new CompagniaAssicurativa();
					compagniaAssicurativaTemp.setId(rs.getLong("id"));
					compagniaAssicurativaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
					compagniaAssicurativaTemp.setIndirizzo(rs.getString("indirizzo"));
					compagniaAssicurativaTemp.setDataFondazione(rs.getDate("data_fondazione"));
					return compagniaAssicurativaTemp;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public int update(CompagniaAssicurativa input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE compagnia_assicurativa SET ragione_sociale=?,data_fondazione=?,indirizzo=? where id=?;")) {

			ps.setString(1, input.getRagioneSociale());
			ps.setDate(2, new java.sql.Date(input.getDataFondazione().getTime()));
			ps.setString(3, input.getIndirizzo());
			ps.setLong(4, input.getId());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(CompagniaAssicurativa input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO compagnia_assicurativa (ragione_sociale,data_fondazione,indirizzo) VALUES (?, ?, ?);")) {

			ps.setString(1, input.getRagioneSociale());
			ps.setDate(2, new java.sql.Date(input.getDataFondazione().getTime()));
			ps.setString(3, input.getIndirizzo());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(CompagniaAssicurativa input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM compagnia_assicurativa WHERE ID=?")) {
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CompagniaAssicurativa> findByExample(CompagniaAssicurativa example) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (example == null)
			throw new Exception("Valore di input non ammesso.");

		ArrayList<CompagniaAssicurativa> result = new ArrayList<CompagniaAssicurativa>();

		CompagniaAssicurativa compagniaAssicurativaTemp = null;

		String query = "SELECT *\r\n" + "FROM compagnia_assicurativa AS a\r\n" + "WHERE 1=1 ";

		if (example.getRagioneSociale() != null && !example.getRagioneSociale().equals("")) {
			query += " and ragione_sociale='" + example.getRagioneSociale() + "' ";
		}
		if (example.getDataFondazione() != null) {
			query += " and data_fondazione='" + example.getDataFondazione() + "' ";
		}

		if (example.getIndirizzo() != null && !example.getIndirizzo().equals("")) {
			query += " and indirizzo='" + example.getIndirizzo() + "' ";

		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {

				compagniaAssicurativaTemp = new CompagniaAssicurativa();
				compagniaAssicurativaTemp.setId(rs.getLong("id"));
				compagniaAssicurativaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				compagniaAssicurativaTemp.setIndirizzo(rs.getString("indirizzo"));
				compagniaAssicurativaTemp.setDataFondazione(rs.getDate("data_fondazione"));

				result.add(compagniaAssicurativaTemp);

			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	@Override
	public void populateAutomobili(CompagniaAssicurativa input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Automobile> result = new ArrayList<Automobile>();
		Automobile automobileTemp = null;

		String query = "SELECT *\r\n" + "FROM automobile AS a\r\n" + "WHERE a.id_compagnia_assicurativa=?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, input.getId());

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					automobileTemp = new Automobile();
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

}
