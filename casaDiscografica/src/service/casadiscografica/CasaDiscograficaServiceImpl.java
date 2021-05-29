package service.casadiscografica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import dao.Constants;
import dao.autore.AutoreDAO;
import dao.casadiscografica.CasaDiscograficaDAO;
import model.Autore;
import model.CasaDiscografica;

public class CasaDiscograficaServiceImpl implements CasaDiscograficaService {

	private CasaDiscograficaDAO casaDiscograficaDao;
	private AutoreDAO autoreDao;

	@Override
	public void setCasaDiscograficaDao(CasaDiscograficaDAO casaDiscograficaDao) {
		this.casaDiscograficaDao = casaDiscograficaDao;
	}

	@Override
	public void setAutoreDao(AutoreDAO autoreDao) {
		this.autoreDao = autoreDao;

	}

	@Override
	public List<CasaDiscografica> listAll() throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public CasaDiscografica findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		CasaDiscografica result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiorna(CasaDiscografica input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovo(CasaDiscografica input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int rimuovi(CasaDiscografica input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			casaDiscograficaDao.populateAuthors(input);
			if (input.getListaAutori().size() > 0) {
				throw new Exception("Per essere eliminata non deve contenere autori");
			}

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public CasaDiscografica casaDiscograficaTrovaDaAutore(Autore input) throws Exception {
		if (input == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		CasaDiscografica result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);
			autoreDao.setConnection(connection);

			// controllo che l'autore sia nel databse
			if (autoreDao.get(input.getId()) == null) {
				throw new Exception("L'autore non è nel database");
			}

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.casaDiscograficaFindByAutore(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CasaDiscografica> trovaTuttiDaAutoreDoveCognomeIniziaCon(String iniziale) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.findAllByAutoreWhereSurnameStartsWith(iniziale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public List<CasaDiscografica> trovaTuttiDaCdDoveGenereUgualeA(String genere) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.findAllByCdWhereGenereEqual(genere);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
